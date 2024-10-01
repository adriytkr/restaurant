package src.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.entidades.Fornecedores;
import src.util.Conexao;

public class FornecedoresDAO {
    public static void cadastrarFornecedor(Fornecedores fornecedor) {
        String sql = "INSERT INTO FORNECEDORES (CNPJ, NOME, TIPO_MATERIAL, EMAIL, TELEFONE, VALOR_MATERIAL) VALUES (?,?,?,?,?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fornecedor.getCnpj());
            ps.setString(2, fornecedor.getNome());
            ps.setString(3, fornecedor.getTipoMaterial());
            ps.setString(4, fornecedor.getEmail());
            ps.setString(5, fornecedor.getTelefone());
            ps.setFloat(6, fornecedor.getValorMaterial());
            ps.executeUpdate(); // Melhor usar executeUpdate para operações de atualização

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int consultarIdFornecedor(String cnpj) {
        int id = 0;
        String sql = "SELECT ID_FORNECEDOR FROM FORNECEDORES WHERE CNPJ = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cnpj);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("ID_FORNECEDOR");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public static Fornecedores consultarFornecedor(Fornecedores fornecedor) {
        if (fornecedor.getIdFornecedor() == 0) {
            fornecedor.setIdFornecedor(FornecedoresDAO.consultarIdFornecedor(fornecedor.getCnpj()));
        }
        String sql = "SELECT * FROM FORNECEDORES WHERE ID_FORNECEDOR = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, fornecedor.getIdFornecedor());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    fornecedor.setNome(rs.getString("NOME"));
                    fornecedor.setCnpj(rs.getString("CNPJ"));
                    fornecedor.setTipoMaterial(rs.getString("TIPO_MATERIAL"));
                    fornecedor.setEmail(rs.getString("EMAIL"));
                    fornecedor.setTelefone(rs.getString("TELEFONE"));
                    fornecedor.setValorMaterial(rs.getFloat("VALOR_MATERIAL"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedor;
    }

    public static void atualizarFornecedor(Fornecedores fornecedor) {
        if (fornecedor.getIdFornecedor() == 0) {
            fornecedor.setIdFornecedor(FornecedoresDAO.consultarIdFornecedor(fornecedor.getCnpj()));
        }
        String sql = "UPDATE FORNECEDORES SET NOME = ?,TIPO_MATERIAL = ?,EMAIL = ?,TELEFONE = ?,VALOR_MATERIAL = ?, CNPJ = ? WHERE ID_FORNECEDOR = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fornecedor.getNome());
            ps.setString(2, fornecedor.getTipoMaterial());
            ps.setString(3, fornecedor.getEmail());
            ps.setString(4, fornecedor.getTelefone());
            ps.setFloat(5, fornecedor.getValorMaterial());
            ps.setString(6, fornecedor.getCnpj());
            ps.setInt(7, fornecedor.getIdFornecedor());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deletarFornecedor(Fornecedores fornecedor) throws SQLException {
        if (fornecedor.getIdFornecedor() == 0) {
            fornecedor.setIdFornecedor(FornecedoresDAO.consultarIdFornecedor(fornecedor.getCnpj()));
        }

        try (Connection conn = Conexao.getConexao();
                PreparedStatement checkEstoque = conn
                        .prepareStatement("SELECT COUNT(*) FROM ESTOQUE WHERE ID_FORNECEDOR = ?")) {
            checkEstoque.setInt(1, fornecedor.getIdFornecedor());
            ResultSet rs = checkEstoque.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                fornecedor.setCnpj(null);
                fornecedor.setEmail(null);
                fornecedor.setNome(null);
                fornecedor.setTelefone(null);
                fornecedor.setTipoMaterial(null);
                fornecedor.setValorMaterial(0);
                FornecedoresDAO.atualizarFornecedor(fornecedor);
                throw new SQLException(
                        "Não é possível deletar o fornecedor porque ela está referenciado em ESTOQUE, registros serão atualizados como nulos.");
            }
        }

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM FORNECEDORES WHERE ID_FORNECEDOR = ?")) {
            ps.setInt(1, fornecedor.getIdFornecedor());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
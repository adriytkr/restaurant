package src.model.DAO;

import src.model.entidades.Pratos;
import src.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PratosDAO {
        public static void cadastrarPrato(Pratos prato){
        String sql = "INSERT INTO PRATOS (NOME,DESCRICAO,VALOR) VALUES (?,?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, prato.getNome());
            ps.setString(2, prato.getDescricao());
            ps.setFloat(3, prato.getValor());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Pratos consultarPrato(String nome) {
        String sql = "SELECT * FROM PRATOS WHERE NOME = ?";
        Pratos prato = null;

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    prato = new Pratos(nome, rs.getString("DESCRICAO"), rs.getFloat("VALOR"));
                    prato.setIdPrato(rs.getInt("ID_PRATO"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prato;
    }

    private static Pratos consultarIdPrato(Pratos prato) {
        String sql = "SELECT ID_PRATO FROM PRATOS WHERE NOME = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, prato.getNome());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    prato.setIdPrato(rs.getInt("ID_PRATO"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prato;
    }

    public static void atualizarPrato(Pratos prato) {
        if (prato.getIdPrato() == 0) {
            prato = PratosDAO.consultarIdPrato(prato);
        }
        String sql = "UPDATE PRATOS SET NOME=?,DESCRICAO=?,VALOR=? WHERE ID_PRATO=?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, prato.getNome());
            ps.setString(2, prato.getDescricao());
            ps.setFloat(3, prato.getValor());
            ps.setInt(4, prato.getIdPrato());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarPrato(Pratos prato) throws SQLException {
        if (prato.getIdPrato() == 0) {
            prato = PratosDAO.consultarIdPrato(prato);
        }

        try (Connection conn = Conexao.getConexao();
                PreparedStatement checkPedidos = conn
                        .prepareStatement("SELECT COUNT(*) FROM PEDIDOS WHERE ID_PRATO = ?")) {
            checkPedidos.setInt(1, prato.getIdPrato());
            ResultSet rs = checkPedidos.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                prato.setDescricao(null);
                prato.setNome(null);
                prato.setValor(0);
                PratosDAO.atualizarPrato(prato);
                throw new SQLException(
                        "Não é possível deletar o prato porque ela está referenciada em PEDIDOS, registros serão atualizados como nulos.");
            }
        }

        try (Connection conn = Conexao.getConexao();
                PreparedStatement deletePrato = conn.prepareStatement("DELETE FROM PRATOS WHERE ID_PRATO = ?")) {
            deletePrato.setInt(1, prato.getIdPrato());
            deletePrato.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

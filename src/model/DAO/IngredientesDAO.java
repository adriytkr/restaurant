package src.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.entidades.Ingredientes;
import src.util.Conexao;

public class IngredientesDAO {

    public static void cadastrarIngrediente(Ingredientes ingrediente) {
        String sql = "INSERT INTO INGREDIENTES (NOME, UNIDADE_MEDIDA) VALUES (?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ingrediente.getNome());
            ps.setString(2, ingrediente.getUnidadeDeMedida());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int consultarIdIngrediente(String nome) {
        int id = 0;
        String sql = "SELECT ID_INGREDIENTE FROM INGREDIENTES WHERE NOME = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("ID_INGREDIENTE");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public static Ingredientes consultarIngrediente(Ingredientes ingrediente) {
        if (ingrediente.getIdIngrediente() == 0) {
            ingrediente.setIdIngrediente(IngredientesDAO.consultarIdIngrediente(ingrediente.getNome()));
        }
        String sql = "SELECT * FROM INGREDIENTES WHERE ID_INGREDIENTE = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, ingrediente.getIdIngrediente());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ingrediente.setNome(rs.getString("NOME"));
                    ingrediente.setUnidadeDeMedida(rs.getString("UNIDADE_MEDIDA"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingrediente;
    }

    public static void atualizarIngrediente(Ingredientes ingrediente) {
        if (ingrediente.getIdIngrediente() == 0) {
            ingrediente.setIdIngrediente(IngredientesDAO.consultarIdIngrediente(ingrediente.getNome()));
        }
        String sql = "UPDATE INGREDIENTES SET NOME = ?, UNIDADE_MEDIDA = ? WHERE ID_INGREDIENTE = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ingrediente.getNome());
            ps.setString(2, ingrediente.getUnidadeDeMedida());
            ps.setInt(3, ingrediente.getIdIngrediente());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarIngrediente(Ingredientes ingrediente) throws SQLException {
        if (ingrediente.getIdIngrediente() == 0) {
            ingrediente.setIdIngrediente(IngredientesDAO.consultarIdIngrediente(ingrediente.getNome()));
        }

        // VERIFICA SE HÁ REGISTROS RELACIONADOS NA TABELA DE ESTOQUE
        try (Connection conn = Conexao.getConexao();
                PreparedStatement checkEstoque = conn
                        .prepareStatement("SELECT COUNT(*) FROM ESTOQUE WHERE ID_INGREDIENTE = ?")) {
            checkEstoque.setInt(1, ingrediente.getIdIngrediente());
            ResultSet rs = checkEstoque.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                ingrediente.setNome(null);
                ingrediente.setUnidadeDeMedida(null);
                IngredientesDAO.atualizarIngrediente(ingrediente);
                throw new SQLException(
                    "Não é possível deletar o ingrediente porque ele está referenciado em ESTOQUE, registros serão atualizados como nulos.");
            }
        }
        try (Connection conn = Conexao.getConexao();
                PreparedStatement deleteIngrediente = conn
                        .prepareStatement("DELETE FROM INGREDIENTES WHERE ID_INGREDIENTES = ?")) {
            deleteIngrediente.setInt(1, ingrediente.getIdIngrediente());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
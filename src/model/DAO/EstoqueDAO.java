package src.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.entidades.ItemEstoque;
import src.util.Conexao;

public class EstoqueDAO {

    public static void cadastrarItem(ItemEstoque itemEstoque) {
        String sql = "INSERT INTO ESTOQUE (ID_INGREDIENTE,ID_FORNECEDOR,QUANTIDADE,QUANTIDADE_MINIMA,ID_FILIAL) VALUES (?,?,?,?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, itemEstoque.getidIngrediente());
            ps.setInt(2, itemEstoque.getIdFornecedor());
            ps.setInt(3, itemEstoque.getQuantidade());
            ps.setInt(4, itemEstoque.getQuantidadeMinima());
            ps.setInt(5, itemEstoque.getIdFilial());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ItemEstoque consultarItem(ItemEstoque item) {
        String sql = "SELECT * FROM ESTOQUE WHERE ID_INGREDIENTE = ? AND ID_FILIAL = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, item.getidIngrediente());
            ps.setInt(2, item.getIdFilial());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    item.setIdFilial(rs.getInt("ID_FILIAL"));
                    item.setQuantidade(rs.getInt("QUANTIDADE"));
                    item.setQuantidadeMinima(rs.getInt("QUANTIDADE_MINIMA"));
                    item.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public static void atualizarItem(ItemEstoque item) {
        String sql = "UPDATE ESTOQUE SET QUANTIDADE = ?, QUANTIDADE_MINIMA = ?, ID_FORNECEDOR = ? WHERE ID_INGREDIENTE = ? AND ID_FILIAL = ?";
        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, item.getQuantidade());
            ps.setInt(2, item.getQuantidadeMinima());
            ps.setInt(3, item.getIdFornecedor());
            ps.setInt(4, item.getidIngrediente());
            ps.setInt(5, item.getIdFilial());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
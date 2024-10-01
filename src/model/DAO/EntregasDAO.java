package src.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.entidades.Entregas;
import src.util.Conexao;

public class EntregasDAO {

    public static void cadastrarEntrega(Entregas entrega) {
        String sql = "INSERT INTO ENTREGAS (ENDERECO,DATA_ENTREGA,ID_PEDIDO) VALUES (?,?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entrega.getEndereco());
            ps.setString(2, entrega.getDataEntrega());
            ps.setInt(3, entrega.getIdPedido());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Entregas consultarEntrega(Entregas entrega) {
        String sql = "SELECT * FROM ENTREGAS WHERE ID_PEDIDO = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, entrega.getIdPedido());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entrega.setDataEntrega(rs.getString("DATA_ENTREGA"));
                    entrega.setEndereco(rs.getString("ENDERECO"));
                    entrega.setIdEntrega(rs.getInt("ID_ENTREGA"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entrega;
    }

    private static Entregas consultarIdEntrega(Entregas entrega) {
        String sql = "SELECT ID_ENTREGA FROM ENTREGAS WHERE ID_PEDIDO = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, entrega.getIdPedido());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entrega.setIdEntrega(rs.getInt("ID_ENTREGA"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entrega;
    }

    public static void atualizarEntrega(Entregas entrega) {

        if (entrega.getIdEntrega() == 0) {
            entrega = EntregasDAO.consultarIdEntrega(entrega);
        }

        String sql = "UPDATE ENTREGAS SET DATA_ENTREGA = ?, ENDERECO = ? WHERE ID_ENTREGA = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entrega.getDataEntrega());
            ps.setString(2, entrega.getEndereco());
            ps.setInt(3, entrega.getIdEntrega());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
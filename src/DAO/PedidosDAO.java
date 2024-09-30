package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.classes.Pedidos;
import src.conexao.Conexao;

public class PedidosDAO {
    public static void cadastrarPedido(Pedidos pedido) {
        String sql = "INSERT INTO PEDIDOS (ID_CLIENTE, ID_PRATO, ID_BEBIDA, VALOR, TIPO_PAGAMENTO, ENDERECO, DATA_PEDIDO, STATUS) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pedido.getIdCliente());
            ps.setInt(2, pedido.getIdPrato());
            ps.setInt(3, pedido.getIdBebida());
            ps.setFloat(4, pedido.getValor());
            ps.setString(5, pedido.getTipoDePagamento());
            ps.setString(6, pedido.getEndereco());
            ps.setString(7, pedido.getDataPedido());
            ps.setString(8, pedido.getStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int consultarIdPedido(Pedidos pedido) {
        String sql = "SELECT ID_PEDIDO FROM PEDIDOS WHERE ID_CLIENTE = ? AND DATA_PEDIDO = ?";
        int id = 0;
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pedido.getIdCliente());
            ps.setString(2, pedido.getDataPedido());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("ID_PEDIDO");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public static Pedidos consultarPedido(Pedidos pedido) {
        if (pedido.getIdPedido() == 0) {
            pedido.setIdPedido(PedidosDAO.consultarIdPedido(pedido));
        }
        String sql = "SELECT * FROM PEDIDOS WHERE ID_PEDIDO = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pedido.getIdPedido());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pedido.setEndereco(rs.getString("ENDERECO"));
                    pedido.setIdBebida(rs.getInt("ID_BEBIDA"));
                    pedido.setIdPrato(rs.getInt("ID_PRATO"));
                    pedido.setStatus(rs.getString("STATUS"));
                    pedido.setTipoDePagamento(rs.getString("TIPO_PAGAMENTO"));
                    pedido.setValor(rs.getFloat("VALOR"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }
}

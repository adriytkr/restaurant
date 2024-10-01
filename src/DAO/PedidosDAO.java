package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.classes.Pedidos;
import src.conexao.Conexao;

public class PedidosDAO {

    private static Pedidos valorPedido(Pedidos pedido) throws SQLException {
        String sqlPrato = "SELECT PEDIDOS.ID_PRATO, PRATOS.VALOR FROM PEDIDOS INNER JOIN PRATOS ON PEDIDOS.ID_PRATO = PRATOS.ID_PRATO WHERE PEDIDOS.ID_PRATO = ? AND PRATOS.ID_PRATO = ?";
        String sqlBebida = "SELECT PEDIDOS.ID_BEBIDA, BEBIDAS.VALOR FROM PEDIDOS INNER JOIN BEBIDAS ON PEDIDOS.ID_BEBIDA = BEBIDAS.ID_BEBIDA WHERE PEDIDOS.ID_BEBIDA = ? AND BEBIDAS.ID_BEBIDA = ?";
        try (Connection conn = Conexao.getConexao();
                PreparedStatement consultaPrato = conn.prepareStatement(sqlPrato)) {
            consultaPrato.setInt(1, pedido.getIdPrato());
            consultaPrato.setInt(2, pedido.getIdPrato());
            try (ResultSet rs = consultaPrato.executeQuery()) {
                if (rs.next()) {
                    float valorPrato = rs.getFloat("VALOR");
                    valorPrato = valorPrato * pedido.getQuantidadePrato();
                    pedido.setValor(valorPrato);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try (Connection conn = Conexao.getConexao();
                PreparedStatement consultaBebida = conn.prepareStatement(sqlBebida)) {
            consultaBebida.setInt(1, pedido.getIdBebida());
            consultaBebida.setInt(2, pedido.getIdBebida());
            try (ResultSet rs = consultaBebida.executeQuery()) {
                if (rs.next()) {
                    float valorBebida = rs.getFloat("VALOR");
                    valorBebida = valorBebida * pedido.getQuantidadeBebida();
                    pedido.setValor(pedido.getValor() + valorBebida);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    public static void cadastrarPedido(Pedidos pedido) throws SQLException {
        pedido = PedidosDAO.valorPedido(pedido);
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
                else{
                    System.out.println("Erro na consulta de ID!");
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

    public static void atualizarPedido(Pedidos pedido) {
        if (pedido.getIdPedido() == 0) {
            pedido.setIdPedido(PedidosDAO.consultarIdPedido(pedido));
        }
        String sql = "UPDATE PEDIDOS SET ID_CLIENTE = ?, ID_PRATO = ?, ID_BEBIDA = ?, VALOR = ?, TIPO_PAGAMENTO = ?, ENDERECO = ?, DATA_PEDIDO = ?, STATUS = ? WHERE ID_PEDIDO = ?";
        
        try (Connection conn = Conexao.getConexao(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
    
            ps.setInt(1, pedido.getIdCliente());
            ps.setInt(2, pedido.getIdPrato());
            ps.setInt(3, pedido.getIdBebida());
            ps.setFloat(4, pedido.getValor());
            ps.setString(5, pedido.getTipoDePagamento());
            ps.setString(6, pedido.getEndereco());
            ps.setString(7, pedido.getDataPedido());
            ps.setString(8, pedido.getStatus());
            ps.setInt(9, pedido.getIdPedido());
    
            ps.executeUpdate();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deletarPedido(Pedidos pedido) throws SQLException {
        if (pedido.getIdPedido() == 0) {
            pedido.setIdPedido(PedidosDAO.consultarIdPedido(pedido));
        }
        
        // Usa uma única conexão para todas as operações
        try (Connection conn = Conexao.getConexao()) {
            
            // Verifica CLIENTES
            try (PreparedStatement checkClientes = conn.prepareStatement("SELECT COUNT(*) FROM CLIENTES WHERE ID_CLIENTE = ?")) {
                checkClientes.setInt(1, pedido.getIdCliente());
                try (ResultSet rsClientes = checkClientes.executeQuery()) {
                    if (rsClientes.next() && rsClientes.getInt(1) > 0) {
                        PedidosDAO.atualizarPedido(pedido);
                        throw new SQLException("Não é possível deletar o pedido porque ele está referenciado em CLIENTES.");
                    }
                }
            }
            
            // Verifica PRATOS
            try (PreparedStatement checkPratos = conn.prepareStatement("SELECT COUNT(*) FROM PRATOS WHERE ID_PRATO = ?")) {
                checkPratos.setInt(1, pedido.getIdPrato());
                try (ResultSet rsPratos = checkPratos.executeQuery()) {
                    if (rsPratos.next() && rsPratos.getInt(1) > 0) {
                        PedidosDAO.atualizarPedido(pedido);
                        throw new SQLException("Não é possível deletar o pedido porque ele está referenciado em PRATOS.");
                    }
                }
            }
            
            // Verifica BEBIDAS
            try (PreparedStatement checkBebidas = conn.prepareStatement("SELECT COUNT(*) FROM BEBIDAS WHERE ID_BEBIDA = ?")) {
                checkBebidas.setInt(1, pedido.getIdBebida());
                try (ResultSet rsBebidas = checkBebidas.executeQuery()) {
                    if (rsBebidas.next() && rsBebidas.getInt(1) > 0) {
                        PedidosDAO.atualizarPedido(pedido);
                        throw new SQLException("Não é possível deletar o pedido porque ele está referenciado em BEBIDAS.");
                    }
                }
            }
            
            // Deleta o pedido
            try (PreparedStatement deletePedido = conn.prepareStatement("DELETE FROM PEDIDOS WHERE ID_PEDIDO = ?")) {
                deletePedido.setInt(1, pedido.getIdPedido());
                deletePedido.executeUpdate();  // Usar executeUpdate para operações de DELETE
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
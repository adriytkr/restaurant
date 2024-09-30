package src;

import java.sql.SQLException;
import src.DAO.*;
import src.classes.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Pedidos pedidoTeste = new Pedidos(0, 0, 0, 0, 0, null, null);
        pedidoTeste.setDataPedido("2024-09-29 00:07:06");
        pedidoTeste.setIdCliente(3);
        pedidoTeste = PedidosDAO.consultarPedido(pedidoTeste);
        pedidoTeste.visualizarPedidos();
    }
}

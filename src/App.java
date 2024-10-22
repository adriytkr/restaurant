package src;

import java.sql.SQLException;
import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Pedidos p1 = new Pedidos(0, 0, 0, 0, 0, null, null);
        p1.setIdPedido(5);
        p1 = PedidosDAO.consultarPedido(p1);
        // p1.visualizarPedidos();
        PedidosDAO.deletarPedido(p1);
    }
}

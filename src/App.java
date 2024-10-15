package src;

import java.sql.SQLException;
import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Clientes cliente = new Clientes(null, null, null, null, 0, null, null, null);
        cliente.setIdCliente(5);
        cliente = ClientesDAO.consultarCliente(cliente);
        cliente.visualizarCliente();

    }
}

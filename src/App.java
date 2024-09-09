package src;
import java.sql.SQLException;
import src.DAO.*;
import src.classes.*;

public class App {
    public static void main(String[] args) throws SQLException {

        Clientes clienteTeste = ClientesDAO.consultarCliente("12345678901");
        clienteTeste.visualizandoCliente();
        ClientesDAO.deletarCliente(clienteTeste);
    }
}

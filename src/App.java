package src;
import src.DAO.ClientesDAO;
import src.classes.Clientes;

public class App {
    public static void main(String[] args) {

        Clientes larissa = new Clientes("23223411289","Larissa da Cruz Vieira", "jpoasd","feminino", 16, "Oswlado Barbisa", "larimclqwe","11937777904");

        ClientesDAO.cadastrarCliente(larissa);
    }
}

package src;
import src.DAO.ClientesDAO;
import src.classes.Clientes;

public class App {
    public static void main(String[] args) {
        Clientes clienteTeste = new Clientes("50032822812", "João Pedro Monteiro Souza Alves", "Masculino", 17, "Ministro Lins de Barros, 271", "jmonteirosouto@2cx.com", "11976535178");

        new ClientesDAO().cadastrarCliente(clienteTeste);
    }
}

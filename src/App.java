package src;
import java.sql.SQLException;
import src.DAO.*;
import src.classes.*;

public class App {
    public static void main(String[] args) throws SQLException {

        Fornecedores f1 = new Fornecedores(null, null, null, null, null, 0);
        f1.setIdFornecedor(1);
        FornecedoresDAO.consultarFornecedor(f1);
        f1.visualizarFornecedor();
    }
}

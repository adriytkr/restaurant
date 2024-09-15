package src;
import java.sql.SQLException;
import src.DAO.*;
import src.classes.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Entregas testeessEntregas = new Entregas("Rua Cardozo 131", 3);
        // EntregasDAO.cadastrarEntrega(testeessEntregas);
        testeessEntregas.setDataEntrega("2024-09-13");
        testeessEntregas.setEndereco("Sebastião Gonçalves");
        EntregasDAO.atualizarEntrega(testeessEntregas);

    }
}

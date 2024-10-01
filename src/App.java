package src;

import java.sql.SQLException;

import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Clientes clienteTeste = new Clientes("20032033201", "Nome de Teste da Silva", "senha123", "M", 18, "nao sei", "noasei", "nao");
        ClientesDAO.cadastrarCliente(clienteTeste);
    }
}

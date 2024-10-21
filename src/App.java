package src;

import java.sql.SQLException;
import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Funcionarios f1 = new Funcionarios("testeeeee", "testeeeee", "testeeeee", "testeeeee", 3, "testeeeee", "testeeeee", "testeeeee", "testeeeee",3);
        f1.setCpf("66677889925");
        FuncionariosDAO.deletarFuncionario(f1);
    }
}

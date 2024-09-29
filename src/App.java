package src;

import java.sql.SQLException;
import src.DAO.*;
import src.classes.*;

public class App {
    public static void main(String[] args) throws SQLException {

        Funcionarios f1 = new Funcionarios("11122334455", null, null, null, 0, null, null, null, null);
        f1 = FuncionariosDAO.consultarFuncionarios(f1);
        FuncionariosDAO.deletarFuncionario(f1);
    }
}

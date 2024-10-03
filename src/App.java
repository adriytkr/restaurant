package src;

import java.sql.SQLException;

import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Funcionarios funcionario = new Funcionarios("00011223344", null, null, null, 0, null, null, null, null);
        FuncionariosDAO.consultarFuncionarios(funcionario);
        funcionario.visualizarFuncionario();
    }
}

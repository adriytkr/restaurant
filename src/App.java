package src;

import java.sql.SQLException;
import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Filiais f1 = new Filiais("RUAA 22", "FILIALTAL@123", "40028922", 30, 5);
        FiliaisDAO.deletarFilial(f1);
    }
}

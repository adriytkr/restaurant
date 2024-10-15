package src;

import java.sql.SQLException;
import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        // Bebidas bebida = new Bebidas("BEBIDA01", "01 NÃO É 02 NÉ VIDA", 55.0f);
        Bebidas b1 = new Bebidas(null, null, 0);
        b1.setIdBebida(62);
        b1 = BebidasDAO.consultarBebida(b1);
        b1.visualizarBebida();
    }
}

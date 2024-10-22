package src;

import java.sql.SQLException;
import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Ingredientes ingredienteTeste = new Ingredientes("Cheirinho verdeee", "Kg");
        IngredientesDAO.deletarIngrediente(ingredienteTeste);
    }
}

package src;

import java.sql.SQLException;
import src.DAO.*;
import src.classes.*;

public class App {
    public static void main(String[] args) throws SQLException {

        Ingredientes ingredienteTeste = new Ingredientes("Leite", "Kg");
        ingredienteTeste.setIdIngrediente(2);
        IngredientesDAO.deletarIngrediente(ingredienteTeste);
        ingredienteTeste.visualizarIngrediente();

    }
}

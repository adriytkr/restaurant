package src;

import java.sql.SQLException;

import src.DAO.BebidasDAO;
import src.classes.*;

public class App {
    public static void main(String[] args) throws SQLException {
        // CRUD BEBIDAS
        // Bebidas bebidaCriada = new Bebidas("bebida teste de criação", "gostosinha", 12);
        // bebidaCriada = BebidasDAO.consultarIdBebida(bebidaCriada);
        // bebidaCriada.setNome("limoneida22");
        // BebidasDAO.atualizarBebida(bebidaCriada);
        // BebidasDAO.deletarBebida(bebidaCriada);
        Bebidas limonada = BebidasDAO.consultarBebida("Limonada");
        // limonada.setDescricao("Prefiro suco de uva");
        // BebidasDAO.atualizarBebida(limonada);    
        BebidasDAO.deletarBebida(limonada);
    }
}

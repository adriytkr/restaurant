package src;

import java.sql.SQLException;

import src.model.DAO.*;
import src.model.entidades.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Reservas reservaTeste = new Reservas("Mesa 1",1,1,1);
        reservaTeste.setDataReserva("2024-10-02 09:12:04");
        ReservasDAO.deletarReserva(reservaTeste);
    }
}

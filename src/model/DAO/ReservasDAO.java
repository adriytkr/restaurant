package src.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.model.entidades.Reservas;
import src.util.Conexao;

public class ReservasDAO {
        public static void cadastrarReserva(Reservas reserva) throws SQLException {
        String sql = "INSERT INTO RESERVAS (DATA_RESERVA, ID_CLIENTE, MESA, ID_FILIAL, CAPACIDADE) VALUES (?,?,?,?,?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, reserva.getDataReserva());
            ps.setInt(2, reserva.getIdCliente());
            ps.setString(3, reserva.getMesa());
            ps.setInt(4, reserva.getIdFilial());
            ps.setInt(5, reserva.getCapacidade());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int consultarIdReserva(Reservas reserva) throws SQLException {
        int id = 0;
        String sql = "SELECT ID_RESERVA FROM RESERVAS WHERE ID_CLIENTE = ? AND DATA_RESERVA = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdCliente());
            ps.setString(2, reserva.getDataReserva());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("ID_RESERVA");
                }
                else{
                    System.out.println("Erro na consulta de ID!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static Reservas consultarReserva(Reservas reserva) throws SQLException {
        if (reserva.getIdReserva() == 0) {
            reserva.setIdReserva(ReservasDAO.consultarIdReserva(reserva));
        }
        String sql = "SELECT * FROM RESERVAS WHERE ID_RESERVA = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdReserva());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reserva.setCapacidade(rs.getInt("CAPACIDADE"));
                    reserva.setDataReserva(rs.getString("DATA_RESERVA"));
                    reserva.setIdCliente(rs.getInt("ID_CLIENTE"));
                    reserva.setIdFilial(rs.getInt("ID_FILIAL"));
                    reserva.setMesa(rs.getString("MESA"));
                }
                else{
                    System.out.println("Erro na consulta de Reserva!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;
    }

    public static void atualizarReserva(Reservas reserva) throws SQLException {
        if (reserva.getIdReserva() == 0) {
            reserva.setIdReserva(ReservasDAO.consultarIdReserva(reserva));
        }
        String sql = "UPDATE RESERVAS SET CAPACIDADE = ?, DATA_RESERVA = ?, ID_CLIENTE = ?, ID_FILIAL = ?, MESA = ? WHERE ID_RESERVA = ?";
        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reserva.getCapacidade());
            ps.setString(2, reserva.getDataReserva());
            ps.setInt(3, reserva.getIdCliente());
            ps.setInt(4, reserva.getIdFilial());
            ps.setString(5, reserva.getMesa());
            ps.setInt(6, reserva.getIdReserva());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void deletarReserva(Reservas reserva) throws SQLException {
            if (reserva.getIdReserva() == 0) {
                reserva.setIdReserva(ReservasDAO.consultarIdReserva(reserva));
            }
        try (Connection conn = Conexao.getConexao();PreparedStatement ps = conn.prepareStatement("DELETE FROM RESERVAS WHERE ID_RESERVA = ?")) {
                ps.setInt(1, reserva.getIdReserva());
                ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

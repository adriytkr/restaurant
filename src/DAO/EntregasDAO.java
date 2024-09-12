package src.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.classes.Entregas;
import src.conexao.Conexao;

public class EntregasDAO {

    public static void cadastrarEntrega(Entregas entrega) {
        String sql = "INSERT INTO ENTREGAS (ENDERECO,DATA_ENTREGA,ID_PEDIDO) VALUES (?,?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entrega.getEndereco());
            ps.setString(2, entrega.getDataEntrega());
            ps.setInt(3, entrega.getIdPedido());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
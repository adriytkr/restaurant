package src.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.classes.Bebidas;
import src.conexao.Conexao;

public class BebidasDAO {

    public static void cadastrarBebida(Bebidas bebida) {
        String sql = "INSERT INTO BEBIDAS (NOME,DESCRICAO,VALOR) VALUES (?,?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bebida.getNome());
            ps.setString(2, bebida.getDescricao());
            ps.setFloat(3, bebida.getValor());
            ps.executeUpdate(); // Melhor usar executeUpdate para operações de atualização

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Bebidas consultarBebida(String nome) {
        String sql = "SELECT * FROM BEBIDAS WHERE NOME = ?";
        Bebidas bebida = null;
    
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
    
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    bebida = new Bebidas(nome, rs.getString("DESCRICAO"), rs.getFloat("VALOR"));
                    bebida.setIdBebida(rs.getInt("ID_BEBIDA"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return bebida;
    }    

    public static void atualizarBebida(Bebidas bebida) {
        bebida = BebidasDAO.consultarBebida(bebida.getNome());
        String sql = "UPDATE BEBIDAS SET NOME=?,DESCRICAO=?,VALOR=? WHERE=?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bebida.getNome());
            ps.setString(2, bebida.getDescricao());
            ps.setFloat(3, bebida.getValor());
            ps.setInt(4, bebida.getIdBebida());
            ps.executeUpdate(); // Melhor usar executeUpdate para operações de atualização

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarBebida(String nome) {
        Bebidas bebida = BebidasDAO.consultarBebida(nome);
        String sql = "DELETE FROM BEBIDAS WHERE ID_BEBIDA = ?";

        try (Connection conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bebida.getIdBebida());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

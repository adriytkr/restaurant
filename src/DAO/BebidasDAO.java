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

    private static Bebidas consultarIdBebida(Bebidas bebida) {
        String sql = "SELECT ID_BEBIDA FROM BEBIDAS WHERE NOME = ?";
    
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
    
            ps.setString(1, bebida.getNome());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
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
        if (bebida.getIdBebida() == 0)  {
            bebida = BebidasDAO.consultarIdBebida(bebida);
        }
        String sql = "UPDATE BEBIDAS SET NOME=?,DESCRICAO=?,VALOR=? WHERE ID_BEBIDA=?";

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

    public static void deletarBebida(Bebidas bebida) throws SQLException {
        if (bebida.getIdBebida() == 0)  {
            bebida = BebidasDAO.consultarIdBebida(bebida);
        }

    // Verificar se há registros relacionados na tabela INGREDIENTES e PEDIDOS
    try (Connection conn = Conexao.getConexao(); PreparedStatement checkIngredientes = conn.prepareStatement("SELECT COUNT(*) FROM INGREDIENTES WHERE ID_BEBIDA = ?")) {
        checkIngredientes.setInt(1, bebida.getIdBebida());
        ResultSet rs = checkIngredientes.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            bebida.setDescricao(null);
            bebida.setNome(null);
            bebida.setValor(0);
            BebidasDAO.atualizarBebida(bebida);
            throw new SQLException("Não é possível deletar a bebida porque ela está referenciada em INGREDIENTES, registros serão atualizados como nulos.");
        }
    }

    try (Connection conn = Conexao.getConexao(); PreparedStatement checkPedidos = conn.prepareStatement("SELECT COUNT(*) FROM PEDIDOS WHERE ID_BEBIDA = ?")) {
        checkPedidos.setInt(1, bebida.getIdBebida());
        ResultSet rs = checkPedidos.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            bebida.setDescricao(null);
            bebida.setNome(null);
            bebida.setValor(0);
            BebidasDAO.atualizarBebida(bebida);
            throw new SQLException("Não é possível deletar a bebida porque ela está referenciada em PEDIDOS, registros serão atualizados como nulos.");
        }
    }

    // Deletar a bebida da tabela BEBIDAS se não houver registros relacionados
    try (Connection conn = Conexao.getConexao(); PreparedStatement deleteBebida = conn.prepareStatement("DELETE FROM BEBIDAS WHERE ID_BEBIDA = ?")) {
        deleteBebida.setInt(1, bebida.getIdBebida());
        deleteBebida.executeUpdate();
    }
    catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

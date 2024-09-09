package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.classes.Clientes;
import src.conexao.Conexao;

public class ClientesDAO {

    public static void cadastrarCliente(Clientes cliente) {
        String sql = "INSERT INTO CLIENTES (CPF, NOME, SENHA, SEXO, IDADE, ENDERECO, EMAIL, TELEFONE) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection conn = Conexao.getConexao(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSenha());
            ps.setString(4, cliente.getSexo());
            ps.setInt(5, cliente.getIdade());
            ps.setString(6, cliente.getEndereco());
            ps.setString(7, cliente.getEmail());
            ps.setString(8, cliente.getTelefone());

            ps.executeUpdate(); // Melhor usar executeUpdate para operações de atualização

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Clientes consultarCliente(String cpf) {
        Clientes cliente = null;
        String sql = "SELECT * FROM CLIENTES WHERE CPF = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Clientes(
                            rs.getString("CPF"),
                            rs.getString("NOME"),
                            rs.getString("SENHA"),
                            rs.getString("SEXO"),
                            rs.getInt("IDADE"),
                            rs.getString("ENDERECO"),
                            rs.getString("EMAIL"),
                            rs.getString("TELEFONE"));
                            cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public static void atualizarCliente(Clientes cliente) {
        cliente = ClientesDAO.consultarCliente(cliente.getCpf());
        String sql = "UPDATE CLIENTES SET NOME=?, SENHA=?, SEXO=?, IDADE=?, ENDERECO=?, EMAIL=?, TELEFONE=? WHERE ID_CLIENTE=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSenha());
            ps.setString(3, cliente.getSexo());
            ps.setInt(4, cliente.getIdade());
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getTelefone());
            ps.setInt(8, cliente.getIdCliente());
            ps.executeUpdate(); // Melhor usar executeUpdate para operações de atualização

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarCliente(String cpf) {
        Clientes cliente = ClientesDAO.consultarCliente(cpf);
        String sql = "DELETE FROM CLIENTES WHERE ID_CLIENTE = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
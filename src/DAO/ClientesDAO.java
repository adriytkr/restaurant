package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.classes.Clientes;
import src.conexao.Conexao;

public class ClientesDAO {

    public static void cadastrarCliente(Clientes cliente) {
        String sql = "INSERT INTO CLIENTES (CPF, NOME, SENHA, SEXO, IDADE, ENDERECO, EMAIL, TELEFONE, DATA_CADASTRO) VALUES (?,?,?,?,?,?,?,?,?)";

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
            ps.setString(9, cliente.getDataCadastro());

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
                            cliente.setDataCadastro(rs.getString("DATA_CADASTRO"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public static int consultarIdCliente(String cpf) {
        int id = 0;
        String sql = "SELECT ID_CLIENTE FROM CLIENTES WHERE CPF = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("ID_CLIENTE");
            }
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public static Clientes consultarCliente(Clientes cliente) {
        String sql = "SELECT * FROM CLIENTES WHERE ID_CLIENTE = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdCliente());
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
                            cliente.setDataCadastro(rs.getString("DATA_CADASTRO"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public static void atualizarCliente(Clientes cliente) {
        if (cliente.getIdCliente() == 0) {
            cliente.setIdCliente(ClientesDAO.consultarIdCliente(cliente.getCpf()));;
        }
        String sql = "UPDATE CLIENTES SET NOME=?, SENHA=?, SEXO=?, IDADE=?, ENDERECO=?, EMAIL=?, TELEFONE=?, CPF = ? WHERE ID_CLIENTE=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSenha());
            ps.setString(3, cliente.getSexo());
            ps.setInt(4, cliente.getIdade());
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getTelefone());
            ps.setString(8, cliente.getCpf());            
            ps.setInt(9, cliente.getIdCliente());
            ps.executeUpdate(); // Melhor usar executeUpdate para operações de atualização

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarCliente(Clientes cliente) throws SQLException {
        if (cliente.getIdCliente() == 0)  {
            cliente = ClientesDAO.consultarCliente(cliente.getCpf());
        }

    // Verificar se há registros relacionados na tabela INGREDIENTES e PEDIDOS
    try (Connection conn = Conexao.getConexao(); PreparedStatement checkReservas = conn.prepareStatement("SELECT COUNT(*) FROM RESERVAS WHERE ID_CLIENTE = ?")) {
        checkReservas.setInt(1, cliente.getIdCliente());
        ResultSet rs = checkReservas.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            cliente.setCpf(null);
            cliente.setDataCadastro(null);
            cliente.setEmail(null);
            cliente.setEndereco(null);
            cliente.setIdade(0);
            cliente.setNome(null);
            cliente.setSexo(null);
            cliente.setTelefone(null);
            cliente.setSenha(null);
            ClientesDAO.atualizarCliente(cliente);
            throw new SQLException("Não é possível deletar o cliente porque ela está referenciado em RESERVAS, registros serão atualizados como nulos.");
        }
    }

    try (Connection conn = Conexao.getConexao(); PreparedStatement checkPedidos = conn.prepareStatement("SELECT COUNT(*) FROM PEDIDOS WHERE ID_CLIENTE = ?")) {
        checkPedidos.setInt(1, cliente.getIdCliente());
        ResultSet rs = checkPedidos.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            cliente.setCpf(null);
            cliente.setDataCadastro(null);
            cliente.setEmail(null);
            cliente.setEndereco(null);
            cliente.setIdade(0);
            cliente.setNome(null);
            cliente.setSexo(null);
            cliente.setTelefone(null);
            cliente.setSenha(null);
            ClientesDAO.atualizarCliente(cliente);
            throw new SQLException("Não é possível deletar o cliente porque ela está referenciado em PEDIDOS, registros serão atualizados como nulos.");
        }
    }

    // Deletar o cliente se não houver registros relacionados
    try (Connection conn = Conexao.getConexao(); PreparedStatement deleteCliente = conn.prepareStatement("DELETE FROM CLIENTES WHERE ID_CLIENTE = ?")) {
        deleteCliente.setInt(1, cliente.getIdCliente());
        deleteCliente.executeUpdate();
    }
    catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
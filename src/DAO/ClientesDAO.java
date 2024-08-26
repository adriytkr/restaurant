package src.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.classes.Clientes;
import src.conexao.conexao;

public class ClientesDAO {

    public static void cadastrarCliente(Clientes cliente) {

        // SQL para inserção de um novo cliente na tabela 'Clientes'
        String sql = "INSERT INTO Clientes (CPF, Nome, senha, Sexo, Idade, Endereco, Email, Telefone) VALUES (?,?,?,?,?,?,?,?)";

        // Usando try-with-resources para garantir que PreparedStatement seja fechado
        // automaticamente
        try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {

            // Define os valores dos parâmetros do INSERT com base na posição na consulta
            // SQL
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSenha());
            ps.setString(4, cliente.getSexo());
            ps.setInt(5, cliente.getIdade());
            ps.setString(6, cliente.getEndereco());
            ps.setString(7, cliente.getEmail());
            ps.setString(8, cliente.getTelefone());

            // Executa o comando de inserção no banco de dados
            ps.execute();

        } catch (SQLException e) {
            // Imprime a pilha de rastreamento do erro caso ocorra uma exceção
            e.printStackTrace();
        }
    }

    public static Clientes consultarCliente(String cpf) {
        Clientes cliente = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Clientes WHERE cpf = ?";

        try (PreparedStatement ps = conexao.getConexao().prepareStatement(sql)) {

            ps.setString(1, cpf);
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Clientes(
                        rs.getString("CPF"),
                        rs.getString("Nome"),
                        rs.getString("Senha"),
                        rs.getString("Sexo"),
                        rs.getInt("Idade"),
                        rs.getString("Endereco"),
                        rs.getString("Email"),
                        rs.getString("Telefone"));
            }

        } catch (SQLException e) {
            // Imprime a pilha de rastreamento do erro caso ocorra uma exceção
            e.printStackTrace();
        }

        return cliente;

    }

}

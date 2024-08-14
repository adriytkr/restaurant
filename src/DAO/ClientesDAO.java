package src.DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.classes.Clientes;
import src.conexao.conexao;

public class ClientesDAO {
    
    public void  cadastrarCliente(Clientes cliente){

        String sql = "INSERT INTO Clientes (CPF, Nome,senha, Sexo, Idade, Endereco, Email, Telefone) VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1,cliente.getCpf());
            ps.setString(2,cliente.getNome());
            ps.setString(3,cliente.getSenha());
            ps.setString(4,cliente.getSexo());
            ps.setInt(5,cliente.getIdade());
            ps.setString(6,cliente.getEndereco());
            ps.setString(7,cliente.getEmail());
            ps.setString(8,cliente.getTelefone());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
}
package src.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.entidades.Funcionarios;
import src.util.Conexao;

public class FuncionariosDAO {

    public static void cadastrarFuncionario(Funcionarios funcionario) {
        String sql = "INSERT INTO FUNCIONARIOS (CPF, NOME, SENHA, SEXO, IDADE, ENDERECO, EMAIL, TELEFONE, DATA_CONTRATACAO,ID_FILIAL,CARGO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, funcionario.getCpf());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getSenha());
            ps.setString(4, funcionario.getSexo());
            ps.setInt(5, funcionario.getIdade());
            ps.setString(6, funcionario.getEndereco());
            ps.setString(7, funcionario.getEmail());
            ps.setString(8, funcionario.getTelefone());
            ps.setString(9, funcionario.getDataContratacao());
            ps.setInt(10, funcionario.getIdFilial());
            ps.setString(11, funcionario.getCargo());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Funcionarios consultarFuncionarios(String cpf) throws SQLException {
        Funcionarios funcionario = null;
        String sql = "SELECT * FROM FUNCIONARIOS WHERE CPF = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionarios(cpf,
                            rs.getString("NOME"),
                            rs.getString("SENHA"),
                            rs.getString("SEXO"),
                            rs.getInt("IDADE"),
                            rs.getString("ENDERECO"),
                            rs.getString("EMAIL"),
                            rs.getString("TELEFONE"),
                            rs.getString("CARGO"));
                    funcionario.setDataContratacao(rs.getString("DATA_CONTRATACAO"));
                    funcionario.setIdFuncionario(rs.getInt("ID_FUNC"));
                    funcionario.setIdFilial(rs.getInt("ID_FILIAL"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return funcionario;
        }

    }

    private static int consultarIdFuncionario(String cpf) {
        int id = 0;
        String sql = "SELECT ID_FUNC FROM FUNCIONARIOS WHERE CPF = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("ID_FUNC");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public static Funcionarios consultarFuncionarios(Funcionarios funcionario) throws SQLException {
        if (funcionario.getIdFuncionario() == 0) {
            funcionario.setIdFuncionario(FuncionariosDAO.consultarIdFuncionario(funcionario.getCpf()));
        }
        String sql = "SELECT * FROM FUNCIONARIOS WHERE ID_FUNC = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, funcionario.getIdFuncionario());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    funcionario.setCargo(rs.getString("CARGO"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setDataContratacao(rs.getString("DATA_CONTRATACAO"));
                    funcionario.setEmail(rs.getString("EMAIL"));
                    funcionario.setEndereco(rs.getString("ENDERECO"));
                    funcionario.setIdFilial(rs.getInt("ID_FILIAL"));
                    funcionario.setIdade(rs.getInt("IDADE"));
                    funcionario.setNome(rs.getString("NOME"));
                    funcionario.setSenha(rs.getString("SENHA"));
                    funcionario.setSexo(rs.getString("SEXO"));
                    funcionario.setTelefone(rs.getString("TELEFONE"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return funcionario;
        }

    }

    public static void atualizarFuncionario(Funcionarios funcionario) {
        if (funcionario.getIdFuncionario() == 0) {
            funcionario.setIdFuncionario(FuncionariosDAO.consultarIdFuncionario(funcionario.getCpf()));
        }
        String sql = "UPDATE FUNCIONARIOS SET CPF = ?, NOME = ?, SENHA = ?, SEXO = ?, IDADE = ?, ENDERECO = ?, EMAIL = ?, TELEFONE = ?, DATA_CONTRATACAO = ?, ID_FILIAL = ?,CARGO = ? WHERE ID_FUNC = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, funcionario.getCpf());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getSenha());
            ps.setString(4, funcionario.getSexo());
            ps.setInt(5, funcionario.getIdade());
            ps.setString(6, funcionario.getEndereco());
            ps.setString(7, funcionario.getEmail());
            ps.setString(8, funcionario.getTelefone());
            ps.setString(9, funcionario.getDataContratacao());
            ps.setInt(10, funcionario.getIdFilial());
            ps.setString(11, funcionario.getCargo());
            ps.setInt(12, funcionario.getIdFuncionario());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarFuncionario(Funcionarios funcionario) {
        if (funcionario.getIdFuncionario() == 0) {
            funcionario.setIdFuncionario(FuncionariosDAO.consultarIdFuncionario(funcionario.getCpf()));
        }
        String sql = "DELETE FROM FUNCIONARIOS WHERE ID_FUNC = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, funcionario.getIdFuncionario());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
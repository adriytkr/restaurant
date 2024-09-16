package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.classes.Filiais;
import src.conexao.Conexao;

public class FiliaisDAO {

    public static void cadastrarFilial(Filiais filial) {
        String sql = "INSERT INTO FILIAIS (ENDERECO,EMAIL,TELEFONE,QUANT_MESAS,AVALIACAO) VALUES (?,?,?,?,?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, filial.getEndereco());
            ps.setString(2, filial.getEmail());
            ps.setString(3, filial.getTelefone());
            ps.setInt(4, filial.getQuantidadeMesas());
            ps.setFloat(5, filial.getAvaliacao());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int consultarIdFilial(String endereco) {
        int id = 0;
        String sql = "SELECT ID_FILIAL FROM FILIAIS WHERE ENDERECO = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, endereco);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("ID_FILIAL");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public static Filiais consultarFilial(Filiais filial) {

        if (filial.getIdFilial() == 0) {
            filial.setIdFilial(FiliaisDAO.consultarIdFilial(filial.getEndereco()));
        }

        String sql = "SELECT * FROM FILIAIS WHERE ID_FILIAL = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, filial.getIdFilial());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    filial.setAvaliacao(rs.getFloat("AVALIACAO"));
                    filial.setEmail(rs.getString("EMAIL"));
                    filial.setQuantidadeMesas(rs.getInt("QUANT_MESAS"));
                    filial.setTelefone(rs.getString("TELEFONE"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filial;
    }

    public static void atualizarFilial(Filiais filial) {

        if (filial.getIdFilial() == 0) {
            filial.setIdFilial(FiliaisDAO.consultarIdFilial(filial.getEndereco()));
        }

        String sql = "UPDATE FILIAIS SET ENDERECO = ?, EMAIL = ?, TELEFONE = ?, QUANT_MESAS = ?, AVALIACAO = ? WHERE ID_FILIAL = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, filial.getEndereco());
            ps.setString(2, filial.getEmail());
            ps.setString(3, filial.getTelefone());
            ps.setInt(4, filial.getQuantidadeMesas());
            ps.setFloat(5, filial.getAvaliacao());
            ps.setInt(6, filial.getIdFilial());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarFilial(Filiais filial) {

        if (filial.getIdFilial() == 0) {
            filial.setIdFilial(FiliaisDAO.consultarIdFilial(filial.getEndereco()));
        }

        String sql = "DELETE FROM FILIAIS WHERE ID_FILIAL = ?";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, filial.getIdFilial());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
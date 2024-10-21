package src.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.entidades.Filiais;
import src.util.Conexao;

public class FiliaisDAO {

    public static void cadastrarFilial(Filiais filial) {
        String sql = "INSERT INTO FILIAIS (ENDERECO,EMAIL,TELEFONE,QUANTIDADE_MESAS,AVALIACAO) VALUES (?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = Conexao.getConexao(); // Obter a conexão
            conn.setAutoCommit(false); // Desabilitar commit automático
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, filial.getEndereco());
                ps.setString(2, filial.getEmail());
                ps.setString(3, filial.getTelefone());
                ps.setInt(4, filial.getQuantidadeMesas());
                ps.setFloat(5, filial.getAvaliacao());
                ps.executeUpdate();

            }
            conn.commit(); // Realizar o commit das operações
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Desfazer as operações em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            System.err.println("Erro ao cadastrar item: " + e.getMessage());

        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Restaurar o auto commit
                    conn.close(); // Fechar a conexão manualmente
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
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
                    filial.setQuantidadeMesas(rs.getInt("QUANTIDADE_MESAS"));
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

        String sql = "UPDATE FILIAIS SET ENDERECO = ?, EMAIL = ?, TELEFONE = ?, QUANTIDADE_MESAS = ?, AVALIACAO = ? WHERE ID_FILIAL = ?";
        Connection conn = null;

        try {
            conn = Conexao.getConexao(); // Obter a conexão
            conn.setAutoCommit(false); // Desabilitar commit automático
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, filial.getEndereco());
                ps.setString(2, filial.getEmail());
                ps.setString(3, filial.getTelefone());
                ps.setInt(4, filial.getQuantidadeMesas());
                ps.setFloat(5, filial.getAvaliacao());
                ps.setInt(6, filial.getIdFilial());
                ps.executeUpdate();

            }
            conn.commit(); // Realizar o commit das operações
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Desfazer as operações em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            System.err.println("Erro ao cadastrar item: " + e.getMessage());

        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Restaurar o auto commit
                    conn.close(); // Fechar a conexão manualmente
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    public static void deletarFilial(Filiais filial) {

        if (filial.getIdFilial() == 0) {
            filial.setIdFilial(FiliaisDAO.consultarIdFilial(filial.getEndereco()));
        }

        String sql = "DELETE FROM FILIAIS WHERE ID_FILIAL = ?";
        Connection conn = null;

        try {
            conn = Conexao.getConexao(); // Obter a conexão
            conn.setAutoCommit(false); // Desabilitar commit automático
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, filial.getIdFilial());
                ps.executeUpdate();

            }
            
            conn.commit(); // Realizar o commit das operações
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Desfazer as operações em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            System.err.println("Erro ao cadastrar item: " + e.getMessage());

        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Restaurar o auto commit
                    conn.close(); // Fechar a conexão manualmente
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }
}
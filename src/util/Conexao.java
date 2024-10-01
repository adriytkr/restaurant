package src.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/RESTAURANTE";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private static Connection conn;

    // Método estático que retorna a conexão com o banco de dados
    public static synchronized Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

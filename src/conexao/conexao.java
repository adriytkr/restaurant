package src.conexao;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {

    private static final String url = "jdbc:mysql://localhost:3306/restaurante";
    private static final String usuario = "root";
    private static final String senha = "";

    private static Connection conn;

    public static Connection getConexao(){
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, usuario, senha);
                return conn;
            }else{
                return conn;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

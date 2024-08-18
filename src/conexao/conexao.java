package src.conexao;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {

    private static final String url = "jdbc:mysql://localhost:3306/restaurante";
    private static final String usuario = "root";
    private static final String senha = "";

    private static Connection conn; // Variável estática que armazenará a conexão com o banco de dados. Inicialmente, está definida como null.

    // Método estático que retorna a conexão com o banco de dados
    public static Connection getConexao(){
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, usuario, senha); // O DriverManager é uma classe Java que gerencia os drivers de banco de dados e fornece uma maneira de obter uma conexão com o banco de dados. O método getConnection retorna um objeto Connection configurado para o banco de dados especificado.
                return conn;
            } else {
                return conn;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime a pilha de rastreamento do erro caso ocorra uma exceção
            return null;
        }
    }
}

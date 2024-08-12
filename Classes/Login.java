package Classes;

public class Login {
    private String userName;
    private String senha;

    public Login(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
    }
    
    // GETTERS E SETTERS
    public String getSenha() {
        return this.senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
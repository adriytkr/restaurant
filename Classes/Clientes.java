package Classes;

public class Clientes {
    private String cpf;
    private String nome;
    private String sexo;
    private int idade;
    private String endereco;
    private String email;
    private String telefone;
    private String dataCadastro;
    
    public Clientes(String cpf, String nome, String sexo, int idade, String endereco, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    
    // GETTERS E SETTERS
    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSexo() {
        return this.sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDataCadastro() {
        return this.dataCadastro;
    }
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
package Classes;

public class Funcionarios {
    private String cpf;
    private String nome;
    private String sexo;
    private int idade;
    private String endereco;
    private String email;
    private String telefone;
    private String dataContratacao;
    private String cargo;

    public Funcionarios(String cpf, String nome, String sexo, int idade, String endereco, String email, String telefone,
            String dataContratacao, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
    }

    // GETTERS E SETTERS
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDataContratacao() {
        return dataContratacao;
    }
    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
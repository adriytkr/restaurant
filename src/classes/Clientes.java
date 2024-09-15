package src.classes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Clientes {
    private String cpf;
    private String nome;
    private String sexo;
    private String senha;
    private int idade;
    private int idCliente;
    private int idFilial;
    private String endereco;
    private String email;
    private String telefone;
    private String dataCadastro;
    
    public Clientes(String cpf, String nome,String senha, String sexo, int idade, String endereco, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.sexo = sexo;
        this.idade = idade;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        this.dataCadastro = formattedDateTime;
    }

    public void visualizandoCliente(){
        System.out.println("");
        System.out.println("Nome: " + this.nome);
        System.out.println("Senha: " + this.senha);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Idade: " + this.idade);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Email: " + this.email);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Id_cliente: " + this.idCliente);
        System.out.println("Id_filial: " + this.idFilial);
        System.out.println("Data de cadastro: " + this.dataCadastro);
        System.out.println("");
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
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }
    
}
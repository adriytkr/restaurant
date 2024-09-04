package src.classes;

public class Bebidas {
    private String nome;
    private String descricao;
    private float valor;
    private int idBebida;
    
    public Bebidas(String nome, String descricao, float valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }
}
package src.classes;

public class Pedidos {
    private float valor;
    private String tipoDePagamento;
    private String endereco;
    private String dataPedido;

    public Pedidos(float valor, String tipoDePagamento, String endereco, String dataPedido) {
        this.valor = valor;
        this.tipoDePagamento = tipoDePagamento;
        this.endereco = endereco;
        this.dataPedido = dataPedido;
    }

    // GETTERS E SETTERS
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getTipoDePagamento() {
        return tipoDePagamento;
    }
    public void setTipoDePagamento(String tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }
}
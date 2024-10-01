package src.model.entidades;

public class Entregas {
    private String endereco;
    String dataEntrega;
    private int idEntrega;
    private int idPedido;

    public Entregas(String endereco, int idPedido) {
        this.endereco = endereco;
        this.idPedido = idPedido;
    }

    public void visualizarEntrega(){
        System.out.println("ENTREGA: ");
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Data de entrega:" + this.dataEntrega);
        System.out.println("ID_ENTREGA: " + this.idEntrega);
        System.out.println("ID_PEDIDO: " + this.idPedido);
    }
    
    // GETTERS E SETTERS
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
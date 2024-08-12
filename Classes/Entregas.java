package Classes;

public class Entregas {
    private String endereco;
    private String dataEntrega;

    public Entregas(String endereco, String dataEntrega) {
        this.endereco = endereco;
        this.dataEntrega = dataEntrega;
    }
    
    // GETTERS E SETTERS
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
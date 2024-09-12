package src.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entregas {
    private String endereco;
    String dataEntrega;
    private int idEntrega;
    private int idPedido;

    public Entregas(String endereco) {
        this.endereco = endereco;

            // Obtém a data e hora atual
            LocalDateTime now = LocalDateTime.now();
            // Define um formatador sem frações de segundos
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // Formata a data e hora
            String formattedDateTime = now.format(formatter);
        this.dataEntrega = formattedDateTime;
    }

    public void visualizarEntrega(){
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
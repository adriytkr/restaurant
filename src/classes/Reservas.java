package src.classes;
public class Reservas {
    private String dataReserva;
    private int mesa;   
    private int capacidade; 

    public Reservas(String dataReserva, int mesa, int capacidade) {
        this.dataReserva = dataReserva;
        this.mesa = mesa;
        this.capacidade = capacidade;
    }
    
    // GETTERS E SETTERS
    public String getDataReserva() {
        return dataReserva;
    }
    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }
    public int getMesa() {
        return mesa;
    }
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }  
}
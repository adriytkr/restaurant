package Classes;

public class Ingredientes {
    private String nome;
    private String unidadeDeMedida;

    public Ingredientes(String nome, String unidadeDeMedida) {
        this.nome = nome;
        this.unidadeDeMedida = unidadeDeMedida;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }
    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }
}
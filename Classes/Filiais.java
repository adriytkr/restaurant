package Classes;

public class Filiais {
    private String endereco;
    private String email;
    private String telefone;
    private String quantidadeMesas;
    private float avaliacao;

    public Filiais(String endereco, String email, String telefone, String quantidadeMesas, float avaliacao) {
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.quantidadeMesas = quantidadeMesas;
        this.avaliacao = avaliacao;
    }

    // GETTERS E SETTERS
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
    public String getQuantidadeMesas() {
        return quantidadeMesas;
    }
    public void setQuantidadeMesas(String quantidadeMesas) {
        this.quantidadeMesas = quantidadeMesas;
    }
    public float getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
}

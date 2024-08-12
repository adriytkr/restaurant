package Classes;

public class Fornecedores {
    private String nome;
    private String cnpj;
    private String tipoMaterial;
    private String email;
    private String telefone;
    private float valorMaterial;

    public Fornecedores(String nome, String cnpj, String tipoMaterial, String email, String telefone,
            float valorMaterial) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.tipoMaterial = tipoMaterial;
        this.email = email;
        this.telefone = telefone;
        this.valorMaterial = valorMaterial;
    }

    
    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getTipoMaterial() {
        return tipoMaterial;
    }
    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
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
    public float getValorMaterial() {
        return valorMaterial;
    }
    public void setValorMaterial(float valorMaterial) {
        this.valorMaterial = valorMaterial;
    }
}

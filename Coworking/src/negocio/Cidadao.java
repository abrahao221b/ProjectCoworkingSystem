package negocio;

public class Cidadao {
    private String nome;
    private String cpf;
    private String rg;

    public Cidadao(String nome, String cpf, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRg() {
        return this.rg;
    }
}

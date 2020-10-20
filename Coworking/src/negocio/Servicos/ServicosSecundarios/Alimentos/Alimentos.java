package negocio.Servicos.ServicosSecundarios.Alimentos;

import negocio.Data.Data;

import java.io.Serializable;

public class Alimentos implements Serializable {
    protected String nome;
    protected String id;
    protected Data validade;

    public Alimentos(String nome, Data validade) {
        this.nome = nome;
        this.id = Integer.toString(setarCodigo());
        this.validade = validade;
    }

    private int setarCodigo() {
        return (int) Math.round(Math.random() * 100);

    }

    @Override
    public String toString() {
        return "Alimentos{" +
                "nome='" + this.nome + '\'' +
                ", id='" + this.id + '\'' +
                ", validade=" + this.validade.printData() +
                '}';
    }

    public String getId() {
        return this.id;
    }
}

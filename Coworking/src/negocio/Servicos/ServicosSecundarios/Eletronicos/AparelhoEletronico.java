package negocio.Servicos.ServicosSecundarios.Eletronicos;

import java.io.Serializable;

public class AparelhoEletronico implements Serializable {

    private String nome;
    private String id;
    private boolean devolvido;

    public AparelhoEletronico(String nome) {
        this.nome = nome;
        this.id = Integer.toString(setarCodigo());
        this.devolvido = true;
    }

    private int setarCodigo() {
        return (int) Math.round(Math.random() * 100);

    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AparelhoEletronico{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", devolvido=" + devolvido +
                '}';
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}

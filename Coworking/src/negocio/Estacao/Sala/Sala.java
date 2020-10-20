package negocio.Estacao.Sala;


import java.io.Serializable;

public class Sala implements Serializable {
    private Tipo tipo;
    private Estilo estilo;
    private String codigo;
    private boolean comAparelhamento;
    private double tamanho;

    public Sala(Tipo tipo, Estilo estilo, double tamanho) {
        this.tipo = tipo;
        this.estilo = estilo;
        this.codigo = Integer.toHexString(setarCodigo());
        this.comAparelhamento = false;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "tipo=" + this.tipo +
                ", estilo=" + this.estilo +
                ", codigo='" + this.codigo + '\'' +
                ", comAparelhamento=" + this.comAparelhamento +
                ", tamanho=" + this.tamanho +
                '}';
    }

    private int setarCodigo() {
        return (int) Math.round(Math.random() * 100);
    }

    public void setComAparelhamento(boolean comAparelhamento) {
        this.comAparelhamento = comAparelhamento;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public enum Tipo {
        PEQUENA, MEDIA, MEDIAGRANDE, GRANDE, MUITOGRANDE
    }

    public enum Estilo {
        TECH, JOVEM, JOVEM_ADULTO, ADULTO, CLASSICA, PARA_REUNIOES, DESCONTRAIDA
    }
}

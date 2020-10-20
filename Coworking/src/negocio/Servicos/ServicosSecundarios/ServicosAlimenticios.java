package negocio.Servicos.ServicosSecundarios;

import negocio.Data.Data;
import negocio.Servicos.Servicos;
import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;

import java.io.Serializable;


public class ServicosAlimenticios extends Servicos implements Serializable {

    private TipoDeAlimento tipoDeAlimento;
    private int quantidade;
    private boolean emEstoque;
    private Alimentos alimento;


    public ServicosAlimenticios (TipoDeAlimento tipoDeAlimento, int quantidade, double preco,
                                 boolean emEstoque, Tipo tipo, Data periodo, boolean ativo, Alimentos alimento) {
        super(tipo, preco, periodo, ativo);
        this.tipoDeAlimento = tipoDeAlimento;
        this.quantidade = quantidade;
        this.emEstoque = emEstoque;
        this.alimento = alimento;
    }



    @Override
    public String getCodigoDoServico() {
        return super.codigoDoServico;
    }

    @Override
    public String toString() {
        return "ServicosAlimenticios{" +
                "tipo=" + this.tipo +
                ", preco=R$" + this.preco +
                ", periodo=" + this.periodo.printData() +
                ", codigoDoServico='" + this.codigoDoServico + '\'' +
                ", ativo=" + this.ativo +
                ", Alimento={" + this.alimento.toString() + "}" +
                "\n" +
                '}';
    }

    public enum TipoDeAlimento {
        LIQUIDO, NAO_LIQUIDO
    }
}

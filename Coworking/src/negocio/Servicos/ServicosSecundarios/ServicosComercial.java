package negocio.Servicos.ServicosSecundarios;

import negocio.Data.Data;
import negocio.Servicos.Servicos;

import java.io.Serializable;

public class ServicosComercial extends Servicos implements Serializable {

    protected TipoComercial tipoComercial;
    protected int quantidade;

    public ServicosComercial(double preco, Data data, Tipo tipo,
                             boolean ativo, TipoComercial tipoComercial, int quantidade) {
        super(tipo, preco, data, ativo);
        this.tipoComercial = tipoComercial;
        this.quantidade = quantidade;
    }

    @Override
    public String getCodigoDoServico() {
        return super.getCodigoDoServico();
    }

    @Override
    public String toString() {
        return "Servicos{" +
                "tipo=" + this.tipo +
                ", preco=R$" + this.preco +
                ", periodo=" + this.periodo.printData() +
                ", codigoDoServico='" + this.codigoDoServico + '\'' +
                ", ativo=" + this.ativo +
                ", tipo de comercio=" + this.tipoComercial +
                "\n" +
                '}';
    }

    public enum TipoComercial {
        AGUA, INTERNET, LIMPESA
    }
}

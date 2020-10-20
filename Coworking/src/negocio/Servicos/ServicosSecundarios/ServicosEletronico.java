package negocio.Servicos.ServicosSecundarios;

import negocio.Data.Data;
import negocio.Servicos.Servicos;
import negocio.Servicos.ServicosSecundarios.Eletronicos.AparelhoEletronico;

import java.io.Serializable;


public class ServicosEletronico extends Servicos implements Serializable {
    protected AparelhoEletronico aparelhoEletronico;
    protected int quantidade;

    public ServicosEletronico(double preco, Data data, Tipo tipo,
                              boolean ativo, int quantidade, AparelhoEletronico aparelhoEletronico) {
        super(tipo, preco, data, ativo);
        this.quantidade = quantidade;
        this.aparelhoEletronico = aparelhoEletronico;
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
                ", Aparelho={" + this.aparelhoEletronico.toString() + "}"+
                "\n" +
                '}';
    }

}

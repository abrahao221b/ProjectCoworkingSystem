package negocio.Servicos;

import negocio.Data.Data;

import java.io.Serializable;

public class Servicos implements Serializable {

    protected Tipo tipo;
    protected double preco;
    protected Data periodo;
    protected String codigoDoServico;
    //Deve ser modificado, pois deveria ter um Array que diria estar disponível ou não!!!!
    protected boolean ativo;

    public Servicos(Tipo tipo, double preco, Data periodo, boolean ativo) {
        this.tipo = tipo;
        this.preco = preco;
        this.periodo = periodo;
        this.ativo = ativo;
        this.codigoDoServico = Integer.toString(setarCodigo());
    }

    private int setarCodigo() {
        return (int) Math.round(Math.random() * 100);

    }

    public String getCodigoDoServico() {
        return this.codigoDoServico;
    }

    @Override
    public String toString() {
        return "Servicos{" +
                "tipo=" + this.tipo +
                ", preco=R$" + this.preco +
                ", periodo=" + this.periodo.printData() +
                ", codigoDoServico='" + this.codigoDoServico + '\'' +
                ", ativo=" + this.ativo +
                "\n" +
                '}';
    }

    public double getPreco() {
        return this.preco;
    }

    public enum Tipo {
        SERVICO_COMERCIAL, SERVICO_ALIMENTICIO, SERVICO_ELETRONICO
    }
}

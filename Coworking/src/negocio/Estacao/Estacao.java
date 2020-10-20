package negocio.Estacao;

import negocio.Clientes.ClienteAbstrata;
import negocio.Data.Data;
import negocio.Estacao.Sala.Sala;
import negocio.Localidade.Localidade;

import java.io.Serializable;


public class Estacao implements Serializable {

    private Localidade localidade;
    private String codigoDaLocalidade;
    private ClienteAbstrata clienteFisico;
    private int nivel;
    private boolean locado;
    private Data periodoDeLocacao;
    private Data dataAtual;
    private Sala sala;
    private double preco;

    public Estacao( Localidade localidade, int nivel, double preco, Sala sala, Data dataAtual) {
        this.localidade = localidade;
        this.codigoDaLocalidade = Integer.toString(setarCodigo());
        this.nivel = nivel;
        this.locado = false;
        this.periodoDeLocacao = dataAtual;
        this.preco = preco;
        this.clienteFisico = null;
        this.sala = sala;
        this.dataAtual = null;
    }

    private int setarCodigo() {
        return (int) Math.round(Math.random() * 100);

    }


    private void terminoDoPeriodo(Data data) {
        if (this.periodoDeLocacao.equals(data)) {
            this.locado = false;
        } else {
            this.locado = true;
        }
    }

    @Override
    public String toString() {
        if (this.periodoDeLocacao == null) {
            this.periodoDeLocacao = this.dataAtual;
        }
        return "Estacao{" +
                "localidade=" + this.localidade +
                ", codigoDaLocalidade='" + this.codigoDaLocalidade + '\'' +
                ", clienteFisico=" + this.clienteFisico +
                ", nivel=" + this.nivel +
                ", locado=" + this.locado +
                ", periodoDeLocacao=" + this.periodoDeLocacao.printData() +
                ", preco=R$" + this.preco +
                ", sala={" + this.sala.toString() + "}" +
                ", localidade={" + this.localidade.toString() + "}"+
                '}';
    }

    public String getCodigoDaLocalidade() {
        return this.codigoDaLocalidade;
    }

    public double getPreco() {
        return this.preco;
    }

    public boolean getLocado() {
        return this.locado;
    }

    public Data getPeriodoDeLocacao() {
        return this.periodoDeLocacao;
    }

    public void setPeriodoDeLocacao(Data periodoDeLocacao) {
        this.periodoDeLocacao = periodoDeLocacao;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }

    public ClienteAbstrata getClienteFisico() {
        return clienteFisico;
    }

    public void setClienteFisico(ClienteAbstrata clienteFisico) {
        this.clienteFisico = clienteFisico;
    }
}

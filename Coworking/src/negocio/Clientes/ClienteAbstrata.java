package negocio.Clientes;

import negocio.Clientes.Cidadao.Cidadao;
import negocio.Data.Data;
import negocio.Localidade.Localidade;
import negocio.Servicos.Servicos;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteAbstrata implements Serializable {

    protected String name;
    protected String rgDoTitular;
    protected String codigo;
    protected Localidade endereco;
    protected Cidadao cidadao;
    protected ArrayList<Servicos> servicos;
    protected Data data;
    protected double valorMensal;

    public ClienteAbstrata(String codigo, Cidadao cidadao, Localidade endereco, Data data) {
        this.codigo = codigo;
        this.name = cidadao.getNome();
        this.rgDoTitular = cidadao.getRg();
        this.endereco = endereco;
        this.data = data;
        this.servicos = new ArrayList<>();
        this.valorMensal = 0;
    }

    @Override
    public String toString() {
        return "ClienteFísico{" +
                "name='" + this.name + '\'' +
                ", rgDoTitular='" + this.rgDoTitular + '\'' +
                ", codigo='" + this.codigo + '\'' +
                ", estado=" + this.endereco.getEstado() +
                ", cidade=" + this.endereco.getCidade() +
                ", bairro=" + this.endereco.getBairro() +
                ", rua=" + this.endereco.getRua() +
                ", cep=" + this.endereco.getCep() +
                ", numero=" + this.endereco.getNumero() +
                ", cidade=" + this.endereco.getCidade() +
                ", dataDeNascimento=" + this.data.printData() +
                ", valorTotalParaPagar=R$" + this.valorMensal +
                '}';
    }

    public void printServicoArrayList() {
        for (Servicos i: this.servicos) {
            System.out.println(i.toString());
        }
    }

    public void setServicos(Servicos servico) {
        if (servico != null) {
            this.servicos.add(servico);
            this.valorMensal += servico.getPreco();
        }
    }

    public void apagarServico(Servicos servicos) {
        if (servicos != null) {
            for (Servicos i: this.servicos) {
                this.servicos.remove(servicos);
                this.valorMensal -= servicos.getPreco();
            }
        }
    }

    public void apagarTodosOsServicos() {
        for (int i = 0; i < this.servicos.size(); i++) {
            this.servicos.set(i, null);
        }
    }

    public void printServicos() {
        for (Servicos i: this.servicos) {
            System.out.println(i.toString());
        }
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public void setEndereco(Localidade endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Servicos> getServicos() {
        return this.servicos;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public double getValorMensal() {
        return this.valorMensal;
    }

    public Localidade getEndereco() {
        return this.endereco;
    }

    public Cidadao getCidadao() {
        return this.cidadao;
    }
}

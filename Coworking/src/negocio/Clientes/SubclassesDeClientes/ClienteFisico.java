package negocio.Clientes.SubclassesDeClientes;

import negocio.Clientes.Cidadao.Cidadao;
import negocio.Clientes.ClienteAbstrata;
import negocio.Localidade.Localidade;
import negocio.Servicos.Servicos;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteFisico extends ClienteAbstrata implements Serializable {

    public ClienteFisico(Cidadao cidadao, Localidade endereco) {
        super(cidadao.getCpf(), cidadao, endereco, cidadao.getDataDeNascimento());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void setServicos(Servicos servico) {
        super.setServicos(servico);
    }

    @Override
    public void printServicoArrayList() {
        super.printServicoArrayList();
    }

    @Override
    public void setValorMensal(double valorMensal) {
        super.setValorMensal(valorMensal);
    }

    @Override
    public void setCidadao(Cidadao cidadao) {
        super.setCidadao(cidadao);
    }

    @Override
    public void printServicos() {
        super.printServicos();
    }

    @Override
    public void setEndereco(Localidade endereco) {
        super.setEndereco(endereco);
    }

    @Override
    public ArrayList<Servicos> getServicos() {
        return super.getServicos();
    }

    @Override
    public String getCodigo() {
        return super.getCodigo();
    }

    @Override
    public double getValorMensal() {
        return super.getValorMensal();
    }


}

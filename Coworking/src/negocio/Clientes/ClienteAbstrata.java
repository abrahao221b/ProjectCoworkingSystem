package negocio.Clientes;

import negocio.Cidadao;
import negocio.Endereco.Localidade;

public class ClienteAbstrata {
    protected String name;
    protected String rgDoTitular;
    protected String codigo;
    protected Localidade endereco;
    protected Cidadao cidadao;

    public ClienteAbstrata(String codigo, Cidadao cidadao, Localidade endereco) {
        this.codigo = codigo;
        this.name = cidadao.getNome();
        this.rgDoTitular = cidadao.getRg();
        this.endereco = endereco;
        ClienteInterface clienteInterface = new ImplementadaClienteInterface();
    }

    @Override
    public String toString() {
        return "ClienteAbstrata{" +
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
                '}';
    }
}

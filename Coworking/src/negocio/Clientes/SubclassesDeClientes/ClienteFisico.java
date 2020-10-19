package negocio.Clientes.SubclassesDeClientes;

import negocio.Cidadao;
import negocio.Clientes.ClienteAbstrata;
import negocio.Endereco.Localidade;

public class ClienteFisico extends ClienteAbstrata {
    private String cpf;

    public ClienteFisico(String cpf, Cidadao cidadao, Localidade endereco) {
        super(cpf, cidadao, endereco);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

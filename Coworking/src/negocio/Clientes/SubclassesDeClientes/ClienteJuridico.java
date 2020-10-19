package negocio.Clientes.SubclassesDeClientes;

import negocio.Cidadao;
import negocio.Clientes.ClienteAbstrata;
import negocio.Endereco.Localidade;

public class ClienteJuridico extends ClienteAbstrata {
    private String cnpj;

    public ClienteJuridico(String cnpj, Cidadao cidadao, Localidade endereco) {
        super(cnpj, cidadao, endereco);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

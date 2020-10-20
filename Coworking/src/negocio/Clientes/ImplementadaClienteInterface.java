package negocio.Clientes;

import negocio.Clientes.Cidadao.Cidadao;
import negocio.Clientes.SubclassesDeClientes.ClienteFisico;
import negocio.Data.Data;
import negocio.Estacao.Estacao;
import negocio.Localidade.Localidade;
import negocio.Servicos.Servicos;

public class ImplementadaClienteInterface implements ClienteInterface {

    @Override
    public ClienteAbstrata cadastrar(Cidadao cidadao, Localidade localidade) {
        return new ClienteFisico(cidadao, localidade);
    }

    @Override
    public ClienteAbstrata corrigirCadastroPessoa(String cpf, Cidadao cidadao, ClienteAbstrata clienteAntigo) {
        if (clienteAntigo.getCodigo().equals(cpf)) {
            return new ClienteFisico(cidadao, clienteAntigo.getEndereco());
        } else {
            System.out.println("Cpf errado!");
            return clienteAntigo;
        }
    }

    @Override
    public void corrigirCadastroLocalidade(String cpf, ClienteAbstrata clienteAntigo, Localidade localidade) {
        if (clienteAntigo.getCodigo().equals(cpf)) {
            clienteAntigo.setEndereco(localidade);
        } else  {
            System.out.println("Cpf errado!");
        }
    }

    @Override
    public void locar(Estacao estacao, Data periodo, ClienteAbstrata cliente, String cpf) {
        if (cliente.getCodigo().equals(cpf)) {
            if (estacao.getClienteFisico() == null) {
                estacao.setPeriodoDeLocacao(periodo);
                estacao.setClienteFisico(cliente);
                estacao.setLocado(true);
                cliente.setValorMensal(estacao.getPreco());
            } else {
                verEstatusDaLocacao(estacao, periodo.getDiaData());
            }
        } else {
            System.out.println("Cpf errado!");
        }
    }

    @Override
    public void cancelarLocacao(Estacao estacao, String codigoEstacao,
                                   Data dataAtual, ClienteAbstrata cliente, String cpf) {
        if (estacao.getCodigoDaLocalidade().equals(codigoEstacao)) {
            if (cliente.getCodigo().equals(cpf)) {
                estacao.setClienteFisico(null);
                estacao.setPeriodoDeLocacao(dataAtual);
                estacao.setLocado(false);
                cliente.apagarTodosOsServicos();
                cliente.setValorMensal(0);
            } else {
                System.out.println("Cliente inexistente!");
            }
        } else {
            System.out.println("Erro: Estação inexistente!");
        }
    }

    @Override
    public void verEstatusDaLocacao(Estacao estacao, Data dia) {
        if (!(estacao.getPeriodoDeLocacao().equals(dia))) {
            System.out.println("A estação está locada!!");
            System.out.println("A estação só será liberada na data: " +
                    estacao.getPeriodoDeLocacao().printData());
        } else {
            System.out.println("A estação está liberada!!");
        }
    }

    @Override
    public void escolherServico(Estacao estacao, ClienteAbstrata cliente,
                                Servicos servicos, String cpfCliente, String codigoEstacao) {
        if (estacao.getCodigoDaLocalidade().equals(codigoEstacao)) {
            if (cliente.getCodigo().equals(cpfCliente)) {
                cliente.setServicos(servicos);
                estacao.setClienteFisico(cliente);
            } else {
                System.out.println("Erro: CPF inválido!!!!");
            }
        } else {
            System.out.println("Erro Estação inválida!!!");
        }
    }

    @Override
    public void cancelarServico(ClienteAbstrata cliente, Servicos servico, String cpfCliente) {
        if (cliente.getCodigo().equals(cpfCliente)) {
            cliente.apagarServico(servico);
        } else {
            System.out.println("Cpf inválido!");
        }
    }

    @Override
    public void verEstatusDoCliente(ClienteAbstrata cliente) {
        System.out.println(cliente.toString());
    }
}

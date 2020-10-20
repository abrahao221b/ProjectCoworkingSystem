package negocio.Clientes;

import Repositorios.RepositorioDeCliente;
import Repositorios.RepositorioDeEstacao;
import negocio.Clientes.Cidadao.Cidadao;
import negocio.Data.Data;
import negocio.Estacao.Estacao;
import negocio.Localidade.Localidade;
import negocio.Servicos.Servicos;


public interface ClienteInterface {

    public ClienteAbstrata cadastrar(Cidadao cidadao, Localidade localidade);
    public ClienteAbstrata corrigirCadastroPessoa(String cpf, Cidadao cidadao, ClienteAbstrata clienteAntigo);
    public void corrigirCadastroLocalidade(String cpf,
                                           ClienteAbstrata clienteAntigo, Localidade localidade);
    public void locar(Estacao estacao, Data periodo, ClienteAbstrata cliente, String cpf);
    public void cancelarLocacao(Estacao estacao, String codigoEstacao,
                                   Data dataAtual, ClienteAbstrata cliente, String cpf);
    public void verEstatusDaLocacao(Estacao estacao, Data dia);
    public void escolherServico(Estacao estacao, ClienteAbstrata cliente, Servicos servicos,
                                String cpfCliente, String codigoEstacao);
    public void verEstatusDoCliente(ClienteAbstrata cliente);
    public void cancelarServico(ClienteAbstrata cliente, Servicos servico, String cpfCliente);
}

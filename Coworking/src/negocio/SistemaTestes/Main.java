package negocio.SistemaTestes;

import Repositorios.*;
import negocio.Clientes.Cidadao.Cidadao;
import negocio.Clientes.ClienteAbstrata;
import negocio.Clientes.ClienteInterface;
import negocio.Clientes.ImplementadaClienteInterface;
import negocio.Clientes.SubclassesDeClientes.ClienteFisico;
import negocio.Data.Data;
import negocio.Estacao.Estacao;
import negocio.Estacao.Sala.Sala;
import negocio.Localidade.Localidade;
import negocio.Servicos.Servicos;
import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;
import negocio.Servicos.ServicosSecundarios.Eletronicos.AparelhoEletronico;
import negocio.Servicos.ServicosSecundarios.ServicosAlimenticios;
import negocio.Servicos.ServicosSecundarios.ServicosComercial;
import negocio.Servicos.ServicosSecundarios.ServicosEletronico;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);

        //Data atual.
        Data dataQualquer = new Data(19,10, 2020);
        Data dataAtual = dataQualquer.getDiaData();

        //Criando um objeto da interface.
        ClienteInterface clienteInterface = new ImplementadaClienteInterface();

        //Criando os repositórios.
        RepositorioDeAlimentos repositorioDeAlimentos = new RepositorioDeAlimentos();
        RepositorioDeCliente repositorioDeCliente = new RepositorioDeCliente();
        RepositorioDeEstacao repositorioDeEstacao = new RepositorioDeEstacao();
        RepositorioDeEquipamentosEletronicos repositorioDeEquipamentosEletronicos =
                new RepositorioDeEquipamentosEletronicos();
        RepositorioDeServicos repositorioDeServicos = new RepositorioDeServicos();
        RepositorioDeSala repositorioDeSala = new RepositorioDeSala();

        //Criando Data.
        Data dataDeNascimentoPrimeiroCidadao = new Data(12, 12, 1990);
        Data dataDeNascimentoSegundoCidadao = new Data(1, 2, 1997);
        Data dataDeNascimentoTerceiroCidadao = new Data(2, 4, 1988);


        Data dataServico = new Data(dataAtual.getDia(), dataAtual.getMes(), dataAtual.getAno() + 1);

        Data validadeSanduiche = new Data(dataAtual.getDia(), dataAtual.getMes() + 7, dataAtual.getAno());
        Data validadeAgua = new Data(dataAtual.getDia(), dataAtual.getMes(), 2200);

        //Criado Localidade.
        Localidade localidadeCidadao1 = new Localidade("Pernambuco", "Recife",
                "Madalena", "Dr. Berardo", "50610300", "", 1023);
        Localidade localidadeCidadao2 = new Localidade("Pernambuco", "Recife",
                "Espinheiro", "Da Hora", "52020015", "", 1024);
        Localidade localidadeCidadao3 = new Localidade("Pernambuco", "Arcoverde",
                "São Miguel", "Duarte Pacheco", "56509300", "", 222);

        Localidade localidadeEstacao1 = new Localidade("Pernambuco", "Recife",
                "Espinheiro", "Da Hora", "52020015", "nivel 2", 1004);
        Localidade localidadeEstacao2 = new Localidade("Pernambuco", "Recife",
                "Espinheiro", "Da Hora", "52020015", "nivel 4", 1015);
        Localidade localidadeEstacao3 = new Localidade("Pernambuco", "Recife",
                "Espinheiro", "Da Hora", "52020015", "nivel 5", 1016);

        //Criado cidadões.
        Cidadao primeiroCidadao = new Cidadao("Carlos", "23345612323", "8882431",
                dataDeNascimentoPrimeiroCidadao);
        Cidadao segundoCidadao = new Cidadao("Maria", "13345613340", "4782545",
                dataDeNascimentoSegundoCidadao);
        Cidadao terceiroCidadao = new Cidadao("Ana", "38955723334", "7782635",
                dataDeNascimentoTerceiroCidadao);

        //Eletrônico.
        AparelhoEletronico computador = new AparelhoEletronico("Computador");
        AparelhoEletronico roteador = new AparelhoEletronico("Roteador");

        //Alimentos.
        Alimentos sanduiche = new Alimentos("Sanduíche", validadeSanduiche);
        Alimentos agua = new Alimentos("Água", validadeAgua);

        //Criando salas.
        Sala sala1 = new Sala(Sala.Tipo.MEDIAGRANDE, Sala.Estilo.JOVEM_ADULTO, 80);
        Sala sala2 = new Sala(Sala.Tipo.GRANDE, Sala.Estilo.TECH, 120);
        Sala sala3 = new Sala(Sala.Tipo.MEDIA, Sala.Estilo.JOVEM, 60);
        Sala sala4 = new Sala(Sala.Tipo.MUITOGRANDE, Sala.Estilo.CLASSICA, 160);
        Sala sala5 = new Sala(Sala.Tipo.PEQUENA, Sala.Estilo.ADULTO, 40);
        Sala sala6 = new Sala(Sala.Tipo.MEDIA, Sala.Estilo.PARA_REUNIOES, 60);
        Sala sala7 = new Sala(Sala.Tipo.MEDIAGRANDE, Sala.Estilo.DESCONTRAIDA, 80);

        //Criando serviços eletrônicos.
        Servicos servicosEletronico1 = new ServicosEletronico(120.50, dataServico, Servicos.Tipo.SERVICO_ELETRONICO,
                true, 5, computador);
        Servicos servicosEletronico2 = new ServicosEletronico(100.00, dataServico, Servicos.Tipo.SERVICO_ELETRONICO,
                true, 2, roteador);

        //Criando serviços alimentícios.
        Servicos servicosAlimenticio1 = new ServicosAlimenticios(ServicosAlimenticios.TipoDeAlimento.NAO_LIQUIDO
                , 60, 150.00, true, Servicos.Tipo.SERVICO_ALIMENTICIO,
                dataServico, true, sanduiche);
        Servicos servicosAlimenticio2 = new ServicosAlimenticios(ServicosAlimenticios.TipoDeAlimento.LIQUIDO,
                180, 100.00,true, Servicos.Tipo.SERVICO_ALIMENTICIO,
                dataServico, true, agua);

        //Criando serviços comerciais.
        Servicos servicosComercial1 = new ServicosComercial(0.00, dataServico, Servicos.Tipo.SERVICO_COMERCIAL,
                true, ServicosComercial.TipoComercial.AGUA, 10000000);
        Servicos servicosComercial2 = new ServicosComercial(100.00, dataServico, Servicos.Tipo.SERVICO_COMERCIAL,
                true, ServicosComercial.TipoComercial.INTERNET, 1000);
        Servicos servicosComercial3 = new ServicosComercial(110.00, dataServico, Servicos.Tipo.SERVICO_COMERCIAL,
                true, ServicosComercial.TipoComercial.LIMPESA, 25);


        //Criando as Estações.
        Estacao estacao1 = new Estacao(localidadeEstacao1, 2, 620.00, sala1, dataAtual);
        Estacao estacao2 = new Estacao(localidadeEstacao2, 4, 750.00, sala4, dataAtual);
        Estacao estacao3 = new Estacao(localidadeEstacao3, 5, 960.00, sala2, dataAtual);


        //Criando clientes.
        ClienteAbstrata primeiroCliente = new ClienteFisico(primeiroCidadao, localidadeCidadao1);
        ClienteAbstrata segundoCliente = new ClienteFisico(segundoCidadao, localidadeCidadao2);
        ClienteAbstrata terceiroCliente = new ClienteFisico(terceiroCidadao, localidadeCidadao3);


        //Teste dos método cadastrar.
        ClienteAbstrata clienteTeste = clienteInterface.cadastrar(primeiroCidadao, localidadeCidadao1);
        clienteInterface.verEstatusDoCliente(clienteTeste);
        System.out.println("\n");

        //Teste método corrigirCadastroPessoa.
        clienteTeste = clienteInterface.corrigirCadastroPessoa(clienteTeste.getCodigo(), segundoCidadao, clienteTeste);
        clienteInterface.verEstatusDoCliente(clienteTeste);
        System.out.println("\n");

        //Teste método corrigirCadastroLocalidade.
        clienteInterface.corrigirCadastroLocalidade(clienteTeste.getCodigo(), clienteTeste, localidadeCidadao3);
        clienteInterface.verEstatusDoCliente(clienteTeste);
        System.out.println("\n");

        //Teste método locar.
        Data periodoDeLocacao = new Data(dataAtual.getDia(), dataAtual.getMes(), dataAtual.getAno() + 1);
        clienteInterface.locar(estacao1,periodoDeLocacao, clienteTeste, clienteTeste.getCodigo());
        clienteInterface.verEstatusDoCliente(clienteTeste);
        clienteInterface.verEstatusDaLocacao(estacao1, dataAtual);
        System.out.println(estacao1.toString());
        System.out.println("\n");

        /*
         Teste método escolherServico. Nesse primeiro caso o
         serviço comercial é água, o mesmo tem valor mensal igual 0 reais
         */
        clienteInterface.escolherServico(estacao1, clienteTeste, servicosComercial1, clienteTeste.getCodigo(),
                estacao1.getCodigoDaLocalidade());
        clienteInterface.verEstatusDoCliente(clienteTeste);
        System.out.println(estacao1.toString());
        System.out.println("\n");
        clienteTeste.printServicoArrayList();
        System.out.println("\n");

        //Teste método escolherServiço, agora mudando o valor total para pagar.
        clienteInterface.escolherServico(estacao1, clienteTeste, servicosAlimenticio2, clienteTeste.getCodigo(),
                estacao1.getCodigoDaLocalidade());
        clienteInterface.verEstatusDoCliente(clienteTeste);
        System.out.println(estacao1.toString());
        System.out.println("\n");
        clienteTeste.printServicoArrayList();
        System.out.println("\n");

        //Teste método cancelamento de serviço.
        clienteInterface.cancelarServico(clienteTeste, servicosAlimenticio2, clienteTeste.getCodigo());
        clienteInterface.verEstatusDoCliente(clienteTeste);
        System.out.println(estacao1.toString());
        System.out.println("\n");
        clienteTeste.printServicoArrayList();
        System.out.println("\n");

        //Teste locação ocupada.
        clienteInterface.locar(estacao1, periodoDeLocacao, primeiroCliente, primeiroCidadao.getCpf());
        clienteInterface.verEstatusDoCliente(primeiroCliente);
        System.out.println("\n");
        System.out.println(estacao1.toString());
        System.out.println("\n");

        //Teste cancelar locação.
        clienteInterface.cancelarLocacao(estacao1, estacao1.getCodigoDaLocalidade(), dataAtual,
                clienteTeste, clienteTeste.getCodigo());
        clienteInterface.verEstatusDoCliente(primeiroCliente);
        System.out.println("\n");
        System.out.println(estacao1.toString());
        System.out.println("\n");

        //Teste locar com o primeiroCliente e depois colocar colocar no repositório.
        clienteInterface.locar(estacao2, periodoDeLocacao, primeiroCliente, primeiroCidadao.getCpf());
        clienteInterface.verEstatusDoCliente(primeiroCliente);
        System.out.println("\n");
        System.out.println(estacao2.toString());
        System.out.println("\n");

        //Teste colocando no repositório clientes.
        repositorioDeCliente.adicionar(primeiroCliente);
        repositorioDeCliente.adicionar(segundoCliente);
        repositorioDeCliente.adicionar(terceiroCliente);

        //Teste colocando no repositório de estações.
        repositorioDeEstacao.adicionar(estacao1);
        repositorioDeEstacao.adicionar(estacao2);
        repositorioDeEstacao.adicionar(estacao3);

        //Teste colocando no repositório de salas.
        repositorioDeSala.adicionar(sala1);
        repositorioDeSala.adicionar(sala2);
        repositorioDeSala.adicionar(sala3);
        repositorioDeSala.adicionar(sala4);
        repositorioDeSala.adicionar(sala5);
        repositorioDeSala.adicionar(sala6);
        repositorioDeSala.adicionar(sala7);

        //Teste colocando no repositório de alimentos.
        repositorioDeAlimentos.adicionar(agua);
        repositorioDeAlimentos.adicionar(sanduiche);

        //Teste colocando no repositório aparelhos.
        repositorioDeEquipamentosEletronicos.adicionar(computador);
        repositorioDeEquipamentosEletronicos.adicionar(roteador);

        //Teste colocando no repositório de serviços.
        repositorioDeServicos.adicionar(servicosAlimenticio1);
        repositorioDeServicos.adicionar(servicosAlimenticio2);
        repositorioDeServicos.adicionar(servicosComercial1);
        repositorioDeServicos.adicionar(servicosComercial2);
        repositorioDeServicos.adicionar(servicosComercial3);
        repositorioDeServicos.adicionar(servicosEletronico1);
        repositorioDeServicos.adicionar(servicosEletronico2);

        //Teste lendo do repositório de clientes.
        System.out.println(repositorioDeCliente.consultarCliente(primeiroCliente.getCodigo()));
        System.out.println("\n");
        System.out.println(repositorioDeCliente.consultarCliente(segundoCliente.getCodigo()));
        System.out.println("\n");
        System.out.println(repositorioDeCliente.consultarCliente(terceiroCliente.getCodigo()));
        System.out.println("\n");

        //Teste lendo do repositório de estações.
        System.out.println(repositorioDeEstacao.consultarEstacao(estacao1.getCodigoDaLocalidade()));
        System.out.println("\n");
        System.out.println(repositorioDeEstacao.consultarEstacao(estacao2.getCodigoDaLocalidade()));
        System.out.println("\n");
        System.out.println(repositorioDeEstacao.consultarEstacao(estacao3.getCodigoDaLocalidade()));
        System.out.println("\n");

        //Teste lendo do repositório de salas.
        System.out.println(repositorioDeSala.consultarSala(sala1.getCodigo()));
        System.out.println("\n");
        System.out.println(repositorioDeSala.consultarSala(sala2.getCodigo()));
        System.out.println("\n");
        System.out.println(repositorioDeSala.consultarSala(sala3.getCodigo()));
        System.out.println("\n");
        System.out.println(repositorioDeSala.consultarSala(sala4.getCodigo()));
        System.out.println("\n");
        System.out.println(repositorioDeSala.consultarSala(sala5.getCodigo()));
        System.out.println("\n");
        System.out.println(repositorioDeSala.consultarSala(sala6.getCodigo()));
        System.out.println("\n");

        //Teste lendo do repositório de alimentos.
        System.out.println(repositorioDeAlimentos.consultarAlimento(agua.getId()));
        System.out.println("\n");
        System.out.println(repositorioDeAlimentos.consultarAlimento(sanduiche.getId()));
        System.out.println("\n");

        //Teste lendo do repositório de aparelhos eletrônicos.
        System.out.println(repositorioDeEquipamentosEletronicos.consultarAparelhoEletronico(computador.getId()));
        System.out.println("\n");
        System.out.println(repositorioDeEquipamentosEletronicos.consultarAparelhoEletronico(roteador.getId()));
        System.out.println("\n");

        //Teste lendo do repositório de serviços.
        System.out.println(repositorioDeServicos.consultarServico(servicosAlimenticio1.getCodigoDoServico()));
        System.out.println("\n");
        System.out.println(repositorioDeServicos.consultarServico(servicosAlimenticio2.getCodigoDoServico()));
        System.out.println("\n");
        System.out.println(repositorioDeServicos.consultarServico(servicosComercial1.getCodigoDoServico()));
        System.out.println("\n");
        System.out.println(repositorioDeServicos.consultarServico(servicosComercial2.getCodigoDoServico()));
        System.out.println("\n");
        System.out.println(repositorioDeServicos.consultarServico(servicosComercial3.getCodigoDoServico()));
        System.out.println("\n");
        System.out.println(repositorioDeServicos.consultarServico(servicosEletronico1.getCodigoDoServico()));
        System.out.println("\n");
        System.out.println(repositorioDeServicos.consultarServico(servicosEletronico2.getCodigoDoServico()));
        System.out.println("\n");

        //Teste com arquivos.
        repositorioDeEstacao.colocarNoArquivo(estacao1);
        if (repositorioDeEstacao.consultarEstacao(estacao1.getCodigoDaLocalidade()) == null) {
            System.out.println("NULL\n");
        } else {
            repositorioDeEstacao.consultarEstacao(estacao1.getCodigoDaLocalidade());
        }

        //Teste lendo do arquivo.
        repositorioDeEstacao.consultarEstacao(estacao1.getCodigoDaLocalidade());
    }
}

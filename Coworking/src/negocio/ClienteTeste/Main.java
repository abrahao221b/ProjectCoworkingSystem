package negocio.ClienteTeste;

import negocio.Cidadao;
import negocio.Clientes.ClienteAbstrata;
import negocio.Clientes.SubclassesDeClientes.ClienteFisico;
import negocio.Endereco.Localidade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        String nome = input.nextLine();
        System.out.println("Digite o seu cpf: ");
        String cpf = input.nextLine();
        System.out.println("Digite o seu rg: ");
        String rg = input.nextLine();
        System.out.println("Digite o estado onde você mora: ");
        String estado = input.nextLine();
        System.out.println("Digite o cidade onde você mora: ");
        String cidade = input.nextLine();
        System.out.println("Digite o bairro onde você mora: ");
        String bairro = input.nextLine();
        System.out.println("Digite a rua onde você mora: ");
        String rua = input.nextLine();
        System.out.println("Digite o seu cep onde você mora: ");
        String cep = input.nextLine();
        System.out.println("Digite o numero de onde você mora: ");
        int numero = input.nextInt();

        Cidadao cidadao = new Cidadao(nome, cpf, rg);
        Localidade localidade = new Localidade(estado, cidade, bairro, rua, cep, "", numero);

        ClienteAbstrata clienteFisico = new ClienteFisico(cpf, cidadao, localidade);

        System.out.println(clienteFisico.toString());
    }
}

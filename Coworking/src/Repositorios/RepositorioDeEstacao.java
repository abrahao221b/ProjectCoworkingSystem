package Repositorios;

import negocio.Estacao.Estacao;
import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;
import negocio.Servicos.ServicosSecundarios.Eletronicos.AparelhoEletronico;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioDeEstacao implements Serializable{
    private HashMap<String, Estacao> estacaoHashMap;

    public RepositorioDeEstacao() {
        this.estacaoHashMap = new HashMap<>();
    }

    public void adicionar(Estacao estacao) {
        if (!(this.estacaoHashMap.containsValue(estacao))) {
            this.estacaoHashMap.put(estacao.getCodigoDaLocalidade(), estacao);
        } else {
            System.out.println("Estação já existe!");
        }
    }

    public void remover(Estacao estacao){
        if(estacaoHashMap.containsKey(estacao.getCodigoDaLocalidade())) {
            this.estacaoHashMap.remove(estacao.getCodigoDaLocalidade(), estacao);
            System.out.println("Estação removida com sucesso!!");
        } else {
            System.out.println("ERRO: A estação a ser removida não existe.");
        }
    }

    public Estacao consultarEstacao(String codigo) {
        if (estacaoHashMap.containsKey(codigo)) {
            return this.estacaoHashMap.get(codigo);
        }else {
            System.out.println("Erro: Não existe tal estação!!");
            return null;
        }
    }

    public boolean existeEstacao(String codigo) {
        return this.estacaoHashMap.containsKey(codigo);
    }

    //Armazenando no arquivo.
    public void colocarNoArquivo(Estacao estacao) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("estacao.dat");
        ObjectOutputStream os = new ObjectOutputStream(fileOut);
        os.writeObject(estacao);
        os.close();
        this.estacaoHashMap.remove(estacao.getCodigoDaLocalidade(), estacao);
    }

    //Lendo do arquivo.
    public void consultarDoArquivo(String codigo) throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("estacao.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        Estacao estacao;
        do {
            estacao = (Estacao) is.readObject();
        } while (estacao.getCodigoDaLocalidade().equals(codigo));
        is.close();
        this.estacaoHashMap.put(estacao.getCodigoDaLocalidade(), estacao);
        System.out.println(this.estacaoHashMap.get(estacao.getCodigoDaLocalidade()).toString());
    }
}

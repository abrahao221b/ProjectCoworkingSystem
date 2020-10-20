package Repositorios;

import negocio.Estacao.Sala.Sala;
import negocio.Servicos.Servicos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioDeServicos {
    private HashMap<String, Servicos> servicosHashMap;
    private ArrayList<SerializebleHashMap> arrayList;

    public RepositorioDeServicos() {
        this.servicosHashMap = new HashMap<>();
        this.arrayList = new ArrayList<>();
    }

    public void adicionar(Servicos servico) {
        if (!(this.servicosHashMap.containsValue(servico))) {
            this.servicosHashMap.put(servico.getCodigoDoServico(), servico);
            SerializebleHashMap serializebleHashMap = new SerializebleHashMap(servico.getCodigoDoServico(),
                    servico);
            this.arrayList.add(serializebleHashMap);
        } else {
            System.out.println("Serviço já exite!");
        }
    }

    public void remover(Servicos servico){
        if(servicosHashMap.containsKey(servico.getCodigoDoServico())) {
            this.servicosHashMap.remove(servico.getCodigoDoServico(), servico);
            System.out.println("Serviço removida com sucesso!!");
        } else {
            System.out.println("ERRO: O serviço a ser removida não existe.");
        }
    }

    public Servicos consultarServico(String codigo) {
        if (this.servicosHashMap.containsKey(codigo)) {
            return this.servicosHashMap.get(codigo);
        } else {
            System.out.println("Erro: Não existe tal serviço!!");
            return null;
        }
    }

    public boolean exiteServico(String codigo) {
        return this.servicosHashMap.containsKey(codigo);
    }

    //Armazenando no arquivo.
    public void colocarNoArquivo() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("servicos.dat");
        ObjectOutputStream os = new ObjectOutputStream(fileOut);
        os.writeObject(this.servicosHashMap);
        os.close();
    }

    //Lendo do arquivo.
    public Servicos consultarDoArquivo(String codigo) throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("servicos.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        Servicos servico = null;
        do {
            servico = (Servicos) is.readObject();
        } while (servico.getCodigoDoServico().equals(codigo));
        is.close();
        return servico;
    }

    public void passarArrayParaHashMap() throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("alimentos.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        ArrayList<SerializebleHashMap> arrayList;
        arrayList = (ArrayList) is.readObject();
        for (SerializebleHashMap i: arrayList) {
            this.servicosHashMap.put(i.key, i.servico);
        }
        is.close();
    }

    public class SerializebleHashMap implements Serializable {
        private String key;
        private Servicos servico;

        public SerializebleHashMap(String key, Servicos servico) {
            this.key = key;
            this.servico = servico;
        }
    }
}

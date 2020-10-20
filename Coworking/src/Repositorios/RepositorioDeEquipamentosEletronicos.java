package Repositorios;

import negocio.Clientes.ClienteAbstrata;
import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;
import negocio.Servicos.ServicosSecundarios.Eletronicos.AparelhoEletronico;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioDeEquipamentosEletronicos {
    private HashMap<String, AparelhoEletronico> aparelhoEletronicoHashMap;
    private ArrayList<SerializebleHashMap> arrayList;

    public RepositorioDeEquipamentosEletronicos() {
        this.aparelhoEletronicoHashMap = new HashMap<>();
        this.arrayList = new ArrayList<>();
    }

    public void adicionar(AparelhoEletronico aparelhoEletronico){
        if (!(this.aparelhoEletronicoHashMap.containsValue(aparelhoEletronico))) {
            this.aparelhoEletronicoHashMap.put(aparelhoEletronico.getId(), aparelhoEletronico);
            SerializebleHashMap serializebleHashMap = new SerializebleHashMap(aparelhoEletronico.getId(),
                    aparelhoEletronico);
            this.arrayList.add(serializebleHashMap);
        } else {
            System.out.println("Aparelho já exite!");
        }
    }

    public void remover(AparelhoEletronico aparelhoEletronico){
        if(aparelhoEletronicoHashMap.containsKey(aparelhoEletronico.getId())) {
            this.aparelhoEletronicoHashMap.remove(aparelhoEletronico.getId(), aparelhoEletronico);
            System.out.println("ERRO: A aparelho removida com sucesso!");
        } else {
            System.out.println("ERRO: O aparelho a ser removida não existe.");
        }
    }

    public AparelhoEletronico consultarAparelhoEletronico(String codigo) {
        if (this.aparelhoEletronicoHashMap.containsKey(codigo)) {
            return this.aparelhoEletronicoHashMap.get(codigo);
        } else {
            System.out.println("ERRO: O aparelho a ser removida não existe.");
            return null;
        }
    }

    public boolean existeAparelhoEletronico(String codigo) {
        return this.aparelhoEletronicoHashMap.containsKey(codigo);
    }

    //Armazenando no arquivo.
    public void colocarNoArquivo(AparelhoEletronico aparelho) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("aparelho.dat");
        ObjectOutputStream os = new ObjectOutputStream(fileOut);
        os.writeObject(this.aparelhoEletronicoHashMap);
        os.close();
    }

    //Lendo do arquivo.
    public AparelhoEletronico consultarDoArquivo(String id) throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("aparelho.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        AparelhoEletronico aparelhoEletronico = null;
        do {
            aparelhoEletronico = (AparelhoEletronico) is.readObject();
        } while (aparelhoEletronico.getId().equals(id));
        is.close();
        return aparelhoEletronico;
    }

    public void passarArrayParaHashMap() throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("aparelho.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        ArrayList<SerializebleHashMap> arrayList;
        arrayList = (ArrayList) is.readObject();
        for (SerializebleHashMap i: arrayList) {
            this.aparelhoEletronicoHashMap.put(i.key, i.aparelhoEletronico);
        }
        is.close();
    }

    public class SerializebleHashMap implements Serializable {
        private String key;
        private AparelhoEletronico aparelhoEletronico;

        public SerializebleHashMap(String key, AparelhoEletronico aparelhoEletronico) {
            this.key = key;
            this.aparelhoEletronico = aparelhoEletronico;
        }
    }
}

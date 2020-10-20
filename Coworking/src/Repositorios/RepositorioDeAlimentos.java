package Repositorios;


import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioDeAlimentos {

    private HashMap<String, Alimentos> alimentosHashMap;
    private ArrayList<SerializebleHashMap> arrayList;

    public RepositorioDeAlimentos() {
        this.alimentosHashMap = new HashMap<>();
        this.arrayList = new ArrayList<>();
    }

    public void adicionar(Alimentos alimentos){
        if (!(this.alimentosHashMap.containsValue(alimentos))) {
            this.alimentosHashMap.put(alimentos.getId(), alimentos);
            SerializebleHashMap serializebleHashMap = new SerializebleHashMap(alimentos.getId(), alimentos);
            this.arrayList.add(serializebleHashMap);
        } else {
            System.out.println("Alimento já existe!");
        }
    }

    public void remover(Alimentos alimentos){
        if(this.alimentosHashMap.containsKey(alimentos.getId())) {
            this.alimentosHashMap.remove(alimentos.getId(), alimentos);
        } else {
            System.out.println("ERRO: O alimento a ser removida não existe.");
        }
    }

    public Alimentos consultarAlimento(String codigo) {
        if (alimentosHashMap.containsKey(codigo)) {
            return this.alimentosHashMap.get(codigo);
        } else{
            System.out.println("ERRO: O alimento a ser removida não existe.");
            return null;
        }
    }

    public boolean existeAlimento(String codigo) {
        return this.alimentosHashMap.containsKey(codigo);
    }

    //Armazenando no arquivo.
    public void colocarNoArquivo() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("alimentos.dat");
        ObjectOutputStream os = new ObjectOutputStream(fileOut);
        ArrayList<Alimentos> arrayList = new ArrayList<>();
        os.writeObject(this.arrayList);
        os.close();
        this.alimentosHashMap = null;
    }

    //Lendo do arquivo.
    public Alimentos consultarDoArquivo(String id) throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("alimentos.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        Alimentos alimento = null;
        do {
            alimento = (Alimentos) is.readObject();
        } while (alimento.getId().equals(id));
        is.close();
        return alimento;
    }

    public void passarArrayParaHashMap() throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("alimentos.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        ArrayList<SerializebleHashMap> arrayList;
        arrayList = (ArrayList) is.readObject();
        for (SerializebleHashMap i: arrayList) {
            this.alimentosHashMap.put(i.key, i.alimento);
        }
        is.close();
    }

    public class SerializebleHashMap implements Serializable{
        private String key;
        private Alimentos alimento;

        public SerializebleHashMap(String key, Alimentos alimento) {
            this.key = key;
            this.alimento = alimento;
        }
    }
}

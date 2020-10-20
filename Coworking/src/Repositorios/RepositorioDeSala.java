package Repositorios;

import negocio.Estacao.Estacao;
import negocio.Estacao.Sala.Sala;
import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioDeSala {
    private HashMap<String, Sala> salaHashMap;
    private ArrayList<SerializebleHashMap> arrayList;

    public RepositorioDeSala(){
        this.salaHashMap = new HashMap<>();
        this.arrayList = new ArrayList<>();
    }

    public void adicionar(Sala sala) {
        if (!(this.salaHashMap.containsValue(sala))) {
            this.salaHashMap.put(sala.getCodigo(), sala);
            SerializebleHashMap serializebleHashMap = new SerializebleHashMap(sala.getCodigo(), sala);
            this.arrayList.add(serializebleHashMap);
        } else {
            System.out.println("Sala já exite!");
        }
    }

    public void remover(Sala sala){
        if(this.salaHashMap.containsKey(sala.getCodigo())) {
            this.salaHashMap.remove(sala.getCodigo(), sala);
            System.out.println("Sala removida com sucesso!!");
        } else {
            System.out.println("ERRO: A sala a ser removida não existe.");
        }
    }

    public Sala consultarSala(String codigo) {
        if (this.salaHashMap.containsKey(codigo)) {
            return this.salaHashMap.get(codigo);
        } else {
            System.out.println("Erro: Não existe tal sala!!");
            return null;
        }
    }

    public boolean existeSala(String codigo) {
        return this.salaHashMap.containsKey(codigo);
    }

    //Armazenando no arquivo.
    public void colocarNoArquivo() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("sala.dat");
        ObjectOutputStream os = new ObjectOutputStream(fileOut);
        os.writeObject(this.salaHashMap);
        os.close();
    }

    //Lendo do arquivo.
    public Sala consultarDoArquivo(String codigo) throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("sala.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        Sala sala = null;
        do {
            sala = (Sala) is.readObject();
        } while (sala.getCodigo().equals(codigo));
        is.close();
        return sala;
    }

    public void passarArrayParaHashMap() throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("alimentos.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        ArrayList<SerializebleHashMap> arrayList;
        arrayList = (ArrayList) is.readObject();
        for (SerializebleHashMap i: arrayList) {
            this.salaHashMap.put(i.key, i.sala);
        }
        is.close();
    }

    public class SerializebleHashMap implements Serializable {
        private String key;
        private Sala sala;

        public SerializebleHashMap(String key, Sala sala) {
            this.key = key;
            this.sala = sala;
        }
    }
}

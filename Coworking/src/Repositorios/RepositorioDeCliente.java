package Repositorios;

import negocio.Clientes.ClienteAbstrata;
import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioDeCliente {

    private HashMap<String, ClienteAbstrata> clienteHashMap;
    private ArrayList<SerializebleHashMap> arrayList;

    public RepositorioDeCliente() {
        this.clienteHashMap = new HashMap<>();
        this.arrayList = new ArrayList<>();
    }

    public void adicionar(ClienteAbstrata cliente){
        if (!(this.clienteHashMap.containsValue(cliente))) {
            this.clienteHashMap.put(cliente.getCodigo(), cliente);
            SerializebleHashMap serializebleHashMap = new
                    SerializebleHashMap(cliente.getCodigo(), cliente);
            this.arrayList.add(serializebleHashMap);
        } else {
            System.out.println("Cliente já existe!");
        }
    }

    public void remover(ClienteAbstrata cliente){
        if(this.clienteHashMap.containsKey(cliente.getCodigo())) {
            this.clienteHashMap.remove(cliente.getCodigo(), cliente);
            System.out.println("ERRO: Cliente removido com sucesso.");
        } else {
            System.out.println("ERRO: Cliente a ser removida não existe.");
        }
    }

    public ClienteAbstrata consultarCliente(String codigo) {
        if(this.clienteHashMap.containsKey(codigo)) {
            return this.clienteHashMap.get(codigo);
        } else {
            System.out.println("ERRO: Cliente a ser removida não existe.");
            return null;
        }
    }

    public boolean existeCliente(String codigo) {
        return this.clienteHashMap.containsKey(codigo);
    }

    //Armazenando no arquivo.
    public void colocarNoArquivo() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("cliente.dat");
        ObjectOutputStream os = new ObjectOutputStream(fileOut);
        os.writeObject(this.clienteHashMap);
        os.close();
    }

    //Lendo do arquivo.
    public ClienteAbstrata consultarDoArquivo(String cpf) throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("cliente.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        ClienteAbstrata cliente = null;
        do {
            cliente = (ClienteAbstrata) is.readObject();
        } while (cliente.getCodigo().equals(cpf));
        is.close();
        return cliente;
    }

    public void passarArrayParaHashMap() throws IOException, ClassNotFoundException {
        FileInputStream fileRead = new FileInputStream("clientes.dat");
        ObjectInputStream is = new ObjectInputStream(fileRead);
        ArrayList<SerializebleHashMap> arrayList;
        arrayList = (ArrayList) is.readObject();
        for (SerializebleHashMap i: arrayList) {
            this.clienteHashMap.put(i.key, i.cliente);
        }
        is.close();
    }

    public class SerializebleHashMap implements Serializable {
        private String key;
        private ClienteAbstrata cliente;

        public SerializebleHashMap(String key, ClienteAbstrata cliente) {
            this.key = key;
            this.cliente = cliente;
        }
    }
}

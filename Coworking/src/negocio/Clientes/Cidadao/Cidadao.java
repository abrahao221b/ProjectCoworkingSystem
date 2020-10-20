package negocio.Clientes.Cidadao;

import negocio.Data.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cidadao implements Serializable {
    private String nome;
    private String cpf;
    private String rg;
    private Data dataDeNascimento;

    public Cidadao(String nome, String cpf, String rg, Data data) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataDeNascimento = verificacaoData(data);
    }

    private Data verificacaoData(Data data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String diaData = dtf.format(now);
        String ano = diaData.substring(6, 10);
        int numeroAno = Integer.parseInt(ano);
        int result = numeroAno - data.getAno();
        if (result < 18) {
            return null;
        } else {
            return data;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public Data getDataDeNascimento() {
        return this.dataDeNascimento;
    }
}

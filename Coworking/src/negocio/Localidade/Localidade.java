package negocio.Localidade;

import java.io.Serializable;
import java.util.Arrays;

public class Localidade implements Serializable {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String cep;
    private String complemento;
    private int numero;

    public Localidade(String estado, String cidade, String bairro,
                      String rua, String cep, String complemento, int numero) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;

    }

    //Passa o CEP para o formato padrão, XXXXX-XXX.
    private String setarCep(String cep) {
        char[] setada = new char[this.cep.length()];
        for (int i = 0; i < cep.length(); i++) {
            if (i != 4) {
                setada[i] = this.cep.charAt(i);
            } else {
                setada[i] = '-';
            }
        }
        return Arrays.toString(setada);
    }

    public String getCep(){
        return this.cep;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getRua() {
        return this.rua;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public int getNumero() {
        return this.numero;
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", cep='" + cep + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numero=" + numero +
                '}';
    }
}

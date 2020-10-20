package negocio.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data implements Serializable {
    private int dia, mes, ano;
    private DateTimeFormatter dtf;
    private LocalDateTime now;
    private String diaData;
    /*  Foi preciso formatar as datas para valores com mesmo quantidade de
        digitos, e como foi escolhido um inteiro, MAX_YEAR_DIGITS,
        esse valor é a maior quantidade de digitos que um inteiro pode ter.
        A partir dele Estou vendo quantos zeros faltam para formatar o ano sem que haja erros.
    */
    private final int MAX_YEAR_DIGITS = 10;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.now = LocalDateTime.now();
        this.diaData =  dtf.format(now);
    }

    public Data() {}

    public void setarSuaData(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        validacaoData();
    }

    /*
      Formata data para o formato utilizado na comparação lexicográfica.
      Ano: é colocado no formato 'YYYYYYYYYY', com 10 dígitos, tal qual o maior valor possível para int 32 bits (0 <= ano <= 2^31 - 1).
      Mês: é colocado no formato 'MM' (01 <= mes <= 12).
      Dia: é colocado no formato 'DD' (01 <= dia <= 31).

      Retorna uma string no formato YYYYYYYYYY/MM/DD.
    */
    private String formatarDataParaComparacao() {
        String ano = Integer.toString(this.ano);
        String mes = Integer.toString(this.mes);
        String dia = Integer.toString(this.dia);
        if (this.mes < 10) {
            mes = "0" + mes;
        }
        if (this.dia < 10) {
            dia = "0" + dia;
        }

        int ajusta = ajustaAno(this.ano);
        if (ajusta > 0) {
            // Utilizando StringBuilder para evitar a recriação de Strings, que são objetos imutáveis.
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < ajusta; i++) {
                builder.append('0');
            }
            ano = builder.toString() + ano;
        }
        return ano + '/' + mes + '/' + dia;
    }

    private int ajustaAno(int ano) {
        int quantidade = 0;
        while (ano > 0) {
            ano /= 10;
            quantidade++;
        }

        return MAX_YEAR_DIGITS - quantidade;
    }

    public String printData() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

    private void validacaoData() {
        if (this.ano < 0) {
            setDefaultData();
        } else if (this.mes > 12 || this.mes < 0) {
            setDefaultData();
        } else if (this.mes == 2 ){
            if (ehBisexto() && this.dia > 29) {
                setDefaultData();
            } else if (this.dia > 28 || this.dia < 0) {
                setDefaultData();
            }
        } else if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11){
            if (this.dia > 30 || this.dia < 0) {
                setDefaultData();
            }
        } else {
            if (this.dia > 31 || this.dia < 0) {
                setDefaultData();
            }
        }
    }

    private void setDefaultData() {
        this.ano = 1999;
        this.mes = 3;
        this.dia = 6;
    }

    private boolean ehBisexto() {
        if (this.ano % 400 == 0) {
            return true;
        } else {
            if (this.ano % 4 == 0) {
                if (this.ano % 100 != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public Data getDiaData() {
        String ano = this.diaData.substring(6, 10);
        String dia = this.diaData.substring(0, 2);
        String mes = this.diaData.substring(3, 5);
        int numeroDia = Integer.parseInt(dia);
        int numeroMes = Integer.parseInt(mes);
        int numeroAno = Integer.parseInt(ano);
        return new Data(numeroDia, numeroMes, numeroAno);
    }
}


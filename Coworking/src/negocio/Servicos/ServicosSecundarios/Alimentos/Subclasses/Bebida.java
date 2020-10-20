package negocio.Servicos.ServicosSecundarios.Alimentos.Subclasses;

import negocio.Data.Data;
import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;

import java.io.Serializable;

public class Bebida extends Alimentos implements Serializable {

    public Bebida(String nome, Data validade) {
        super(nome, validade);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

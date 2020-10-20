package negocio.Servicos.ServicosSecundarios.Alimentos.Subclasses;

import negocio.Data.Data;
import negocio.Servicos.ServicosSecundarios.Alimentos.Alimentos;

import java.io.Serializable;

public class Comida extends Alimentos implements Serializable {

    public Comida(String nome, Data validade) {
        super(nome, validade);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

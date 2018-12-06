package model;

import java.io.Serializable;
import view.Imprimivel;

public class Ingrediente implements Imprimivel, Serializable {
    private static final long serialVersionUID = 4L;
    private String nome = "";
    private int calorias = 0;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCaloria() {
        return this.caloria;
    }

    public void setCaloria(int caloria) {
        this.caloria = caloria;
    }

    @Override
    public void imprimeInformacoes(boolean comQuebraDeLinha) {
        if (comQuebraDeLinha == true) {
            System.out.println(this.nome + " " + "(" + this.calorias + "Kcal" + ")");
        } else {
            System.out.print(this.nome + " " + "(" + this.calorias + "Kcal" + ")");
        }
    }
}

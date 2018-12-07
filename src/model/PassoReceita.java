package model;

import java.io.Serializable;
import view.Imprimivel;

public class PassoReceita implements Imprimivel, Serializable {
    private static final long serialVersionUID = 5L;
    private int numero;
    private String descricao;

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void imprimeInformacoes(boolean comQuebraDeLinha) {
        System.out.print(this.numero + " + " + this.descricao);
        if (comQuebraDeLinha) {
            System.out.println();
        }
    }
}

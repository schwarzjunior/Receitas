package model;

import java.io.Serializable;
import view.Imprimivel;

public class IngredienteReceita implements Imprimivel, Serializable {
    private static final long serialVersionUID = 6L;
    private Ingrediente ingrediente;
    private int quantidade;
    private String unidadeDeMedida;

    public IngredienteReceita(Ingrediente ingrediente, int quantidade, String unidadeDeMedida) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public Ingrediente getIngrediente() {
        return this.ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeDeMedida() {
        return this.unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    @Override
    public void imprimeImformacoes(boolean comQuebraDeLinha) {
        this.ingrediente.imprimeInformacoes(comQuebraDeLinha);
        System.out.println(" - " + this.quantidade + " " + unidadeDeMedida);
    }

}

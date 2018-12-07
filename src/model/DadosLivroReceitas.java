package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DadosLivroReceitas implements Serializable {
    private static final long serialVersionUID = 1L;
    private Livro livroReceitas;
    private List<Ingrediente> listaIngredientes;

    public DadosLivroReceitas() {
        this.livroReceitas = new Livro();
        this.listaIngredientes = new ArrayList<Ingrediente>();
    }

    public Livro getLivroReceitas() {
        return this.livroReceitas;
    }

    public void setLivroReceitas(Livro livroReceitas) {
        this.livroReceitas = livroReceitas;
    }

    public List<Ingrediente> getListaIngredientes() {
        return this.listaIngredientes;
    }

    public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }


}

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import view.Imprimivel;

public class Livro implements Imprimivel, Serializable {
    private static final long serialVersionUID = 3L;
    private String nome;
    private List<Receita> listaDeReceitas;

    public Livro() {
        this.listaDeReceitas = new ArrayList<>(Receita);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Este metodo esta inadequado, pois esta imprimindo de uma classe model.
    private void listaReceita() {
        if (listaDeReceitas.size() < 1) {
            System.out.println("Lista de receitas esta vazia");
        } else {
            for (int i = 0; i < listaDeReceitas.size(); i++) {
                listaDeReceitas.get(i).imprimeInformacoes(true);
            }
        }
    }

    public void sadicionaReceita(Receita receita) {
        this.listaDeReceitas.add(receita);
    }

    @Override
    public void imprimeInformacoes(boolean comQuebraDeLinha) {
        System.out.println(nome);
        listaReceita();
        System.out.println("\n");
    }
}

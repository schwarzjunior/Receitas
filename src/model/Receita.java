package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import view.Imprimivel;

public class Receita implements Imprimivel, Serializable {
    private static final long serialVersionUID = 2L;
    private String nome;
    private List<IngredienteReceita> listaDeIngredientes;
    private List<PassoReceita> listaDePassos;

    public Receita() {
        this.listaDeIngredientes = new ArrayList<IngredienteReceita>();
        this.listaDePassos = new ArrayList<PassoReceita>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionaIngrediente(IngredienteReceita ingrediente) {
        this.listaDeIngredientes.add(ingrediente);
    }

    public void adicionaPasso(PassoReceita passo) {
        this.listaDePassos.add(passo);
    }

    public void listaIngredientes() throws Exception {
        if (this.listaDeIngredientes.size() > 0) {
            for (int i = 0; i < listaDeIngredientes.size(); i++) {
                this.listaDeIngredientes.get(i).imprimeInformacoes(false);
            }
        } else {
            throw new Exception("INFO: Lista de ingredientes esta vazia!");
        }
    }

    public void listaPassos() throws Exception {
        if (this.listaDePassos.size() > 0) {
            for (int i = 0; i < listaDePassos.size(); i++) {
                this.listaDePassos.get(i).imprimeInformacoes(false);
            }
        } else {
            throw new Exception("INFO: Lista de passos esta vazia.");
        }
    }

    @Override
    public void inprimeInformacoes(boolean comQuebraDeLinha) {
        if (comQuebraDeLinha) {
            System.out.println("Nome da receita: " + this.getNome());
            System.out.println("---------------------------------");
            System.out.println("Ingredientes:");
            try {
                this.listaIngredientes();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Passos da receita:");
            try {
                this.listaPassos();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.print("Nome da receita: " + this.getNome());
            System.out.print("---------------------------------");
            System.out.print("Ingredientes:");
            try {
                this.listaIngredientes();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            System.out.print("Passos da receita:");
            try {
                this.listaPassos();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }
}

package view;

import java.util.List;
import java.util.Scanner;
import model.Ingrediente;

public class InterfaceIngrediente {
    static int opcao = 0;
    static Scanner entrada = new Scanner(System.in);
    static List<Ingrediente> listaDeIngredientes;

    public static void menuPrincipal() {
        do {
            System.out.println("Escolha uma das opcoes abaixo:");
            System.out.println("   1 - Ver ingredientes");
            System.out.println("   2 - Incluir ingrediente");
            System.out.println("   0 - Voltar");

            InterfaceIngrediente.opcao = InterfaceIngrediente.entrada.nextInt();

            if (InterfaceIngrediente.opcao == 1) {
                InterfaceIngrediente.listaIngredientes();
            } else if (InterfaceIngrediente.opcao == 2) {
                InterfaceIngrediente.adicionaIngredientes();
            }
        } while (InterfaceIngrediente.opcao != 0);
    }

    public static void listaIngredientes() {
        for (i = 0; i < InterfaceIngrediente.listaDeIngredientes.size(); i++) {
            Ingrediente ingrediente = InterfaceIngrediente.listaDeIngredientes.get(i);
            ingrediente.imprimeInformacoes(true);
        }
    }

    public static void adicionaIngredientes() {
        String nomeIngrediente = "";
        int caloriasIngrediente = 0;

        System.out.println("Digite o nom do ingrediente: ");
        nomeIngrediente = InterfaceIngrediente.entrada.next();
        System.out.println("Digite a quantidade de calorias do ingrediente: ");
        caloriasIngrediente = InterfaceIngrediente.entrada.nextInt();

        Ingrediente novoIngrediente = new Ingrediente();
        novoIngrediente.setNome(nomeIngrediente);
        novoIngrediente.setCaloria(caloriasIngrediente);

        InterfaceIngrediente.listaDeIngredientes.add(novoIngrediente);
    }
}

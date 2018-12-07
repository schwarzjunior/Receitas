package view;

import java.util.Scanner;
import model.Livro;

public class InterfacePrincipal {
    public static Scanner leitor = new Scanner(System.in);
    public static Livro livroDeReceitas;
    public static int op = 1;

    /*
     * Imprime informações do livro
     */
    public static void listaReceitas() {
        InterfacePrincipal.livroDeReceitas.imprimeInformacoes(true);
    }

    /*
     * Imprime o menu, e solicita a interação com o usuário
     */
    public static void menuPrincipal() {
        /*
         * Executa um laço até que o usuário digite 0
         */
        do {
            System.out.printf(
                    "1 - Ver receitas\n2 - Acessar menu de receitas\n3 - Acessar menu de ingredientes\n0 - Sair \n");
            try {
                op = leitor.nextInt();
            } catch (Exception e) {
                System.out.printf("Opção inválida! " + e.getMessage() + "%n");
            }

            switch (op) {
                case 0:
                    System.out.println("Obrigado!");
                    break;
                case 1:
                    listaReceitas();
                    break;
                case 2:
                    InterfaceReceita.menuPrincipal();
                    break;
                case 3:
                    InterfaceIngrediente.menuPrincipal();
                    break;
                default:
                    System.out.printf("Opção inválida!%n");
                    break;
            }

        } while (op != 0);

    }

}

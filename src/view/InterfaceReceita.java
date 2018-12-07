package view;

import java.util.List;
import java.util.Scanner;
import model.Ingrediente;
import model.IngredienteReceita;
import model.Livro;
import model.PassoReceita;
import model.Receita;

public class InterfaceReceita {
    public static List<Ingrediente> listaIngredientes;
    public static Livro livroReceitas;

    public static void menuPrincipal() {
        int incluiReceita;
        boolean verifica;
        Scanner leitor = new Scanner(System.in);

        do {
            System.out.println("\n   1 - Incluir receita\n   0 - Voltar");

            try {
                incluiReceita = leitor.nextInt();
                verifica = true;
                if (incluiReceita == 1) {
                    adicionaReceita();
                } else if (incluiReceita == 0) {
                    // Voltar
                } else {
                    System.out.print("\n# Opcao incorreta! Escolha '1' ou '0' #\n");
                    verifica = false;
                }
            } catch (NumberFormatException e) {
                verifica = false;
                System.out.print("\n# Opcao incorreta! Voce digitou uma letra! #\n");
            } catch (Exception e) {
                verifica = false;
                System.out.print("\n# Opcao incorreta! Escolha '1' ou '0' #\n");
            }
        } while (!verifica);
    }

    public static void adicionaReceita() {
        // Atributo para confirmar se a Opção selecionada esta co
        boolean opcaoCorreta = true;
        // Atributo para registrar a Opção selecionada
        int opcao = 0;
        Scanner leitor = new Scanner(System.in);
        Receita objReceita = new Receita();

        System.out.println("Nome da receita: ");
        String nomeReceita = leitor.nextLine();
        objReceita.setNome(nomeReceita);

        // Laço para opções possíveis ficarem a mostra enquanto Opção
        // Selecionada esta incorreta.
        // Se estiver correta, irá direcionar ao método da opção
        do {
            System.out.println("\n1 - Incluir ingrediente.\n2 - Incluir passo.\n0 - Finalizar");

            try {
                opcao = leitor.nextInt();
                opcaoCorreta = false;
                // Se opção for 1 puxará método adicionaIngrediente
                if (opcao == 1) {
                    objReceita.adicionaIngrediente(InterfaceReceita.adicionaIngrediente());
                    opcaoCorreta = true;
                }
                // Se opção for 2 puxará método adicionaPasso
                else if (opcao == 2) {
                    objReceita.adicionaPasso(InterfaceReceita.adicionaPasso());
                    opcaoCorreta = true;
                }
                // Se opção for 1 puxará método adicionaPasso
                else if (opcao == 0) {
                    InterfaceReceita.livroDeReceitas.adicionaReceita(objReceita);
                    // Volta
                }
                // Para outras opções, informará que opção não é válida e
                // retornara às opções
                else {
                    System.out.println("\nDigite uma opção válida.");
                    opcaoCorreta = true;
                }
            }
            // Se usuário digitar algo que não sejá número, informará que opção
            // não é válida e retornara às opções
            catch (Exception ex) {
                System.out.println("\nDigite um número válido.");
                opcaoCorreta = true;
            }
        } while (opcaoCorreta);
    }

    public static IngredienteReceita adicionaIngrediente() {

        int numIngrediente = 1;
        int escIngrediente = 0;
        int qtdIngrediente = 0;
        String undIngrediente = "";
        Ingrediente ingrediente = null;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Selecione um ingrediente: \n");
        for (Ingrediente item : listaDeIngredientes) {
            System.out.println(numIngrediente + " - " + item.getNome() + "\n");
            numIngrediente++;
        }
        try {
            escIngrediente = leitor.nextInt();
            if (escIngrediente <= 0) { // valida valor
                System.out.println("O valor deve ser acima de zero!");
            } else {
                ingrediente = InterfaceReceita.listaDeIngredientes.get(escIngrediente - 1);
            }
        } catch (Exception ex) {
            System.out.println("Valor Invalido!");
        }
        System.out.println("Digite a quantidade: ");
        try {
            qtdIngrediente = leitor.nextInt();
            if (qtdIngrediente <= 0) { // valida valor
                System.out.println("O valor deve ser acima de zero!");
            }
        } catch (Exception ex) {
            System.out.println("Valor Invalido!");
        }
        System.out.println("Digite a unidade de medida: ");
        try {
            undIngrediente = leitor.next();

        } catch (Exception ex) {
            System.out.println("Valor Invalido!");
        }

        IngredienteReceita novoIngrediente =
                new IngredienteReceita(ingrediente, qtdIngrediente, undIngrediente);

        return novoIngrediente;
    }

    /**
     * Método para adicionar um passo à uma receita
     */
    public static PassoReceita adicionaPasso() {

        PassoReceita passo = new PassoReceita();
        Scanner leitor = new Scanner(System.in);

        boolean numeroCorreto = true;
        do {
            try {
                System.out.println("Inclua número do Passo:");
                int numeroDigitado = leitor.nextInt();
                passo.setNumero(numeroDigitado);
                numeroCorreto = false;
            } catch (Exception ex) {
                System.out.println("\nDigite um número válido.");
                numeroCorreto = true;
            }
        } while (numeroCorreto == true);

        leitor = new Scanner(System.in);
        System.out.println("Inclua uma descrição para o Passo:");
        String descricaoDigitada = leitor.nextLine();
        passo.setDescricao(descricaoDigitada);

        return passo;
    }
}

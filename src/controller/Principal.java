package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.DadosLivroReceitas;
import view.*;

public class Principal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        DadosLivroReceitas dados = recuperaDados();

        InterfacePrincipal.livroDeReceitas = dados.getLivroReceitas();
        InterfaceReceita.listaIngredientes = dados.getListaIngredientes();
        InterfaceReceita.livroReceitas = dados.getLivroReceitas();

        InterfaceIngrediente.listaDeIngredientes = dados.getListaIngredientes();

        InterfacePrincipal.menuPrincipal();

        System.out.println("Salvando dados...");
        salvaDados(dados);
    }

    /**
     * Salva um objeto DadosReceita em um arquivo com o nome DadosReceita.rct
     * 
     * @param DadosReceita dados
     */
    public static void salvaDados(DadosLivroReceitas dados) {
        try { // Para tratar erros de I/O
              // Abrir um arquivo para gravar
              // Se não existir, o arquivo é criado
            FileOutputStream arquivoSalvar = new FileOutputStream("DadosReceita.rct");

            // Cria um ObjectOutputStream, que vai colocar objetos no arquivo
            ObjectOutputStream salvamento = new ObjectOutputStream(arquivoSalvar);

            // Salva o aluno
            salvamento.writeObject(dados);

            // Fecha o arquivo
            salvamento.close(); // Vai fechar o arquivo e o ObjectOutputStream
        } catch (Exception e) {
            e.printStackTrace(); // Se der exceção, imprime erros
        }
    }

    /**
     * Recupera um objeto DadosReceita salvo no arquivo DadosReceita.rct
     * 
     * @return o objeto DadosReceita
     */
    public static DadosLivroReceitas recuperaDados() {
        DadosLivroReceitas dados = new DadosLivroReceitas();

        try
        // Para tratar erros de I/O
        {
            // Abre um arquivo para leitura
            // Se não existir, dá erro (exceção)
            FileInputStream arquivoSalvo = new FileInputStream("DadosReceita.rct");

            // Cria um ObjectInputStream, que vai ler os objetos do arquivo
            ObjectInputStream recuperacao = new ObjectInputStream(arquivoSalvo);

            // Recupera o objeto do arquivo
            // É preciso dizer o tipo do objeto que está sendo retornado
            // senão é retornado um Object padrão
            dados = (DadosLivroReceitas) recuperacao.readObject();

            // Fecha o arquivo
            recuperacao.close(); // Fecha o arquivo e o ObjectInputStream
        } catch (Exception e) {
            // e.printStackTrace(); // Se der exceção, imprime erros
            System.out.println("Arquivo não existe, dados não foram recuperados.");
        }

        return dados;
    }
}

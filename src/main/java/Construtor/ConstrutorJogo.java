/*
 * Link de videos que ajudaram
 *
 * https://www.youtube.com/watch?v=-V66mnoUGG8      // como colocar um personagem e fazer ele se mexer
 * https://www.youtube.com/watch?v=gEI_bj5t7fo      // Tutorial Java Passando variáveis entre janelas
 *
 */
package Construtor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author hlima
 */

public class ConstrutorJogo {
    
    private String nome;
    private String nomeReino;
    private int QtTrabalhadores;
    private String QtFazendas;

    public int QtSpinnerFazendas, QtSpinnerConstrucao,QtSpinnerFerreiro,QtSpinnerSoldados,QtSpinnerExploradores,QtSpinnerMineradores,QtSpinnerFeiticaria,QtSpinnerCiencia;
    
   

    public void Escritor(){

        try {
            
            FileOutputStream arquivo = new FileOutputStream("banco_de_dados.txt");
            PrintWriter pr = new PrintWriter(arquivo);

            //pr.println("Nome jogador ;"+ nome);
            //pr.println("Nome reino ;"+ nomeReino);
            //pr.println("QtTrabalhadores ;"+ QtTrabalhadores);
            pr.println("QtFazendas ;"+ QtSpinnerFazendas);

            pr.close();
            arquivo.close();


        } catch (Exception e) {

            System.out.println("Erro ao abrir arquivo: ");

        }

    }
  
    public void Leitor(){

        try {
            
            FileInputStream arquivo = new FileInputStream("banco_de_dados.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);

            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {

                    String[] palavras = linha.split(";"); // pegar valor apos ;
                    QtSpinnerFazendas = Integer.parseInt(palavras[1]);

                    
                }
            } while (linha != null);

        } catch (Exception e) {

            System.out.println("Erro ao abrir arquivo");

        }

    }
  
  
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

      /**
     * @return the QtTrabalhadores
     */
    public int getQtTrabalhadores() {
        return QtTrabalhadores;
    }

    /**
     * @param QtTrabalhadores the QtTrabalhadores to set
     */
    public void setQtTrabalhadores(int QtTrabalhadores) {
        this.QtTrabalhadores = QtTrabalhadores;
    }

    /**
     * @return the nomeReino
     */
    public String getNomeReino() {
        return nomeReino;
    }

    /**
     * @param nomeReino the nomeReino to set
     */
    public void setNomeReino(String nomeReino) {
        this.nomeReino = nomeReino;
    }

    /**
     * @return the QtFazendas
     */
    public String getQtFazendas() {
        return QtFazendas;
    }

    /**
     * @param QtFazendas the QtFazendas to set
     */
    public void setQtFazendas(String QtFazendas) {
        this.QtFazendas = QtFazendas;
    }
}

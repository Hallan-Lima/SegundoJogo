/*
 * Link de videos que ajudaram
 *
 * https://www.youtube.com/watch?v=-V66mnoUGG8      // como colocar um personagem e fazer ele se mexer
 * https://www.youtube.com/watch?v=gEI_bj5t7fo      // Tutorial Java Passando variáveis entre janelas
 *
 */
package Construtor;

import java.io.FileOutputStream;
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

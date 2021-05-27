/*
 * Link de videos que ajudaram
 *
 * https://www.youtube.com/watch?v=-V66mnoUGG8      // como colocar um personagem e fazer ele se mexer
 * https://www.youtube.com/watch?v=gEI_bj5t7fo      // Tutorial Java Passando variáveis entre janelas
 *
 */
package Construtor;

/**
 *
 * @author hlima
 */

public class ConstrutorJogo {
    
    private String nome;
    private String nomeReino;
    private int QtTrabalhadores;
    private int QtFerreiro;
    private int QtFazendas;

    public void retorno(){
        System.out.println(QtFazendas);
    }

    public int getQtFerreiro() {
        return QtFerreiro;
    }
    public void setQtFerreiro(int qtFerreiro) {
        QtFerreiro = qtFerreiro;
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
     * @return the QtFazendas
     */
    public int getQtFazendas() {
        return QtFazendas;
    }

    /**
     * @param QtFazendas the QtFazendas to set
     */
    public void setQtFazendas(int QtFazendas) {
        this.QtFazendas = QtFazendas;
    }
}

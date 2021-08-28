/*
 * Link de videos que ajudaram
 *
 * https://www.youtube.com/watch?v=-V66mnoUGG8      --> como colocar um personagem e fazer ele se mexer
 * https://www.youtube.com/watch?v=gEI_bj5t7fo      --> Tutorial Java Passando variáveis entre janelas
 * 
 *      #videos que ajudaram
 * 
 * https://www.youtube.com/watch?v=qFfBVPnpw4w      --> Escrever e ler em arquivos
 * https://www.youtube.com/watch?v=xLDViuYlqGM
 * https://www.youtube.com/watch?v=sBoAecYJN0w
 * https://www.youtube.com/watch?v=Ics80J6JgGo
 *
 *      #jogo 2D
 * 
 * https://youtu.be/5aE55KZ93xw?list=PLlW3qrNjsvBwUmUk9kio7bNT3GR554FH5                     --> criado a estrutura
 * https://www.youtube.com/watch?v=ntDvADUoMs8&list=PLnOrFdw5rkTzLcPRa_JKmpMqzNGIlLi3r      --> desenvolvendo o personagem 
 * 
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
    
    private     String  nome, nomeReino, QtFazendas;
    private     int     QtTrabalhadores;
    public      int     QtSpinnerFazendas,   QtSpinnerConstrucao,    QtSpinnerFerreiro,  QtSpinnerSoldados,  QtSpinnerExploradores,
    QtSpinnerMineradores,   QtSpinnerFeiticaria,    QtSpinnerCiencia;
    public      boolean isRunning;

    public void Escritor(){
        try {
            
            FileOutputStream arquivo = new FileOutputStream("banco_de_dados.txt");
            PrintWriter pr = new PrintWriter(arquivo);

            pr.println("QtSpinnerFazendas,QtSpinnerConstrucao,QtSpinnerFerreiro,QtSpinnerSoldados,QtSpinnerExploradores,QtSpinnerMineradores,QtSpinnerFeiticaria,QtSpinnerCiencia,nomeJogador,nomeReino");                  // cabeçalho do banco de dados
            pr.println(QtSpinnerFazendas    +","+   QtSpinnerConstrucao +","+   QtSpinnerFerreiro   +","+   QtSpinnerSoldados   +","+   
            QtSpinnerExploradores   +","+   QtSpinnerMineradores    +","+   QtSpinnerFeiticaria +","+   QtSpinnerCiencia    +","+
            nome    +","+   nomeReino);                                                // variavel que serão armazenadas 

            pr.close();
            arquivo.close();

        } catch (Exception e) {
            System.out.println("Escrever - Erro: "+e.getMessage());
        }
    }
  
    public void Leitor(){

        try {
            
            FileInputStream arquivo = new FileInputStream("banco_de_dados.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);

            String linha;

            linha = br.readLine();
            do {
                linha = br.readLine();
                if (linha != null) {

                    String[] vect = linha.split(",");                           // pegar valor apos
                    QtSpinnerFazendas       = Integer.parseInt(vect[0]);
                    QtSpinnerConstrucao     = Integer.parseInt(vect[1]);
                    QtSpinnerFerreiro       = Integer.parseInt(vect[2]);
                    QtSpinnerSoldados       = Integer.parseInt(vect[3]);
                    QtSpinnerExploradores   = Integer.parseInt(vect[4]);
                    QtSpinnerMineradores    = Integer.parseInt(vect[5]);
                    QtSpinnerFeiticaria     = Integer.parseInt(vect[6]);
                    QtSpinnerCiencia        = Integer.parseInt(vect[7]);
                    nome                    = vect[8];
                    nomeReino               = vect[9];

                }
            } while (linha != null);

        } catch (Exception e) {

            System.out.println("Erro ao ler: "+e.getMessage());

        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtTrabalhadores() {
        return QtTrabalhadores;
    }

    public void setQtTrabalhadores(int QtTrabalhadores) {
        this.QtTrabalhadores = QtTrabalhadores;
    }

    public String getNomeReino() {
        return nomeReino;
    }

    public void setNomeReino(String nomeReino) {
        this.nomeReino = nomeReino;
    }

    public String getQtFazendas() {
        return QtFazendas;
    }

    public void setQtFazendas(String QtFazendas) {
        this.QtFazendas = QtFazendas;
    }

}

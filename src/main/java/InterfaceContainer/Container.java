package InterfaceContainer;

import javax.swing.JFrame;

import InterfaceContainer.Fase.Fase;

public class Container extends JFrame{
    
    public Container(){
    
        add(new Fase());
        setTitle("Meu Jogo");                                       //titulo da tela
        setSize(1024,720);                                          //largura da tela
        setLocationRelativeTo(null);                                //centralizar                
        this.setResizable(false);                                   //para não maximixar
        setVisible(true);

    }

    public static void main(String []args) {
        
        new Container();
        
    }

}

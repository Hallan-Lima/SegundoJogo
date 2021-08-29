package InterfaceContainer.Fase;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
    
    private Image fundo;
    private final Player player;
    private final Timer timer;
    private ImageIcon referencia;
   
    public Fase(){

        setFocusable(true);
        setDoubleBuffered(true);
        
        referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\fundoteste.png");
        fundo = referencia.getImage();

        player = new Player();
        player.load();
        
        addKeyListener(new TecladoAdapter());

       timer = new Timer(5, this);
       timer.start();

    }

    @Override
    public void paint(Graphics g){

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);            
        graficos.drawImage(player.getImagem(),player.getX(),player.getY(),this);
        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }
    
    private class TecladoAdapter extends KeyAdapter{                    //entrada dos valores do teclado
        @Override
        public void keyPressed(KeyEvent e){           
            player.keyPressed(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            
            player.keyRelease(e);
        }
        
    }

}

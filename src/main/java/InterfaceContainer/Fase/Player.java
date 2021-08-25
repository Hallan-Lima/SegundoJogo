package InterfaceContainer.Fase;

import javax.imageio.IIOImage;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Player {

    private int x,y;
    private int dx,dy;
    private int altura, largura;
    private Image imagem;

    public Player(){                //local de nacimento
        this.x = 250;
        this.y = 500;           
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player.png");
        imagem = referencia.getImage();
        
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
        
    }

    public void update(){           //mover o player
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }
    
    public void keyPressed(KeyEvent tecla){             //comando para movimentar o player
    int codigo = tecla.getKeyCode();
    
    if(codigo == KeyEvent.VK_UP){
            dy=-2;
    }    
    
    if(codigo == KeyEvent.VK_DOWN){
            dy=2;
    }    
    
    if(codigo == KeyEvent.VK_LEFT){
            dx=-2;
    }    
    
    if(codigo == KeyEvent.VK_RIGHT){
            dx=2;
    }    }
        
    public void keyRelease(KeyEvent tecla){         //quando parar de precionar a tecla
    int codigo = tecla.getKeyCode();
    
    if(codigo == KeyEvent.VK_UP){
            dy=0;
    }    
    
    if(codigo == KeyEvent.VK_DOWN){
            dy=0;
    }    
    
    if(codigo == KeyEvent.VK_LEFT){
            dx=0;
    }    
    
    if(codigo == KeyEvent.VK_RIGHT){
            dx=0;
    } }

    void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

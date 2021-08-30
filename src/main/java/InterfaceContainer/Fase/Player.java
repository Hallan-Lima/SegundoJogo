package InterfaceContainer.Fase;

import javax.swing.ImageIcon;

import Construtor.ConstrutorJogo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.lang.reflect.Constructor;

public class Player {

    private int x,y;
    private int dx,dy,a=0, posicao;
    private Image imagem;
    private int personagem;
    public  int valor2=0,laco=0;
    private int sprite=0;


    public Player(){                //local de nacimento
        
        this.x = 471;
        this.y = 343;

    }

    public void load() {
    
        ImageIcon referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down1.png");
        imagem = referencia.getImage();
    
    }

    public void personagemParado() {
        
        ImageIcon referencia;
        
        if (posicao == 1) {
            
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up1.png");
            imagem = referencia.getImage();

        } 
        if (posicao == 2) {
            
            sprite++;
            switch (sprite) {
                case 10:
                    
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_down1.png");
                imagem = referencia.getImage();

                    break;

                case 30:
                    
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_down2.png");
                imagem = referencia.getImage();

                    break;

                case 40:
                    
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_down3.png");
                imagem = referencia.getImage();
    
                sprite=0;
                    break;
            
                default:
                    break;
            }
                
        }
        if (posicao == 3) {
            
            sprite++;
            switch (sprite) {
                case 10:
                    
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_left1.png");
                imagem = referencia.getImage();

                    break;

                case 30:
                    
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_left3.png");
                imagem = referencia.getImage();

                    break;

                case 40:
                    
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_left1.png");
                imagem = referencia.getImage();
    
                sprite=0;
                    break;
            
                default:
                    break;
            }
                
        }
        if (posicao == 4) {
            
            sprite++;
            switch (sprite) {
                case 10:
                    
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_right1.png");
                imagem = referencia.getImage();

                    break;

                case 30:
                    //tem que ajustar a imagem
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_right2.png");
                imagem = referencia.getImage();

                    break;

                case 40:
                    
                referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\playerparado_right3.png");
                imagem = referencia.getImage();
    
                sprite=0;
                    break;
            
                default:
                    break;
            }
                
        }

        if (sprite > 62) {
            sprite=0;
        }

    }

    public void personagemDown() {

        if (personagem > 27) {
            personagem=0;
        }

        switch (personagem) {
            case 1:
                
            ImageIcon referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down1.png");
            imagem = referencia.getImage();

                break;
            case 3:
                
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down2.png");
            imagem = referencia.getImage();

                break;
            case 6:
            
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down3.png");
            imagem = referencia.getImage();
            
                break;
            case 9:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down4.png");
            imagem = referencia.getImage();
            
                break;
            case 12:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down5.png");
            imagem = referencia.getImage();
            
                break;
            case 15:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down6.png");
            imagem = referencia.getImage();
            
                break;
            case 18:
    
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down7.png");
            imagem = referencia.getImage();
            
                break;
            case 21:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down8.png");
            imagem = referencia.getImage();
                
                break;
            case 24:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down9.png");
            imagem = referencia.getImage();
            
                break;

            case 27:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_down10.png");
            imagem = referencia.getImage();

            personagem = 0;
                break;
        
            default:

                break;
        }

    }

    public void personagemUp() {
        
        ImageIcon referencia;

        personagem++;

        if (personagem == 1) {
            
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up1.png");
            imagem = referencia.getImage();

        }if (personagem == 3) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up2.png");
            imagem = referencia.getImage();

        }if (personagem == 6) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up3.png");
            imagem = referencia.getImage();

        }if (personagem == 9) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up4.png");
            imagem = referencia.getImage();

        }if (personagem == 12) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up5.png");
            imagem = referencia.getImage();

        }if (personagem == 15) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up6.png");
            imagem = referencia.getImage();

        }if (personagem == 17) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up7.png");
            imagem = referencia.getImage();

        }if (personagem == 20) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up8.png");
            imagem = referencia.getImage();

        }if (personagem == 23) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up9.png");
            imagem = referencia.getImage();

        }if (personagem == 26) {

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_up10.png");
            imagem = referencia.getImage();
        }if (personagem >= 26) {
            personagem  = 0;
        }

    }

    public void personagemLeft() {

        if (personagem > 27) {
            personagem=0;
        }

        switch (personagem) {
            case 1:
                
            ImageIcon referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left1.png");
            imagem = referencia.getImage();

                break;
            case 3:
                
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left2.png");
            imagem = referencia.getImage();

                break;
            case 6:
            
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left3.png");
            imagem = referencia.getImage();
            
                break;
            case 9:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left4.png");
            imagem = referencia.getImage();
            
                break;
            case 12:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left5.png");
            imagem = referencia.getImage();
            
                break;
            case 15:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left6.png");
            imagem = referencia.getImage();
            
                break;
            case 18:
    
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left7.png");
            imagem = referencia.getImage();
            
                break;
            case 21:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left8.png");
            imagem = referencia.getImage();
                
                break;
            case 24:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left9.png");
            imagem = referencia.getImage();
            
                break;

            case 27:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_left10.png");
            imagem = referencia.getImage();

            personagem = 0;
                break;
        
            default:

                break;
        }

    }

    public void personagemRight() {

        if (personagem > 27) {
            personagem=0;
        }

        switch (personagem) {
            case 1:
                
            ImageIcon referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right1.png");
            imagem = referencia.getImage();

                break;
            case 3:
                
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right2.png");
            imagem = referencia.getImage();

                break;
            case 6:
            
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right3.png");
            imagem = referencia.getImage();
            
                break;
            case 9:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right4.png");
            imagem = referencia.getImage();
            
                break;
            case 12:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right5.png");
            imagem = referencia.getImage();
            
                break;
            case 15:
        
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right6.png");
            imagem = referencia.getImage();
            
                break;
            case 18:
    
            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right7.png");
            imagem = referencia.getImage();
            
                break;
            case 21:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right8.png");
            imagem = referencia.getImage();
                
                break;
            case 24:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right9.png");
            imagem = referencia.getImage();
            
                break;

            case 27:

            referencia = new ImageIcon("src\\main\\java\\InterfaceContainer\\Imagens\\player_right10.png");
            imagem = referencia.getImage();

            personagem = 0;
                break;
        
            default:

                break;
        }

    }

    public void update(){           //mover o player
        
        if (a >= 2) {               //gambiarra para o personagem não ser arrastado
         
            x += dx;
            y += dy;

           System.out.println("x -"+x+" y -"+y);
        }
        if ((dx == 0) && (dy == 0)) {
            a=0;
            personagemParado();

        }
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
        if (this.y < 60) {
            dy=0;             
        } else {

            a++;
            personagem++;
            personagemUp();
            dy=-1;
            dx=0;                   //para não andar em diagonal
        }
    }    
    
    if(codigo == KeyEvent.VK_DOWN){
        if (this.y > 600) {
            dy=0; 
        } else {
            a++;
            personagem++;
            personagemDown();
            dy=1;
            dx=0;
        }
    }    
    
    if(codigo == KeyEvent.VK_LEFT){
        if (this.x < 60) {
            dx=0;               
        } else {
            a++;
            personagem++;
            personagemLeft();           
            dx=-1;   
            dy=0;
        }
    }    
    
    if(codigo == KeyEvent.VK_RIGHT){
        if (this.x > 950) {
            dx=0;
            
        } else {
            a++;
            personagem++;
            personagemRight();
            dx=1;
            dy=0;
        }
    }    
}

    public void keyRelease(KeyEvent tecla){         //quando parar de precionar a tecla
    int codigo = tecla.getKeyCode();

    ConstrutorJogo constructor = new ConstrutorJogo();
    constructor.audioAndando(valor2=0);

    
    if(codigo == KeyEvent.VK_UP){
            dy=0;
            posicao=1;
    }    
    
    if(codigo == KeyEvent.VK_DOWN){
            dy=0;
            posicao=2;
    }    
    
    if(codigo == KeyEvent.VK_LEFT){
            dx=0;
            posicao=3;
    }    
    
    if(codigo == KeyEvent.VK_RIGHT){
            dx=0;
            posicao=4;
    } 

}

    void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

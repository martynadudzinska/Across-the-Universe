import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Postac  {

    static public boolean wLewo, wPrawo;
    static public int x=100;
    static public int y=450;
    int przesuniecie=4;
    public BufferedImage postacImg1, postacImg2;
    static public BufferedImage imagePostac;
    OknoGry oknoGry;
    KeyHandler keyHandler;

    public Postac (OknoGry oknoGry) {
        this.oknoGry=oknoGry;

        getPostacImg();
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    }

    public void getPostacImg () {
        try {

            postacImg1 = ImageIO.read(getClass().getResourceAsStream("/resources/spongebob.png"));
            postacImg2 = ImageIO.read(getClass().getResourceAsStream("/resources/spongebob2.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {

        if (wLewo) {
            x -= przesuniecie;
            System.out.println("PRZESUNIECEI");
            imagePostac = postacImg2;
        } else if (wPrawo) {
            x += przesuniecie;
            System.out.println("przesunieciee");
            imagePostac = postacImg1;
        }

    }
    /*public void paintComponent(Graphics2D g2) {

        //image = postacImg;
        g2.drawImage(imagePostac,x,y, 100, 100,null);
    }*/




}

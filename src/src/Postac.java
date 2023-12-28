import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Postac  {

    static public boolean wLewo, wPrawo, wGore, wDol;
    static public int x=100;
    static public int y=500;
    int przesuniecie=4;
    public BufferedImage postacImg1, postacImg2;
    static public BufferedImage imagePostac;
    OknoGry oknoGry;
    KeyHandler keyHandler;
    Kolizja kolizja;
    public static int ktoryPoziom;
    int gornaGranica;
    boolean czyWPowietrzu;

    public Postac (OknoGry oknoGry) {
        this.oknoGry=oknoGry;

        getPostacImg();
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        ktoryPoziom = 1;
        kolizja = new Kolizja(ktoryPoziom);


    }

    public void getPostacImg () {
        try {

            postacImg1 = ImageIO.read(getClass().getResourceAsStream("/resources/spongebob.png"));
            postacImg2 = ImageIO.read(getClass().getResourceAsStream("/resources/spongebob2.png"));
            imagePostac = postacImg1;

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() { //z kazdym uderzeniem thread sie robi

        kolizja.kolizjaDol();
        if (wLewo) {
            if (x>0) {
                x -= przesuniecie;
                imagePostac = postacImg2;
            }
        } else if (wPrawo) {
            if (x<886) {
                x += przesuniecie;
                imagePostac = postacImg1;
            }
        }
        if (wGore) //mozna np maksymalnie 100 skoczyc w gore i wtedy blokuje sie pomzliwosc i zaczyna sie spadac, mozna ruszac lewo prawo
        { if (y>46) {
            y -= przesuniecie;
        }
        }
        else if (wDol)
        { if(!kolizja.kolizjaDol()) {
            y += przesuniecie;
        }
        }

        }



    /*public void paintComponent(Graphics2D g2) {

        //image = postacImg;
        g2.drawImage(imagePostac,x,y, 100, 100,null);
    }*/




}

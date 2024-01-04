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
    public BufferedImage postacImg1, postacImg2, postacImgSkok1, postacImgSkok2;
    static public BufferedImage imagePostac;
    OknoGry oknoGry;
    KeyHandler keyHandler;
    Kolizja kolizja;
    public static int ktoryPoziom;
    int gornaGranica;
    boolean spadanie;
    boolean kierunek; //prawo -prawda, lewo-falsz


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
            postacImgSkok1 = ImageIO.read(getClass().getResourceAsStream("/resources/spongebob_skok.png"));
            postacImgSkok2 = ImageIO.read(getClass().getResourceAsStream("/resources/spongebob_skok_lewo.png"));
            imagePostac = postacImg1;

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() { //z kazdym uderzeniem thread sie robi


        if(kolizja.kolizjaDol()){

            gornaGranica = y-200;
            spadanie = false;
            if(kierunek) {
                imagePostac=postacImg1;
            }else imagePostac = postacImg2;
            //System.out.println(gornaGranica);
        }
        else if (((y>gornaGranica-3)&(y<gornaGranica+1)) || (y<=46) ||(kolizja.kolizjaGora()) || ((!wGore)&(!kolizja.kolizjaDol()))){
            spadanie = true; //musi chwile postac na bloczku znim kolejny skok

        }
        if (spadanie) {

                y+=przesuniecie;

        }
        //kolizja.kolizjaDol();
        if (wLewo) {
            if (x>0) {
                x -= przesuniecie;
                kierunek = false;
                if(kolizja.kolizjaDol()) {
                    imagePostac = postacImg2;
                }else imagePostac = postacImgSkok2;
            }
        } else if (wPrawo) {
            if (x<886) {
                x += przesuniecie;
                kierunek = true;
                if (kolizja.kolizjaDol()) {
                    imagePostac = postacImg1;
                }else imagePostac = postacImgSkok1;
            }
        }
        if (wGore & !spadanie & !kolizja.kolizjaGora()) //mozna np maksymalnie 100 skoczyc w gore i wtedy blokuje sie pomzliwosc i zaczyna sie spadac, mozna ruszac lewo prawo
        { if (y>46) {
            if(y>gornaGranica) {
                y -= przesuniecie;
            }
        }
        }

       /* System.out.println(x +"  " +y);*/
        }



}

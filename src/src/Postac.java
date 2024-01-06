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
    Zbieranie zbieranie;
    public static int ktoryPoziom;
    int gornaGranica;
    static int licznikZebranych;
    boolean czySkok;
    boolean spadanie;
    boolean kierunek; //prawo -prawda, lewo-falsz
    public static boolean ananasWidoczny, lizakWidoczny, majonezWidoczny, pizzaWidoczna, zupaWidoczna;

    public Postac (OknoGry oknoGry) {
        this.oknoGry=oknoGry;

        getPostacImg();
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        ktoryPoziom = 1;
        kolizja = new Kolizja(ktoryPoziom);
        zbieranie = new Zbieranie(ktoryPoziom);
        licznikZebranych =0;

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
            czySkok = false;
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
                    czySkok = false;
                }else {
                    imagePostac = postacImgSkok2;
                    czySkok = true;
                }
            }
        } else if (wPrawo) {
            if (x<886) {
                x += przesuniecie;
                kierunek = true;
                if (kolizja.kolizjaDol()) {
                    imagePostac = postacImg1;
                    czySkok = false;
                }else {
                    imagePostac = postacImgSkok1;
                    czySkok = true;
                }
            }
        }
        if (wGore & !spadanie & !kolizja.kolizjaGora()) //mozna np maksymalnie 100 skoczyc w gore i wtedy blokuje sie pomzliwosc i zaczyna sie spadac, mozna ruszac lewo prawo
        { if (y>46) {
            if(y>gornaGranica) {
                y -= przesuniecie;
            }
        }
        }
        if (ktoryPoziom==1) {
            //System.out.println("zetkniecie= "+zbieranie.zetkniecie);
            if (zbieranie.zbieranie() ==1 ) {OknoGry.sprawdzanie=true; OknoGry.jakieSlowko ="ananas"; } //Poziom1.ananasWidoczny =false; licznikZebranych++;
            else if (zbieranie.zbieranie() ==2 ) {OknoGry.sprawdzanie=true; OknoGry.jakieSlowko ="majonez";}
            else if (zbieranie.zbieranie() ==3 ) {OknoGry.sprawdzanie=true; OknoGry.jakieSlowko ="lizak";}
            else if (zbieranie.zbieranie() ==4 ) {OknoGry.sprawdzanie=true; OknoGry.jakieSlowko ="pizza";}
            else if (zbieranie.zbieranie() ==5 ) {OknoGry.sprawdzanie=true; OknoGry.jakieSlowko ="zupa";}

        }
        //zbieranie.zbieranie();
       //System.out.println(x +"  " +y);
        } //koniec update



}

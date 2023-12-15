import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class Okno extends JFrame {

    Okno () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Across the Universe");
        setSize(1000,600); //1280, 800
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void zmienWidocznosc(boolean widocznosc) {
        this.setVisible(widocznosc);
    }
}
public class Main {

    public int abc;
    public static Okno okno;
    public static void main(String[] args) {

       okno = new Okno();
       OknoStartowe oknoStartowe = new OknoStartowe();
       okno.add(oknoStartowe);
       okno.setVisible(true);


        /*OknoGry oknoGry = new OknoGry();
        okno.add(oknoGry);
        okno.pack();*/

       //okno.setLocationRelativeTo(null);
       //okno.setVisible(true);

       //oknoGry.startThread();

        }
    }

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

       JFrame okno = new JFrame();

       okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       okno.setResizable(false);
       okno.setTitle("Across the Universe - Okno Startowe");
       okno.setSize(1000,600); //1280, 800
       okno.setLocationRelativeTo(null);
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

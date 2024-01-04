import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;*/
//import java.awt.Desktop.Action;
import java.awt.image.BufferedImage;
import java.io.IOException;

class Okno extends JFrame implements KeyListener {

//zmienic buttony w key - dzis
//dodać okno menu z funkcjami - dzis
//dodac obsluge zetkniecia z obiektami i okno wpisywania nazwy
//dodać nowe poziomy - dzis
//dodać zczytywanie z pliku informacji o poziomach
// muzyka xd

    Okno () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Across the Universe");
        pack();
        setSize(1000,650); //1280, 800
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        this.addKeyListener(this);

    }

    public void focus () {
        //System.out.println("FOKUS DZIALA");
        setFocusable(true);
        this.addKeyListener(this);
        this.requestFocus();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int klawisz = e.getKeyCode();
        if (klawisz == KeyEvent.VK_A) {
            Postac.wLewo = true;
        }
        if (klawisz == KeyEvent.VK_D) {
            Postac.wPrawo = true;
        }
        if (klawisz == KeyEvent.VK_W) {
            Postac.wGore = true;
        }

        if (klawisz == KeyEvent.VK_S) {
            OknoGry.slownikWybrany = true;
        }
        if (klawisz == KeyEvent.VK_P) {
            Slownik.powrotDoGry = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int klawisz = e.getKeyCode();
        if (klawisz == KeyEvent.VK_A) {
            Postac.wLewo = false;

        }
        if (klawisz == KeyEvent.VK_D) {
            Postac.wPrawo = false;

        }
        if (klawisz == KeyEvent.VK_W) {
            Postac.wGore = false;
        }
        if (klawisz == KeyEvent.VK_P) {
            Slownik.powrotDoGry = false;
        }
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

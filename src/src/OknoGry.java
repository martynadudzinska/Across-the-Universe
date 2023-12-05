import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class OknoGry extends JPanel implements Runnable {


    int FPS = 60;
    Thread thread;
    KeyHandler keyHandler = new KeyHandler();
    Postac postac = new Postac(this,keyHandler);

    public OknoGry () {
        this.setPreferredSize(new Dimension(1000,600));
        this.setBackground(Color.PINK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler); //dodaje KeyListener do panela - obiekt klasy KeyHandler
        this.setFocusable(true);
    }

    public void startThread () {
        thread = new Thread(this); //ten JPanel zamieszczony w konstruktorze Thread
        thread.start();  //wywoluje metode run()
    }
    @Override
    public void run() {

        double interval = 1000000000/FPS;   // miliard nanosekund = sekunda, paintComponent co 1/FPS sekund
        double delta =0;
        long czas = System.nanoTime();
        long aktualnyCzas;

        while(thread != null) {

            aktualnyCzas = System.nanoTime();
            delta += (aktualnyCzas - czas) / interval; //zeby zadzialal if delta musi być równa 1 (bądź przekroczyć 1),
            czas = aktualnyCzas;                       //a wiec (aktualnyCzas - czas) musi być równe przynajmniej interval
                                                       //im wiekszy FPS tym mniejszy interval, tym częściej delta = 1
            if (delta >= 1) {
                update();
                repaint();  //wywoluje paintComponent()
                delta --;
            }
        }
    }
    public void update() {
        postac.update();
    }
    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        postac.draw(g2);
        g2.dispose();
    }
}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OknoGry extends JPanel implements Runnable {

    int FPS = 60;
    Thread thread;
    //KeyHandler keyHandler = new KeyHandler();
    Postac postac = new Postac(this);
    BufferedImage tlo, platform1, platform2, platform3, platform4, platform5, menu, ksiazka;
    JPanel jPanel;
    public OknoGry () {
        this.setPreferredSize(new Dimension(1000,600));
        Color color = new Color(177,162,202);
        this.setBackground(color);
        this.setDoubleBuffered(true);
        addKeyListener(new KeyHandler()); //dodaje KeyListener do panela - obiekt klasy KeyHandler
        //setFocusable(true);
        this.requestFocus();
        getImg();
        //setLayout(new BorderLayout());
        ImageIcon przyciskMenu = new ImageIcon(menu);
        JButton menuBtn = new JButton("M E N U");
        menuBtn.setBounds(0,0,140,47);
        this.add(menuBtn/*,BorderLayout.NORTH*/);
        //jPanel = new JPanel();
        //this.add(jPanel, BorderLayout.SOUTH);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        menuBtn.setCursor(cursor);
    }

    public void getImg () {
        try {

            tlo = ImageIO.read(getClass().getResourceAsStream("/resources/tlo_gra.jpg"));
            platform1 = ImageIO.read(getClass().getResourceAsStream("/resources/platform.png"));
            menu = ImageIO.read(getClass().getResourceAsStream("/resources/menu.bmp"));

            ksiazka = ImageIO.read(getClass().getResourceAsStream("/resources/ksiazka.png"));
            platform2 = platform1; platform3 = platform1; platform4 = platform1; platform5 = platform1;
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                /*this.jPanel.*/repaint();  //wywoluje paintComponent()
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
        g2.drawImage(tlo,0,0,1000,600,null);
        g2.drawImage(platform1,0,400,200,25,null);
        g2.drawImage(platform2,30,100,200,25,null);
        g2.drawImage(platform3,300,250,200,25,null);
        g2.drawImage(platform4,600,350,200,25,null);
        g2.drawImage(platform5,800,150,200,25,null);
        g2.drawImage(Postac.imagePostac,Postac.x,Postac.y, 100, 100,null);
        //g2.dispose();
    }
}

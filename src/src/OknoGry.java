import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class OknoGry extends JPanel implements Runnable {

    int FPS = 70;
    Thread thread;
    //KeyHandler keyHandler = new KeyHandler();
    Postac postac;
    BufferedImage tlo, platform1, platform2, platform3, platform4, platform5, menu, ksiazka;
    Slownik slownik;
    JPanel jPanel;
    //static public Rectangle rect;
    public OknoGry () {
        postac = new Postac(this);
        this.setPreferredSize(new Dimension(1000,600));
        Color color = new Color(177,162,202);
        this.setBackground(color);
        this.setDoubleBuffered(true);
        addKeyListener(new KeyHandler()); //dodaje KeyListener do panela - obiekt klasy KeyHandler
        //setFocusable(true);
        this.requestFocus();
        getImg();
        setLayout(null);
        ImageIcon przyciskMenu = new ImageIcon(menu);
        ImageIcon przyciskSlownik = new ImageIcon(ksiazka);
        JButton menuBtn = new JButton(przyciskMenu);
        menuBtn.setBackground(color);
        JButton slownikBtn = new JButton(przyciskSlownik);
        slownikBtn.setBackground(color);
        menuBtn.setBounds(20,2,140,47);
        slownikBtn.setBounds(170,0,60,50);
        this.add(menuBtn/*,BorderLayout.NORTH*/);
        this.add(slownikBtn/*,BorderLayout.NORTH*/);
        //jPanel = new JPanel();
        //this.add(jPanel, BorderLayout.SOUTH);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        menuBtn.setCursor(cursor);
        slownikBtn.setCursor(cursor);

        slownikBtn.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                slownik = new Slownik(1);
            }
        });


        JLabel punkty = new JLabel("WYNIK/SCORE : 0/5");
        punkty.setFont(new Font("Helvetica", Font.BOLD, 20));
        punkty.setBounds(300,0,200,50);
        JLabel napisPoziom = new JLabel("Poziom: 1");
        napisPoziom.setFont(new Font("Helvetica", Font.BOLD, 20));
        napisPoziom.setBounds(600,0,200,50);
        this.add(punkty);
        this.add(napisPoziom);
        //rect = new Rectangle(Postac.x,Postac.y+5,100,88);
    }

    public void getImg () {
        try {

            tlo = ImageIO.read(getClass().getResourceAsStream("/resources/tlo_gra.jpg"));
            platform1 = ImageIO.read(getClass().getResourceAsStream("/resources/platform.png"));
            menu = ImageIO.read(getClass().getResourceAsStream("/resources/menu.bmp"));

            ksiazka = ImageIO.read(getClass().getResourceAsStream("/resources/ksiazka2.bmp"));
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
                repaint();  //wywoluje paintComponent()
                delta --;
            }
        }
    }
    public void update() {
        postac.update();
        if(slownik !=null) {
            
            if (slownik.widoczny) {
                System.out.println("WIDOCZNYY");
            } else System.out.println("NIE WIDOCZNY");
        }
        //rect = new Rectangle(Postac.x,Postac.y+5,100,88);

    }
    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(tlo,0,50,1000,600,null);
        g2.drawImage(Postac.imagePostac,Postac.x,Postac.y, 100, 100,null);
        g2.drawImage(platform1,0,450,200,25,null);
        g2.drawImage(platform2,30,150,200,25,null);
        g2.drawImage(platform3,300,300,200,25,null);
        g2.drawImage(platform4,600,400,200,25,null);
        g2.drawImage(platform5,800,200,200,25,null);
        //g2.drawRect(rect.x, rect.y, rect.width, rect.height);
        //g2.drawImage(ksiazka,170,0, 60, 50,null);
        //g2.dispose();
    }
}

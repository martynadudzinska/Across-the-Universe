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
    Color color2;
    Color color3;
    BufferedImage tlo, platform1, platform2, platform3, platform4, platform5, menuImg, ksiazka;
    static boolean slownikWlaczony;
    static boolean menuWlaczone;
    Slownik slownik;
    static Menu menu;
    JButton menuBtn;
    JButton slownikBtn;
    JButton enter;
    JLabel punkty;
    JLabel napis;
    TextField blednyWpis;
    TextField textField;
    static boolean sprawdzanie;
    static String jakieSlowko;
    String wpis;
    static boolean poprawnieWpisane;
    int ktoryPoziom;
    static boolean czyWRuchu;
    boolean enterKlikniety;
    boolean rysujProstokat=false;

    public OknoGry () {
        postac = new Postac(this);
        this.setPreferredSize(new Dimension(1000,600));
        Color color = new Color(177,162,202);
        color2 = new Color(136,77,255);
        color3 = new Color(212,88,88);
        this.setBackground(color);
        this.setDoubleBuffered(true);
        ktoryPoziom = Postac.ktoryPoziom;
        //setFocusable(true);
        this.requestFocus();
        getImg();
        setLayout(null);
        napis = new JLabel("Wpisz nazwę elementu");
        napis.setFont(new Font("Helvetica", Font.BOLD, 15));
        napis.setBounds(420, 250, 250, 20);
        napis.setVisible(false);
        add(napis);
        blednyWpis = new TextField(" NAZWA NIEPOPRAWNA!");
        blednyWpis.setFont(new Font("Helvetica", Font.BOLD, 15));
        blednyWpis.setBackground(color3);
        blednyWpis.setBounds(405, 275, 190, 40);
        blednyWpis.setVisible(false);
        add(blednyWpis);
        textField = new TextField();
        textField.setVisible(false);
        textField.setBackground(color);
        textField.setBounds(430,275,140,50);
        textField.setFocusable(false);
        add(textField);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        enter = new JButton("E N T E R");
        enter.setBounds(440,350,120,50);
        enter.setBackground(color); enter.setCursor(cursor);
        enter.setVisible(false);
        enter.setFocusable(false);
        add(enter);
        ImageIcon przyciskMenu = new ImageIcon(menuImg);
        ImageIcon przyciskSlownik = new ImageIcon(ksiazka);
        menuBtn = new JButton();
        menuBtn.setIcon(przyciskMenu);
        menuBtn.setBackground(color);
        slownikBtn = new JButton(przyciskSlownik);
        slownikBtn.setBackground(color);
        menuBtn.setBounds(20,2,140,47);
        slownikBtn.setBounds(170,0,50,50);
        slownikBtn.setFocusable(false);
        this.add(menuBtn);
        this.add(slownikBtn);
        //jPanel = new JPanel();
        //this.add(jPanel, BorderLayout.SOUTH);
        menuBtn.setCursor(cursor);
        slownikBtn.setCursor(cursor);
        slownikBtn.setFocusable(false);
        menuBtn.setFocusable(false);
        slownikBtn.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                if (!sprawdzanie) {
                    System.out.println("S");
                    pokazSlownik();
                }
            }
        });

        menuBtn.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                System.out.println("M");
                pokazMenu();
            }
        });


        punkty = new JLabel("WYNIK/SCORE : "+Postac.licznikZebranych+"/5");
        punkty.setFont(new Font("Helvetica", Font.BOLD, 20));
        punkty.setBounds(300,0,300,50);
        JLabel napisPoziom = new JLabel("Poziom: "+ktoryPoziom);
        napisPoziom.setFont(new Font("Helvetica", Font.BOLD, 20));
        napisPoziom.setBounds(600,0,200,50);
        this.add(punkty);
        this.add(napisPoziom);
        //rect = new Rectangle(Postac.x,Postac.y+5,100,88);
    }



    public void update() {
        postac.update();
        punkty.setText("WYNIK/SCORE : "+Postac.licznikZebranych+"/5");
        if (Slownik.powrotDoGry) {
            ukryjSlownik();
        }
        if (Menu.powrotDoGry) {
            ukryjMenu();
        }
        if (sprawdzanie) {
            sprawdzenieWiedzy(jakieSlowko);
        }
        if (czyWRuchu || Menu.poziomOdNowyWybrany) {blednyWpis.setVisible(false); rysujProstokat= false;}
               // Main.okno.remove(slownik);
                //Main.okno.focus();
                //this.requestFocus();
    }

public void sprawdzenieWiedzy(String jakieSlowko) {
        enterKlikniety = false;
    textField.setVisible(true);
    textField.setFocusable(true);
    napis.setVisible(true);
    enter.setVisible(true);

    enter.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            wpis = textField.getText();
            enterKlikniety = true;
        }
    });
    if(enterKlikniety) {
        if (wpis != null & ktoryPoziom == 1) {
            if (jakieSlowko.equals("ananas")) {
                if (wpis.equals("pineapple")) {
                    Poziom1.ananasWidoczny = false;
                    poprawnieWpisane = true;
                } else {
                    poprawnieWpisane = false;
                    niepoprawnyWpis();
                }
            }
            if (jakieSlowko.equals("majonez")) {
                if (wpis.equals("mayonnaise")) {
                    Poziom1.majonezWidoczny = false;
                    poprawnieWpisane = true;
                } else {
                    poprawnieWpisane = false;
                    niepoprawnyWpis();
                }
            }
            if (jakieSlowko.equals("lizak")) {
                if (wpis.equals("lollipop")) {
                    Poziom1.lizakWidoczny = false;
                    poprawnieWpisane = true;
                } else {
                    poprawnieWpisane = false;
                    niepoprawnyWpis();
                }
            }
            if (jakieSlowko.equals("pizza")) {
                if (wpis.equals("pizza")) {
                    Poziom1.pizzaWidoczna = false;
                    poprawnieWpisane = true;
                } else {
                    poprawnieWpisane = false;
                    niepoprawnyWpis();
                }
            }
            if (jakieSlowko.equals("zupa")) {
                if (wpis.equals("soup")) {
                    Poziom1.zupaWidoczna = false;
                    poprawnieWpisane = true;
                } else {
                    poprawnieWpisane = false;
                    niepoprawnyWpis();
                }
            }
        }
    }
    if (poprawnieWpisane) {
        textField.setVisible(false);
        textField.setText("");
        enter.setVisible(false);
        enter.setFocusable(false);
        textField.setFocusable(false);
        napis.setVisible(false);
        sprawdzanie = false;
        Postac.licznikZebranych++;
        poprawnieWpisane = false;
    }

}
public void niepoprawnyWpis () {
        czyWRuchu = false;
        sprawdzanie = false;
        Postac.x = 100;
        Postac.y = 500;
    textField.setVisible(false);
    textField.setText("");
    enter.setVisible(false);
    enter.setFocusable(false);
    textField.setFocusable(false);
    napis.setVisible(false);
    sprawdzanie = false;
    blednyWpis.setVisible(true);
    rysujProstokat = true;
}


    public void pokazSlownik () {

        slownik = new Slownik(ktoryPoziom);
        Main.okno.add(slownik);
        slownik.setVisible(true);
        this.setVisible(false);
        slownikWlaczony = true;
        slownikBtn.setFocusable(false);
    }

    public void ukryjSlownik() {
        slownik.setVisible(false);
        slownik = null;
        Slownik.powrotDoGry = false;
    }
    private void pokazMenu() {
        menu = new Menu(1);
        Main.okno.add(menu);
        menu.setVisible(true);
        this.setVisible(false);
        menuWlaczone = true;
        menuBtn.setFocusable(false);
    }
    private void ukryjMenu() {
        menu.setVisible(false);
        menu = null;
        Menu.powrotDoGry = false;
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
        g2.setColor(color2);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        if (sprawdzanie) g2.drawRect(405, 250,190,175);
        g2.setColor(color3);
        if (rysujProstokat) g2.drawRect(380, 250,240,90);

    }

    public void getImg () {
        try {

            tlo = ImageIO.read(getClass().getResourceAsStream("/resources/tlo_gra.jpg"));
            platform1 = ImageIO.read(getClass().getResourceAsStream("/resources/platform.png"));
            menuImg = ImageIO.read(getClass().getResourceAsStream("/resources/menu.bmp"));
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
}

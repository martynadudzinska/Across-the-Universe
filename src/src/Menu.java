import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu extends JPanel implements Runnable {

    Color color, color2;
    Cursor cursor;
    int ktoryPoziom;
    int FPS = 70;
    JButton btnPowrot, btnInstrukcja, btnPoziomOdNowa, btnZakoncz, btnInnyPoziom;
    BufferedImage tlo;
    Instrukcja instrukcja;
    int y= 50;
    static public boolean powrotDoGry;
    static boolean instrukcjaWlaczona;
    static boolean poziomOdNowyWybrany;
    Thread thread;

    Menu (int ktoryPoziom) {

        getImg();
        startThread();
        powrotDoGry = false;
        poziomOdNowyWybrany = false;
        setSize(1000, 600);
        this.setDoubleBuffered(true);
        this.ktoryPoziom = ktoryPoziom;
        //setPreferredSize(new Dimension(300,400));
        color = new Color(177, 162, 202);
        color2 = new Color(136, 77, 255);
        this.setBackground(color);
        setBackground(color);
        this.setPreferredSize(new Dimension(300, 400));

        //*************** P R Z Y C I S K I *************************************************************
        btnPowrot = new JButton("POWRÓT"); btnInstrukcja = new JButton("INSTRUKCJA");
        btnPoziomOdNowa = new JButton("RESTART");  btnInnyPoziom = new JButton("INNY POZIOM");
        btnZakoncz = new JButton("ZAKOŃCZ");
        btnPowrot.setBounds(440, y, 120, 50); btnInstrukcja.setBounds(440, y+100, 120, 50);
        btnPoziomOdNowa.setBounds(440, y+200, 120, 50); btnInnyPoziom.setBounds(440, y+300, 120, 50);
        btnZakoncz.setBounds(440, y+400, 120, 50);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        btnPowrot.setCursor(cursor);    btnInstrukcja.setCursor(cursor);
        btnPoziomOdNowa.setCursor(cursor);btnInnyPoziom.setCursor(cursor); btnZakoncz.setCursor(cursor);
        btnPowrot.setBackground(color); btnInstrukcja.setBackground(color);
        btnPoziomOdNowa.setBackground(color); btnInnyPoziom.setBackground(color); btnZakoncz.setBackground(color);
        btnPowrot.setVisible(true);     btnInstrukcja.setVisible(true);
        btnPoziomOdNowa.setVisible(true); btnInnyPoziom.setVisible(true); btnZakoncz.setVisible(true);
        btnPowrot.setFocusable(true);   btnInstrukcja.setFocusable(true);
        btnPoziomOdNowa.setFocusable(true); btnInnyPoziom.setFocusable(true); btnZakoncz.setFocusable(true);
        btnPowrot.requestFocus();       btnInstrukcja.requestFocus();
        btnPoziomOdNowa.requestFocus(); btnInnyPoziom.requestFocus(); btnZakoncz.requestFocus();
        add(btnPowrot); add(btnInstrukcja); add(btnPoziomOdNowa); add(btnInnyPoziom);  add(btnZakoncz);
        //*************** P R Z Y C I S K I ************************************************************
        btnPowrot.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                //System.out.println("POWROT DO GRYYYY");
                powrotDoGry = true;
                OknoGry.menuWlaczone = false;
                if(ktoryPoziom==1) ListaPoziomow.poziom1.setVisible(true);
                else if (ktoryPoziom ==2) ListaPoziomow.poziom2.setVisible(true);
                else if (ktoryPoziom ==3) ListaPoziomow.poziom3.setVisible(true);
                System.out.println("P");
                btnPowrot.setVisible(false);
                //button.setFocusable(false);

            }
        });
        btnPoziomOdNowa.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                powrotDoGry = true;
                OknoGry.menuWlaczone = false;
                System.out.println("P");
                btnPowrot.setVisible(false);
                Postac.x =100; Postac.y = 500;
                if(ktoryPoziom==1) {
                    ListaPoziomow.poziom1.setVisible(true);
                    Poziom1.ananasWidoczny = true;
                    Poziom1.majonezWidoczny = true;
                    Poziom1.lizakWidoczny = true;
                    Poziom1.pizzaWidoczna = true;
                    Poziom1.zupaWidoczna = true;
                }else if (ktoryPoziom ==2){
                    ListaPoziomow.poziom2.setVisible(true);
                    Poziom2.slimakWidoczny = true;
                    Poziom2.papugaWidoczna = true;
                    Poziom2.meduzaWidoczna = true;
                    Poziom2.malpaWidoczna = true;
                    Poziom2.konikMorskiWidoczny = true;
                }
                else if (ktoryPoziom ==3){
                    ListaPoziomow.poziom3.setVisible(true);
                    Poziom3.banknotWidoczny = true;
                    Poziom3.okularyWidoczne = true;
                    Poziom3.olowekWidoczny = true;
                    Poziom3.prezentWidocznu = true;
                    Poziom3.gitaraWidoczna = true;
                }
                poziomOdNowyWybrany = true;
                OknoGry.poprawnieWpisane = true;
                if (Postac.licznikZebranych >0) Postac.licznikZebranych = 0;
                //button.setFocusable(false);

            }
        });
        btnInstrukcja.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                //System.out.println("Wlaczam instrukcje");
                pokazInstrukcje();

            }
        });
        btnZakoncz.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.exit(0);

            }
        });
        setLayout(null);
        setVisible(true);
    }

    private void pokazInstrukcje() {
        instrukcja = new Instrukcja();
        Main.okno.add(instrukcja);
        instrukcja.setVisible(true);
        this.setVisible(false);
        instrukcjaWlaczona = true;
        //btnInstrukcja.setVisible(false);
    }

    private void ukryjInstrukcje() {
        if (instrukcja!=null) {
            instrukcja.setVisible(false);
            instrukcja = null;
            Instrukcja.powrotDoMenu = false;
        }
    }
    public void update () {
        if(Instrukcja.powrotDoMenu) {
            ukryjInstrukcje();
        }
    }
    public void getImg () {
        try {

            tlo = ImageIO.read(getClass().getResourceAsStream("/resources/tloWoda.png"));
           // poz1 = ImageIO.read(getClass().getResourceAsStream("/resources/poz1.png"));
            //poz2 = ImageIO.read(getClass().getResourceAsStream("/resources/poz2.png"));
            //poz3 = ImageIO.read(getClass().getResourceAsStream("/resources/poz3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(tlo,0,0,1000,650,null);
        g2.setColor(color2);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        //g2.drawRect(340, 70,300,200);
        g2.drawRect(425,y-10,150,70);
        g2.drawRect(425,y+90,150,70);
        g2.drawRect(425,y+190,150,70);
        g2.drawRect(425,y+290,150,70);
        g2.drawRect(425,y+390,150,70);
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
                delta --;
            }
        }
    }
}

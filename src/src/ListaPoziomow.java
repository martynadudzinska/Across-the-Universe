import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ListaPoziomow extends JPanel {


    JButton start1 = new JButton("POZIOM 1");
    JButton start2 = new JButton("POZIOM 2");
    JButton start3 = new JButton("POZIOM 3");
    BufferedImage poz1;
    BufferedImage poz2;
    BufferedImage poz3;
    static public boolean poziom2Odblokowany;
    static public boolean poziom3Odblokowany;
    BufferedImage tlo;
    Color color1;
    Color color2;
    static Poziom1 poziom1;
    static Poziom2 poziom2;
    static Poziom3 poziom3;
    static public int ktoryPoziom;
    ListaPoziomow() {

        setSize(1000, 600);
        this.setDoubleBuffered(true);
        setLayout(null);
        /////////
        getImg();
        start1.setBounds(170,360,120,50); start2.setBounds(440,360,120,50);
        start3.setBounds(710,360,120,50);
        color1 = new Color(177,162,202);
        start1.setBackground(color1);
        //start2.setBackground(Color.lightGray); start3.setBackground(Color.lightGray);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        start1.setCursor(cursor); //start2.setCursor(cursor); start3.setCursor(cursor);
        if (poziom2Odblokowany) {
            start2.setBackground(color1);
            start2.setCursor(cursor);
        } else {
            System.out.println("2 NIE odblokowany");
            start2.setBackground(Color.lightGray);
        }
        if (poziom3Odblokowany) {
            start3.setBackground(color1);
            start3.setCursor(cursor);
        } else {
            System.out.println("3 NIE odblokowany");
            start3.setBackground(Color.lightGray);
        }
        this.add(start1); this.add(start2); this.add(start3);

        start1.setVisible(true); start2.setVisible(true); start3.setVisible(true);
        start1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                setVisible(false);
                ktoryPoziom = 1;
                //OknoGry oknogry = new OknoGry();
                poziom1 = new Poziom1();
                Main.okno.add(poziom1);
                poziom1.setVisible(true);
                poziom1.startThread();
            }
        });
        start2.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                setVisible(false);
                ktoryPoziom = 2;
                //OknoGry oknogry = new OknoGry();
                poziom2 = new Poziom2();
                Main.okno.add(poziom2);
                poziom2.setVisible(true);
                poziom2.startThread();
            }
        });
        start3.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                setVisible(false);
                ktoryPoziom = 3;
                //OknoGry oknogry = new OknoGry();
                poziom3 = new Poziom3();
                Main.okno.add(poziom3);
                poziom3.setVisible(true);
                poziom3.startThread();
            }
        });
        color2 = new Color(190,190,190);
        setVisible(true);
    }
    public void getImg () {
        try {

            tlo = ImageIO.read(getClass().getResourceAsStream("/resources/tloWoda.png"));
            poz1 = ImageIO.read(getClass().getResourceAsStream("/resources/poz1.png"));
            poz2 = ImageIO.read(getClass().getResourceAsStream("/resources/poz2.png"));
            poz3 = ImageIO.read(getClass().getResourceAsStream("/resources/poz3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(tlo,0,0,1000,650,null);
        g2.drawImage(poz1,150,140,157,190,null);
        g2.drawImage(poz2,430,140,157,190,null);
        g2.drawImage(poz3,680,140,190,190,null);
        g2.setColor(color1);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        g2.drawRect(155,350,150,70);
        if(poziom2Odblokowany){
            g2.setColor(color1);
        }else {
            g2.setColor(color2);
        }
        g2.drawRect(425, 350, 150, 70);
        if(poziom3Odblokowany){
            g2.setColor(color1);
        }else {
            g2.setColor(color2);
        }
        //g2.setColor(color3);
        g2.drawRect(695,350,150,70);
        //g2.dispose();
    }
}

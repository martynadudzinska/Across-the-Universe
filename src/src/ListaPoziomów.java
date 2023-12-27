import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ListaPoziomów extends JPanel {

    public boolean z1,z2,z3;
    JButton start1 = new JButton("POZIOM 1");
    JButton start2 = new JButton("POZIOM 2");
    JButton start3 = new JButton("POZIOM 3");
    BufferedImage poz1;
    BufferedImage poz2;
    BufferedImage poz3;
    BufferedImage tlo;
    Color color1;
    Color color2;
    Color color3;
    ListaPoziomów (boolean z1, boolean z2, boolean z3) {

        setSize(1000, 600);
        this.setDoubleBuffered(true);
        setLayout(null);
        /////////
        getImg();
        start1.setBounds(170,360,120,50); start2.setBounds(440,360,120,50);
        start3.setBounds(710,360,120,50);
        color1 = new Color(177,162,202);
        start1.setBackground(color1); start2.setBackground(Color.lightGray); start3.setBackground(Color.lightGray);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        start1.setCursor(cursor); //start2.setCursor(cursor); start3.setCursor(cursor);
        this.add(start1); this.add(start2); this.add(start3);
        start1.setVisible(true); start2.setVisible(true); start3.setVisible(true);
        start1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                setVisible(false);
                //OknoGry oknogry = new OknoGry();
                Poziom1 poziom1 = new Poziom1();
                Main.okno.add(poziom1);
                poziom1.setVisible(true);
                poziom1.startThread();
            }
        });
        color2 = new Color(190,190,190);
        color3 = new Color(190,190,190);
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
        g2.drawImage(tlo,0,0,1000,600,null);
        g2.drawImage(poz1,150,140,157,190,null);
        g2.drawImage(poz2,430,140,157,190,null);
        g2.drawImage(poz3,680,140,190,190,null);
        g2.setColor(color1);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        g2.drawRect(155,350,150,70);
        g2.setColor(color2);
        g2.drawRect(425,350,150,70);
        g2.setColor(color3);
        g2.drawRect(695,350,150,70);
        //g2.dispose();
    }
}

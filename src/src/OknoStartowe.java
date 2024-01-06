import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OknoStartowe extends JPanel {

    BufferedImage tlo;

    JButton start = new JButton("S T A R T");
    JButton proba = new JButton("Proba");
    Color color;
    KeyHandler keyHandler = new KeyHandler();

    OknoStartowe () {

        //////////
        setSize(1000, 600);
        this.setDoubleBuffered(true);
        setLayout(null);
        /////////
        getImg();
        color = new Color(177,162,202);
        //repaint();
        start.setBounds(440,360,120,50);
        start.setBackground(color);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        start.setCursor(cursor);
        start.setVisible(true);
        this.add(start);

        this.setFocusable(true);

        start.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                setVisible(false);
                ListaPoziomow.poziom2Odblokowany = true;
                ListaPoziomow.poziom3Odblokowany = true;
                ListaPoziomow listaPoziomow = new ListaPoziomow();
                Main.okno.add(listaPoziomow);
                listaPoziomow.setVisible(true);
            }
        });

        setVisible(true);

    }

    public void getImg () {
        try {

            tlo = ImageIO.read(getClass().getResourceAsStream("/resources/tlo_OknoStartowe.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(tlo,0,0,1000,650,null);
        g2.setColor(color);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        g2.drawRect(425,350,150,70);


    }

}



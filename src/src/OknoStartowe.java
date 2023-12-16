import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OknoStartowe extends JPanel {

    BufferedImage tlo;

    JButton start = new JButton("S T A R T");
    JButton proba = new JButton("Proba");
    Color color;

    OknoStartowe () {

        //////////
        setSize(1000, 600);
        this.setDoubleBuffered(true);
        setLayout(null);
        /////////
        getImg();
        start.setBounds(440,320,120,50);
        color = new Color(177,162,202);
        start.setBackground(color);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        start.setCursor(cursor);

        start.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                setVisible(false);
                ListaPoziomów listaPoziomów = new ListaPoziomów(false,false,false);
                Main.okno.add(listaPoziomów);
                listaPoziomów.setVisible(true);
            }
        });

        this.add(start);
        start.setVisible(true);
        //start.setRolloverEnabled(true);
        //this.setComponentZOrder(start, 0);
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
        g2.drawImage(tlo,0,0,1000,600,null);
        /*GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(start, gbc);*/
        g2.setColor(color);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        g2.drawRect(425,310,150,70);
        g2.dispose();
    }


}



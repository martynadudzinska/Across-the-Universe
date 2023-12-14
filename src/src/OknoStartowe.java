import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OknoStartowe extends JPanel {

    BufferedImage tlo;
    //Icon icon = new ImageIcon("/resources/R.png");
    JButton start = new JButton("S T A R T");
    Color color;

    OknoStartowe () {
        //////////
        setSize(1000, 600);
        setVisible(true);
        this.setDoubleBuffered(true);
        setLayout(null);
        /////////
        getImg();
        add(start);
        start.setBounds(440,320,120,50);
        color = new Color(177,162,202);
        start.setBackground(color);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        start.setCursor(cursor);
        start.addActionListener(new startListener());
    }

    private class startListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame okno2 = new JFrame();
            okno2.setVisible(true);
        }
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
        g2.setColor(color);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        g2.drawRect(425,310,150,70);
        g2.dispose();
    }


}



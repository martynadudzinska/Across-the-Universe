import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ListaPoziomów extends JPanel {

    public boolean z1,z2,z3;
    BufferedImage poziom1Obraz;
    BufferedImage poziom2Obraz;
    BufferedImage poziom3Obraz;
    BufferedImage tlo;
    ListaPoziomów (boolean z1, boolean z2, boolean z3) {
        setSize(1000, 600);
        this.setDoubleBuffered(true);
        setLayout(null);
        /////////
        getImg();
        setVisible(true);
    }
    public void getImg () {
        try {

            tlo = ImageIO.read(getClass().getResourceAsStream("/resources/tloWoda.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(tlo,0,0,1000,600,null);
        g2.dispose();
    }
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Poziom1 extends OknoGry {

    public BufferedImage ananas, lizak, majonez, pizza, zupa;


    Poziom1 () {

        Postac.ktoryPoziom = 1;
        getElementyImg();
    }

    private void getElementyImg() {
        try {

            ananas = ImageIO.read(getClass().getResourceAsStream("/resources/ananas.png"));
            lizak = ImageIO.read(getClass().getResourceAsStream("/resources/lizak.png"));
            majonez = ImageIO.read(getClass().getResourceAsStream("/resources/majonez.png"));
            pizza = ImageIO.read(getClass().getResourceAsStream("/resources/pizza.png"));
            zupa = ImageIO.read(getClass().getResourceAsStream("/resources/zupa.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(ananas,0,350,100,100,null);
        g2.drawImage(lizak,30,50,100,100,null);
        g2.drawImage(majonez,300,200,100,100,null);
        g2.drawImage(pizza,600,300,100,100,null);
        g2.drawImage(zupa,800,100,100,100,null);

    }


}

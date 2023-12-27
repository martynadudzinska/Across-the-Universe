import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Poziom1 extends OknoGry {

    public BufferedImage ananas, lizak, majonez, pizza, zupa;


    Poziom1 () {

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



}

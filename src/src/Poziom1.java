import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Poziom1 extends OknoGry {

    public BufferedImage ananas, lizak, majonez, pizza, zupa;
    public static boolean ananasWidoczny, lizakWidoczny, majonezWidoczny, pizzaWidoczna, zupaWidoczna;

    Poziom1 () {

        Postac.ktoryPoziom = 1;
        getElementyImg();
        ananasWidoczny=true; lizakWidoczny = true; majonezWidoczny = true; pizzaWidoczna=true; zupaWidoczna=true;
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
        if(ananasWidoczny) g2.drawImage(ananas,0,360,100,100,null);
        if(lizakWidoczny) g2.drawImage(lizak,30,80,70,70,null);
        if(majonezWidoczny) g2.drawImage(majonez,330,210,100,100,null);
        if (pizzaWidoczna)g2.drawImage(pizza,660,310,100,100,null);
        if(zupaWidoczna) g2.drawImage(zupa,800,110,100,100,null);

    }


}

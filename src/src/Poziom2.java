import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Poziom2 extends OknoGry {

    public BufferedImage slimak, meduza, konikMorski, malpa, papuga;
    public static boolean slimakWidoczny, meduzaWidoczna, konikMorskiWidoczny, malpaWidoczna, papugaWidoczna;

    Poziom2 () {

        ktoryPoziom = 2;
        getElementyImg();
        slimakWidoczny=true; meduzaWidoczna = true; konikMorskiWidoczny = true; malpaWidoczna=true; papugaWidoczna=true;
    }

    private void getElementyImg() {
        try {

            slimak = ImageIO.read(getClass().getResourceAsStream("/resources/slimak.png"));
            meduza = ImageIO.read(getClass().getResourceAsStream("/resources/meduza.png"));
            konikMorski = ImageIO.read(getClass().getResourceAsStream("/resources/konik.png"));
            malpa = ImageIO.read(getClass().getResourceAsStream("/resources/malpa.png"));
            papuga = ImageIO.read(getClass().getResourceAsStream("/resources/papuga.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(slimakWidoczny) g2.drawImage(slimak,350,110,80,80,null);
        if(meduzaWidoczna) g2.drawImage(meduza,400,376,80,80,null);
        if(konikMorskiWidoczny) g2.drawImage(konikMorski,60,216,90,90,null);
        if (malpaWidoczna)g2.drawImage(malpa,850,295,110,110,null);
        if(papugaWidoczna) g2.drawImage(papuga,680,180,100,100,null);

    }


}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Postac {

    int x=100;
    int y=100;
    int przesuniecie=4;
    public BufferedImage postacImg;
    OknoGry oknoGry;
    KeyHandler keyHandler;

    public Postac (OknoGry oknoGry, KeyHandler keyHandler) {
        this.oknoGry=oknoGry;
        this.keyHandler = keyHandler;

        getPostacImg();
    }

    public void getPostacImg () {
        try {

            postacImg = ImageIO.read(getClass().getResourceAsStream("/resources/spongebob.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if (keyHandler.wLewo==true) {
            x -= przesuniecie;

        } else if (keyHandler.wPrawo==true) {
            x += przesuniecie;
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        image = postacImg;
        g2.drawImage(image,x,y, 100, 100,null);
    }

}

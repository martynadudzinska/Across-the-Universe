import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Poziom3 extends OknoGry {

    public BufferedImage banknot, gitara, okulary, olowek, prezent;
    public static boolean banknotWidoczny, gitaraWidoczna, okularyWidoczne, olowekWidoczny, prezentWidocznu;

    Poziom3 () {

        ktoryPoziom = 3;
        getElementyImg();
        banknotWidoczny=true; gitaraWidoczna = true; okularyWidoczne = true; olowekWidoczny=true; prezentWidocznu=true;
    }

    private void getElementyImg() {
        try {

            banknot = ImageIO.read(getClass().getResourceAsStream("/resources/banknot.png"));
            gitara = ImageIO.read(getClass().getResourceAsStream("/resources/gitara.png"));
            olowek = ImageIO.read(getClass().getResourceAsStream("/resources/olowek.png"));
            okulary = ImageIO.read(getClass().getResourceAsStream("/resources/okulary.png"));
            prezent = ImageIO.read(getClass().getResourceAsStream("/resources/prezent.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(banknotWidoczny) g2.drawImage(banknot,550,85,90,90,null);
        if(prezentWidocznu) g2.drawImage(prezent,30,115,90,90,null);
        if(olowekWidoczny) g2.drawImage(olowek,300,240,80,80,null);
        if (okularyWidoczne)g2.drawImage(okulary,685,375,80,80,null);
        if(gitaraWidoczna) g2.drawImage(gitara,850,220,90,90,null);

    }


}

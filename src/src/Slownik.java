import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Slownik extends JPanel {

    Color color, color2;
    Cursor cursor;
    int ktoryPoziom;
    JButton button;
    static public boolean powrotDoGry;
    BufferedImage flowerPink ,logoSlownik;
    JLabel slownik;


    Slownik (int ktoryPoziom) {

        getImg();
        powrotDoGry = false;
        setSize(1000, 600);
        this.setDoubleBuffered(true);
        this.ktoryPoziom = ktoryPoziom;
        //setPreferredSize(new Dimension(300,400));
        color = new Color(177,162,202);
        color2 = new Color(136,77,255);
        this.setBackground(color);
        setBackground(color);
        this.setPreferredSize(new Dimension(300,400));
        this.setDoubleBuffered(true);
        button = new JButton("P O W R Ó T");
        button.setBounds(440,450,120,50);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        button.setCursor(cursor);
        button.setBackground(color);
        button.setVisible(true);
        button.setFocusable(true);
        button.requestFocus();
        add(button);
        button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                System.out.println("POWROT DO GRYYYY");
                powrotDoGry = true;
                OknoGry.slownikWlaczony = false;
                if(Postac.ktoryPoziom==1) ListaPoziomow.poziom1.setVisible(true);
                else if (Postac.ktoryPoziom ==2) ListaPoziomow.poziom2.setVisible(true);
                else if (Postac.ktoryPoziom ==3) ListaPoziomow.poziom3.setVisible(true);
                System.out.println("P");
                button.setVisible(false);
                //button.setFocusable(false);

            }
        });
        setLayout(null);
        setVisible(true);

        JLabel ananas =  new JLabel("ananas      -       pineapple");
        JLabel majonez = new JLabel("majonez    -       mayonnaise");
        JLabel lizak =   new JLabel("lizak            -        lollipop");
        JLabel pizza =   new JLabel("pizza           -         pizza");
        JLabel zupa =    new JLabel("zupa           -          soup");

        JLabel slimak =  new JLabel("ślimak      -       snail");
        JLabel meduza = new JLabel("meduza    -       jellyfish");
        JLabel papuga =   new JLabel("papuga     -        parrot");
        JLabel konikMorski =   new JLabel("konik morski   -   seahorse");
        JLabel malpa =    new JLabel("małpa         -          monkey");

        JLabel banknot =  new JLabel("pieniądze      -       money");
        JLabel olowek = new JLabel("ołówek    -       pencil");
        JLabel okulary =   new JLabel("okulary     -        glasses");
        JLabel prezent =   new JLabel("prezent   -   gift");
        JLabel gitara =    new JLabel("gitara         -          guitar");

        slownik =    new JLabel("S Ł O W N I K");
        slownik.setFont(new Font("Helvetica", Font.BOLD, 45));
        slownik.setBounds(355, 50, 300, 100);
        add(slownik);

        if (this.ktoryPoziom ==1) {
            ananas.setFont(new Font("Helvetica", Font.BOLD, 15));
            ananas.setBounds(400, 230, 250, 20);
            add(ananas);

            majonez.setFont(new Font("Helvetica", Font.BOLD, 15));
            majonez.setBounds(400, 260, 250, 20);
            add(majonez);

            lizak.setFont(new Font("Helvetica", Font.BOLD, 15));
            lizak.setBounds(400, 290, 250, 20);
            add(lizak);

            pizza.setFont(new Font("Helvetica", Font.BOLD, 15));
            pizza.setBounds(400, 320, 250, 20);
            add(pizza);

            zupa.setFont(new Font("Helvetica", Font.BOLD, 15));
            zupa.setBounds(400, 350, 250, 20);
            add(zupa);

        }
        else if (this.ktoryPoziom ==2) {
            slimak.setFont(new Font("Helvetica", Font.BOLD, 15));
            slimak.setBounds(400, 230, 250, 20);
            add(slimak);

            meduza.setFont(new Font("Helvetica", Font.BOLD, 15));
            meduza.setBounds(400, 260, 250, 20);
            add(meduza);

            papuga.setFont(new Font("Helvetica", Font.BOLD, 15));
            papuga.setBounds(400, 290, 250, 20);
            add(papuga);

            konikMorski.setFont(new Font("Helvetica", Font.BOLD, 15));
            konikMorski.setBounds(400, 320, 250, 20);
            add(konikMorski);

            malpa.setFont(new Font("Helvetica", Font.BOLD, 15));
            malpa.setBounds(400, 350, 250, 20);
            add(malpa);
        }
        else if (this.ktoryPoziom ==3) {
            gitara.setFont(new Font("Helvetica", Font.BOLD, 15));
            gitara.setBounds(400, 230, 250, 20);
            add(gitara);

            banknot.setFont(new Font("Helvetica", Font.BOLD, 15));
            banknot.setBounds(400, 260, 250, 20);
            add(banknot);

            okulary.setFont(new Font("Helvetica", Font.BOLD, 15));
            okulary.setBounds(400, 290, 250, 20);
            add(okulary);

            olowek.setFont(new Font("Helvetica", Font.BOLD, 15));
            olowek.setBounds(400, 320, 250, 20);
            add(olowek);

            prezent.setFont(new Font("Helvetica", Font.BOLD, 15));
            prezent.setBounds(400, 350, 250, 20);
            add(prezent);
        }
    }
    public void getImg () {
        try {

            flowerPink = ImageIO.read(getClass().getResourceAsStream("/resources/flowerPink.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(flowerPink,50,100,200,180,null);
        //g2.drawImage(logoSlownik,320,0,360,195,null); //jednak chyba Label zamiast tego
        g2.setColor(color2);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        g2.drawRect(350, 200,300,200);
        g2.drawRect(425,440,150,70);
    }

}

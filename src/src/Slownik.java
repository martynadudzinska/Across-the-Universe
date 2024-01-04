import javax.swing.*;
import java.awt.*;

public class Slownik extends JPanel {

    Color color, color2;
    int ktoryPoziom;
    JButton button;
    static public boolean powrotDoGry;
    Slownik (int ktoryPoziom) {
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
        JLabel powrot =  new JLabel("Jeśli chcesz powrócić do gry kliknij 'P' ");
        powrot.setFont(new Font("Helvetica", Font.BOLD, 15));
        powrot.setBounds(350, 360, 400, 20);
        add(powrot);

        setLayout(null);
        setVisible(true);



        JLabel ananas =  new JLabel("ananas     -"); JLabel pineapple = new JLabel("pineapple");
        JLabel majonez = new JLabel("majonez    -"); JLabel mayonnaise = new JLabel("mayonnaise");
        JLabel lizak =   new JLabel("lizak           -"); JLabel lollipop = new JLabel("lollipop");
        JLabel pizza =   new JLabel("pizza          -"); JLabel pizza1 = new JLabel("pizza");
        JLabel zupa =    new JLabel("zupa          -"); JLabel soup = new JLabel("soup");



        if (this.ktoryPoziom ==1) {
            ananas.setFont(new Font("Helvetica", Font.BOLD, 15));
            ananas.setBounds(380, 70, 80, 20);
            add(ananas);
            pineapple.setFont(new Font("Helvetica", Font.BOLD, 15));
            pineapple.setBounds(500, 70, 80, 20);
            add(pineapple);

            majonez.setFont(new Font("Helvetica", Font.BOLD, 15));
            majonez.setBounds(350, 100, 100, 20);
            add(majonez);
            mayonnaise.setFont(new Font("Helvetica", Font.BOLD, 15));
            mayonnaise.setBounds(470, 100, 100, 20);
            add(mayonnaise);

            lizak.setFont(new Font("Helvetica", Font.BOLD, 15));
            lizak.setBounds(350, 130, 100, 20);
            add(lizak);
            lollipop.setFont(new Font("Helvetica", Font.BOLD, 15));
            lollipop.setBounds(470, 130, 100, 20);
            add(lollipop);

            pizza.setFont(new Font("Helvetica", Font.BOLD, 15));
            pizza.setBounds(350, 160, 100, 20);
            add(pizza);
            pizza1.setFont(new Font("Helvetica", Font.BOLD, 15));
            pizza1.setBounds(470, 160, 100, 20);
            add(pizza1);

            zupa.setFont(new Font("Helvetica", Font.BOLD, 15));
            zupa.setBounds(350, 190, 100, 20);
            add(zupa);
            soup.setFont(new Font("Helvetica", Font.BOLD, 15));
            soup.setBounds(470, 190, 100, 20);
            add(soup);
        }
    }
    public void update () {
        if(powrotDoGry) {
            if (this.isVisible()) {
                System.out.println("POWROT DO GRYYYY");
                OknoGry.slownikWybrany = false;
                setVisible(false);
                ListaPoziomów.poziom1.setVisible(true);
                Main.okno.focus();
                setFocusable(false);

            }
        }
    }

    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(color2);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        g2.drawRect(340, 70,300,200);
        //g2.dispose();

    }

}

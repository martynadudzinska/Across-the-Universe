import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Slownik extends JPanel {

    Color color, color2;
    Cursor cursor;
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

        button = new JButton("P O W R O T");
        button.setBounds(440,360,120,50);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        button.setCursor(cursor);
        button.setBackground(color2);
        button.setVisible(true);
        button.setFocusable(true);
        button.requestFocus();
        add(button);
        button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                System.out.println("POWROT DO GRYYYY");
                powrotDoGry = true;
                OknoGry.slownikWlaczony = false;
                ListaPoziomów.poziom1.setVisible(true);
                System.out.println("P");
                button.setVisible(false);
                //button.setFocusable(false);

            }
        });
        setLayout(null);
        setVisible(true);

        JLabel ananas =  new JLabel("ananas     -       pineapple"); //JLabel pineapple = new JLabel("pineapple");
        JLabel majonez = new JLabel("majonez    -       mayonnaise"); //JLabel mayonnaise = new JLabel("mayonnaise");
        JLabel lizak =   new JLabel("lizak           -        lollipop"); //JLabel lollipop = new JLabel("lollipop");
        JLabel pizza =   new JLabel("pizza          -         pizza"); //JLabel pizza1 = new JLabel("pizza");
        JLabel zupa =    new JLabel("zupa          -          soup"); //JLabel soup = new JLabel("soup");

        if (this.ktoryPoziom ==1) {
            ananas.setFont(new Font("Helvetica", Font.BOLD, 15));
            ananas.setBounds(400, 100, 250, 20);
            add(ananas);

            majonez.setFont(new Font("Helvetica", Font.BOLD, 15));
            majonez.setBounds(400, 130, 250, 20);
            add(majonez);

            lizak.setFont(new Font("Helvetica", Font.BOLD, 15));
            lizak.setBounds(400, 160, 250, 20);
            add(lizak);

            pizza.setFont(new Font("Helvetica", Font.BOLD, 15));
            pizza.setBounds(400, 190, 250, 20);
            add(pizza);

            zupa.setFont(new Font("Helvetica", Font.BOLD, 15));
            zupa.setBounds(400, 220, 250, 20);
            add(zupa);

        }
    }

    public void paintComponent(Graphics  g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color2);
        BasicStroke grubaLinia = new BasicStroke(4.0f);
        g2.setStroke(grubaLinia);
        g2.drawRect(340, 70,300,200);
        g2.drawRect(425,350,150,70);
    }

}

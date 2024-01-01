import javax.swing.*;
import java.awt.*;

public class Slownik extends JFrame {

    Color color;
    int ktoryPoziom;
    boolean widoczny;
    Slownik (int ktoryPoziom) {
        this.ktoryPoziom = ktoryPoziom;
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,400));
        color = new Color(177,162,202);
        this.setBackground(color);
        panel.setBackground(color);
        add(panel);
        ktoryPoziom = this.ktoryPoziom;
        this.setPreferredSize(new Dimension(300,400));
        setLocation(500,200);
        setResizable(false);
        panel.setLayout(null);
        setVisible(true);
        pack();
        widoczny = this.isVisible();


        JLabel ananas =  new JLabel("ananas     -"); JLabel pineapple = new JLabel("pineapple");
        JLabel majonez = new JLabel("majonez    -"); JLabel mayonnaise = new JLabel("mayonnaise");
        JLabel lizak =   new JLabel("lizak           -"); JLabel lollipop = new JLabel("lollipop");
        JLabel pizza =   new JLabel("pizza          -"); JLabel pizza1 = new JLabel("pizza");
        JLabel zupa =    new JLabel("zupa          -"); JLabel soup = new JLabel("soup");



        if (ktoryPoziom ==1) {
            ananas.setFont(new Font("Helvetica", Font.BOLD, 15));
            ananas.setBounds(40, 70, 80, 20);
            panel.add(ananas);
            pineapple.setFont(new Font("Helvetica", Font.BOLD, 15));
            pineapple.setBounds(160, 70, 80, 20);
            panel.add(pineapple);

            majonez.setFont(new Font("Helvetica", Font.BOLD, 15));
            majonez.setBounds(40, 100, 100, 20);
            panel.add(majonez);
            mayonnaise.setFont(new Font("Helvetica", Font.BOLD, 15));
            mayonnaise.setBounds(160, 100, 100, 20);
            panel.add(mayonnaise);

            lizak.setFont(new Font("Helvetica", Font.BOLD, 15));
            lizak.setBounds(40, 130, 100, 20);
            panel.add(lizak);
            lollipop.setFont(new Font("Helvetica", Font.BOLD, 15));
            lollipop.setBounds(160, 130, 100, 20);
            panel.add(lollipop);

            pizza.setFont(new Font("Helvetica", Font.BOLD, 15));
            pizza.setBounds(40, 160, 100, 20);
            panel.add(pizza);
            pizza1.setFont(new Font("Helvetica", Font.BOLD, 15));
            pizza1.setBounds(160, 160, 100, 20);
            panel.add(pizza1);

            zupa.setFont(new Font("Helvetica", Font.BOLD, 15));
            zupa.setBounds(40, 190, 100, 20);
            panel.add(zupa);
            soup.setFont(new Font("Helvetica", Font.BOLD, 15));
            soup.setBounds(160, 190, 100, 20);
            panel.add(soup);
        }
    }


}

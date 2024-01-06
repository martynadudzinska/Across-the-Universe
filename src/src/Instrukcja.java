
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Instrukcja extends JPanel {
    Color color, color2;
    Cursor cursor;
    int ty = 160;
    JButton button;
    static public boolean powrotDoMenu;
    BufferedImage flowerPink ,logoSlownik;
    JLabel slownik;

    Instrukcja () {

        getImg();
        powrotDoMenu = false;
        setSize(1000, 600);
        this.setDoubleBuffered(true);

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
               // System.out.println("POWROT DO MENU");
                powrotDoMenu = true;
                Menu.instrukcjaWlaczona = false; //
                OknoGry.menu.setVisible(true);
                button.setVisible(false);
                //button.setFocusable(false);

            }
        });
        setLayout(null);
        setVisible(true);

        JLabel t1 =  new JLabel("Postacią należy poruszać klawiszami 'W' , 'A' , 'D'. Podczas");
        JLabel t2 = new JLabel("wchodzenia na elementy pojawia się okno tekstowe. Gracz musi");
        JLabel t3 =   new JLabel("wpisać w nim poprawną nazwę angielską aktualnie wybranego");
        JLabel t4 =   new JLabel("elementu i zatwierdzić. Gdy gracz zbierze wszystkie elementy,");
        JLabel t5 =    new JLabel("pojawi się portal prowadzący do następnego poziomu. W");
        JLabel t6 =   new JLabel("przypadku błędnego wpisania, zawsze istnieje możliwość");
        JLabel t7 =    new JLabel("ponowienia próby. Pomocą w trakcie gry służy słownik ");
        JLabel t8 =    new JLabel("zamieszczony w lewym górnym rogu. ");
        slownik =    new JLabel("I N S T R U K C J A");
        slownik.setFont(new Font("Helvetica", Font.BOLD, 45));
        slownik.setBounds(300, 50, 500, 100);
        t1.setFont(new Font("Helvetica", Font.BOLD, 15));
        t1.setBounds(265, ty, 480, 20);
        t2.setFont(new Font("Helvetica", Font.BOLD, 15));
        t2.setBounds(265, ty+30, 480, 20);
        t3.setFont(new Font("Helvetica", Font.BOLD, 15));
        t3.setBounds(265, ty+60, 480, 20);
        t4.setFont(new Font("Helvetica", Font.BOLD, 15));
        t4.setBounds(265, ty+90, 480, 20);
        t5.setFont(new Font("Helvetica", Font.BOLD, 15));
        t5.setBounds(265, ty+120, 480, 20);
        t6.setFont(new Font("Helvetica", Font.BOLD, 15));
        t6.setBounds(265, ty+150, 480, 20);
        t7.setFont(new Font("Helvetica", Font.BOLD, 15));
        t7.setBounds(265, ty+180, 480, 20);
        t8.setFont(new Font("Helvetica", Font.BOLD, 15));
        t8.setBounds(265, ty+210, 480, 20);
        add(slownik); add(t1); add(t2); add(t3); add(t4); add(t5);add(t6); add(t7); add(t8);


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
        g2.drawRect(250, 150,500,250);
        g2.drawRect(425,440,150,70);
    }

}

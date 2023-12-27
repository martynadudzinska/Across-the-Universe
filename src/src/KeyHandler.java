import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean wLewo, wPrawo;
    @Override
    public void keyTyped(KeyEvent e) { //nieuzywana
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int klawisz = e.getKeyCode();
        if (klawisz == KeyEvent.VK_A) {
            wLewo = true;

        }
        if (klawisz == KeyEvent.VK_D) {
            wPrawo = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int klawisz = e.getKeyCode();
        if (klawisz == KeyEvent.VK_A) {
            wLewo = false;
            System.out.println("AAAA");
        }
        if (klawisz == KeyEvent.VK_D) {
            wPrawo = false;
            System.out.println("DDDD");

        }
    }
}

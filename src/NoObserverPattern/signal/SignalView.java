package NoObserverPattern.signal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Niklas on 2016-02-23.
 */
public class SignalView extends JFrame {
    private final Color redOff = new Color(96,0,0);
    private final Color redOn = new Color(255,0,0);
    private final Color greenOff = new Color(0,96,0);
    private final Color greenOn = Color.GREEN;
    private final Color yellowOff = new Color(128,128,0);
    private final Color yellowOn = Color.YELLOW;

    private boolean redIsOn = true;
    private boolean yellowIsOn = false;
    private boolean greenIsOn = false;

    public SignalView() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(50, 50, 90, 350);

        JPanel panel = new SignalPanel();
        setBackground(Color.DARK_GRAY);
        add(panel);
        //pack();
        setVisible(true);
    }

    public void actOnSignalChange(SignalStatus newStatus) {
        switch (newStatus) {
            case RED -> makeRed();
            case TOGREEN -> makeRedYellow();
            case GREEN -> makeGreen();
            case TORED -> makeYellow();
        }
        repaint();
    }
    private void makeRed(){
        redIsOn = true;
        yellowIsOn = false;
        greenIsOn = false;
    }
    private void makeRedYellow(){
        redIsOn = true;
        yellowIsOn = true;
        greenIsOn = false;
    }
    private void makeGreen(){
        redIsOn = false;
        yellowIsOn = false;
        greenIsOn = true;
    }
    private void makeYellow(){
        redIsOn = false;
        yellowIsOn = true;
        greenIsOn = false;
    }

    private class SignalPanel extends JPanel {

        public void paintComponent(Graphics g) {
            drawCircle(g, redIsOn ? redOn : redOff, 0);
            drawCircle(g, yellowIsOn ? yellowOn : yellowOff, 100);
            drawCircle(g, greenIsOn ? greenOn : greenOff, 200);
        }

        private void drawCircle(Graphics g, Color color, int offset) {
            g.setColor(color);
            g.fillOval(20, 20+offset, 80, 80);
            g.setColor(Color.BLACK);
            g.drawOval(20, 20+offset, 80, 80);
        }
    }
}

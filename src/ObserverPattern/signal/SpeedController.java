package ObserverPattern.signal;

import ObserverPattern.signal.model.Signal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Niklas on 2016-02-23.
 */
public class SpeedController extends JFrame
        implements ActionListener {
    private final Signal signal;

    public SpeedController(Signal signal){
        this.signal = signal;

        JPanel panel = new JPanel();
        initFrame();
        initButtons(panel);
        this.add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(50, 400, 90, 50);
        pack();
        setVisible(true);
    }

    private void initButtons(JPanel panel) {
        JButton increase = mkButton("++");
        JButton decrease = mkButton("--");
        panel.add(increase);
        panel.add(decrease);
    }

    private JButton mkButton(String actionCommand) {
        JButton button = new JButton(actionCommand);
        button.setActionCommand(actionCommand);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("++")) {
            signal.speedUp();
        } else {
            signal.slowDown();
        }
    }
}

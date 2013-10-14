package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel {

    public final JButton calculateButton;
    public final JButton bettingButton;
    public final JButton quitButton;

    public BottomPanel() {

        calculateButton = new JButton();
        calculateButton.setText("Calculate");

        bettingButton = new JButton();
        bettingButton.setText("Betting");

        quitButton = new JButton();
        quitButton.setText("Quit");

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               System.exit(0);
            }
        });

        add(calculateButton);
        add(bettingButton);
        add(quitButton);
    }

}

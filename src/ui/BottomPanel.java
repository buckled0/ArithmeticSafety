package ui;

import javax.swing.*;

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

        add(calculateButton);
        add(bettingButton);
        add(quitButton);
    }

}

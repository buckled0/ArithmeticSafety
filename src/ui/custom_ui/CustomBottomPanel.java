package ui.custom_ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CustomBottomPanel extends JPanel {

    public final JButton closeButton;

    public CustomBottomPanel() {

        closeButton = new JButton();
        closeButton.setText("Close");

        add(closeButton);
    }

    public void onCloseButton(ActionListener listener){
        closeButton.addActionListener(listener);
    }

}
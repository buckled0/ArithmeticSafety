package ui.custom_ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomLeagueWindow extends JFrame {
    public static final String TITLE = "Arithmetic Football";
    public static final Dimension INITIAL_SIZE = new Dimension(900, 600);
    public static final Point INITIAL_LOCATION = new Point(200, 50);
    public CustomLeagueTable customLeagueTable;

    public CustomLeagueWindow(){
        setTitle(TITLE);
        setSize(INITIAL_SIZE);
        setResizable(false);
        setLocation(INITIAL_LOCATION);

        getContentPane().add(BorderLayout.SOUTH, setupCustomBottomPanel());
        getContentPane().add(BorderLayout.NORTH, setupCustomTopPanel());
        getContentPane().add(BorderLayout.CENTER, customLeagueTable = new CustomLeagueTable());

        setVisible(true);
    }

    private CustomBottomPanel setupCustomBottomPanel(){
        final CustomBottomPanel customBottomPanel = new CustomBottomPanel();

        customBottomPanel.onCloseButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);         }
        });

        return customBottomPanel;
    }

    private CustomTopPanel setupCustomTopPanel(){
        final CustomTopPanel customTopPanel = new CustomTopPanel();

        customTopPanel.onCalculateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        return customTopPanel;
    }

}
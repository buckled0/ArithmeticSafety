package ui;

import javax.swing.*;
import java.awt.*;

public class LeagueWindow extends JFrame {
    public static final String TITLE = "The League";
    public static final Dimension INITIAL_SIZE = new Dimension(1000, 711);
    public static final Point INITIAL_LOCATION = new Point(150, 22);

    public LeagueWindow(){
        setTitle(TITLE);
        setSize(INITIAL_SIZE);
        setResizable(false);
        setLocation(INITIAL_LOCATION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().add(BorderLayout.CENTER, new JTable());
        getContentPane().add(BorderLayout.SOUTH, new JPanel());
    }
}

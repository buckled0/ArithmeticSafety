package ui;

import javax.swing.*;

public class TopPanel extends JPanel{

    public final JComboBox leagueMenu;
    public final JButton goButton;
    public final String[] leagues;

    public TopPanel() {
        leagues = new String[] {"Please Select a League", "Premier League", "La Liga", "Serie A", "Bundesliga",
                                  "Ligue 1", "Eredivisie"};
        leagueMenu = new JComboBox(leagues);

        goButton = new JButton();
        goButton.setText("Go");

        add(leagueMenu);
        add(goButton);
    }

    public String[] getStringArray() {
        return leagues;
    }
}

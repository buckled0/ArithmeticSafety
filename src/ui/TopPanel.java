package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel{

    public final JComboBox leagueMenu;
    public final JButton goButton;
    public final JButton clearButton;
    public final String[] leagues;
    public String leagueValue;
    public String selectedValue;

    public TopPanel() {
        leagues = new String[] {"Please Select a LeagueVerdict", "Premier LeagueVerdict", "La Liga", "Serie A", "Bundesliga",
                                  "Ligue 1", "Eredivisie"};
        leagueMenu = new JComboBox(leagues);

        goButton = new JButton();
        goButton.setText("Go");

        clearButton = new JButton();
        clearButton.setText("Clear");

        onGo();

        add(leagueMenu);
        add(goButton);
        add(clearButton);
    }

    public void onGo() {
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leagueValue = String.valueOf(leagueMenu.getSelectedItem());
                selectedValue = leagueValue;
            }
        });
    }

    public String[] getStringArray() {
        return leagues;
    }

    public String getLeagueValue(){
        return leagueValue;
    }
}

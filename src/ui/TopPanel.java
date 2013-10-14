package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel{

    public final JComboBox leagueMenu;
    public final JButton goButton;
    public final JButton clearButton;
    public final String[] leagues;
    public final Integer[] roundAmount;
    public final JComboBox roundMenu;
    public String leagueValue;
    public String selectedValue;

    public TopPanel() {
        leagues = new String[] {"Please Select a League", "Premier League", "La Liga", "Serie A", "Bundesliga",
                                  "Ligue 1", "Eredivisie"};
        leagueMenu = new JComboBox(leagues);


        roundAmount = new Integer[39];
        for(int i = 1; i < roundAmount.length; i++)
            roundAmount[i] = i;

        roundMenu = new JComboBox(roundAmount);

        goButton = new JButton();
        goButton.setText("Go");

        clearButton = new JButton();
        clearButton.setText("Clear");

        onGo();

        add(leagueMenu);
        add(roundMenu);
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

    public Integer[] getIntArray() {
        return roundAmount;
    }

    public String getLeagueValue(){
        return leagueValue;
    }
}

package ui.betting_ui;

import domain.LeagueVerdict;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BettingTeamSelection extends JPanel {
    public JComboBox team1;
    public JComboBox team2;
    public JButton calculateOddsButton;
    private String newValueTeam1;
    private String newValueTeam2;

    public BettingTeamSelection(){
        LeagueVerdict leagueVerdict = new LeagueVerdict("Premier League Current");

        String[] team1List = new String[21];
        String[] team2List = new String[21];

        team1List[0] = "Please select Home Team";
        team2List[0] = "Please select Away Team";

        for(int i = 1; i < 21; i++){
            team1List[i] = leagueVerdict.getTeamList().get(i-1).getName();
            team2List[i] = leagueVerdict.getTeamList().get(i-1).getName();
        }

        team1 = new JComboBox(team1List);

        team1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    setTeam1Value(itemEvent.getItem().toString());
                }
            }
        });

        team2 = new JComboBox(team2List);

        team2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    setTeam2Value(itemEvent.getItem().toString());
                }
            }
        });

        calculateOddsButton = new JButton("Calculate Odds");

        add(team1);
        add(team2);
        add(calculateOddsButton);
    }

    public void onCalculateOddsButton(ActionListener listener){
        calculateOddsButton.addActionListener(listener);
    }

    private void setTeam1Value(String selectedTeam1){ this.newValueTeam1 = selectedTeam1; }

    public String getTeam1Selection() { return newValueTeam1; }

    private void setTeam2Value(String selectedTeam2){ this.newValueTeam2 = selectedTeam2; }

    public String getTeam2Selection() { return newValueTeam2; }
}

package ui.betting_ui;

import domain.TeamVerdict;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BettingTeamSelection extends JPanel {
    public JComboBox homeTeam;
    public JComboBox awayTeam;
    public JButton calculateOddsButton;
    public JTextField homeTeamOdds;
    public JTextField drawingOdds;
    public JTextField awayTeamOdds;
    public JTextField homeOddsValue;
    public JTextField drawingOddsValue;
    public JTextField awayOddsValue;
    private String newHomeTeamValue;
    private String newAwayTeamValue;
    public double homeOdds;
    public double drawOdds;
    public double awayOdds;

    public BettingTeamSelection(){
        TeamVerdict leagueVerdict = new TeamVerdict("Premier League Current");

        String[] team1List = new String[21];
        String[] team2List = new String[21];

        team1List[0] = "Please select Home Team";
        team2List[0] = "Please select Away Team";

        for(int i = 1; i < 21; i++){
            team1List[i] = leagueVerdict.getTeamList().get(i-1).getName();
            team2List[i] = leagueVerdict.getTeamList().get(i-1).getName();
        }

        homeTeam = new JComboBox(team1List);

        homeTeam.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    setHomeTeamValue(itemEvent.getItem().toString());
                }
            }
        });

        awayTeam = new JComboBox(team2List);

        awayTeam.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    setTeam2Value(itemEvent.getItem().toString());
                }
            }
        });

        calculateOddsButton = new JButton("Calculate Odds");

        Box teamSelectionBox = Box.createVerticalBox();

        teamSelectionBox.add(homeTeam);
        teamSelectionBox.add(awayTeam);
        teamSelectionBox.add(calculateOddsButton);

        homeTeamOdds = new JTextField("Home Team Odds: ");
        drawingOdds = new JTextField("Drawing Odds: ");
        awayTeamOdds = new JTextField("Away Team Odds: ");

        homeTeamOdds.setEditable(false);
        drawingOdds.setEditable(false);
        awayTeamOdds.setEditable(false);

        Box textFieldBox = Box.createVerticalBox();

        textFieldBox.add(homeTeamOdds);
        textFieldBox.add(drawingOdds);
        textFieldBox.add(awayTeamOdds);

        homeOddsValue = new JTextField("0.00");
        drawingOddsValue = new JTextField("0.00");
        awayOddsValue = new JTextField("0.00");

        Box teamOddsValueBox = Box.createVerticalBox();

        teamOddsValueBox.add(homeOddsValue);
        teamOddsValueBox.add(drawingOddsValue);
        teamOddsValueBox.add(awayOddsValue);

        add(teamSelectionBox);
        add(textFieldBox);
        add(teamOddsValueBox);
    }

    public void onCalculateOddsButton(ActionListener listener){
        calculateOddsButton.addActionListener(listener);
    }

    public void setHomeOdds(double homeOdds){
        this.homeOdds = homeOdds;
        homeOddsValue.setText(String.valueOf(homeOdds));
    }

    public double getHomeOdds(){
        return homeOdds;
    }

    public void setDrawOdds(double drawOdds){
        this.drawOdds = drawOdds;
        drawingOddsValue.setText(String.valueOf(drawOdds));
    }

    public double getDrawOdds(){
        return drawOdds;
    }

    public void setAwayOdds(double awayOdds){
        this.awayOdds = awayOdds;
        awayOddsValue.setText(String.valueOf(awayOdds));
    }

    public double getAwayOdds(){
        return awayOdds;
    }

    private void setHomeTeamValue(String selectedTeam1){ this.newHomeTeamValue = selectedTeam1; }

    public String getHomeTeamValue() { return newHomeTeamValue; }

    private void setTeam2Value(String selectedTeam2){ this.newAwayTeamValue = selectedTeam2; }

    public String getAwayTeamValue() { return newAwayTeamValue; }
}

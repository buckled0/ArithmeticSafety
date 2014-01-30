package ui.betting_ui;

import javax.swing.*;

public class BettingEastPanel extends JPanel {
    public JTextField team1Odds;
    public JTextField drawingOdds;
    public JTextField team2Odds;

    public BettingEastPanel(){
        team1Odds = new JTextField("Team 1 Odds:");
        drawingOdds = new JTextField("Drawing Odds:");
        team2Odds = new JTextField("Team 2 Odds:");

        team1Odds.setEditable(false);
        drawingOdds.setEditable(false);
        team2Odds.setEditable(false);

        Box textFieldBox = Box.createVerticalBox();

        textFieldBox.add(team1Odds);
        textFieldBox.add(drawingOdds);
        textFieldBox.add(team2Odds);

        add(textFieldBox);
    }
}

package ui.betting_ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BettingWindow extends JFrame {
    public static final String TITLE = "Odds On Betting";
    public static final Dimension INITIAL_SIZE = new Dimension(700, 200);
    public static final Point INITIAL_LOCATION = new Point(260, 132);

    public BettingWindow(){
        setTitle(TITLE);
        setSize(INITIAL_SIZE);
        setResizable(false);
        setLocation(INITIAL_LOCATION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().add(BorderLayout.CENTER, setupTeamSelection());
        getContentPane().add(BorderLayout.NORTH, new BettingNorthPanel());
        getContentPane().add(BorderLayout.SOUTH, setupBettingBottomPanel());
        getContentPane().add(BorderLayout.EAST, new BettingEastPanel());

        setVisible(true);
    }

    private BettingTeamSelection setupTeamSelection(){
        final BettingTeamSelection bettingTeamSelection = new BettingTeamSelection();

        bettingTeamSelection.onCalculateOddsButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String team1 = bettingTeamSelection.getTeam1Selection();
                String team2 = bettingTeamSelection.getTeam2Selection();
                System.out.println(team1 + " " + team2);
            }
        });

        return bettingTeamSelection;
    }

    private BettingSouthPanel setupBettingBottomPanel(){
        BettingSouthPanel bettingBottomPanel = new BettingSouthPanel();

        bettingBottomPanel.onCloseButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });

        return bettingBottomPanel;
    }

}

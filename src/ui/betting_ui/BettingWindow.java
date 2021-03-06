package ui.betting_ui;

import domain.BettingVerdict;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BettingWindow extends JFrame {
    public static final String TITLE = "Odds On Betting";
    public static final Dimension INITIAL_SIZE = new Dimension(700, 200);
    public static final Point INITIAL_LOCATION = new Point(260, 132);
    private BettingVerdict bettingVerdict;

    public BettingWindow(){
        setTitle(TITLE);
        setSize(INITIAL_SIZE);
        setResizable(false);
        setLocation(INITIAL_LOCATION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().add(BorderLayout.CENTER, setupTeamSelection());
        getContentPane().add(BorderLayout.NORTH, new BettingNorthPanel());
        getContentPane().add(BorderLayout.SOUTH, setupBettingBottomPanel());

        setVisible(true);
    }

    private BettingTeamSelection setupTeamSelection(){
        final BettingTeamSelection bettingTeamSelection = new BettingTeamSelection();

        bettingTeamSelection.onCalculateOddsButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String homeTeam = bettingTeamSelection.getHomeTeamValue();
                String awayTeam = bettingTeamSelection.getAwayTeamValue();

                if(homeTeam.equals(awayTeam)){
                    JOptionPane.showMessageDialog(null, "You have selected the same Team, please select another");
                } else {
                    bettingVerdict = new BettingVerdict(homeTeam, awayTeam);
                    double homeTeamOdds = bettingVerdict.getHomeOdds();
                    double awayTeamOdds = bettingVerdict.getAwayOdds();
                    double drawingOdds = bettingVerdict.getDrawingOdds();

                    bettingTeamSelection.setHomeOdds(homeTeamOdds);
                    bettingTeamSelection.setAwayOdds(awayTeamOdds);
                    bettingTeamSelection.setDrawOdds(drawingOdds);
                }
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

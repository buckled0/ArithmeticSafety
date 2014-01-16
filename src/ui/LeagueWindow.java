package ui;

import domain.LeagueVerdict;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeagueWindow extends JFrame {
    public static final String TITLE = "Arithmetic Football";
    public static final Dimension INITIAL_SIZE = new Dimension(850, 450);
    public static final Point INITIAL_LOCATION = new Point(150, 22);
    public LeagueTable leagueTable;

    public LeagueWindow(){
        setTitle(TITLE);
        setSize(INITIAL_SIZE);
        setResizable(false);
        setLocation(INITIAL_LOCATION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().add(BorderLayout.CENTER, leagueTable = new LeagueTable());
        getContentPane().add(BorderLayout.SOUTH, new BottomPanel());
        getContentPane().add(BorderLayout.NORTH, setupTopPanel());

        setVisible(true);
    }

    private TopPanel setupTopPanel(){
        final TopPanel topPanel = new TopPanel();

        topPanel.onCalculate(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LeagueVerdict leagueVerdict = new LeagueVerdict(topPanel.getSelectedValue());
                leagueTable.populateTable(leagueVerdict.getTeamList(), leagueVerdict.getVerdictArray());
                if(topPanel.getSelectedValue() == "Premier League Current"){
                    int bottomDifference = leagueVerdict.getBottomDifference();
                    leagueTable.populateRelegationCell(bottomDifference);
                }
                if(topPanel.getSelectedValue() == "Custom League"){
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new CustomLeagueWindow();
                        }
                    });
                }
            }
        });

        return topPanel;
    }

}

package ui.main_ui;

import domain.Team;
import domain.TeamStatus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class LeagueTable extends JTable {

    public static final Dimension INITIAL_SIZE = new Dimension(1000, 340);
    DefaultTableModel model;
    JTable table;

    public LeagueTable(){

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Team Name", "Points", "Goal Diff",
                "Wins", "Draws", "Loses", "Played", "League Verdict"});
        table = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
        }};

        JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setPreferredSize(INITIAL_SIZE);
        setVisible(true);
        setLayout(new FlowLayout());

        TableColumn colVerdict = table.getColumnModel().getColumn(7);

        colVerdict.setPreferredWidth(290);

        add(pane);
    }

    public void populateTable(ArrayList<Team> teamList, ArrayList<TeamStatus> verdictArray, int gamesRemaining) {

        model.setRowCount(0);

        if(teamList == null){
            model.setRowCount(0);

        }
        else {

            for(Team team: teamList){
                model.addRow(new Object[]{team.getName(), team.getPoints(), team.getGoalDifference(),
                        team.getWins(), team.getDraws(), team.getLoses(), team.getGamesPlayed()});
            }

            for(int i = 0; i < 20; i++){
                if(verdictArray.get(i) == TeamStatus.startOfSeason)
                    model.setValueAt("Start of Season, no verdict yet", i, 7);
                if(verdictArray.get(i) == TeamStatus.finalPlace)
                    model.setValueAt("Team finished " + (i + 1) + "th place!", i, 7);
                if(verdictArray.get(i) == TeamStatus.equalOnEverything)
                    model.setValueAt("Drawing on points and Goal Difference", i, 7);
                if(verdictArray.get(i) == TeamStatus.equalButTop)
                    model.setValueAt("Drawing on points but has a higher Goal Difference", i, 7);
                if(verdictArray.get(i) == TeamStatus.atRisk)
                    model.setValueAt("Team is at Risk this week", i, 7);
                if(verdictArray.get(i) == TeamStatus.fairlySafeForNow)
                    model.setValueAt("Team is safe, but if team below wins, risk of drawing", i, 7);
                if(verdictArray.get(i) == TeamStatus.definitelySafeForNow)
                    model.setValueAt("Team is definitely safe this week", i, 7);
                if(verdictArray.get(i) == TeamStatus.champions)
                    model.setValueAt("Champions of the Premier League!!!", i, 7);
                if(verdictArray.get(i) == TeamStatus.drawingForTitle)
                    model.setValueAt("Racing for the Title!!", i, 7);
                if(verdictArray.get(i) == TeamStatus.chanceOfChampion)
                    model.setValueAt("High possibility of winning the League", i, 7);
                if(verdictArray.get(i) == TeamStatus.chanceOfChampionsLeague)
                    model.setValueAt("High chance of entering the Champions League", i, 7);
                if(verdictArray.get(i) == TeamStatus.chanceOfEuropaLeague)
                    model.setValueAt("High chance of entering the Europa League", i, 7);
                if(verdictArray.get(i) == TeamStatus.highChanceOfRelegation)
                    model.setValueAt("High chance of being relegated", i, 7);
                if(verdictArray.get(i) == TeamStatus.championsLeague)
                    model.setValueAt("In the Champions League!", i, 7);
                if(verdictArray.get(i) == TeamStatus.europaLeague)
                    model.setValueAt("In the Europa League!", i, 7);
                if(verdictArray.get(i) == TeamStatus.definitelySafeOfRelegation)
                    model.setValueAt("Team is definitely safe of Relegation",i, 7);
                if(verdictArray.get(i) == TeamStatus.definitelySafe)
                    model.setValueAt("Team is safe where they are", i, 7);
                if(verdictArray.get(i) == TeamStatus.definitelyRelegated)
                    model.setValueAt("Team is definitely moving to Championship", i, 7);
                if(verdictArray.get(i) == TeamStatus.canGetOutOfRelegation)
                    model.setValueAt("Team can get out of relegation if they win their next " +
                            gamesRemaining + " games", i, 7);
            }
        }
    }

    public void populateRelegationCell(int bottomDifference){
        model.setValueAt("Team needs " + bottomDifference + " points to overtake the team above", 19, 7);
    }

}

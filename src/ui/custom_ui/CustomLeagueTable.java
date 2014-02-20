package ui.custom_ui;

import domain.Team;
import domain.TeamStatus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class CustomLeagueTable extends JTable {

    public static final Dimension INITIAL_SIZE = new Dimension(800, 450);
    DefaultTableModel model;
    JTable table;
    ArrayList<Team> teamList = new ArrayList<Team>();

    public CustomLeagueTable(String teamAmount){

        model = new DefaultTableModel();
        table = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }};
        model.setColumnIdentifiers(new String[]{"Team Name", "Points", "Goal Diff", "Wins", "Loses",
                "Draws", "Played", "League Verdict"});
        model.setRowCount(Integer.parseInt(teamAmount));

        JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setPreferredSize(INITIAL_SIZE);
        setVisible(true);
        setLayout(new FlowLayout());

        table.setRowSelectionAllowed(false);

        TableColumn colTeamName = table.getColumnModel().getColumn(0);
        colTeamName.setPreferredWidth(150);

        TableColumn colVerdict = table.getColumnModel().getColumn(4);
        colVerdict.setPreferredWidth(290);

        add(pane);
    }

    public ArrayList<Team> getValuesInTable() {
        teamList.clear();
        int rowNum = table.getRowCount();
        for(int i = 0; i < rowNum; i++){
            String teamName = String.valueOf(table.getValueAt(i, 0));
            int teamPoints = Integer.parseInt(String.valueOf(table.getValueAt(i, 1)));
            int teamGD = Integer.parseInt(String.valueOf(table.getValueAt(i, 2)));
            int wins = Integer.parseInt(String.valueOf(table.getValueAt(i, 2)));
            int loses = Integer.parseInt(String.valueOf(table.getValueAt(i, 2)));
            int draws = Integer.parseInt(String.valueOf(table.getValueAt(i, 2)));
            int gamesPlayed = Integer.parseInt(String.valueOf(table.getValueAt(i, 3)));
            Team team = new Team(teamName, teamPoints, teamGD, wins, draws, loses, gamesPlayed);
            teamList.add(i, team);
        }
        return teamList;
    }


    public void populateTable(ArrayList<Team> teamList, ArrayList<TeamStatus> verdictArray) {

        for(int i = 0; i < teamList.size() - 1; i++){
            if(verdictArray.get(i) == TeamStatus.finalPlace)
                model.setValueAt("Team finished " + (i + 1) + "th place!", i, 4);
            if(verdictArray.get(i) == TeamStatus.equalOnEverything)
                model.setValueAt("Drawing on points and Goal Difference", i, 4);
            if(verdictArray.get(i) == TeamStatus.equalButTop)
                model.setValueAt("Drawing on points but has a higher Goal Difference", i, 4);
            if(verdictArray.get(i) == TeamStatus.atRisk)
                model.setValueAt("Team is at Risk this week", i, 4);
            if(verdictArray.get(i) == TeamStatus.fairlySafeForNow)
                model.setValueAt("Team is safe, but if team below wins, risk of drawing", i, 4);
            if(verdictArray.get(i) == TeamStatus.definitelySafeForNow)
                model.setValueAt("Team is definitely safe this week", i, 4);
            if(verdictArray.get(i) == TeamStatus.champions)
                model.setValueAt("Champions of the League!!!", i, 4);
            if(verdictArray.get(i) == TeamStatus.drawingForTitle)
                model.setValueAt("Racing for the Title!!", i, 4);
            if(verdictArray.get(i) == TeamStatus.chanceOfChampion)
                model.setValueAt("High possibility of winning the League", i, 4);
            if(verdictArray.get(i) == TeamStatus.highChanceOfRelegation)
                model.setValueAt("High chance of being relegated", i, 4);
            if(verdictArray.get(i) == TeamStatus.europaLeague)
                model.setValueAt("In the Europa League!", i, 4);
            if(verdictArray.get(i) == TeamStatus.definitelyRelegated)
                model.setValueAt("Team is definitely moving to Championship", i, 4);
            }
        }

    public void populateOnlyTeamInLeagueVerdict(int teamAmount){
        model.setValueAt("Only Team in league, pretty sure they're safe", teamAmount - 1, 4);
    }

    public void populateRelegationCell(int bottomDifference, int teamAmount){
        model.setValueAt("Team needs " + bottomDifference + " to overtake the team above", teamAmount - 1, 4);
    }

}

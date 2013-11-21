package ui;

import domain.LeagueVerdict;
import domain.Team;
import domain.TeamStatus;
<<<<<<< HEAD
=======
import domain.Verdict;
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class LeagueTable extends JTable {

<<<<<<< HEAD
    public static final Dimension INITIAL_SIZE = new Dimension(800, 340);
    private LeagueVerdict leagueVerdict;
=======
    public static final Dimension INITIAL_SIZE = new Dimension(500, 300);
    private static final int smallerColumnWidths = 5;
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746
    DefaultTableModel model;
    JTable table;

    public LeagueTable(){

        leagueVerdict = new LeagueVerdict();
        model = new DefaultTableModel();
<<<<<<< HEAD
        model.setColumnIdentifiers(new String[]{"Team Name", "Goal Diff", "Points", "Played", "LeagueVerdict"});
        table = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
        }};
=======
        model.setColumnIdentifiers(new String[]{"Team", "GoalDiff", "Pts", "Played", "Verdict"});
        table = new JTable(model){@Override
                                  public boolean isCellEditable(int row, int column) {
            return false;
        }};

        TableColumn colGD = table.getColumnModel().getColumn(1);
        colGD.setPreferredWidth(smallerColumnWidths);

        TableColumn colPts = table.getColumnModel().getColumn(2);
        colPts.setPreferredWidth(smallerColumnWidths);

        TableColumn colGms = table.getColumnModel().getColumn(3);
        colGms.setPreferredWidth(smallerColumnWidths);

        for(Team team: leagueSQLConnector.teamList){
            model.addRow(new Object[]{team.getName(), team.getGoalDifference(),
                    team.getPoints(), team.getGamesPlayed()});
        }

        int i = 0;
        while(i < 20){
            if(verdict.verdictArray.get(i) == TeamStatus.equal)
                model.setValueAt("Drawing", i, 4);
            else if(verdict.verdictArray.get(i) == TeamStatus.safe)
                model.setValueAt("Safe", i, 4);
            else if(verdict.verdictArray.get(i) == TeamStatus.notSafe)
                model.setValueAt("Not Safe", i, 4);
            else
                model.setValueAt("Relegation Zone", i, 4);
            i++;
        }
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746

        JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setPreferredSize(INITIAL_SIZE);
        setVisible(true);
        setLayout(new FlowLayout());

        table.setRowSelectionAllowed(false);

        TableColumn colVerdict = table.getColumnModel().getColumn(4);

        colVerdict.setPreferredWidth(290);

        for(Team team: leagueVerdict.getTeamList()){
             model.addRow(new Object[]{team.getName(), team.getGoalDifference(),
                     team.getPoints(), team.getGamesPlayed()});
        }

        int i = 0;
        while(i < 20){
            if(leagueVerdict.getVerdictArray().get(i) == TeamStatus.equalOnEverything)
                model.setValueAt("Drawing on points and Goal Difference", i, 4);
            else if(leagueVerdict.getVerdictArray().get(i) == TeamStatus.equalButTop)
                model.setValueAt("Drawing on points but has a higher Goal Difference", i, 4);
            else if(leagueVerdict.getVerdictArray().get(i) == TeamStatus.atRisk)
                model.setValueAt("Team is at Risk this week", i, 4);
            else if(leagueVerdict.getVerdictArray().get(i) == TeamStatus.fairlySafeForNow)
                model.setValueAt("Team is safe, but if team below wins, would be drawing", i, 4);
            else if(leagueVerdict.getVerdictArray().get(i) == TeamStatus.definitelySafeForNow)
                model.setValueAt("Team is definitely safe this week", i, 4);
            else if(leagueVerdict.getVerdictArray().get(i) == TeamStatus.relegated)
                model.setValueAt("Team needs " + leagueVerdict.getBottomDifference() + " points", i, 4);
            i++;
        }

        add(pane);
    }


}

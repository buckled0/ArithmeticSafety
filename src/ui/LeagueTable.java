package ui;

import databaseConnection.LeagueSQLConnector;
import domain.Team;
import domain.TeamStatus;
import domain.Verdict;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class LeagueTable extends JTable {

    public static final Dimension INITIAL_SIZE = new Dimension(500, 300);
    private static final int smallerColumnWidths = 5;
    DefaultTableModel model;
    JTable table;

    public LeagueTable(){

        TopPanel tp = new TopPanel();
        LeagueSQLConnector leagueSQLConnector = new LeagueSQLConnector();
        Verdict verdict = new Verdict();
        model = new DefaultTableModel();
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

        JScrollPane pane = new JScrollPane(table);
        setVisible(true);
        setSize(INITIAL_SIZE);
        setLayout(new FlowLayout());

        add(pane);
    }

}

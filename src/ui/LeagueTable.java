package ui;

import databaseConnection.LeagueSQLConnector;
import domain.Team;
import domain.Verdict;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LeagueTable extends JTable {

    public static final Dimension INITIAL_SIZE = new Dimension(500, 300);
    DefaultTableModel model;
    JTable table;

    public LeagueTable(){

        TopPanel tp = new TopPanel();
        LeagueSQLConnector leagueSQLConnector = new LeagueSQLConnector();
        Verdict verdict = new Verdict();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Team Name", "Goal Difference", "Points", "Verdict"});

        for(Team team: leagueSQLConnector.teamList){
             model.addRow(new Object[]{team.name, team.goalDifference,
                     team.points, verdict.verdictArray});
        }

        table = new JTable(model){@Override
                          public boolean isCellEditable(int row, int column) {
            return false;
        }};

        JScrollPane pane = new JScrollPane(table);
        setVisible(true);
        setSize(INITIAL_SIZE);
        setLayout(new FlowLayout());

        add(pane);
    }

}

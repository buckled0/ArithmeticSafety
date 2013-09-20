package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LeagueTable extends JTable {

    public final String[] columnNames;
    DefaultTableModel model;
    JTable table;

    public LeagueTable(){

        columnNames = new String[]{"Teams", "Goal Difference", "Points", "Verdict"};
        model = new DefaultTableModel(columnNames, 20);
        table = new JTable(model){@Override
                                public boolean isCellEditable(int arg0, int arg1) {

            return false;
        }};

        JScrollPane pane = new JScrollPane(table);
        setVisible(true);
        setSize(500, 300);
        setLayout(new FlowLayout());

        add(pane);
    }
}

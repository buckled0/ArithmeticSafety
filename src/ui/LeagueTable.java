package ui;

import domain.LeagueVerdict;
import domain.Team;
import domain.TeamStatus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class LeagueTable extends JTable {

    public static final Dimension INITIAL_SIZE = new Dimension(800, 340);
    private LeagueVerdict leagueVerdict;
    DefaultTableModel model;
    JTable table;

    public LeagueTable(){

        leagueVerdict = new LeagueVerdict();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Team Name", "Goal Diff", "Points", "Played", "LeagueVerdict"});
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

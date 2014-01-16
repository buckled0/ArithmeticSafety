package ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TopPanel extends JPanel{

    public String[] leagues;
    public JComboBox leagueMenu;
    public JButton calculate;
    public String newValue;

    public TopPanel() {
        leagues = new String[] {"Please Select a League", "Custom League", "Premier League Current",
                "Premier League, 08/05/2012", "Premier League, 13/05/2012"};
        leagueMenu = new JComboBox(leagues);

        leagueMenu.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == itemEvent.SELECTED)
                    setNewValue(itemEvent.getItem().toString());
            }
        });

        calculate = new JButton("Calculate Safety");

        add(leagueMenu);
        add(calculate);

    }

    public void onCalculate(ActionListener listener){
        calculate.addActionListener(listener);
    }

    private void setNewValue(String selectedValue){
        this.newValue = selectedValue;
    }

    public String getSelectedValue() { return newValue; }

}

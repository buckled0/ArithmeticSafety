package ui.main_ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TopPanel extends JPanel{

    public String[] leagues;
    public JComboBox leagueMenu;
    public JButton calculate;
    public JButton bettingButton;
    public String newValue;

    public TopPanel() {
        leagues = new String[] {"Please Select a League", "Premier League Current", "Premier League Half Way Point",
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
        bettingButton = new JButton("Odds On Betting");

        add(leagueMenu);
        add(calculate);
        add(bettingButton);

    }

    public void onCalculate(ActionListener listener){
        calculate.addActionListener(listener);
    }

    public void onBettingButton(ActionListener listener){
        bettingButton.addActionListener(listener);
    }

    private void setNewValue(String selectedValue){
        this.newValue = selectedValue;
    }

    public String getSelectedValue() { return newValue; }


}

package ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomTopPanel extends JPanel {

    public JTextField howManyField;
    public JComboBox teamAmountSelection;
    public JButton calculateButton;
    public String newAmountValue;

    public CustomTopPanel(){

        howManyField = new JTextField("How many teams in your League?");
        howManyField.setEditable(false);

        String[] teamAmount = new String[25];
        for(int i = 1; i < teamAmount.length; i++)
            teamAmount[i] = String.valueOf(i);

        teamAmountSelection = new JComboBox(teamAmount);

        teamAmountSelection.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == itemEvent.SELECTED)
                    setTeamAmountValue(itemEvent.getItem().toString());
            }

        });

        calculateButton = new JButton("Calculate Safety");

        add(howManyField);
        add(teamAmountSelection);
        add(calculateButton);

    }

    public void setTeamAmountValue(String teamAmountValue) {
        this.newAmountValue = teamAmountValue;
    }

    public String getNewAmountValue() { return newAmountValue; }


    public void onCalculateButton(ActionListener listener){
        calculateButton.addActionListener(listener);
    }

}

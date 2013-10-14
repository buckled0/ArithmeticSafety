package ui.test;

import org.junit.Before;
import org.junit.Test;
import ui.TopPanel;

import javax.swing.*;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ui.test.TestHelpers.assertInstanceOf;

public class TopPanelTest {

    private TopPanel topPanel;

    @Before
    public void setUp() throws Exception {
        topPanel = new TopPanel();
    }

    @Test
    public void beAJPanel(){
        assertInstanceOf(new TopPanel(), JPanel.class);
    }

    @Test
    public void shouldHaveAFullyFilledArray(){
        String[] expectedArray = {"Please Select a League", "Premier League", "La Liga", "Serie A", "Bundesliga",
                                        "Ligue 1", "Eredivisie"};
        String[] resultsArray = topPanel.getStringArray();
        assertTrue(Arrays.equals(expectedArray, resultsArray));
    }

    @Test
    public void shouldHaveComboBox(){
        int index = 0;
        assertEquals("Should have a combobox", topPanel.getComponents()[index].getClass(), JComboBox.class);
    }

    @Test
    public void shouldHaveARoundsArray(){
        Integer[] expected = new Integer[39];
        for(int i = 1; i < expected.length; i++) {
            expected[i] = i;
        }
        Integer[] actual = topPanel.getIntArray();
        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    public void shouldHaveARoundsComboBox(){
        int index = 1;
        assertEquals("Should have a combo box", topPanel.getComponents()[index].getClass(), JComboBox.class);
    }

    @Test
    public void shouldHaveAJButton(){
        String name = "Go";
        int index = 2;
        assertEquals("Should have a JButton", topPanel.getComponents()[index].getClass(), JButton.class);
    }

}

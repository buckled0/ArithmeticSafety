package ui.test;

import org.junit.Before;
import org.junit.Test;
import ui.LeagueWindow;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;
import static ui.test.TestHelpers.assertInstanceOf;

public class LeagueWindowTest {
    private LeagueWindow lt;

    @Before
    public void setUp() throws Exception {
        lt = new LeagueWindow();
    }

    @Test
    public void isAJFrame(){
        assertInstanceOf(lt, JFrame.class);
    }
    
    @Test
    public void shouldHaveATitle(){
        assertEquals(LeagueWindow.TITLE, lt.getTitle());
    }

    @Test
    public void shouldTheWindowBeVisible(){
        assertTrue("Is Visible", lt.isVisible());
    }

    @Test
    public void shouldBeCorrectSize(){
        assertFalse(lt.isResizable());
        assertEquals("league table size", lt.INITIAL_SIZE, lt.getSize());
    }

    @Test
    public void shouldBeInCorrectPosition(){
        assertEquals("league table position", new Point(150, 22), lt.getLocation());
    }

    @Test
    public void shouldExitOnClose(){
        assertEquals("close operation", WindowConstants.EXIT_ON_CLOSE, lt.getDefaultCloseOperation());
    }

    @Test
    public void borderLayout(){
        assertInstanceOf(lt.getContentPane().getLayout(), BorderLayout.class);
    }

    @Test
    public void shouldATableAppear(){
        assertInstanceOf(lt.getContentPane().getComponents()[0], JTable.class);
    }

    @Test
    public void shouldHaveAJPanel(){
        assertInstanceOf(lt.getContentPane().getComponents()[1], JPanel.class);
    }
}

package ui.test;

import org.junit.Test;
import test.LeagueTable;

import javax.swing.*;

import static ui.test.TestHelpers.assertInstanceOf;

public class LeagueTableTest {
    @Test
    public void beAJTable(){
        assertInstanceOf(new LeagueTable(), JTable.class);
    }


}

package test;

import domain.BettingVerdict;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BettingTest {

    @Test
    public void shouldPassToHomeOddsMethodForSunderlandAndHull(){
        BettingVerdict home = createTeam("Sunderland", 6, 3, 7, 3, 5);
        BettingVerdict away = createTeam("Hull", 1, 5, 3, 1, 9);

        double expected = 1.83;

        assertEquals("Should give the home odds", expected, home.homeOdds(home, away));

    }

    @Test
    public void shouldPassToHomeOddsMethodForChelseaAndNewcastleIfOneValueIsZero(){
        BettingVerdict home = createTeam("Chelsea", 9, 10, 0, 6, 3);
        BettingVerdict away = createTeam("Newcastle", -5, 5, 4, 6, 5);

        double expected = 0.41;

        assertEquals("Should give the home odds", expected, home.homeOdds(home, away));

    }

    @Test
    public void shouldPassToAwayOddsMethodForSunderlandAndHull(){
        BettingVerdict away = createTeam("Hull", 1, 5, 3, 1, 9);
        BettingVerdict home = createTeam("Sunderland", 6, 3, 7, 3, 5);

        double expected = 5.75;

        assertEquals("Should give away odds", expected, away.awayOdds(home, away));
    }

    private BettingVerdict createTeam(String name, int goalDifferenceSixGames, int homeWins,
                                      int homeLoses, int awayWins, int awayLoses) {
        return new BettingVerdict(name, goalDifferenceSixGames, homeWins, homeLoses, awayWins, awayLoses);
    }

}

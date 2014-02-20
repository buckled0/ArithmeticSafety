package test;

import domain.Team;
import domain.TeamStatus;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class definitiveSafetyVerdictCheckTest {

    @Test
    public void shouldCheckForDefiniteChampionsFrom8GamesLeft(){
        Team sunderland = createTeam("Sunderland", 85, 43, 30, 0, 0, 0);
        Team manCity = createTeam("Man City", 60, 30, 30, 0, 0, 0);
        int i = 0;

        assertEquals("Will return definitely safe as there is no way City can overtake", TeamStatus.champions,
                sunderland.definitiveSafetyVerdictCheck(sunderland, manCity, i));
    }
    
    @Test
    public void shouldDefinitelyReturnDefinitelyReturnInChampionsLeagueFrom8GamesLeft(){
        Team sunderland = createTeam("Sunderland", 89, 43, 30, 0, 0, 0);
        Team manCity = createTeam("Man City", 65, 30, 30, 0, 0, 0);
        int i = 1;

        assertEquals("Points difference so great city can't overtake Sunderland, so definitely in champions league",
                TeamStatus.championsLeague, sunderland.definitiveSafetyVerdictCheck(sunderland, manCity, i));
    }

    @Test
    public void shouldDefinitelyReturnInEuropaLeague(){
        Team sunderland = createTeam("Sunderland", 89, 43, 30, 0, 0, 0);
        Team manCity = createTeam("Man City", 65, 30, 30, 0, 0, 0);
        int i = 4;

        assertEquals("Points difference between two teams is so great, Sunderland defintiely in Europa",
                TeamStatus.europaLeague, sunderland.definitiveSafetyVerdictCheck(sunderland, manCity, i));
    }

    @Test
    public void definitelySafeIfTeamPointsAreGreaterThanRelegation(){
        Team sunderland = createTeam("Sunderland", 89, 43, 30, 0, 0, 0);
        Team manCity = createTeam("Man City", 65, 30, 30, 0, 0, 0);
        int i = 16;

        assertEquals("If team in 18th can't overtake team in 17th, 17th is definitely safe of relegation",
                TeamStatus.definitelySafeOfRelegation, sunderland.definitiveSafetyVerdictCheck(sunderland, manCity, i));
    }

    @Test
    public void shouldBeDefinitelySafeIfTopOfRelegationIsAmountOfViablePointsAwayFromCurrentTeam(){
        Team sunderland = createTeam("Sunderland", 59, 43, 30, 0, 0, 0);
        Team manCity = createTeam("Man City", 35, 30, 30, 0, 0, 0);
        int i = 5;

        assertEquals("If Sunderland are anywhere in the league and City can't overtake, then Sunderland are definitely safe of relegation",
                TeamStatus.definitelySafe, sunderland.definitiveSafetyVerdictCheck(sunderland, manCity, i));
    }

    @Test
    public void shouldBeChanceOfRelegationIfTeamsCanGetOutOfRelegation(){
        Team sunderland = createTeam("Sunderland", 35, 43, 30, 0, 0, 0);
        Team manCity = createTeam("Man City", 28, 30, 30, 0, 0, 0);
        int i = 17;

        assertEquals("If Man City can get past Sunderlands points then can get out of relegation",
                TeamStatus.canGetOutOfRelegation, sunderland.definitiveSafetyVerdictCheck(sunderland, manCity, i));
    }

    private Team createTeam(String name, int points, int goalDifference, int wins,
                            int loses, int draws, int gamesPlayed) {
        return new Team(name, points, goalDifference, wins, loses, draws, gamesPlayed);
    }
}

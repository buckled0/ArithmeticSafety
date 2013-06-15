package test;

import domain.Team;
import domain.TeamStatus;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class TeamTest {
    @Test
    public void giveTeamName() {
        assertTeamName("Sunderland", createTeam("Sunderland", 32, 0));
        assertTeamName("QPR", createTeam("QPR", 15, 0));
    }

    @Test
    public void giveTeamPoints() {
        assertEquals("Team Points", 32, createTeam("Sunderland", 32, 0).getPoints());
        assertEquals("Team Points", 31, createTeam("QPR", 31, 0).getPoints());
    }

    @Test
    public void giveTeamGoalDifference() {
        assertEquals("Team Goal Difference", -13, createTeam("Sunderland", 32, -13).getGoalDifference());
        assertEquals("Team Goal Difference", 10, createTeam("Sunderland", 32, 10).getGoalDifference());
    }

    @Test
    public void ifPointsDifferenceIsExactlyFourTeamAreSafe(){
        Team sunderland = createTeam("Sunderland", 32, -13);
        Team qpr = createTeam("QPR", 28, 10);

        FakeLeague l = new FakeLeague(Arrays.asList(qpr));

        assertEquals("Team Safe Determination", TeamStatus.safe, sunderland.teamStatus(l));
    }

    @Test
    public void ifPointsDifferenceIsLessThanFourTeamAreNotSafe(){
        Team qpr = createTeam("qpr", 30, -13);
        Team sunderland = createTeam("Sunderland", 32, -13);

        FakeLeague l = new FakeLeague(Arrays.asList(qpr));

        assertEquals("Team Not Safe Determination", TeamStatus.notSafe, sunderland.teamStatus(l));
    }

    @Test
    public void ifPointsDifferenceIsMoreThanFourThenTeamAreSafe(){
        Team sunderland = createTeam("Sunderland", 32, -13);
        Team qpr = createTeam("QPR", 25, 10);

        FakeLeague l = new FakeLeague(Arrays.asList(qpr));

        assertEquals("Team Safe Determination", TeamStatus.safe, sunderland.teamStatus(l));
    }

    @Test
    public void ifPointsDifferenceIsEqual(){
        Team sunderland = createTeam("Sunderland", 32, -13);
        Team qpr = createTeam("QPR", 32, 10);

        FakeLeague l = new FakeLeague(Arrays.asList(qpr));

        assertEquals("Team Equal Determination", TeamStatus.equal, sunderland.teamStatus(l));
    }

    @Test
    public void thereIsATwoPointDifferenceAndTheTwoTeamsBelowYouArePlayingEachOther (){
        Team sunderland = createTeam("Sunderland", 32, -13);
        Team qpr = createTeam("QPR", 30, 10);
        Team newcastle = createTeam("Newcastle", 29, 10);

        FakeLeague l = new FakeLeague(Arrays.asList(qpr, newcastle));

        assertEquals("Team Safe Determination", TeamStatus.safe, sunderland.teamStatus(l));
    }

    private Team createTeam(String name, int points, int goalDifference) {
        return new Team(name, points, goalDifference);
    }

    private void assertTeamName(String teamName, Team team) {
        assertEquals("Team Name", teamName, team.getName());
    }

}

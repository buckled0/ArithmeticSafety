package test;

import domain.Team;
import domain.TeamStatus;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TeamTest {
    @Test
    public void giveTeamName() {
<<<<<<< HEAD
        assertTeamName("Sunderland", createTeam("Sunderland", 32, 0, 0));
        assertTeamName("QPR", createTeam("QPR", 15, 0, 0));
=======
        assertTeamName("Sunderland", createTeam("Sunderland", 32, 0, 8));
        assertTeamName("QPR", createTeam("QPR", 15, 0, 8));
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746
    }

    @Test
    public void giveTeamPoints() {
<<<<<<< HEAD
        assertEquals("Team Points", 32, createTeam("Sunderland", 0, 32, 0).getPoints());
        assertEquals("Team Points", 31, createTeam("QPR", 0, 31, 0).getPoints());
=======
        assertEquals("Team Points", 32, createTeam("Sunderland", 32, 0, 8).getPoints());
        assertEquals("Team Points", 31, createTeam("QPR", 31, 0, 8).getPoints());
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746
    }

    @Test
    public void giveTeamGoalDifference() {
<<<<<<< HEAD
        assertEquals("Team Goal Difference", -13, createTeam("Sunderland", -13, 32, 0).getGoalDifference());
        assertEquals("Team Goal Difference", 10, createTeam("Sunderland", 10, 10, 0).getGoalDifference());
    }

    @Test
    public void shouldHaveBothTeamsEqual(){
        Team sunderland = createTeam("Sunderland", 10, 32, 0);
        Team manCity = createTeam("Man City", 10, 32, 0);
=======
        assertEquals("Team Goal Difference", -13, createTeam("Sunderland", 32, -13, 8).getGoalDifference());
        assertEquals("Team Goal Difference", 10, createTeam("Sunderland", 32, 10, 8).getGoalDifference());
    }

    @Test
    public void ifPointsDifferenceIsExactlyFourTeamAreSafe(){
        Team sunderland = createTeam("Sunderland", 32, -13, 8);
        Team qpr = createTeam("QPR", 28, 10, 8);

        FakeLeague l = new FakeLeague(Arrays.asList(qpr));
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746

        assertEquals("Team Equal Determination", TeamStatus.equalOnEverything, sunderland.leagueStatus(sunderland, manCity));
    }

    @Test
<<<<<<< HEAD
    public void shouldBeEqualOnPointsButHigherGoalDifference(){
        Team sunderland = createTeam("Sunderland", 15, 32, 0);
        Team manCity = createTeam("Man City", 10, 32, 0);
=======
    public void ifPointsDifferenceIsLessThanFourTeamAreNotSafe(){
        Team qpr = createTeam("qpr", 30, -13, 8);
        Team sunderland = createTeam("Sunderland", 32, -13, 8);

        FakeLeague l = new FakeLeague(Arrays.asList(qpr));
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746

        assertEquals("Team equal but higher Goal Difference", TeamStatus.equalButTop,
                sunderland.leagueStatus(sunderland, manCity));
    }

    @Test
<<<<<<< HEAD
    public void shouldBeAtRiskIfPointsDifferenceIsTwoOrLess(){
        Team sunderland = createTeam("Sunderland", 15, 32, 0);
        Team manCity = createTeam("Man City", 15, 30, 0);
=======
    public void ifPointsDifferenceIsMoreThanFourThenTeamAreSafe(){
        Team sunderland = createTeam("Sunderland", 32, -13, 8);
        Team qpr = createTeam("QPR", 25, 10, 8);
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746

        assertEquals("Team is at risk as points difference is less than 2", TeamStatus.atRisk,
                sunderland.leagueStatus(sunderland, manCity));
    }

    @Test
<<<<<<< HEAD
    public void shouldBeFairlySafeIfPointsDifferenceIsThree(){
        Team sunderland = createTeam("Sunderland", 15, 33, 0);
        Team manCity = createTeam("Man City", 15, 30, 0);
=======
    public void ifPointsDifferenceIsEqual(){
        Team sunderland = createTeam("Sunderland", 32, -13, 8);
        Team qpr = createTeam("QPR", 32, 10, 8);

        FakeLeague l = new FakeLeague(Arrays.asList(qpr));
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746

        assertEquals("Team is farely safe if points difference is three", TeamStatus.fairlySafeForNow,
                sunderland.leagueStatus(sunderland, manCity));
    }

<<<<<<< HEAD

    @Test
    public void shouldBeDefinitelySafeForNowIfPointsDifferenceIsGreaterThanFour(){
        Team sunderland = createTeam("Sunderland", 15, 34, 0);
        Team manCity = createTeam("Man City", 15, 30, 0);

        assertEquals("Team is definitely safe that week if points difference is greater than four",
                TeamStatus.definitelySafeForNow, sunderland.leagueStatus(sunderland, manCity));
    }

=======
>>>>>>> a86130f9a685fd78cc6b1e8bfe559ff7c2745746

    private Team createTeam(String name, int points, int goalDifference, int gamesPlayed) {
        return new Team(name, points, goalDifference, gamesPlayed);
    }


    private void assertTeamName(String teamName, Team team) {
        assertEquals("Team Name", teamName, team.getName());
    }

}

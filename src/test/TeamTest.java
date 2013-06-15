package test;

import domain.Team;
import org.junit.Test;

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

    private Team createTeam(String name, int points, int goalDifference) {
        return new Team(name, points, goalDifference);
    }

    private void assertTeamName(String teamName, Team team) {
        assertEquals("Team Name", teamName, team.getName());
    }

}

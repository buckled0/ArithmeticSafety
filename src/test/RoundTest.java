package test;

import domain.Round;
import domain.Team;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RoundTest {

    @Test
    public void creatingAConceptOfARound(){
        Team team1 = new Team("t1", 0, 0, 8);
        Team team2 = new Team("t2", 0, 0, 8);
        Round r = new Round(team1, team2);
    }

    @Test
    public void teamsDrawShouldGetOnePointEach(){
        Team team1 = new Team("t1", 0, 0, 8);
        Team team2 = new Team("t2", 0, 0, 8);
        Round r = new Round(team1, team2);

        r.play(0, 0);

        assertEquals("Teams Both Get One Point", 1, team1.getPoints());
        assertEquals("Teams Both Get One Point", 1, team2.getPoints());

    }

    @Test
    public void oneTeamWinsAndOneTeamLoses(){
        Team team1 = new Team("t1", 0, 0, 8);
        Team team2 = new Team("t2", 0, 0, 8);
        Round r = new Round(team1, team2);

        r.play(1, 0);

        assertEquals("One Team Gets 3 points other gets 0", 3, team1.getPoints());
        assertEquals("One Team Gets 3 points other gets 0", 0, team2.getPoints());
    }

    @Test
    public void roundOneDrawRoundTwoWin(){
        Team team1 = new Team("t1", 0, 0, 8);
        Team team2 = new Team("t2", 0, 0, 8);
        Round r = new Round(team1, team2);

        r.play(0, 0).play(1, 0);

        assertEquals("One Team Gets 3 points other gets 0", 4, team1.getPoints());
        assertEquals("One Team Gets 3 points other gets 0", 1, team2.getPoints());
    }

}

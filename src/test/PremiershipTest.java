package test;

import domain.Premiership;
import domain.Team;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class PremiershipTest {

    public List<Team> buildTeams(){
        List<Team> teams = new ArrayList<Team>();
        for(int i = 0; i < 10; i++)
            teams.add(new Team("T"+i, 0, 0));
        return teams;
    }

    @Test
    public void oneRoundPlayedAllTeamsDraw(){
        Premiership p = new Premiership(buildTeams());

        assertArrayEquals("All teams in same position", buildTeams().toArray() , p.teams().toArray());
    }
}

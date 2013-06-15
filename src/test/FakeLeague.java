package test;

import domain.League;
import domain.Team;

import java.util.List;

public class FakeLeague implements League {
    public List<Team> teams;

    public FakeLeague(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public List<Team> teamsBelowMe(Team t) {
        return teams;
    }
}

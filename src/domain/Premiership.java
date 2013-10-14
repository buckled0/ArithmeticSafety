package domain;

import java.util.List;

public class Premiership {

    private List<Team> teams;

    public Premiership(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> teams() {
        return teams;
    }
}

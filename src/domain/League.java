package domain;

import java.util.List;

public interface League {
    public List<Team> teamsBelowMe(Team t);
}

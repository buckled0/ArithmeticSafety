package domain;

import java.util.List;

public class Team {
    private String name;
    private int points;
    private int goalDifference;

    public Team(String name, int points, int goalDifference) {
        this.name = name;
        this.points = points;
        this.goalDifference = goalDifference;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public TeamStatus teamStatus(League league) {
        List<Team> teams = league.teamsBelowMe(this);
        Team team = teams.get(0);

        if(points == team.points)
            return TeamStatus.equal;

        if(teams.size() > 1)
            return TeamStatus.safe;

        if(points - team.points < 4)
            return TeamStatus.notSafe;

        return TeamStatus.safe;
    }

    public void setPoints(int i) {
        points += i;
    }
}

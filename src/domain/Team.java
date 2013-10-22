package domain;

import java.util.List;

public class Team {
    public String name;
    public int goalDifference;
    public int points;
    public int gamesPlayed;

    public Team(String name, int goalDifference, int points, int gamesPlayed) {
        this.name = name;
        this.goalDifference = goalDifference;
        this.points = points;
        this.gamesPlayed = gamesPlayed;
    }

    public String getName() {
        return name;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getPoints() {
        return points;
    }

    public int getGamesPlayed(){
        return gamesPlayed;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!name.equals(team.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void setPoints(int i) {
        points += i;
    }

}

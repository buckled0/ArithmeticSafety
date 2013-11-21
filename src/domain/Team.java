package domain;

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

    public TeamStatus leagueStatus(Team team1, Team team2){

        if ((team1.getPoints() == team2.getPoints()) && (team1.getGoalDifference() == team2.getGoalDifference()))
            return TeamStatus.equalOnEverything;

        if ((team1.getPoints() == team2.getPoints()) && (team1.getGoalDifference() > team2.getGoalDifference()))
            return TeamStatus.equalButTop;

        if (team1.getPoints() - team2.points <= 2)
            return TeamStatus.atRisk;

        if (team1.getPoints() - team2.getPoints() == 3)
            return TeamStatus.fairlySafeForNow;

        if (team1.getPoints() - team2.getPoints() >= 4)
            return TeamStatus.definitelySafeForNow;

        return TeamStatus.relegated;
    }


    /*public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.verdictArray).append(",");
        return result.toString();
    } */
}

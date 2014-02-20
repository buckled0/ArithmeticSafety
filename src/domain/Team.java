package domain;

public class Team {

    public String name;
    public int goalDifference;
    public int points;
    public int wins;
    public int loses;
    public int draws;
    public int gamesPlayed;

    public Team(String name, int goalDifference, int points, int wins, int loses, int draws, int gamesPlayed) {
        this.name = name;
        this.goalDifference = goalDifference;
        this.points = points;
        this.wins = wins;
        this.loses = loses;
        this.draws = draws;
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

    public int getWins(){
        return wins;
    }

    public int getLoses(){
        return loses;
    }

    public int getDraws(){
        return draws;
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

        return TeamStatus.couldBeRelegated;
    }

    public TeamStatus definitiveSafetyVerdictCheck(Team team1, Team team2, int i) {
        int totalGamesInSeason = 38;
        int gamesInSeasonDifference = totalGamesInSeason - team1.getGamesPlayed();
        int possibleAmountOfPoints = gamesInSeasonDifference * 3;
        int possibleEndOfSeason = team2.getPoints() + possibleAmountOfPoints;
        if(i == 0){
            if(possibleEndOfSeason > team1.getPoints())
                return TeamStatus.champions;
            else
                return TeamStatus.chanceOfChampion;
        }
        if(i > 0 && i < 4){
            if(possibleEndOfSeason > team1.getPoints())
                return TeamStatus.championsLeague;
            else
                return TeamStatus.chanceOfChampionsLeague;
        }
        if(i == 4){
            if(possibleEndOfSeason > team1.getPoints())
                return TeamStatus.europaLeague;
            else
                return TeamStatus.chanceOfEuropaLeague;
        }
        if(i == 16){
            if(possibleEndOfSeason > team1.getPoints())
                return TeamStatus.definitelySafeOfRelegation;
            else
                return TeamStatus.chanceOfRelegation;
        }
        if(i > 16){
            if(possibleEndOfSeason > team1.getPoints())
                return TeamStatus.canGetOutOfRelegation;
            else
                return TeamStatus.chanceOfRelegation;
        }
        if(i > 4 || i < 16){
            if(possibleEndOfSeason > team1.getPoints())
                return TeamStatus.definitelySafe;
        }

        return TeamStatus.fairlySafeForNow;
    }

}

package domain;

import databaseConnection.LeagueSQLConnector;

import java.util.ArrayList;

public class Verdict {

    public ArrayList<TeamStatus> verdictArray = new ArrayList<TeamStatus>();
    private static final int win = 3;

    public Verdict(){
        LeagueSQLConnector leagueSQLConnector = new LeagueSQLConnector();
        int size = leagueSQLConnector.pointsList.size();

        for(int i = 0; i < teamDifference(size, 1); i++){
            int team1 = leagueSQLConnector.pointsList.get(i);
            int team2 = leagueSQLConnector.pointsList.get(i + 1);
            if(equalTeams(team1, team2)){
                verdictArray.add(i, TeamStatus.equal);
            } else if((teamDifference(team1, team2)) > win){
                verdictArray.add(i, TeamStatus.safe);
            } else if (teamDifference(team1, team2) < win) {
                verdictArray.add(i, TeamStatus.notSafe);
            }
        }

        int secondFromBottom = leagueSQLConnector.pointsList.get(18);
        int bottom = leagueSQLConnector.pointsList.get(19);
        if(equalTeams(secondFromBottom, bottom))
            verdictArray.add(19,TeamStatus.equal);
        else if ((teamDifference(secondFromBottom, bottom)) < win)
            verdictArray.add(19, TeamStatus.notSafe);
        else
            verdictArray.add(19, TeamStatus.safe);

    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.verdictArray).append(",");
        return result.toString();
    }

    public ArrayList<TeamStatus> getVerdictArray() {
        return verdictArray;
    }

    private boolean equalTeams(int team1, int team2) {
        return team1 == team2;
    }

    private int teamDifference(int team1, int team2) {
        return team1 - team2;
    }
}
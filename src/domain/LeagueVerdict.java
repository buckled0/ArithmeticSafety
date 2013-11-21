package domain;

import database.LeagueSQLConnector;

import java.util.ArrayList;
import java.util.List;

public class LeagueVerdict {

    public List<Team> teamList;
    public ArrayList<TeamStatus> verdictArray = new ArrayList<TeamStatus>();
    private LeagueSQLConnector leagueSQLConnector = new LeagueSQLConnector();

    public LeagueVerdict() {
        teamList = leagueSQLConnector.getTeamList();
        for(int i = 0; i < teamList.size() - 1; i++){
            Team team1 = teamList.get(i);
            Team team2 = teamList.get(i + 1);
            TeamStatus teamStatus = team1.leagueStatus(team1, team2);
            verdictArray.add(i, teamStatus);
        }

        verdictArray.add(19, TeamStatus.relegated);

    }

    public int getBottomDifference(){
        int bottomDifference = teamList.get(18).getPoints() - teamList.get(19).getPoints() + 1;
        return bottomDifference;
    }

    public List<Team> getTeamList(){
        return teamList;
    }

    public ArrayList<TeamStatus> getVerdictArray(){
        return verdictArray;
    }

}

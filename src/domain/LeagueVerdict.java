package domain;

import database.LeagueSQLConnector;

import java.util.ArrayList;

public class LeagueVerdict {

    public ArrayList<Team> teamList;
    public ArrayList<TeamStatus> verdictArray = new ArrayList<TeamStatus>();
    private LeagueSQLConnector leagueSQLConnector;
    private String tableName;

    public LeagueVerdict(String selectedValue) {
        this.tableName = selectedValue;
        if(tableName == "Premier League Current") {
            tableName = "`test`.`Premier_League`";
            leagueVerdictConnector(tableName);
        }
        if(tableName == "Premier League Half Way Point") {
            tableName = "`test`.`Premier_League_Half_Point`";
            leagueVerdictConnector(tableName);
        }
        if(tableName == "Premier League, 08/05/2012") {
            tableName = "`test`.`Premier_League_May_8_2012`";
            leagueVerdictConnector(tableName);
        }
        if(tableName == "Premier League, 13/05/2012") {
            tableName = "`test`.`Premier_League_May_13_2012`";
            leagueVerdictConnector(tableName);
        }
    }

    private void leagueVerdictConnector(String tableName) {
        leagueSQLConnector = new LeagueSQLConnector(tableName);
        teamList = leagueSQLConnector.getTeamList();
        verdictArray.clear();
        int checkGamesPlayed = teamList.get(0).getGamesPlayed();

        if(checkGamesPlayed >= 30)
            endOfSeasonPlacement(teamList);
        else if(checkGamesPlayed == 0)
            startOfSeason();
        else {
            for(int i = 0; i < teamList.size() - 1; i++){
                Team team1 = teamList.get(i);
                Team team2 = teamList.get(i + 1);
                TeamStatus teamStatus = team1.leagueStatus(team1, team2);
                verdictArray.add(i, teamStatus);
            }
            verdictArray.add(19, TeamStatus.couldBeRelegated);
        }

    }

    private void startOfSeason() {
        for(int i = 0; i < 20; i++)
            verdictArray.add(i, TeamStatus.startOfSeason);
    }

    public void endOfSeasonPlacement(ArrayList<Team> teamList) {
        Team firstTeamInList = teamList.get(0);
        if(firstTeamInList.getGamesPlayed() == 38) {

            verdictArray.add(0, TeamStatus.champions);

            for(int i = 1; i < 4; i++)
                verdictArray.add(i, TeamStatus.championsLeague);

            verdictArray.add(4, TeamStatus.europaLeague);

            for(int i = 5; i < 17; i++){
                verdictArray.add(i, TeamStatus.finalPlace);
            }

            for(int i = 17; i < 20; i++)
                verdictArray.add(i, TeamStatus.definitelyRelegated);

        } else if(firstTeamInList.getGamesPlayed() >= 35) {

            lastLegOfTheSeason(teamList, firstTeamInList);

        }

    }

    public void lastLegOfTheSeason(ArrayList<Team> teamList, Team firstTeamInList) {
        verdictArray.add(0, TeamStatus.chanceOfChampion);

        if(firstTeamInList.getPoints() == teamList.get(0).getPoints()) {
            verdictArray.add(0, TeamStatus.drawingForTitle);
            verdictArray.add(1, TeamStatus.drawingForTitle);

            for(int i = 2; i < 4; i++)
                verdictArray.add(i, TeamStatus.chanceOfChampionsLeague);
        } else {
            for(int i = 1; i < 4; i++)
                verdictArray.add(i, TeamStatus.chanceOfChampionsLeague);
        }
        verdictArray.add(4, TeamStatus.chanceOfEuropaLeague);

        if(teamList.get(4).getPoints() == teamList.get(5).getPoints())
            verdictArray.add(5, TeamStatus.chanceOfEuropaLeague);
        else {
            for(int i = 5; i < 17; i++){
                Team team1 = teamList.get(i);
                Team team2 = teamList.get(i + 1);
                TeamStatus teamStatus = team1.leagueStatus(team1, team2);
                verdictArray.add(i, teamStatus);
            }
        }

        for(int i = 17; i < 20; i++)
            verdictArray.add(i, TeamStatus.highChanceOfRelegation);
    }

    public int getBottomDifference(){
        int bottomDifference = teamList.get(18).getPoints() - teamList.get(19).getPoints() + 1;
        return bottomDifference;
    }

    public ArrayList<Team> getTeamList(){ return teamList; }

    public ArrayList<TeamStatus> getVerdictArray(){
        return verdictArray;
    }

}

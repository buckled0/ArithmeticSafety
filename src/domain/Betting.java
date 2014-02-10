package domain;

import java.text.DecimalFormat;

public class Betting {

    public String name;
    public int goalDifferenceSixGames;
    public int homeWins;
    public int homeLoses;
    public int awayWins;
    public int awayLoses;
    private double pastHomeWinsPercentage = 0.4622;
    private double pastAwayWinsPercentage = 0.2694;

    public Betting(String name, int goalDifferenceSixGames, int homeWins,
                   int homeLoses, int awayWins, int awayLoses) {
        this.name = name;
        this.goalDifferenceSixGames = goalDifferenceSixGames;
        this.homeWins = homeWins;
        this.homeLoses = homeLoses;
        this.awayWins = awayWins;
        this.awayLoses = awayLoses;
    }

    public String getName(){
        return name;
    }
    public int getGoalDifferenceSixGames(){
        return goalDifferenceSixGames;
    }
    public int getHomeWins(){
        return homeWins;
    }
    public int getHomeLoses(){
        return homeLoses;
    }
    public int getAwayWins(){
        return awayWins;
    }
    public int getAwayLoses(){
        return awayLoses;
    }

    public double homeOdds(Betting home, Betting away) {
        double homeTeamOdds;

        if(home.getHomeWins() == 0 || home.getHomeLoses() == 0)
            if(home.getHomeWins() > home.getHomeLoses())
                homeTeamOdds = (1/(0.0156 * (home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames()) +
                        pastHomeWinsPercentage));
            else
                homeTeamOdds = (1/((home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames()) +
                        pastHomeWinsPercentage));


        else {
            homeTeamOdds = (1/(0.0156 * (home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames()) +
                    pastHomeWinsPercentage));
        }

        DecimalFormat finalHomeOdds = new DecimalFormat("#.##");

        return Double.parseDouble(finalHomeOdds.format(homeTeamOdds));
    }

    public double awayOdds(Betting home, Betting away) {
        double awayTeamOdds;

        if(away.getAwayWins() == 0 || away.getAwayLoses() == 0){
            if(away.getAwayWins() > away.getAwayLoses() && home.getHomeWins() > home.getHomeLoses()){
                awayTeamOdds = 1/(0.0003 * (Math.pow(home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames(), 2)) -
                        (0.0127* (home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames())) +
                        pastAwayWinsPercentage);
            }
            else {
                awayTeamOdds = 1/(0.0003 * (Math.pow(home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames(), 2)) -
                        (0.0127 * (home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames())) +
                        pastAwayWinsPercentage);
            }
        } else {
            awayTeamOdds = 1/(0.0003 * (Math.pow(home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames(), 2)) -
                    (0.0127* (home.getGoalDifferenceSixGames() - away.getGoalDifferenceSixGames())) +
                pastAwayWinsPercentage);
        }
        DecimalFormat finalAwayOdds = new DecimalFormat("#.##");

        return Double.parseDouble(finalAwayOdds.format(awayTeamOdds));
    }
}

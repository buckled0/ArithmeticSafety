package domain;

import java.text.DecimalFormat;

public class BettingVerdict {

    public String name;
    public int goalDifferenceSixGames;
    public int homeWins;
    public int homeLoses;
    public int awayWins;
    public int awayLoses;
    private double pastHomeWinsPercentage = 0.4622;
    private double pastAwayWinsPercentage = 0.2694;

    public BettingVerdict(String name, int goalDifferenceSixGames, int homeWins,
                          int homeLoses, int awayWins, int awayLoses) {
        this.name = name;
        this.goalDifferenceSixGames = goalDifferenceSixGames;
        this.homeWins = homeWins;
        this.homeLoses = homeLoses;
        this.awayWins = awayWins;
        this.awayLoses = awayLoses;
    }

    public double homeOdds(BettingVerdict home, BettingVerdict away) {
        double homeTeamOdds;
        double homeTeamNoiseReductionValue;

        if(home.homeLoses == 0 || home.homeWins == 0)
            if(home.homeWins > homeLoses)
                homeTeamOdds = (1/(home.homeWins + (home.goalDifferenceSixGames - away.goalDifferenceSixGames) +
                        pastHomeWinsPercentage)) * 10;
            else
                homeTeamOdds = (1/(home.homeLoses + (home.goalDifferenceSixGames - away.goalDifferenceSixGames) +
                        pastHomeWinsPercentage)) * 10;


        else {
            homeTeamNoiseReductionValue = home.homeWins/home.homeLoses;
            homeTeamOdds = (1/(homeTeamNoiseReductionValue + (home.goalDifferenceSixGames - away.goalDifferenceSixGames) +
                    pastHomeWinsPercentage)) * 10;
        }

        DecimalFormat finalHomeOdds = new DecimalFormat("#.##");

        return Double.parseDouble(finalHomeOdds.format(homeTeamOdds));
    }

    public double awayOdds(BettingVerdict home, BettingVerdict away) {
        double awayTeamOdds;

        System.out.print(Math.pow(home.goalDifferenceSixGames - away.goalDifferenceSixGames, 2));

        awayTeamOdds = 1/((awayWins/awayLoses) + Math.pow(home.goalDifferenceSixGames - away.goalDifferenceSixGames, 2) -
                    (home.goalDifferenceSixGames - away.goalDifferenceSixGames) + pastAwayWinsPercentage) * 100;

        DecimalFormat finalAwayOdds = new DecimalFormat("#.##");

        return Double.parseDouble(finalAwayOdds.format(awayTeamOdds));
    }
}

package domain;

import database.BettingSQLConnector;

import java.util.ArrayList;

public class BettingVerdict {
    public Betting home;
    public Betting away;
    public double homeOdds;
    public double awayOdds;
    public ArrayList<Double> bettingVerdictList = new ArrayList<Double>();

    public BettingVerdict(String homeTeam, String awayTeam){
        BettingSQLConnector bettingSQLConnector = new BettingSQLConnector();
        bettingVerdictList.clear();
        for(int i = 0; i < bettingSQLConnector.getBettingList().size(); i++){
            if(bettingSQLConnector.getBettingList().get(i).getName().equals(homeTeam))
                home = bettingSQLConnector.getBettingList().get(i);
            if(bettingSQLConnector.getBettingList().get(i).getName().equals(awayTeam))
                away = bettingSQLConnector.getBettingList().get(i);
        }

        homeOdds = home.homeOdds(home, away);
        awayOdds = away.awayOdds(home, away);

    }

    public double getHomeOdds(){
        return homeOdds;
    }

    public double getAwayOdds(){
        return awayOdds;
    }

}

package domain;

public class Round {
    private Team team1;
    private Team team2;

    public Round(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Round play(int goalsTeam1, int goalsTeam2) {
        if(goalsTeam1 == goalsTeam2){
            team1.setPoints(1);
            team2.setPoints(1);
        }
        else{
            team1.setPoints(3);
            team2.setPoints(0);
        }

        return this;
    }
}

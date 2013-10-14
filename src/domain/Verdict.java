package domain;

import databaseConnection.LeagueSQLConnector;

import java.util.ArrayList;
import java.util.Iterator;

public class Verdict {

    public ArrayList<String> verdictArray = new ArrayList<String>();

    public Verdict(){

        LeagueSQLConnector leagueSQLConnector = new LeagueSQLConnector();
        Iterator<Integer> iterator = leagueSQLConnector.pointsList.iterator();
        int i = 1;

        while(iterator.hasNext()){
            int team1 = iterator.next();
            if(iterator.next() != null){
                int team2 = leagueSQLConnector.pointsList.get(i);
                System.out.print(team1 + " " + team2 + " ");
                i++;
            }
            else
                break;
        }

    }
}

package databaseConnection;

import domain.Team;

import java.sql.*;
import java.util.ArrayList;


public class LeagueSQLConnector {

    String url = "jdbc:mysql://localhost:3306/test";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "daniel";
    String password = "JBaxter2011";
    public ArrayList<Team> teamList = new ArrayList<Team>();
    public ArrayList<Integer> pointsList = new ArrayList<Integer>();

    public LeagueSQLConnector(){

        try {

            Class.forName(driver);

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your MySQL JDBC Driver?");

            e.printStackTrace();

            return;

        }

        System.out.println("Established a connection");
        Connection connection = null;



        try {

            connection = DriverManager.getConnection(url, userName, password);
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("select * from `test`.`Premier_League`" +
                    "ORDER BY Points DESC, Goal_Difference DESC;");


            while(res.next()){
                teamList.add(new Team(res.getString("Team_Name"), res.getInt("Goal_Difference"),
                        res.getInt("Points")));
                pointsList.add(new Integer(res.getInt("Points")));
            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");

            e.printStackTrace();

            return;

        }

    }

    public ArrayList<Team> getTeamList(){
        return teamList;
    }

    public ArrayList<Integer> getPointsList(){
        return pointsList;
    }

}

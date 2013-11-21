package database;

import domain.Team;

import java.sql.*;
import java.util.ArrayList;

public class LeagueSQLConnector {

    private String url = "jdbc:mysql://localhost:3306/test";
    private String driver = "com.mysql.jdbc.Driver";
    private String userName = "daniel";
    private String password = "JBaxter2011";
    private Connection connection = null;
    private Statement st = null;
    private ResultSet res = null;
    public ArrayList<Team> teamList = new ArrayList<Team>();

    public LeagueSQLConnector(){

        try {

            Class.forName(driver);

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your MySQL JDBC Driver?");

            e.printStackTrace();

            return;

        }

        System.out.println("Established a connection");

        try {

            connection = DriverManager.getConnection(url, userName, password);
            st = connection.createStatement();
            res = st.executeQuery("select * from `test`.`Premier_League`" +
                    "ORDER BY Points DESC, Goal_Difference DESC;");
            while(res.next()){
                pointsList.add(res.getInt("Points"));
                teamList.add(new Team(res.getString("Team_Name"), res.getInt("Goal_Difference"),
                        res.getInt("Points"), res.getInt("Games_Played")));
            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");

            e.printStackTrace();

        } finally {
            try { res.close(); } catch (SQLException e) {   }
            try { st.close(); } catch (SQLException e) {   }
            try { connection.close(); } catch (SQLException e) {   }
        }

    }

    public ArrayList<Team> getTeamList(){
        return teamList;
    }

}

package databaseConnection;

import domain.Team;

import java.sql.*;
import java.util.ArrayList;

public class LaLigaConnector {
    String url = "jdbc:mysql://localhost:3306/test";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "daniel";
    String password = "JBaxter2011";
    String teamName;
    int goalDifference;
    int points;
    public ArrayList<Team> team = new ArrayList<Team>();


    public LaLigaConnector(){

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
                ResultSet res = st.executeQuery("select * from `La Liga`");


                while(res.next()){
                    team.add(new Team(res.getString("Team_Name"), res.getInt("Goal_Difference"),
                            res.getInt("Points")));
                }

            } catch (SQLException e) {

                System.out.println("Connection Failed! Check output console");

                e.printStackTrace();

                return;

            }

        }

        public ArrayList<Team> getTeamNm(){
            return team;
        }


    }


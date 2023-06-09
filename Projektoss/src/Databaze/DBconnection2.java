package Databaze;

import java.sql.*;

public class DBconnection2 {
    
	private static Connection conn;

    public DBconnection2() {
        try {
            
        	Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:sqlite\\animovanyFilmy.db");
        } 
        
        	catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } 
        
        	catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static void createTable2() {
		
		try {
	        
			Statement statement = conn.createStatement();
	        statement.execute("DROP TABLE IF EXISTS animovanyFilmy");
	        statement.execute("CREATE TABLE IF NOT EXISTS animovanyFilmy (id INTEGER PRIMARY KEY, title TEXT, director TEXT, year INTEGER, animators TEXT, rating INTEGER, ratingText TEXT, ageRating INTEGER)");
	    } 
		
			catch (SQLException e) {
	        System.out.println("Error creating table: " + e.getMessage());
	    }
	}

	public static void insertMovie2(String title, String director, int year, String animators, int rating, String ratingText, int ageRating) {
		
		try {
	        
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO animovanyFilmy (title, director, year, animators, rating, ratingText, ageRating) VALUES (?, ?, ?, ?, ?, ?, ?)");
	        preparedStatement.setString(1, title);
	        preparedStatement.setString(2, director);
	        preparedStatement.setInt(3, year);
	        preparedStatement.setString(4, animators);
	        preparedStatement.setInt(5, rating);
	        preparedStatement.setString(6, ratingText);
	        preparedStatement.setInt(7, ageRating);
	        preparedStatement.executeUpdate();
	    } 
		
			catch (SQLException e) {
	        System.out.println("Error inserting movie: " + e.getMessage());
	    }
	}
}

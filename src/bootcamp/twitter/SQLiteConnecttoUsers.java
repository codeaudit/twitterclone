package bootcamp.twitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;

/**
 * 
 * @author sqlitetutorial.net
 */
public class SQLiteConnecttoUsers {
	/**
	 * Connect to a sample database
	 */
	public static void connectUsers(int searchUser) {
		Connection conn = null;
		PreparedStatement selectUser = null;
		
		try {
			// db parameters
			String url = "jdbc:sqlite:C:/Users/admin/slyone/day4/twitterclone/data/test5.db";
            ResultSet rs;
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite Users table has been established.");
				
			String selectStringUsers = "SELECT * FROM Users WHERE id = ?";
		    selectUser = conn.prepareStatement(selectStringUsers);
			selectUser.setInt(1, searchUser);
		    rs = selectUser.executeQuery();
			System.out.println(selectStringUsers);
	
            while (rs.next()) {
            	int    id       = rs.getInt(1);
                String username = rs.getString(2);
                String avatar = rs.getString(3);
                String follows = rs.getString(4);
                System.out.println("Result: " + id + " " + username + " " + avatar + " " + follows);
            }
            //conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	// **********************************Connect to Tweets table
	public static void connectTweets(int searchUserTweets) {
		Connection conn = null;
		PreparedStatement selectTweets = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:C:/Users/admin/slyone/day4/twitterclone/data/test5.db";
            ResultSet rs;
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite Tweets table has been established.");
			
			String selectStringTweets = "SELECT * FROM Tweets WHERE tweet_id = ?";
		    selectTweets = conn.prepareStatement(selectStringTweets);
			selectTweets.setInt(1, searchUserTweets);
		    rs = selectTweets.executeQuery();
			System.out.println(selectStringTweets);
			
            while (rs.next()) {
                int tweet_id = rs.getInt(1);
                int user_id = rs.getInt(2);
                String message = rs.getString(3);
                String hit_time = rs.getString(4);
                System.out.println("Result: " + tweet_id + " " + user_id + " " + message + " " + hit_time);
            }
            conn.close();			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	// **********************************Connect to Tweets table
	public static void connectFollowers(int searchFollower) {
		Connection conn = null;
		PreparedStatement selectFollowers = null;
		
		try {
			// db parameters
			String url = "jdbc:sqlite:C:/Users/admin/slyone/day4/twitterclone/data/test5.db";
            ResultSet rs;
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite Followers table has been established.");
			
			String selectStringFollowers = "SELECT * FROM Followers WHERE id = ?";
		    selectFollowers = conn.prepareStatement(selectStringFollowers);
			selectFollowers.setInt(1, searchFollower);
		    rs = selectFollowers.executeQuery();
			System.out.println(selectStringFollowers);
						
			while (rs.next()) {
	            int          id = rs.getInt(1);
                int follower_id = rs.getInt(2);
                int followed_id = rs.getInt(3);
                System.out.println("Result: " + id + " " + follower_id + " " + followed_id);
            }
            conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		connectUsers(1);
		connectTweets(2);
		connectFollowers(1);
	}
}
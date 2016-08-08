package bootcamp.twitter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ViewNewsFeedServlet extends HttpServlet {
	private String greeting = "Twitter Clone!";
	private String ret_user = null;
	private String ret_tweets = null;
	private String ret_followers = null;
	private String [] json_array;

	public ViewNewsFeedServlet() {
	}

	public ViewNewsFeedServlet(String greeting) {
		this.greeting = greeting;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);

		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		request.getParameter("user");
		//JSONObject obj = new JSONObject();
		//obj.put("message", "database opened!");
		//obj.put("class", getClass().getName());
		//obj.put("session", request.getSession(true).getId());
				
		//JSONArray list = new JSONArray();
		//list.add(obj);

		
		String userstr = request.getParameter("user");
		int searchUser = Integer.parseInt(userstr);	
		int searchUserTweets = searchUser;
		int searchFollower = searchUser;	
		
		connectUsers(searchUser);
		connectTweets(searchUserTweets);
		connectFollowers(searchFollower);
		
		

		response.getWriter().print(ret_user);
		response.getWriter().print(ret_tweets);
		response.getWriter().print(ret_followers);
		
	}

	public void connectUsers(int searchUser) {
		Connection conn = null;
		PreparedStatement selectUser = null;

		try {
			// db parameters
			String url = "jdbc:sqlite:C:/Users/admin/slyone/day4/twitterclone/data/test5.db";
			ResultSet rs;
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out
					.println("Connection to SQLite Users table has been established.");

			String selectStringUsers = "SELECT * FROM Users WHERE id = ?";
			selectUser = conn.prepareStatement(selectStringUsers);
			selectUser.setInt(1, searchUser);
			rs = selectUser.executeQuery();
			System.out.println(selectStringUsers);

			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String avatar = rs.getString(3);
				String follows = rs.getString(4);
				
				System.out.println("User: " + id + " " + username + " "
						+ avatar + " " + follows);
				ret_user = "[{\"id\"" + ":" + id + "," + "\"username\"" +":\"" + username + "\"" + 
						"," + "\"avatar\"" + ":" + "\"avatar\""+","+"\"follows\"" + ":\""+follows+"\"" +"}";

			}
			// conn.close();
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
	public void connectTweets(int searchUserTweets) {
		Connection conn = null;
		PreparedStatement selectTweets = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:C:/Users/admin/slyone/day4/twitterclone/data/test5.db";
			ResultSet rs;
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out
					.println("Connection to SQLite Tweets table has been established.");

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
				System.out.println("Tweets: " + tweet_id + " " + user_id + " "
						+ message + " " + hit_time);
				ret_tweets = ",{\"id\"" + ":" + user_id + "," + "\"message\"" + ":\""+message+"\"" +
						"," + "\"time\""+":\""+hit_time+"\""+"}";

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
	public void connectFollowers(int searchFollower) {
		Connection conn = null;
		PreparedStatement selectFollowers = null;

		try {
			// db parameters
			String url = "jdbc:sqlite:C:/Users/admin/slyone/day4/twitterclone/data/test5.db";
			ResultSet rs;
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out
					.println("Connection to SQLite Followers table has been established.");

			String selectStringFollowers = "SELECT * FROM Followers WHERE id = ?";
			selectFollowers = conn.prepareStatement(selectStringFollowers);
			selectFollowers.setInt(1, searchFollower);
			rs = selectFollowers.executeQuery();
			System.out.println(selectStringFollowers);

			while (rs.next()) {
				int id = rs.getInt(1);
				int follower_id = rs.getInt(2);
				int followed_id = rs.getInt(3);
				System.out.println("Followers: " + id + " " + follower_id + " "
						+ followed_id);
				ret_followers = ",{\"follower\"" + ":" + follower_id + "," + "\"followed\""+":" +
						followed_id+"}]"; 
				//		+ followed_id;
				//ret_tweets = ",{\"id\"" + ":" + user_id + "," + "\"message\"" + ":\""+message+"\"" +
				//		"," + "\"time\""+":\""+hit_time+"\""+"}";
				
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
}
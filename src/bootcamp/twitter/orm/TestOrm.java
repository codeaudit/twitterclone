package bootcamp.twitter.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class TestOrm {

	ConnectionSource  connectionSource;
	Dao<User, Integer> userDao; 
	Dao<Follower, Integer> followerDao; 
	Dao<Tweet, Integer> tweetDao; 
	
	@Before
	public void setUp() throws Exception {
		connectionSource =
				  new JdbcConnectionSource("jdbc:sqlite:test.db");
		
		TableUtils.createTableIfNotExists(connectionSource, User.class);
		TableUtils.createTableIfNotExists(connectionSource, Tweet.class);
		TableUtils.createTableIfNotExists(connectionSource, Follower.class);
		
		
		userDao = 
				  DaoManager.createDao(connectionSource, User.class);
		followerDao = 
				  DaoManager.createDao(connectionSource, Follower.class);
		tweetDao = 
				  DaoManager.createDao(connectionSource, Tweet.class);
	}

	@After
	public void tearDown() throws Exception {
		connectionSource.close();
	}
	
	@Test
	public void testUser() throws SQLException {
		User user = new User("user1", "pass", "avatar");
		
		userDao.create(user);
		
		userDao.create(new User("user" + Math.random(), "pass", "avatar"));
	}

	
	@Test
	public void testTweet() throws SQLException {
		Tweet tweet = new Tweet("this is a tweet " + Math.random(), "user1");
		
		tweetDao.create(tweet);
		
	}
	
	@Test
	public void testFollower() throws SQLException {
		Follower follower= new Follower(0, 1);
		
		followerDao.create(follower);
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		String json = gson.toJson(this);  
		return json;
	}

}

package bootcamp.twitter.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import com.google.gson.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import bootcamp.twitter.orm.Follower;
import bootcamp.twitter.orm.Tweet;
import bootcamp.twitter.orm.User;

public class ViewTweets 
{
    private String greeting="Twitter Clone!";
    public ViewTweets(){}
    public ViewTweets(String greeting)
    {
        this.greeting=greeting;
    }
    
    public List execute(Map request) 
    {
        ConnectionSource  connectionSource;
    	Dao<User, Integer> userDao; 
    	Dao<Follower, Integer> followerDao; 
    	Dao<Tweet, Integer> tweetDao = null;
        
        tweetDao = setup(tweetDao);
    	
	        
        //List<Tweet> list = new ArrayList<Tweet>();
       
        List<Tweet> list = queryTweets(request, tweetDao);


        /*
        for (Tweet tweet: tweetDao) { 
       	 list.add(tweet);
		}
		*/
        
        Collections.sort((List<Tweet>)list, new Comparator<Tweet>() {

			@Override
			public int compare(Tweet o1, Tweet o2) {
				if( o1.getHitTime() != null && o2.getHitTime() != null)
					return  - o1.getHitTime().compareTo(o2.getHitTime());
				return 0;
				}
		});
        
        return list;
    }
	private List<Tweet> queryTweets(Map request, Dao<Tweet, Integer> tweetDao) {
		// get our query builder from the DAO
        QueryBuilder<Tweet, Integer> queryBuilder =
          tweetDao.queryBuilder();
        // query for all accounts that have "qwerty" as a password
		List<Tweet> list = new ArrayList<Tweet>();
		try {
			String user = (String) request.get("user");
			if( user.isEmpty() ) user = "user1";
				System.out.println("USER IS EMPTY!");
			// the 'password' field must be equal to "qwerty"
			queryBuilder.where().eq("userId", user);
			// prepare our sql statement
			PreparedQuery<Tweet> preparedQuery = queryBuilder.prepare();
			list = tweetDao.query(preparedQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
    
	private Dao<Tweet, Integer> setup(Dao<Tweet, Integer> tweetDao) {
		ConnectionSource connectionSource;
		Dao<User, Integer> userDao;
		Dao<Follower, Integer> followerDao;
		try {
			connectionSource =
					  new JdbcConnectionSource("jdbc:sqlite:test.db");
			
			userDao = 
					  DaoManager.createDao(connectionSource, User.class);
			followerDao = 
					  DaoManager.createDao(connectionSource, Follower.class);
			tweetDao = 
					  DaoManager.createDao(connectionSource, Tweet.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweetDao;
	}
	
	
	public List<Tweet> add(Map map) {
		ConnectionSource  connectionSource;
    	Dao<User, Integer> userDao; 
    	Dao<Follower, Integer> followerDao; 
    	Dao<Tweet, Integer> tweetDao = null;
        
        tweetDao = setup(tweetDao);
    	
	        
        //List<Object> list = new ArrayList<Object>();
        
        
        Tweet newTweet = new Tweet();
        newTweet.setMessage((String) map.get("message"));
        newTweet.setUserId((String) map.get("user"));
        
        System.out.println("newTweet:" + newTweet);
        
        try {
			tweetDao.create(newTweet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        List<Tweet> list = queryTweets(map, tweetDao);

        
        return list;
		
	}
}
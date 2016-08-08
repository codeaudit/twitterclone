package bootcamp.twitter.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import com.google.gson.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import bootcamp.twitter.orm.Follower;
import bootcamp.twitter.orm.Tweet;
import bootcamp.twitter.orm.User;

public class ViewUsers 
{
    private String greeting="Twitter Clone!";
    public ViewUsers(){}
    public ViewUsers(String greeting)
    {
        this.greeting=greeting;
    }
    
    public List<Object> execute(Map request) 
    {
        ConnectionSource  connectionSource;
    	Dao<User, Integer> userDao = null; 
    	Dao<Follower, Integer> followerDao; 
    	Dao<Tweet, Integer> tweetDao = null;
        
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
    	
	        
        List<Object> list = new ArrayList<Object>();
       

        
        for (User user: userDao) { 
       	 list.add(user);
		}
        
        return list;
    }
}
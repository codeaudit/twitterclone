package bootcamp.twitter.orm;

import java.sql.Timestamp;
import java.util.Date;

import com.google.gson.Gson;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

// create table Tweets(id int primary key, user_id int, message varchar(140), hit_time timestamp, foreign key(user_id) references Users(id));
@DatabaseTable(tableName = "Tweets")
public class Tweet {


	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField
	String userId;
	@DatabaseField
	String message;
	@DatabaseField
	Date hitTime = new Date();
	
	

	public Tweet() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Tweet(String message, String user) {
		super();
		this.message = message;
	    this.userId = user;
	}



	public int getId() {
		return id;
	}
	
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getHitTime() {
		return hitTime;
	}
	public void setHitTime(Date hitTime) {
		this.hitTime = hitTime;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		String json = gson.toJson(this);  
		return json;
	}
	
}

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
	int userId;
	@DatabaseField
	String message;
	@DatabaseField
	Date hitTime = new Date();
	
	

	public Tweet() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Tweet(String message, int user) {
		super();
		this.message = message;
	    this.userId = user;
	}



	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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

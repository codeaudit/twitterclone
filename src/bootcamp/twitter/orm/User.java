package bootcamp.twitter.orm;

import com.google.gson.Gson;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Users")
public class User {
	
	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField
    private String username;
	@DatabaseField
    private String fullname;
    @DatabaseField
    private String password;
    @DatabaseField
    private String avatar;
    @DatabaseField
    private String profile;

	




	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	
	public User( String username, String password, String avatar) {
		super();
		this.username = username;
		this.password = password;
		this.avatar = avatar;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getAvatar() {
		return avatar;
	}




	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}




	public int getId() {
		return id;
	}

	public String getProfile() {
		return profile;
	}




	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		String json = gson.toJson(this);  
		return json;
	}

	
    
}

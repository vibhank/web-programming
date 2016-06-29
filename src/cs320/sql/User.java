package cs320.sql;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String first;
	private String last;
	
	public User(int id, String first, String last, String username, String password){
		this.first = first;
		this.last = last;
		this.username = username;
		this.id = id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
	

}

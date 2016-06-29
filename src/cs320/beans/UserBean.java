package cs320.beans;

public class UserBean {

	private String email;
	private String password;
	private String firstName;
	
	public UserBean(String email, String password, String firstName) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}

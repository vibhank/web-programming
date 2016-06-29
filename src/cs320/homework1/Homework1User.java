package cs320.homework1;

public class Homework1User {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String repassword;
	private String zipcode;

public Homework1User(String firstname,String lastname,String email, String password,String zipcode){
	super();
	this.firstname=firstname;
	this.lastname=lastname;
	this.email=email;
	this.password=password;
	//this.repassword=repassword;
	this.zipcode=zipcode;
	
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
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

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
}
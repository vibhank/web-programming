package cs320.Registration;

import java.util.Date;

public class Fields {
	private String name;
	private String Email;
	private String Phone;
	private String Password ;
	private String Address;
	
	public Fields(String name, String Email, String Phone, String Password , String Address ) {
		super();
		this.name = name;
		this.Email = Email;
		this.Phone = Phone;
		this.Password = Password;
		this.Address = Address;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	

}

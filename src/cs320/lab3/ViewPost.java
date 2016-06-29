package cs320.lab3;

import java.util.Date;

public class ViewPost {
	private String name;
	private Date date;
	private String message;
	private String image;
	//private String imageName;
	
	public ViewPost(String name, String message, String image) {
		super();
		this.name = name;
		this.message = message;
		this.image = image;
		this.date = new Date();
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public String getComment() {
		return message;
	}
	
	public String getImage() {
		
		return image;
	}
	
	/*public String getImageName() {
		return imageName;
	}*/
	
	
	
}


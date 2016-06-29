package cs320.guestbook;

import java.util.Date;

public class GuestBookPost {
	private String name;
	private Date date;
	private String comment;
	
	public GuestBookPost(String name, String comment) {
		super();
		this.name = name;
		this.comment = comment;
		this.date = new Date();
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public String getComment() {
		return comment;
	}
	
	
	
}

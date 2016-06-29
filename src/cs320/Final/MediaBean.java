package cs320.Final;

import java.sql.Date;

import javax.print.attribute.DateTimeSyntax;

public class MediaBean {
	private int id;
	private String type;
	private String title;
	private Date date;
	private boolean ifLoan ;
	private DateTimeSyntax lent;
	private String borrower;
	
	
	public MediaBean(int id, String type, String title,Date date, boolean ifLoan, String borrower){
		this.type = type;
		this.title = title;
		this.date = date;
		this.ifLoan = ifLoan;
		this.borrower = borrower;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public boolean isIfLoan() {
		return ifLoan;
	}


	public void setIfLoan(boolean ifLoan) {
		this.ifLoan = ifLoan;
	}


	public DateTimeSyntax getLent() {
		return lent;
	}


	public void setLent(DateTimeSyntax lent) {
		this.lent = lent;
	}


	public String getBorrower() {
		return borrower;
	}


	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	

}

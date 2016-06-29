package cs320.Midterm;


import java.util.Date;

public class View {
	private Integer id;
	private String Make;
	private String Model;
	private String Year;
	
	
	public View(int id , String Make, String Model, String Year) {
		super();
		this.id = id;
		this.Make = Make;
		this.Model = Model;
		this.Year = Year;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMake() {
		return Make;
	}


	public void setMake(String make) {
		Make = make;
	}


	public String getModel() {
		return Model;
	}


	public void setModel(String model) {
		Model = model;
	}


	public String getYear() {
		return Year;
	}


	public void setYear(String year) {
		Year = year;
	}

	
	
	
	
	
	
}


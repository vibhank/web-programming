package cs320.homework3;

public class CoffeeShopBean {
	
	public int StoreNumber;
	public double distance;
	public String Zip; 
	public String Name;
	public String Street;
	public String City;
	public String Phone;
	public double Latitude;
	public double Longitude;
	
	
	

	public CoffeeShopBean(int StoreNumber,String Name,String Street, String City, String Zip, String Phone, double Latitude, double Longitude, double distance) {
		super();
		
		this.StoreNumber = StoreNumber;
		this.Name = Name;
		this.Street = Street;
		this.City = City;
		this.Zip = Zip;
		this.Phone = Phone;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		this.distance = distance;
		
		
	}
	
	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}



	public int getStoreNumber() {
		return StoreNumber;
	}


	public void setStoreNumber(int storeNumber) {
		StoreNumber = storeNumber;
	}


	public String getZip() {
		return Zip;
	}


	public void setZip(String zip) {
		Zip = zip;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getStreet() {
		return Street;
	}


	public void setStreet(String street) {
		Street = street;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public double getLatitude() {
		return Latitude;
	}


	public void setLatitude(double latitude) {
		Latitude = latitude;
	}


	public double getLongitude() {
		return Longitude;
	}


	public void setLongitude(double longitude) {
		Longitude = longitude;
	}
}

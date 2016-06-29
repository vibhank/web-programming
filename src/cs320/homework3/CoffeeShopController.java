package cs320.homework3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.sql.User;


@WebServlet("/homework3/CoffeeShopController")
public class CoffeeShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Construct the URL			
		String username = "cs320stu25";
		String password = "qbHUfYwX";
		String host 	= "cs3.calstatela.edu";
		String port   	= "3306";
		String dbName 	= "cs320stu25";

		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		
		try{
			
			// Dynamically include the MySQL Driver
			System.out.println("Class.forName");
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();

			// Instantiate the Driver
			Driver driver = new org.gjt.mm.mysql.Driver();

			// Connect to the database
			System.out.println("Creating Connection");
			Connection connection = DriverManager.getConnection(url, username, password);
			
			// Create Statement
			System.out.println("Creating Statement");			
			Statement statement = connection.createStatement();
			
			// Create SQL query
		
		Double Latquery = null ;
		Double Longiquery = null;

		System.out.println(">>>>>>>>>");
		String Lat = request.getParameter("latitude");
		String Lon = request.getParameter("longitude");
		String Radius = request.getParameter("radius");
		
		ArrayList<CoffeeShopBean> users = new ArrayList<CoffeeShopBean>();
		System.out.println(Lat+"------"+Lon+"------"+Radius);
		
		// If any field is null
		
		
		if(Lat != null && Lon != null && Radius.trim().length() != 0){
		    String query = "SELECT * FROM CoffeeShop" ;
			int r = Integer.parseInt(Radius);
			System.out.println("query: "+query);
			
			ResultSet resultSet = statement.executeQuery(query);
			
			System.out.println("Iterating Over Results");
			while(resultSet.next()){
			
			Latquery = resultSet.getDouble("Latitude");
			Longiquery = resultSet.getDouble("Longitude");
			String name= resultSet.getString("Name");
			
			double x1 = Math.toRadians(Latquery);
			double y1 = Math.toRadians(Longiquery);
			double x2=  Math.toRadians(Double.parseDouble(Lat));
			double y2=  Math.toRadians(Double.parseDouble(Lon));
			
			double distance = Math.acos(Math.sin(x1) * Math.sin(x2)+Math.cos(x1)*Math.cos(x2)*Math.cos(y1-y2));
			distance = Math.toDegrees(distance);
			float Distance = (float) (69.1105*distance);
			
			System.out.println(name+"distance: "+Distance);
			System.out.println("radius: "+r);
			
			if(Distance <= r ){
				System.out.println("Adding");
				users.add(new CoffeeShopBean(resultSet.getInt("StoreNumber"),
						
						resultSet.getString("Name"),
						           resultSet.getString("Street"),
						           resultSet.getString("City"),
								   resultSet.getString("Zip"),
								   resultSet.getString("Phone"),
								   resultSet.getDouble("Latitude"),
								   resultSet.getDouble("Longitude"),
								   Distance
								   
						));
			}
		  }
		}
		
			// Tidy Up
			connection.close();
			
			request.setAttribute("CoffeeShopBeans", users);
			
			System.out.println("Dispatching");
			request.getRequestDispatcher("../WEB-INF/homework3/CoffeeShopView.jsp").forward(request,response);
			
		}catch (SQLException sqle){
			System.out.println(sqle.getMessage());
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
package cs320.Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Final/DisplayMedia")
public class DisplayMedia extends HttpServlet {
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
			
			String select = "SELECT * ";
			String from   = "FROM `Media` ";
			
			String searchTerm = request.getParameter("title");			
			String where  = "WHERE `Media`.`title` LIKE '%" + searchTerm + "%' "  ;
			
			
			String query = "SELECT * FROM Media " + (searchTerm != null ? where : "");
			//String query = "SELECT * FROM users " + ( where );
			
			System.out.println("Executing Query: " + query);
			ResultSet resultSet = statement.executeQuery(query);
			
			ArrayList<MediaBean> users = new ArrayList<MediaBean>();
			
			System.out.println("Iterating Over Results");
			while(resultSet.next()){
				users.add(new MediaBean(resultSet.getInt("id"),
								   resultSet.getString("type"),
								   resultSet.getString("title"),
								   resultSet.getDate("date"),
								   resultSet.getBoolean("ifLoan"),
								   resultSet.getString("borrower") ));
			}
			// Tidy Up
			connection.close();
			
			request.setAttribute("MediaBeans", users);
			
			System.out.println("Dispatching");
			request.getRequestDispatcher("../WEB-INF/Final/DisplayMedia.jsp").forward(request,response);
			
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
package cs320.Final;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;




import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Final/AddMedia")
public class AddMedia extends HttpServlet {
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
					
					String title = request.getParameter("title");	
					String type = request.getParameter("type");	
					
					// Create SQL query
					Date date = new Date ();
					String d = new SimpleDateFormat("DD-MM-YY").format(date);
					
					
					if(title != null && !type.equals("SelectOne")){
						//if (title.trim().length() == 0){
					    String query = "INSERT INTO Media VALUES(NULL,'" + type + "','" + title + "','" + d + "',NULL,NULL,NULL)" ;		
					
					System.out.println("Executing Query: " + query);
					int resultSet = statement.executeUpdate(query);
					
					ArrayList<MediaBean> users = new ArrayList<MediaBean>();
					
					}
					
					// Tidy Up
					connection.close();
					
					//request.setAttribute("MediaBeans", users);
					
					System.out.println("Dispatching");
					request.getRequestDispatcher("../WEB-INF/Final/AddMedia.jsp").forward(request,response);
					
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
package cs320.Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.Base64;

import cs320.homework1.Homework1User;


@WebServlet("/Homework2/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public void init() throws ServletException {
		
		ArrayList<Homework1User> users = new ArrayList<Homework1User>();
		users.add(new Homework1User("John", "Doe", "john@doe.com", "1!", "91801"));
		getServletContext().setAttribute("Homework1Users", users);
	
	    
     
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isValidFirstname = true;
		
		
		PrintWriter out = response.getWriter();	
		ArrayList<Homework1User> users = (ArrayList<Homework1User>) this.getServletContext().getAttribute("Homework1Users");
		
			out.println("<!DOCTYPE html>");
			
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
			out.println("<title>"
					+ "</title>");
			out.println("</head>");
			
			out.println("<body class=\"bg-success\">");
			out.println("<div class=\"page-header bg-warning text-primary\">");
			out.println("<h1>");
			out.println("Login: ");
			/*out.println("<small>CS 320</small>");*/
			/*(shwetlana)*/
			out.println(" </h1>");
			out.println("</div>");
			
			out.println("<form action='Login' method='post'>");
			
			
            out.println("<table class= \"table table-bordered\">");
			
			/*System.out.println("firstname: "+users.get(0).getFirstname());
			System.out.println("password: "+users.get(0).getPassword());*/
			
			String firstname = request.getParameter("firstname"); 
			//String email = request.getParameter("email"); 
			String password = request.getParameter("password");
			
			
			if( request.getParameter("firstname") != null && request.getParameter("password") != null ){
				for(Homework1User u: users){
					
				/*System.out.println("x1 " +u.getFirstname()+"y1 " +u.getPassword());
				System.out.println("x2 " +request.getParameter("firstname")+"y2 " +request.getParameter("password"));*/
				
			if(request.getParameter("firstname").equals(u.getEmail()) && request.getParameter("password").equals( u.getPassword())){
				
				System.out.println("x3 " +request.getParameter("firstname")+"y3 " +request.getParameter("password"));
				if(request.getParameter("rememberme")!= null){
					 try {
							MessageDigest md = MessageDigest.getInstance("SHA-256");
							md.reset();

							byte[] username = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(firstname);
							md.update(username);
							byte[] value1 = md.digest(username);
							
							String usernamecode = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(value1);
							System.out.println("sha.."+usernamecode);
						

						    Cookie cookie = new Cookie("hw2hash",usernamecode);
							cookie.setMaxAge(60*60*24*14); // cookie stored for 14days
							response.addCookie(cookie);	
							
							System.out.println(cookie.getValue());
							
							
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }
				 
				HttpSession session=request.getSession();
				session.setAttribute("Homework2User", u);
				
				response.sendRedirect("../Homework2/Welcome");
			}
			}//for loop close
				isValidFirstname = false;
				out.println("<p class=\"text-danger\">Invalid Username/ Password</p>");
		
			} 
			
			 isValidFirstname = true;

			 out.println("</table>");
			    
               /* if (isValidFirstname != true)
                	out.println("<p class=\"text-danger\">Invalid Username/ Password</p>");*/
	             
            
			    out.println("<p>Username: </p>");
			    out.print("   <input name=\"firstname\" ");
				out.println(" type=\"text\" class=\"form-control\" placeholder=\"First Name\"><br />");
				
				out.println("<p>Password:</p>");
				out.print("   <input name=\"password\" ");
				out.println(" type=\"password\" class=\"form-control\" placeholder=\"Password\"><br />");
			
			    out.println("</br>");
			    out.println("<div class=\"checkbox\"><label><input name= \"rememberme\" type=\"checkbox\"> REMEMBER ME </label></div></br>");
					
			
			out.println("<input type='submit' class=\"btn btn-primary\" value='Login' />"); 
			
			
			out.println("<br><br>");
			out.println("</form>");
			out.println("</body>");
			
			
			out.println("</html>");

			
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		}
	}



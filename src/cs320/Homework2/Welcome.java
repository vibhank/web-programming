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

import cs320.homework1.Homework1User;


@WebServlet("/Homework2/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        ArrayList<Homework1User> users = (ArrayList<Homework1User>) this.getServletContext().getAttribute("Homework1Users");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		    out.println("<!DOCTYPE html>");
			
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
			
			out.println("<title>WELCOME USER</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"page-header bg-danger text-success\">");
			/*out.println("<h1>");
			out.println("Welcome User");
			out.println(" </h1>");
			*/
			//Cookie loginCookie = null;
			
			if(session.getAttribute("Homework2User") != null)
			{
				Homework1User welcome = (Homework1User)session.getAttribute("Homework2User");
				/*for(Homework1User us : users){	
					
			    if(session.getAttribute("Homework2User").equals(us.getFirstname()))*/
				out.println("<h1> Welcome : <small>" +welcome.getFirstname()+"<div class=\"col-md-2\"></small>"
						//+"<div class=\"col-md-2\">"
						+ "<img src=\"../Images/smiley.png\" alt=\"Smile\" class=\"img-circle img-responsive\" />"
						 
						+"</h1>");
				
		
				
			}
				if(session.getAttribute("Homework2User") == null){
			
				Cookie[] cookies = request.getCookies();
		        if (cookies != null) {
		            for (Cookie cookie : cookies) {
		                if (cookie.getName().equals("hw2hash")) {
		                    //loginCookie = cookie;
		                    for(Homework1User us : users){
		                    	
		                    	try{
		                    	MessageDigest md = MessageDigest.getInstance("SHA-256");
								md.reset();

								byte[] username = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(us.getEmail());
								md.update(username);
								byte[] value1 = md.digest(username);
								
								String usernamecode = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(value1);
								System.out.println("cokieeeeee"+cookie.getValue());
								System.out.println("username"+cookie.getValue());
								
		                    	if(cookie.getValue().equals(usernamecode)){
		                    	out.println("<h1> Welcome : <small>" +us.getFirstname()+"<div class=\"col-md-2\"></small>"
		                    			+ "<img src=\"../Images/bluesmiley.png\" alt=\"Green Smile\" class=\"img-circle img-responsive\" />"
		                    			+ "</h1>");
		                    	}
		                    	
		                    	
		                    }
		                    	catch (NoSuchAlgorithmException e) {
		    						// TODO Auto-generated catch block
		    						e.printStackTrace();
		    					}
		                    } 
		                    
		                    
		                } else {
                    		cookie.setMaxAge(0);
                    		response.sendRedirect("../Homework2/Login");
	                    }
		            }
		        }
		        else{
		        	
		        	response.sendRedirect("../Homework2/Login");
		        }
			}
				
		
			out.println("</div>");
			
			
			
			out.println("</body>");
			out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

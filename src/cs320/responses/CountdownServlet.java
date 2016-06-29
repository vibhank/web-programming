package cs320.responses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/CountdownServlet")
public class CountdownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// If the request contains a "countdown" parameter, 
		// and the parameter is a positive integer
		// then we will create a cookie named "countdown" and store the value
		try{
			int countdown = Integer.parseInt(request.getParameter("countdown"));
			
			Cookie cookie = new Cookie("countdown", Integer.toString(countdown) );
			response.addCookie( cookie );
			
			response.sendRedirect("CountdownServlet");
		}catch (Exception e){
		
		}
		
		int count = 0; // Defined here for scope
		
		// Else, if a cookie exists named "countdown", decrement the value
		// by 1, and respond with a REFRESH header field
		if (request.getParameter("countdown") == null){
			Cookie[] cookies = request.getCookies();
			
			if (cookies != null){
				for (int i = 0; i < cookies.length; i++){
					Cookie c = cookies[i];
					
					if (c.getName().equals("countdown")){
						count = Integer.parseInt(c.getValue());
						if (count > 0){
							Cookie newCountdown = new Cookie("countdown", Integer.toString(count-1));
							response.addCookie(newCountdown);
							response.setIntHeader("Refresh", 1);
						}
						break;
					}
				}
			}
		}
		
		// Else, simply display the page
		
		
		// Set the content type
		response.setContentType("text/html");
		
		// Set my refresh header
		//response.setIntHeader("Refresh",  1);
		
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>Countdown</h1>");
		out.println("<h3><small>The current count is: </small>" + count + "</h3>");
		out.println("<p class=\"lead\">" + new java.util.Date() + "</p>");
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

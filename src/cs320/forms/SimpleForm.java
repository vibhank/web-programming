package cs320.forms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forms/SimpleForm")
public class SimpleForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Validate the form elements
		boolean isValidName = true;
		boolean isValidAge = true;
		
		// Was the name parameter submitted? If so, let's validate it!
		if( request.getParameter("firstName") != null ){
			if (request.getParameter("firstName").trim().length() == 0)
				isValidName = false;
		}
		
		// Was the name parameter submitted? If so, let's validate it!
		if( request.getParameter("age") != null){
			try{
				
				int temp = Integer.parseInt(request.getParameter("age"));
				
			}catch(Exception e){
				isValidAge = false;
				
				}
			}
		
	
		// Set the content type
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Register Form: </h1><hr />");
		out.println("<form action=\"SimpleForm\" method=\"get\">");
		
		// If error, print message
		if (!isValidName)
			out.println("   <p class=\"text-danger\">Enter a valid name</p>");
		
		out.print("   <input name=\"firstName\" ");
		if (request.getParameter("firstName") != null && isValidName)
			out.print(" value=\"" + request.getParameter("firstName") + "\" ");
		out.println(" type=\"text\" class=\"form-control\" placeholder=\"First Name\"><br />");
		
		// If error, print message
		if (!isValidAge)
			out.println("   <p class=\"text-danger\">Enter a valid age</p>");
				
		out.print("   <input name=\"age\" ");
		if (request.getParameter("age") != null && isValidAge)
			out.print(" value=\"" + request.getParameter("age") + "\" ");
		out.println(" type=\"text\" class=\"form-control\" placeholder=\"Age\"><br />");
		
		
		out.println("   <input type=\"submit\" class=\"btn btn-primary\" value=\"Submit\">");
		out.println("</form>");	
/*

<form action="SimpleForm" method="get">
	
	<input name="firstName" type="text" class="form-control" placeholder="First Name">
	<br />
	<input name="age" type="text" class="form-control" placeholder="Age">
	<br />
	<input class="btn btn-primary" type="submit" value="Submit">

</form>

 */
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

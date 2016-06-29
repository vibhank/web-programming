package cs320.homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs320.Midterm.View;


@WebServlet("/homework1/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public Register() {
        super();
        
    }

	
	@Override
	public void init() throws ServletException {
		
		ArrayList<Homework1User> users = new ArrayList<Homework1User>();
		getServletContext().setAttribute("Homework1Users", users);
	
		//users.add(new Homework1User("john@doe.com", "Doe", "john@doe.com", "1!", "91801"));
		
	}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	boolean isValidFirstname = true;
	boolean isValidFirstnameerror = false;
	boolean isValidLastname = true;
	boolean isValidLastnameerror = false;
	boolean isValidEmail = true;
	boolean isValidEmailerror = false;
	boolean isValidPassword = true;
	boolean isValidPassworderror = false;
	boolean isValidRepassword = true;
	boolean isValidRepassworderror = false;
	boolean isValidZipcode = true;
	boolean isValidZipcodeerror = false; 
	
	
	
	ArrayList<View> ViewList = (ArrayList<View>) getServletContext().getAttribute("ViewList");//quoteList = ViewList
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.println("<html>");
	out.println("<head>");
	
	out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
	
	out.print("</head>");
	out.println("<body class=\"bg-success\">");
	out.println("<div class=\"page-header bg-warning text-primary\">");
	out.println("<h1>");
	out.println("Registration Form");
	out.println("<small>CS 320</small>");
	/*(shwetlana)*/
	out.println(" </h1>");
	out.println("</div>");
	
	out.println("<form action='Register' method='post'>");
	out.println("<table class= \"table table-bordered\">");
	
	// Was the name parameter submitted? If so, let's validate it!
	if( request.getParameter("firstname") != null ){
		if (request.getParameter("firstname").trim().length() == 0)
			isValidFirstname = false;
		else if (request.getParameter("firstname").matches("[0-9]"))
			isValidFirstnameerror = true;
	}
	
	// Was the name parameter submitted? If so, let's validate it!
	if( request.getParameter("lastname") != null ){ 
		if (request.getParameter("lastname").trim().length() == 0)
			isValidLastname = false;
		else if (request.getParameter("lastname").matches("[0-9]"))
			isValidLastnameerror = true;
	}
	
	if( request.getParameter("email") != null ){
		if (request.getParameter("email").trim().length() == 0)
			isValidEmail = false;
		else
	    if (request.getParameter("email").matches("(.*)@(.*).com")!=true){
			//isValidEmail = false;
	        isValidEmailerror = true;
	        
	    }
	}
	
	if( request.getParameter("password") != null ){
		if (request.getParameter("password").trim().length() == 0)
			isValidPassword = false;
		else
			if(request.getParameter("password").matches("((?=.*[0-9])(?=.*[a-z])(?=.*[@#$%]).{6,20})")!=true){ //((?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^*]))
				isValidPassworderror = true;
				isValidPassword = false;
			}
	}
	
	if( request.getParameter("repassword") != null ){
		if (request.getParameter("repassword").trim().length() == 0)
			isValidRepassword = false;
		else if(request.getParameter("repassword").matches(request.getParameter("password"))!=true){ 
			isValidRepassworderror = true;
		}
	}
	
	
	if( request.getParameter("zipcode") != null ){
		if (request.getParameter("zipcode").trim().length() == 0)
			isValidZipcode = false;
		else
			if (request.getParameter("zipcode").matches("[0-9]{5}") != true)
				isValidZipcodeerror = true;
			
	}
	
	
	out.println("</table>");
	
	if (!isValidFirstname)
		
		out.println("<p class=\"text-danger\">Field cannot be empty</p>");
   if (isValidFirstnameerror)
	   out.println("<p class=\"text-danger\">Enter a valid First name contains only letters</p>");
	    out.println("<p>First name: </p>");
	    out.print("   <input name=\"firstname\" ");
	    if (request.getParameter("firstname") != null && isValidFirstname && !isValidFirstnameerror)
	    out.print(" value=\"" + request.getParameter("firstname") + "\" ");
		out.println(" type=\"text\" class=\"form-control\" placeholder=\"First Name\"><br />");
	
	    if (!isValidLastname)
		out.println("  <p class=\"text-danger\">Field cannot be empty</p>");
	    if (isValidLastnameerror)
	 	   out.println("<p class=\"text-danger\">Enter a valid Last name contains only letters</p>");
	    out.println("<p>Last Name: </p>");
	    out.print("   <input name=\"lastname\" ");
	    if (request.getParameter("lastname") != null && isValidLastname && !isValidLastnameerror)
	    out.print(" value=\"" + request.getParameter("lastname") + "\" ");
		out.println(" type=\"text\" class=\"form-control\" placeholder=\"Last Name\"><br />");
	        
	    if (!isValidEmail)	
		out.println("  <p class=\"text-danger\">Field cannot be empty</p>");
	    if (isValidEmailerror)	
		out.println("  <p class=\"text-danger\">Enter a valid Email ex: something@something.com</p>");
	    
		out.println("<p>Email Id:</p>");
		out.print("   <input name=\"email\" ");
	    if (request.getParameter("email") != null && isValidEmail && !isValidEmailerror)
		out.print(" value=\"" + request.getParameter("email") + "\" ");
		out.println(" type=\"text\" class=\"form-control\" placeholder=\"Email Id\"><br />");
		
		if (!isValidPassword)	
			out.println("  <p class=\"text-danger\">Field cannot be empty</p>");
		if (isValidPassworderror)	
			out.println("  <p class=\"text-danger\">Enter a valid Password that contains 1 letter, 1 number and atleast 1 character from @#$%^& </p>");
			out.println("<p>Password:</p>");
			out.print("   <input name=\"password\" ");
		    if (request.getParameter("password") != null && isValidPassword && !isValidPassworderror)
			out.print(" value=\"" + request.getParameter("password") + "\" ");
			out.println(" type=\"password\" class=\"form-control\" placeholder=\"Password\"><br />");
			
			if (!isValidRepassword)	
				out.println("  <p class=\"text-danger\">Field cannot be empty</p>");
			if (isValidRepassworderror)	
				out.println("  <p class=\"text-danger\">Doesn't match with PASSWORD, Please try again! </p>");
				out.println("<p>Re Enter Password:</p>");
				out.print("   <input name=\"repassword\" ");
			    if (request.getParameter("repassword") != null && isValidRepassword && !isValidRepassworderror )
				out.print(" value=\"" + request.getParameter("repassword") + "\" ");
				out.println(" type=\"password\" class=\"form-control\" placeholder=\"re enter password\"><br />");
			
			if (!isValidZipcode)	
				out.println("  <p class=\"text-danger\">Field cannot be empty</p>");
			if (isValidZipcodeerror)	
				out.println("  <p class=\"text-danger\">Enter a valid Zip of Length 5</p>");
				out.println("<p>Zip Code:</p>");
				out.print("   <input name=\"zipcode\" ");
			    if (request.getParameter("zipcode") != null && isValidZipcode && !isValidZipcodeerror)
				out.print(" value=\"" + request.getParameter("zipcode") + "\" ");
				out.println(" type=\"text\" class=\"form-control\" placeholder=\"Zip Code\"><br />");
	
	out.println("<input type='submit' class=\"btn btn-primary\" value='Submit' />"); 
	out.println("<br><br>");
	out.println("</form>");
	
	out.println("</body>");
	out.println("</html>");
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String firstname = request.getParameter("firstname"); 
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String zipcode = request.getParameter("zipcode");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		ArrayList<Homework1User> users  = (ArrayList<Homework1User>) getServletContext().getAttribute("Homework1Users");
		
		if(firstname!=null && lastname!=null && email!=null && password!=null && zipcode !=null && !firstname.isEmpty()
		&& !lastname.isEmpty() && !email.isEmpty()&& !password.isEmpty() && !zipcode.isEmpty()){
			users.add(new Homework1User(firstname, lastname, email, password, zipcode));
			
            out.println("<!DOCTYPE html>");
			
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
			
			out.println("<title>WELCOME USER</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"page-header bg-danger text-success\">");
			out.println("<h1>");
			out.println("Welcome User");
			out.println(" </h1>");
			out.println("</div>");
			out.println("<a href = '../Homework2/Login'>LOGIN </a>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			doGet(request, response);
		}
	}

}


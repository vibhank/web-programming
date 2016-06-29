package cs320.Registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	boolean isValidName = true;
	boolean isValidEmail = true;
	boolean isValidPhone = true;
	boolean isValidPhone2 = true;
	boolean isValidPhone3 = true;
	boolean isValidAddress = true;
	boolean isValidPassword = true;
   
    public Registration() {
        super();
        
    }

	
	
	public void init() throws ServletException {
	
		
		if (this.getServletContext().getAttribute("Field") == null)
			this.getServletContext().setAttribute("Field", new ArrayList<Fields>());
	}

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<!doctype html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Registeration Form: </h1><hr />");
			//out.println("<a href='Login' class=\"btn btn-success\">Welcome Page</a>");
			out.println("<form action=\"Registration\" method=\"post\">");
			
			if (!isValidName)
				out.println("   <p class=\"text-danger\">Enter a valid name</p>");
			
			out.print("   <input name=\"firstName\" ");
			if (request.getParameter("firstName") != null && isValidName)
				out.print(" value=\"" + request.getParameter("firstName") + "\" ");
			out.println(" type=\"text\" class=\"form-control\" placeholder=\"First Name\"><br />");
			
			// If error, print message
			if (!isValidEmail)
				out.println("   <p class=\"text-danger\">Enter a valid Email</p>");
					
			out.print("   <input name=\"Email\" ");
			if (request.getParameter("Email") != null && isValidEmail)
				out.print(" value=\"" + request.getParameter("Email") + "\" ");
			out.println(" type=\"text\" class=\"form-control\" placeholder=\"Email Address\"><br />");
			
			//Phone
			
			if (!isValidPhone)
				out.println("   <p class=\"text-danger\">Enter a valid Phone Number</p>");
					
			out.print("   <input name=\"Phone\" ");
			if (request.getParameter("Phone") != null && isValidPhone)
				out.print(" value=\"" + request.getParameter("Phone") + "\" ");
			out.println(" type=\"text\" class=\"form-control\"><br />");
			
			
			
			//Password
			
			if (!isValidPassword)
				out.println("   <p class=\"text-danger\">Enter a valid Password</p>");
					
			out.print("   <input name=\"Password\" ");
			if (request.getParameter("Password") != null && isValidPassword)
				out.print(" value=\"" + request.getParameter("Password") + "\" ");
			out.println(" type=\"password\" class=\"form-control\" placeholder=\"Password\"><br />");
			
			//Address
			
			if (!isValidAddress)
				out.println("   <p class=\"text-danger\">Enter a valid Address</p>");
					
			out.print("   <input name=\"Address\" ");
			if (request.getParameter("Address") != null && isValidAddress)
				out.print(" value=\"" + request.getParameter("Address") + "\" ");
			out.println(" type=\"text\" class=\"form-control\" placeholder=\"Address\"><br />");
			
			out.println("   <input type=\"submit\" class=\"btn btn-primary\" value=\"Submit\">");
			out.println("</form>");	
			
			out.println("</body>");
			out.println("</html>");
			
			
			
	}

	
		@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Password = request.getParameter("Password");
		String Address = request.getParameter("Address");
		PrintWriter out = response.getWriter();
		
		if( request.getParameter("firstName") != null ){
			if (request.getParameter("firstName").trim().length() == 0)
				isValidName = false;
		}
		
		//email
		if( request.getParameter("Email") != null){
			if (request.getParameter("Email").matches("(.*)@(.*).com")!=true)
			isValidEmail = false;
			
			
		}
		//phone
		if( request.getParameter("Phone") != null){
			try{
				
				int temp = Integer.parseInt(request.getParameter("Phone"));
				
			}catch(Exception e){
				isValidPhone = false;
				
				}
			
			if(request.getParameter("Phone").matches("^([0-9]{3}+[0-9]{3}+[0-9]{4})") != true){
				isValidPhone = false;
			}
			
				
			}
		
		//password
		if( request.getParameter("Password") != null){
			if (request.getParameter("Password").trim().length() == 0){
				isValidPassword = false;
			}
			if(request.getParameter("Password").matches("^[a-z]+[0-9]+(!@#$%^&*)") != true){
				isValidPassword = false;
			}
		}
		
		if( request.getParameter("Address") != null){
			if (request.getParameter("Address").trim().length() == 0)
				isValidAddress = false;
			}
		
		
		if ((isValidName != false) && (isValidEmail != false) && (isValidPhone != false) && (isValidPassword != false) && (isValidAddress != false)){
			// Add a new post to the array list
			
			ArrayList<Fields> fill = (ArrayList<Fields>) this.getServletContext().getAttribute("Field");
			fill.add(new Fields(firstName, Email, Phone, Password, Address));
			
			//request.getRequestDispatcher("/test/Login").forward(request, response);
		    response.sendRedirect("login");
		    
		}
		else
			doGet(request,response);
		
	
	}

}

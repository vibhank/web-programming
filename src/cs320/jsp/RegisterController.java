package cs320.jsp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs320.beans.UserBean;

@WebServlet("/jsp/Register/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		if (context.getAttribute("JspUsers") == null)
			context.setAttribute("JspUsers", new ArrayList<UserBean>());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// We have to validate the Form Submission
		String firstName = request.getParameter("firstName");
		boolean isValidFirstName = true;
		if ( firstName != null ){
			if (firstName.trim().length() == 0) 
				isValidFirstName = false;
		}
		
		String email = request.getParameter("email");
		boolean isValidEmail = email == null || email.trim().length() > 0;
		
		String password = request.getParameter("password");
		boolean isValidPassword = password == null || password.trim().length() > 0;
		
		if (firstName != null && isValidFirstName &&
			email != null && isValidEmail &&
			password != null && isValidPassword){
			
			ArrayList<UserBean> users = (ArrayList<UserBean>) this.getServletContext().getAttribute("JspUsers");
			
			// Create a new User
			UserBean newUser = new UserBean(email, password, firstName);
			
			// Add the new User to our array list
			users.add( newUser );
			
			HttpSession session = request.getSession();
			session.setAttribute("JspUser", newUser);

			response.sendRedirect("DisplayUsersController");
		}else{
		
			request.setAttribute("isValidFirstName", isValidFirstName);
			request.setAttribute("isValidEmail", isValidEmail);
			request.setAttribute("isValidPassword", isValidPassword);
			
			// If no form was submitted, we display the Registration Form
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

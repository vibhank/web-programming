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

import cs320.beans.UserBean;

@WebServlet("/jsp/Register/DisplayUsersController")
public class DisplayUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		if (context.getAttribute("JspUsers") == null)
			context.setAttribute("JspUsers", new ArrayList<UserBean>());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<UserBean> users = (ArrayList<UserBean>) this.getServletContext().getAttribute("JspUsers");
		
		request.setAttribute("users", users);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register/DisplayUsers.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

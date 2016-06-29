package cs320.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/jsp/HiddenVariablesController")
public class HiddenVariablesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("attribute1", "request scope");
		
		HttpSession session = request.getSession();
		session.setAttribute("attribute2", "session scope");
		
		ServletContext application = this.getServletContext();
		application.setAttribute("attribute3", new java.util.Date());
		
		// The same variable name in multiple scopes
		request.setAttribute("repeated", "request scope");
		session.setAttribute("repeated", "session scope");
		//session.removeAttribute("repeated");
		application.setAttribute("repeated", "application scope");
		
		 
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/HiddenScopedVariables.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

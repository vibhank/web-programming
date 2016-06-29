package cs320.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessions/IntroToSessions")
public class IntroToSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get a reference to the session object
		HttpSession session = request.getSession();
		
		// Initialize the count variable to 0
		int count = 0;
		
		// Is there a count down variable set in the session?
		if ( session.getAttribute("countdown") == null)
			session.setAttribute("countdown", 10);
		
		else
		{
			count = (Integer) session.getAttribute("countdown");
			session.setAttribute("countdown", --count);			
		}
		
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<!DOCTYPE html><html lang=\"en\">");
		writer.println("<head><title>Single Page Counter</title></head>");
		writer.println("<body>");
		
		writer.println("<h3>Session ID: " + session.getId() + "</h3>");
		
		if (count == 0)
			writer.println("<h1>Countdown Complete</h1>");
		else{
			writer.println("<h1>Countdown: " + count + "</h1>");			
		}
		
		writer.println("</body>");
		writer.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

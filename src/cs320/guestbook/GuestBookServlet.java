package cs320.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/examples/GuestBookServlet")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GuestBookServlet() {
        super();
        
    }

	
	public void init() throws ServletException {
		if (this.getServletContext().getAttribute("GuestBookPosts") == null)
			this.getServletContext().setAttribute("GuestBookPosts", new ArrayList<GuestBookPost>());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body><div class=\"container\">");
		out.println("<h1>CS320 Guest Book</h1>");
		
		out.println("<form action=\"GuestBookServlet\" method=\"post\">");
		out.println("    <input type=\"text\" name=\"name\" placeholder=\"Enter Your Name\" />");
		out.println("    <br /><textarea rows=\"4\" cols=\"16\" name=\"message\" placeholder=\"Enter Your Comment\" /></textarea>");
		out.println("    <input type=\"submit\" value=\"Post\" />");
		out.println("</form>");
		
		
		out.println("<hr />");
		
		
		out.println("<h3>Posts</h3>");
		
		ArrayList<GuestBookPost> posts = (ArrayList<GuestBookPost>) this.getServletContext().getAttribute("GuestBookPosts");
		//out.println(posts);
		for(GuestBookPost post : posts){
			out.println("<div class=\"well\">");
			out.println("<p class=\"text-right\"><strong>" + post.getDate() + "</strong></p>");
			out.println("    <p class=\"lead\">");
			out.println(post.getComment());
			out.println("    </p><p class=\"text-right\">");
			out.println(post.getName());
			out.println("</p>");
			out.println("</div>");
		}
		
		out.println("</div></body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		if (name != null && message != null){
			// Add a new post to the array list
			ArrayList<GuestBookPost> posts = (ArrayList<GuestBookPost>) this.getServletContext().getAttribute("GuestBookPosts");
			posts.add(new GuestBookPost(name, message));
		}
	}

}

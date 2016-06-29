package cs320.lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lab3/WritePost")
public class WritePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public WritePost() {
        super();
        
    }
    
    public void init() throws ServletException {
		if (this.getServletContext().getAttribute("ViewPosts") == null)
			this.getServletContext().setAttribute("ViewPosts", new ArrayList<ViewPost>());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
		out.println("<html>");
		/*(head)*/
		out.println("<head>");	
		
		out.println("<title>CS320 Message Board</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");		
		out.print("</head>");
		/*(body)*/
		out.println("<body>");
		
		out.println("<div class=\"container\">");			
		out.println("<h1>Message Board <small>CS320</small>");
		out.println("<p class=\"pull-right\">");
		out.println("<a href='Index' class=\"btn btn-success\">View Posts</a>");
		out.println("</p>");
		out.println("</h1>");
		out.println("</hr>");
		
		out.println("<form action=\"WritePost\" method=\"post\">");
		
		out.println("<div class=\"row\">");
		out.println("<div class=\"col-md-offset-3 col-md-6\">");
			
				out.println("<p class=\"lead\">");
					out.println("<input name=\"postTitle\" type=\"text\" class=\"form-control\" placeholder=\"Post Title\">");
				out.println("</p>");
				out.println("<p class=\"lead\">");
					out.println("<textarea name=\"postBody\" placeholder=\"Message\" class=\"form-control\" rows=\"3\">");
							out.println("</textarea>");
				out.println("</p>");
				out.println("</div>");
				out.println("</div>");
				
				out.println("<div class=\"row text-center bg-success\">");
				out.println("<div class=\"col-md-3\">");
				out.println("<img src=\"../Images/bean.png\" alt=\"Mr. Bean\" class=\"img-circle img-responsive\" />");
		
		
	out.println("<input checked type=\"radio\" name=\"image\" value=\"bean.png\" /> </div>"
					+ "<div class=\"col-md-3\">"
					+	"<img src=\"../Images/clint.png\" alt=\"Clint Eastwood\" class=\"img-circle img-responsive\" />"
					+	"<input type=\"radio\" name=\"image\" value=\"clint.png\" />"			
					+ "</div>"
					+ "<div class=\"col-md-3\">"
					+	"<img src=\"../Images/gaga.png\" alt=\"Lady Gaga\" class=\"img-circle img-responsive\" />"
					+	"<input type=\"radio\" name=\"image\" value=\"gaga.png\" />"
					+ "</div>"
					+ "<div class=\"col-md-3\">"
					+ "<img src =\"../Images/hermoine.png\" alt=\"Hermoine G.\" class=\"img-circle img-responsive\" />"
					+ "<input type=\"radio\" name=\"image\" value=\"hermoine.png\" />"
					+"</div>"
				    +"</div>");
	
	/*another Segment of Images*/
	
	                out.println("<div class=\"row text-center bg-danger\">");
					
				    out.println("<div class=\"col-md-3\">");
					out.println("<img src=\"../Images/joker.png\" alt=\"Mr. Joker\" class=\"img-circle img-responsive\" />");
			
			
		out.println("<input type=\"radio\" name=\"image\" value=\"joker.png\" /> </div>"
						+ "<div class=\"col-md-3\">"
						+	"<img src=\"../Images/mj.png\" alt=\"Michael Jackson\" class=\"img-circle img-responsive\" />"
						+	"<input type=\"radio\" name=\"image\" value=\"mj.png\" />"			
						+ "</div>"
						+ "<div class=\"col-md-3\">"
						+	"<img src=\"../Images/penny.png\" alt=\"Penny\" class=\"img-circle img-responsive\" />"
						+	"<input type=\"radio\" name=\"image\" value=\"penny.png\" />"
						+ "</div>"
						+ "<div class=\"col-md-3\">"
						+ "<img src =\"../Images/sheldon.png\" alt=\"Sheldon\" class=\"img-circle img-responsive\" />"
						+ "<input type=\"radio\" name=\"image\" value=\"sheldon.png\" />"
						+"</div>"
						
						
				
				    +"<p class=\"text-center\">"
					+ "<input class=\"btn btn-primary\" type=\"submit\" value=\"Post\" />"
				
				    + "</p>"
			
			        + "</form>");
	                    out.println("</div>" );
	//ArrayList<ViewPost> posts = (ArrayList<ViewPost>) this.getServletContext().getAttribute("ViewPosts");
	               
	
                    out.println("</body>");
		 
		
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postTitle = request.getParameter("postTitle");
		String postBody = request.getParameter("postBody");
		String image = request.getParameter("image");
		
		/*String[] image1 = image.split(".");
		String part1 = image1[0];
		String part2 = image1[1];*/
		
		//ArrayList<ViewPost> posts = new ArrayList<ViewPost>();
		
		if ((postTitle != null && postBody != null)){
			// Add a new post to the array list
			
			ArrayList<ViewPost> posts = (ArrayList<ViewPost>) this.getServletContext().getAttribute("ViewPosts");
			posts.add(new ViewPost(postTitle, postBody, image));
		
		}
		
		doGet(request, response);
		
	}

}
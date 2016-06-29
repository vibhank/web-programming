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



/**
 * Servlet implementation class Index
 */
@WebServlet("/lab3/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Index() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>"
		+"<html>"
				
		/*Head*/
		+"<head>"
		
		+"<title>CS320 Message Board</title>"
		+"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">"
		+"</head>");
		
		/*Body*/
		out.println("<body>"

		+"<div class=\"container\">"
			
			+"<h1>Message Board <small>CS320</small>"
				+"<p class=\"pull-right\">"
					+"<a href= 'WritePost' class=\"btn btn-primary\">Write Post</a>"
				+"</p>"
			+"</h1>"
			
			+"<hr />");
		
    ArrayList<ViewPost> posts = (ArrayList<ViewPost>) this.getServletContext().getAttribute("ViewPosts");
		//out.println(posts);
		for(ViewPost post : posts){
			 out.println("<div class=\"row bg-warning\">"
			         +"<div class=\"col-xs-offset-4 col-xs-4 col-md-offset-1 col-md-2 bg-info\">");
			out.println("<img src=\"../Images/"+post.getImage()+"\" class=\"img-circle img-responsive\" />");
			         out.println("</div>"
			         +"<div class=\"col-xs-12 col-md-offset-1 col-md-6\">");
				     out.println("<h3>");
				     out.println("<strong class = \"text-muted\">Title: </strong>"+post.getName());
				     out.println("</h3>");
			//out.println("<div class=\"well\">");
			//request.getParameter("postTitle");
			out.println(post.getComment());
			out.println(" </p><p class=\"pull-right\"><strong>");
			
			String imageName = (post.getImage().replaceAll(".png", ""));
			/*Conditions for Printing Image Names*/
			if(imageName.equals("bean")){
				out.println("~ Rowan Atkinson '<small>Mr. Bean</small>'");
			}
			if(imageName.equals("clint")){
				out.println("~ Clint Eastwood");
			}
			if(imageName.equals("gaga")){
				out.println("~ Lady Gaga");
			}
			if(imageName.equals("hermoine")){
				out.println("~ Emma Watson '<small>Hermoine Granger</small>' ");
			}
			if(imageName.equals("joker")){
				out.println("~ Heath Ledger '<small>Joker</small>' ");
			}
			if(imageName.equals("mj")){
				out.println("~ Michael Jackson");
			}
			if(imageName.equals("penny")){
				out.println("~ Kaley Cuoco '<small>Penny</small>' ");
			}
			if(imageName.equals("sheldon")){
				out.println("~ Sheldon Cooper");
			}
			
					
			out.println("</strong>");
			out.println("</p>");
			out.println("<p class=\"text-primary\">" + post.getDate() + "</p>");
			//out.println("<p class=\"lead\">");
			out.println("</div>");

            out.println("</div>");

            out.println("<hr />");
		}

		out.println("</div>");

		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postTitle = request.getParameter("postTitle");
		String postBody = request.getParameter("postBody");
		String image = request.getParameter("image");
		
		/*String[] image1 = image.split(".");
		String part1 = image1[0]; 
		String part2 = image1[1];*/
		//ArrayList<ViewPost> posts = new ArrayList<ViewPost>();
		
		if (postTitle != null && postBody != null && image != null){
			// Add a new post to the array list
			
			ArrayList<ViewPost> posts = (ArrayList<ViewPost>) this.getServletContext().getAttribute("ViewPosts");
			posts.add(new ViewPost(postTitle, postBody, image));
			
		
		}
		doGet(request,response);
	}

}

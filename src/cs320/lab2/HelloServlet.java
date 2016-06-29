package cs320.lab2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lab2/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HelloServlet() {
        super();
         }
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		/*(head)*/
		out.println("<head>");	
		out.println("<title>CS320 - Web Programming</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");		
		out.print("</head>");
		/*(body)*/
		out.println("<body>");
		out.println("<div class=\"container\">");			
		out.println("<div class=\"page-header bg-warning text-primary\">");
		out.println("<h1>");
		out.println(" CS320 Web & Internet Programming");
		out.println("<small>Laboratory 2</small>");
		/*(shwetlana)*/
		out.println(" </h1>");
		out.println("</div>");
		out.println("<p class=\"lead text-success\">");
		out.println("CIN:");
		out.println("<strong>");
		out.println("304371488");
		out.println("</strong>");
		out.println("</p>");
		out.println("<p class=\"lead text-success\">");
		out.println("Name:");
		out.println("<strong>");
		out.println("Singh, Shwetlana");
		out.println("</strong>");
		out.println("</p>");		
		out.println("<p class=\"bg-success text-center lead\">");
		out.println("Hello, Servlet!");
		out.println("</p>");
		out.println("</p>");		
		out.println("<a href='HelloJSTL.jsp'>Hello JSTL!</a>");		
		out.println("</body>");
		out.println("</html>");

		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package cs320.requests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/SimpleAdder")
public class SimpleAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int n1 = 0, n2 = 0;
		
		String strNum1 = request.getParameter("num1");
		String strNum2 = request.getParameter("num2");
		
		if (strNum1 != null)
			 n1 = Integer.parseInt(strNum1);
		if (strNum2 != null)
			 n2 = Integer.parseInt(strNum2);
		
		int sum = n1 + n2;
		
		
		// Set the content type
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>Simple Adder<small>");
		
		if (strNum1 == null || strNum2 == null){
			out.println("   <form action=\"SimpleAdder\" method=\"post\">");
			out.println("   		<input value=\"" + n1 + "\" placeholder=\"Number 1\" type=\"text\" name=\"num1\" /> + ");
			out.println("   		<input value=\"" + n2 + "\" placeholder=\"Number 2\" type=\"text\" name=\"num2\" /> = ");
			out.println("   		<input value=\"" + sum + "\" placeholder=\"The Sum\" type=\"text\" name=\"sum\" />");
			out.println("   		<input type=\"submit\" value=\"Add\" />");
			out.println("   		<input type=\"hidden\" name=\"secret\" value=\"Shhhhh\" />");
			out.println("   </form>");
		}
		else{
			out.println("<p class=\"lead\">");
			out.println(n1 + " + " + n2 + " = " + sum);		
			out.println("</p>");
		}
		
		
		
/*
 
 <form action="SimpleAdder" method="get">
 	<input placeholder="Number 1" type="text" name="num1" /> + 
 	<input placeholder="Number 1" type="text" name="num2" /> = 
 	<input placeholder="The Sum" type="text" name="sum" />
 	<br />
 	<input type="submit" value="Add" />
 </form>
 
 
 */
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

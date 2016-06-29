package cs320.requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.guestbook.GuestBookPost;

@WebServlet("/requests/ListHeadersServlet")
public class ListHeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set the content type
				response.setContentType("text/html");
				
				//response.setContentType("application/vnd.ms-excel");		
		
				
				PrintWriter out = response.getWriter();
				out.println("<!doctype html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">");
				out.println("</head>");
				out.println("<body><div class=\"container\">");
				out.println("<h1><small>CS320</small> Request Headers</h1>");
				
				out.println("<table>");
				out.println("   <tr>");
				out.println("   	   <th>Header Name</th>");
				out.println("   	   <th>Header Value</th>");
				out.println("   </tr>");
				
				// Get a reference to all headers
				Enumeration<String> headers = request.getHeaderNames();
				
				// print a row for each header-value pair
				while (headers.hasMoreElements()){
					
					String headerName = headers.nextElement();
					
					out.println("<tr>");
					out.println("   <td>" + headerName + "</td>" );
					out.println("   <td>" + request.getHeader(headerName) + "</td>" );
					out.println("</tr>");
					
				}
				
				
				out.println("</table>");
/*

<table>
	<tr>
		<th>Header Name</th>
		<th>Header Value</th>
	</tr>
	<tr>
		<td>???</td>
		<td>???</td>
	</tr>
</table>
				
 */
				
				out.println("</div></body>");
				out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

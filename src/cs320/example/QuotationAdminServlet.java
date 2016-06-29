package cs320.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuotationAdminServlet")
public class QuotationAdminServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
	       
		Integer addQA = 100;    
	    
	    public QuotationAdminServlet() {
	        super();
	        
	    }

		
		public void init(ServletConfig config) throws ServletException {
			
			super.init(config);
		}

		
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			boolean isValidquoteText = true;
			boolean isValidauthorText = true;
			
			ArrayList<Quote> quoteList = (ArrayList<Quote>) getServletContext().getAttribute("quoteList");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
			
			out.print("</head>");
			out.println("<body class=\"bg-success\">");
			out.println("<form action='QuotationAdminServlet' method='post'>");
			out.println("<center><table class= \"table table-bordered\"></center>");
			out.println("<tr><th>Quote</th><th>Author</th><th>Remove Link</th></tr>");
			
			for(int i=0;i<quoteList.size();i++){
				
			out.println("<tr><td>"+quoteList.get(i).getDescription()+"</td>");
			out.println("<td>"+quoteList.get(i).getAuthor()+"</td>");
			
			out.println("<td><a href='RemoveQuote?id="+quoteList.get(i).getId()+"'>Remove</a></td></tr>");	
				
			if(request.getParameter("id") != null){
				response.sendRedirect("RemoveQuote");
			}
			
			}
			
			// Was the name parameter submitted? If so, let's validate it!
			if( request.getParameter("quoteText") != null ){
				if (request.getParameter("quoteText").trim().length() == 0)
					isValidquoteText = false;
			}
			
			// Was the name parameter submitted? If so, let's validate it!
			if( request.getParameter("authorText") != null ){
				if (request.getParameter("authorText").trim().length() == 0)
					isValidauthorText = false;
			}
			
			out.println("</table>");
			if (!isValidquoteText)
				out.println("   <p class=\"text-danger\">Enter a valid quote</p>");
			    out.println("<p>INSERT QUOTE:<input type='text' name='quoteText' /></p>");
			
			    if (!isValidauthorText)
					out.println("   <p class=\"text-danger\">Enter a valid author</p>");
			out.println("<p>NAME OF AUTHOR:<input type='text' name='authorText' /></p>");
			
			out.println("<input type='submit' name='add' value='Add' />"); //this line will evoke doPost of the same servlet
			out.println("<br><br>");
			
			out.println("<a href='QuotationServlet'>CLICK ON THE LINK TO SEE ALL THE QUOTES</a>");
			
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String quote = request.getParameter("quoteText"); 
			String author = request.getParameter("authorText");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			ArrayList<Quote> quoteList  = (ArrayList<Quote>) getServletContext().getAttribute("quoteList");
			
			if(quote!=null && author!=null && !quote.isEmpty() && !author.isEmpty()){
				quoteList.add(new Quote(addQA++,author, quote));
				response.sendRedirect("QuotationAdminServlet");
			}
			else {
				//out.println("<p>FILL BOTH THE FIELDS TOO ENTER THE QUOTE</p>");
				doGet(request, response);
			}
		}

	}

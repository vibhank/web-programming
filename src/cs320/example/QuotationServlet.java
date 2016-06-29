package cs320.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuotationServlet
 */
@WebServlet("/QuotationServlet")
public class QuotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
	//Integer QuoteId;
	
   
    public QuotationServlet() {
        super();
        
    }

	//populating list for random quotes
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		ArrayList<Quote> quoteList = new ArrayList<Quote>();
		quoteList.add(new Quote(0, "Shwetlana", "Destiny is not a matter of chance, its a choice"));
		quoteList.add(new Quote(1, "THOMAS EDISON",   "YOUR FAILURE SHOWS THAT YOU ARE NEAR TO SUCCESS "));
		quoteList.add(new Quote(2, "Halo", "**Expressions are like mirror**"));
		
		getServletContext().setAttribute("quoteList", quoteList);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Quote> quoteList = (ArrayList<Quote>) getServletContext().getAttribute("quoteList");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		out.println("</head>");
		
		out.println("<body class=\"bg-info\">");
		out.println("<form action='QuotationServlet' method='post'>"); 
		
		int random = (int) (Math.random()*100%quoteList.size());
		int count = 0;
		
		out.println("<p> Quote: "+quoteList.get(random).getDescription()+"</p>");
		out.println("<p> Author: "+quoteList.get(random).getAuthor()+"</p>");
		
		
		
		out.println("<input type='submit' name='generate' value='NEW QUOTE PLEASE' />");
		
		/* 
		if(map.containsKey(random)){
		map.put(random,map.get(random+1));
		}
		else{
		map.put(random,1);
		}
		out.print(map)	;
		*/
		out.println("<br><br>");
		out.println("<a href='QuotationAdminServlet'>Admin Quote Page</a>");
		
		out.println("<a href='StatisticsServlet'>Frequency of Quotes Generated</a>");
		
		out.println("</form></body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

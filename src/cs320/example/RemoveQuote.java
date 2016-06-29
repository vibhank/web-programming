package cs320.example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RemoveQuote")
public class RemoveQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public RemoveQuote() {
        super();        
    }
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ArrayList<Quote> quoteList = (ArrayList<Quote>) getServletContext().getAttribute("quoteList");
		int id = Integer.parseInt(request.getParameter("id"));

		
		for(int i=0; i<quoteList.size(); i++){
			
			if(quoteList.get(i).getId() == id){
				quoteList.remove(i);
				response.sendRedirect("QuotationAdminServlet");
				break;
				
			}
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}

package cs320.Midterm;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Remove
 */
@WebServlet("/Midterm/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Remove() {
        super();        
    }
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ArrayList<View> ViewList = (ArrayList<View>) getServletContext().getAttribute("ViewList");
		int id = Integer.parseInt(request.getParameter("id"));

		
		for(int i=0; i<ViewList.size(); i++){
			
			if(ViewList.get(i).getId() == id){
				ViewList.remove(i);
				response.sendRedirect("CarAdmin");
				break;
				
			}
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}

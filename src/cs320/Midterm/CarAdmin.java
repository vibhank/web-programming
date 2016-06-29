package cs320.Midterm;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Midterm/CarAdmin")
public class CarAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	Integer addQA = 100;    
    
    public CarAdmin() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		ArrayList<View> ViewList = new ArrayList<View>();
		getServletContext().setAttribute("ViewList", ViewList);
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isValidMake = true;
		boolean isValidModel = true;
		boolean isValidYear = true;
		boolean isValidSearch = true;
		
		ArrayList<View> ViewList = (ArrayList<View>) getServletContext().getAttribute("ViewList");//quoteList = ViewList
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		
		out.print("</head>");
		out.println("<body class=\"bg-success\">");
		out.println("<div class=\"page-header bg-warning text-primary\">");
		out.println("<h1>");
		out.println(" Car Administrator");
		out.println("<small>CS320 Midterm</small>");
		/*(shwetlana)*/
		out.println(" </h1>");
		out.println("</div>");
		
		out.println("<form action='CarAdmin' method='post'>");
		out.println("<table class= \"table table-bordered\">");
		
		// Was the name parameter submitted? If so, let's validate it!
		if( request.getParameter("Make") != null ){
			if (request.getParameter("Make").trim().length() == 0)
				isValidMake = false;
		}
		
		// Was the name parameter submitted? If so, let's validate it!
		if( request.getParameter("Model") != null ){
			if (request.getParameter("Model").trim().length() == 0)
				isValidModel = false;
		}
		
		if( request.getParameter("Year") != null ){
			if (request.getParameter("Year").trim().length() == 0)
				isValidYear = false;
		}
		
		if( request.getParameter("Year") != null){
			try{
				
				int temp = Integer.parseInt(request.getParameter("Year"));
				
			}catch(Exception e){
				isValidYear = false;
				
				}
			
			if(request.getParameter("Year").matches("^([0-9]{4})") != true){
				isValidYear = false;
			}
			}
		
		
		out.println("</table>");
		
		if (!isValidMake)
			
			out.println("<p class=\"text-danger\">Enter a valid Make</p>");
		    out.println("<p>MAKE: </p>");
		    out.print("   <input name=\"Make\" ");
		    if (request.getParameter("Make") != null && isValidMake)
		    out.print(" value=\"" + request.getParameter("Make") + "\" ");
			out.println(" type=\"text\" class=\"form-control\" placeholder=\"Make\"><br />");
		
		    if (!isValidModel)
			out.println("  <p class=\"text-danger\">Enter a valid Model</p>");
		    out.println("<p>Model: </p>");
		    out.print("   <input name=\"Model\" ");
		    if (request.getParameter("Model") != null && isValidModel)
		    out.print(" value=\"" + request.getParameter("Model") + "\" ");
			out.println(" type=\"text\" class=\"form-control\" placeholder=\"Model\"><br />");
		        
		        if (!isValidYear)
		        	
					out.println("  <p class=\"text-danger\">Enter a valid Year</p>");
					out.println("<p>YEAR: </p>");
					out.print("   <input name=\"Year\" ");
				    if (request.getParameter("Year") != null && isValidYear)
				    out.print(" value=\"" + request.getParameter("Year") + "\" ");
					out.println(" type=\"text\" class=\"form-control\" placeholder=\"Year\"><br />");
		
		out.println("<input type='submit' name='add' value='Add' />"); 
		out.println("<br><br>");
		out.println("</form>");
		
		
		/*To Search*/
        out.println("<form action=\"CarAdmin\" method=\"post\">");
        out.println("<div class=\"page-header bg-warning text-primary\">");
		out.println("<h1>");
		out.println("Search Form");
		out.println(" </h1>");
		out.println("</div>");
		out.print(" <input name=\"Search\" ");
		//if (request.getParameter("") != null){
			//if((request.getParameter("Search")==request.getParameter("Make")) ||(request.getParameter("Search")==request.getParameter("Model")) || (request.getParameter("Search")==request.getParameter("Year")))
		out.println(" type=\"text\" class=\"form-control\" placeholder=\"Search\"><br />");
		
		out.print(" <input name=\"dropdown\" ");
		out.println("<select>");
		out.println("<option>"+request.getParameter("Year")+"</option>");
		out.println("</select>");
		
		out.println(" <input type=\"submit\" class=\"btn btn-primary\" value=\"Search\">");
		
		//}
		out.println("</form>");	
	
		
	/*Remove Link*/
		out.println("<form action='CarAdmin' method='post'>");
		out.println("<table class= \"table table-bordered\">");
		out.println("<tr><th>MAKE</th><th>MODEL</th><th>YEAR</th><th>Remove Link</th></tr>");
		
		out.println("<div class=\"page-header bg-warning text-primary\">");
		
		out.println("<h1>Form to Remove</h1>");
		out.println("</div>");
		
		for(int i=0;i<ViewList.size();i++){
			
		out.println("<tr><td>"+ViewList.get(i).getMake()+"</td>");
		out.println("<td>"+ViewList.get(i).getModel()+"</td>");
		out.println("<td>"+ViewList.get(i).getYear()+"</td>");
		
		out.println("<td><a href='Remove?id="+ViewList.get(i).getId()+"'>Delete</a></td></tr>");	
		}
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Make = request.getParameter("Make"); 
		String Model = request.getParameter("Model");
		String Year = request.getParameter("Year");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		ArrayList<View> ViewList  = (ArrayList<View>) getServletContext().getAttribute("ViewList");
		
		if(Make!=null && Model!=null && Year!=null && !Make.isEmpty() && !Model.isEmpty() && !Year.isEmpty()){
			ViewList.add(new View(addQA++,Make, Model, Year));
			
			response.sendRedirect("CarAdmin");
		}
		else {
			doGet(request, response);
		}
	}

}

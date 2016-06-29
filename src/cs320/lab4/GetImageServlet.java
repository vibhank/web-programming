package cs320.lab4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import com.sun.xml.internal.bind.CycleRecoverable.Context;*/


@WebServlet("/lab4/GetImageServlet")
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		ServletOutputStream out = response.getOutputStream();
        response.setContentType("text/html");
        
         if (request.getParameter("name") != null){
        	
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[5000];
            int bytesRead = -1;
            
           ServletContext context = this.getServletContext();
           String s = context.getRealPath(request.getParameter("name"));
           //String s = "C:\\Users\\acar\\Desktop\\"+request.getParameter("name");
            
            FileInputStream inputStream = new FileInputStream(s);
            
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", "attachment;filename=\""+request.getParameter("name"));
            while ((bytesRead = inputStream.read(buffer)) != -1) {
            	outputStream.write(buffer, 0, bytesRead);
            }
     
            inputStream.close();
            outputStream.close(); 

        	}
        
        
        out.println("<html>"
        		+ "<body>");
        out.println("<h1>List of Images</h1><small>click to Download</small>");
        out.println("<ul>");
        out.println("<li>"
        		+ "<a href=\"?name=bean.png\">");
        out.println("Mr.Bean"+"</a>");
        out.println("</li>");
        
        
        out.println("<li><a href=\"?name=penny.png\">");
        out.println("Penny"+"</a>");
        out.println("</li>");
        
        out.println("<li><a href=\"?name=sheldon.png\">");
        out.println("Sheldon Cooper"+"</a>");
        out.println("</li>");
        
        out.println("<li><a href=\"?name=clint.png\">");
        out.println("Mr.Clint"+"</a>");
        out.println("</li>");
        
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
       
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
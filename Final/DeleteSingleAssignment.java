package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirectoryManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/final/DeleteSingleAssignment")
public class DeleteSingleAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteSingleAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/Final/DeleteSingleAssignment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection c = null; 
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu68?serverTimezone=UTC";
			String username = "cs3220stu68";
			String password = "*tv1n##Z"; 
        	
        	
        	 c = DriverManager.getConnection( url, username, password );
	            
	            // Create a new statement and execute it
	            Statement stmt = c.createStatement();
	            
	            String deletingexam = "UPDATE final_exam SET Assignment = (\"" + "" + "\") where id = (\"" + id + "\")";
	            stmt.executeUpdate(deletingexam);
	        
	            
	         
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
        
        response.sendRedirect("Organizer");
	}

}

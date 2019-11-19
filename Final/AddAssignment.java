package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAssignment
 */
@WebServlet("/final/AddAssignment")
public class AddAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/Final/AddAssignment.jsp" ).forward(
	            request, response );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       
	        Connection c = null;
	        try
	        {
	        	String id = request.getParameter("id");
	        	 String courseNumber = request.getParameter( "courseNumber" );
	 	        String courseName = request.getParameter( "courseName" );
	        	 String assignment = request.getParameter( "assignment" );
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu68?serverTimezone=UTC";
				String username = "cs3220stu68";
				String password = "*tv1n##Z"; 

	           // String sql = /*"insert into final_exam (courseNumber, courseName, assignment) values (courseNumber, courseName, assignment)"*/
	            	//	"update final_exam SET Assignment = '?' where Id = '?'";
	            				
	            c = DriverManager.getConnection( url, username, password );
	            Statement stmtt = c.createStatement();
	            ResultSet rs = stmtt.executeQuery("select * from final_exam where id =(\"" + id + "\")");
	            String a = "";
	            while( rs.next() )
	            {
	              a += rs.getString("Assignment");
	            }
	            Statement stmt = c.createStatement();
	            
	            String statement = null;
	            if(!a.isEmpty()) {
	            	 statement = a + " | " + assignment ;
	            }
	            else {
	            	statement = assignment;
	            }
	            
	            
	            String assig = "UPDATE final_exam SET Assignment = (\"" + statement + "\") where id = (\"" + id + "\")";
	           //System.out.println("sql = " + sql);
	            stmt.executeUpdate(assig);
	        
	            c.close();
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
	       // ArrayList<OrganizerEntry> entries = (ArrayList<OrganizerEntry>) getServletContext().getAttribute("entries");
	       // entries.add(new OrganizerEntry(courseNumber, courseName, assignment));
	        // send the user back to the guest book page
	        response.sendRedirect( "Organizer" );

//		doGet(request, response);
	}
}

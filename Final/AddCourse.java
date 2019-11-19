package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/final/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCourse() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/Final/AddCourse.jsp" ).forward(
	            request, response );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String courseNumber = request.getParameter( "courseNumber" );
	        String courseName = request.getParameter( "courseName" );
	        String assignment = request.getParameter( "assignment" );
	        Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu68?serverTimezone=UTC";
				String username = "cs3220stu68";
				String password = "*tv1n##Z"; 

	            String sql = "insert into final_exam (courseNumber, courseName, assignment) values (\"" + courseNumber + "\", \"" + courseName + "\", \"" + assignment + "\")";

	            c = DriverManager.getConnection( url, username, password );
	           // PreparedStatement pstmt = c.prepareStatement( sql );
	            Statement statement = c.createStatement();
	            
//	            pstmt.setString( 1, courseNumber );
//	            pstmt.setString( 2, courseName );
//	            pstmt.setString(3, assignment );
	            statement.executeUpdate(sql);
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

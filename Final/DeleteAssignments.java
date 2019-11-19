package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAssignments
 */
@WebServlet("/final/DeleteAssignments")
public class DeleteAssignments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAssignments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/Final/DeleteAssignments.jsp" ).forward(
	            request, response );
		 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String assignment = request.getParameter("assignment");
//		
//		String completed;
//		completed = (assignment + "(DONE).");
//		response.sendRedirect( "Organizer" );
//		 String courseNumber = request.getParameter( "courseNumber" );
//	        String courseName = request.getParameter( "courseName" );
	      //  int id = Integer.parseInt(request.getParameter("id"));
	       
		String courseNumber = request.getParameter( "courseNumber" );
        String courseName = request.getParameter( "courseName" );
        String assignment = request.getParameter( "assignment" );
	Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu68?serverTimezone=UTC";
			String username = "cs3220stu68";
			String password = "*tv1n##Z"; 

            String sql = "UPDATE final_exam SET Assignment = ' ';";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
           // pstmt.setString( 1, courseNumber );
           // pstmt.setString( 2, courseName );
//            String assignment = request.getParameter( "assignment" );
//            String assignmentDone = " DONE.";
           // pstmt.setString(3, assignment );
      // 	pstmt.setInt(1, id);
            pstmt.executeUpdate();
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
        response.sendRedirect( "Organizer" );

	}

}

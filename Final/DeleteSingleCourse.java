package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteSingleCourse
 */
@WebServlet("/final/DeleteSingleCourse")
public class DeleteSingleCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSingleCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/Final/DeleteSingleCourse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection c = null; //Defined here for scope
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu68?serverTimezone=UTC";
			String username = "cs3220stu68";
			String password = "*tv1n##Z"; 

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
            String sql = "Delete from final_exam where id =(\""+ id  +"\")";
            stmt.executeUpdate(sql);
        
            
         
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

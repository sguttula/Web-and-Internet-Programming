package Final;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/final/Organizer")
public class Organizer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Organizer() {
        super(); 
    }
    public void init( ServletConfig config ) throws ServletException
	{
		super.init( config );

		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			throw new ServletException( e );
		}
	}
    protected void doGet( HttpServletRequest request,
			HttpServletResponse response ) throws ServletException, IOException
	{
    	
		PrintWriter out = response.getWriter();
		out.print( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0" );
		out.print( "Transitional//EN\">\n" );
		out.print( "<html><head><title>Final Exam</title></head>\n<body>" );

//		out.println("<form action=\"Query\" method=\"get\">");
//		out.println("<textarea name=\"sql\" placeholder=\"Enter your SQL\"></textarea>");
//		out.println("<br>");
//		out.println("<input type =\"submit\" name=\"Submit\" value=\"Execute SQL\">");
//		out.println("</form>");
		ArrayList<OrganizerEntry> entries = new ArrayList<OrganizerEntry>();
		//String sql = request.getParameter("sql");
		//if(sql != null && sql.trim().length() > 0) {
			Connection c = null;
			try
			{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu68?serverTimezone=UTC";
				String username = "cs3220stu68";
				String password = "*tv1n##Z"; 
	//*tv1n##Z
				//?serverTimezone=UTC
				c = DriverManager.getConnection( url, username, password );
				Statement stmt = c.createStatement();
				//ResultSet rs = stmt.executeQuery( sql );
				ResultSet rs = stmt.executeQuery( "select * from final_exam" );
				
				while( rs.next() )
	            {
	                /*, rs.getString( "assignment" )*/ 
	                entries.add(  new OrganizerEntry(rs.getInt("id"), 
		                    rs.getString( "courseNumber" ), rs.getString( "courseName" ), rs.getString( "assignment" )));
	            }
				c.close();
//				ResultSetMetaData meta = rs.getMetaData();
//				int numberOfColumns = meta.getColumnCount();
//				
//				out.println("<table>");
//				out.println("<tr>");
//				
//				 for (int i = 1; i <= numberOfColumns; i++) {
//             		String columnName = meta.getColumnName( i );
//             		out.println("	<th>" + columnName + "</th>");
//             }
//				 
//				out.println("<th>?????</th>");
//				out.println("</tr>");
//				
//				 while( rs.next() )
//	                {
//	                		out.println("<tr>");
//	                		for (int i = 1; i <= numberOfColumns; i++) {
/*ResultSetMetaData*/								request.setAttribute
/*numberOfColums*/								( "entries", entries );
//	                			String columnValue = rs.getString( i );
//	                			out.println("<td>" + columnValue + "</td>");
//	                		}                    
//	                    out.println( "</tr>" );
//	                }
//				 
//				
//				
//
//				while( rs.next() )
//				{
//					out.println( rs.getString( "courseNumber" ) );
//					out.println( rs.getString( "courseName" ) );
//					//out.println( rs.getString( "assignment" ) );
//					out.println( "<br>" );
//				}
//				out.println("</table>");
				//c.close();
			}
			catch( SQLException e )
			{
				throw new ServletException( e );
			}
			finally
			{
				try
				{
					if(c != null) c.close();
				}
				catch(SQLException e) {
					throw new ServletException(e);
				}
			}
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Final/Organizer.jsp");
		dis.forward(request, response);
		out.print( "</body></html>" );
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
    protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            doGet( request, response );
        }
}

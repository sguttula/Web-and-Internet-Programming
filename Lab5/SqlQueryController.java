package Lab5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SqlQueryController
 */
@WebServlet("/Query")
public class SqlQueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	out.println("<form>");
	out.println("<textarea name=\"sql\" placeholder=\"Enter your SQL\"></textarea>");
	out.println("<br>");
	out.println("<input type =\"submit\" name=\"Submit\" value=\"Execute SQL\">");
	out.println("</form>");
	*/
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
		out.print( "<html><head><title>Hello JDBC</title></head>\n<body>" );

		out.println("<form action=\"Query\" method=\"get\">");
		out.println("<textarea name=\"sql\" placeholder=\"Enter your SQL\"></textarea>");
		out.println("<br>");
		out.println("<input type =\"submit\" name=\"Submit\" value=\"Execute SQL\">");
		out.println("</form>");
		
		String sql = request.getParameter("sql");
		if(sql != null && sql.trim().length() > 0) {
			Connection c = null;
			try
			{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu68?serverTimezone=UTC";
				String username = "cs3220stu68";
				String password = "*tv1n##Z"; 
	//*tv1n##Z
				c = DriverManager.getConnection( url, username, password );
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery( sql );
				
				ResultSetMetaData meta = rs.getMetaData();
				int numberOfColumns = meta.getColumnCount();
				out.println("<table>");
				out.println("<tr>");
				
				 for (int i = 1; i <= numberOfColumns; i++) {
             		String columnName = meta.getColumnName( i );
             		out.println("	<th>" + columnName + "</th>");
             }
				 
				//out.println("<th>?????</th>");
				out.println("</tr>");
				
				 while( rs.next() )
	                {
	                		out.println("<tr>");
	                		for (int i = 1; i <= numberOfColumns; i++) {
	                			String columnValue = rs.getString( i );
	                			out.println("<td>" + columnValue + "</td>");
	                		}                    
	                    out.println( "</tr>" );
	                }
				 
				out.println("</table>");
				

//				while( rs.next() )
//				{
//					out.println( rs.getString( "name" ) );
//					out.println( rs.getString( "price" ) );
//					out.println( rs.getFloat( "quantity" ) );
//					out.println( "<br>" );
//				}

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
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("/Lab5/Query.jsp");
		dis.forward(request, response);
		out.print( "</body></html>" );
	}

}
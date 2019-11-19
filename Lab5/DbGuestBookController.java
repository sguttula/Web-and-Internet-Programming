package Lab5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;


@WebServlet("/db/GuestBook")
public class DbGuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;


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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		PrintWriter out = response.getWriter();
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu68?serverTimezone=UTC";
			String username = "cs3220stu68";
			String password = "*tv1n##Z"; 
			//*tv1n##Z
			c = DriverManager.getConnection( url, username, password );
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM guestbook" );
//
//			ResultSetMetaData meta = rs.getMetaData();
//			int numberOfColumns = meta.getColumnCount();
//			out.println("<table>");
//			out.println("<tr>");
//
//			for (int i = 1; i <= numberOfColumns; i++) {
//				String columnName = meta.getColumnName( i );
//				out.println("	<th>" + columnName + "</th>");
//			}
//
//			//out.println("<th>?????</th>");
//			out.println("</tr>");
ArrayList<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
			while( rs.next() )
			{
//				out.println("<tr>");
//				for (int i = 1; i <= numberOfColumns; i++) {
//					String columnValue = rs.getString( i );
//					out.println("<td>" + columnValue + "</td>");
//				}                    
//				out.println( "</tr>" );
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String message = rs.getString("message");
				
				entries.add(new GuestBookEntry(id, name, message));
			}
			request.setAttribute("entries", entries);
			request.getRequestDispatcher("/WEB-INF/mvc/GuestBook.jsp").forward(request, response);
			//out.println("</table>");


			//		while( rs.next() )
			//		{
			//			out.println( rs.getString( "name" ) );
			//			out.println( rs.getString( "price" ) );
			//			out.println( rs.getFloat( "quantity" ) );
			//			out.println( "<br>" );
			//		}

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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

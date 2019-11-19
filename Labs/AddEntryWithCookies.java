//package Labs;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class AddEntryWithCookies
// */
//@WebServlet("/Labs/AddEntryWithCookies")
//public class AddEntryWithCookies extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AddEntryWithCookies() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}





package Labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/Labs/AddEntryWithCookies")
public class AddEntryWithCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String getName( HttpServletRequest request )
    {
        Cookie[] cookies = request.getCookies();
        if( cookies != null )
            for( Cookie cookie : cookies )
                if( cookie.getName().equals( "name" ) )
                    return cookie.getValue();

        return null;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set the content type to HTML
		response.setContentType("text/html");
		
		// Get a Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate the template HTML
		out.println("<!DOCTYPE html>");		
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>Add Entry with Cookies</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<form action=\"AddEntryWithCookies\" method=\"post\">");
		
		String name = getName(request);
		
		if (name == null)
			out.println("	<input type=\"text\" name=\"name\" placeholder=\"Enter your name\">");
		else {
			out.println("<strong>" + name + "</strong>");
			// Insert a hidden form input 
		}
		
		
		out.println("	<br>");		
		out.println("	<textarea name=\"message\"></textarea>");
		out.println("	<br>");
		out.println("	<input type=\"submit\" value=\"Add Entry\">");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the users's name
		
		// Let's try to read the name from the cookies first.
		String name = getName(request);
		
		if (name == null)
			name = request.getParameter("name");
		
		// Get the user's message
		String message = request.getParameter("message");
		
		
		if (name == null || name.trim().length() == 0 || message == null || message.trim().length() == 0) {
			doGet(request, response);
		}		
		else {		
			// Get a reference to the entries collection in the servlet context
			ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
			
			// Add a new entry to the guestbook
			entries.add(new GuestBookEntry(name, message));
			
			// Create a cookie 
			Cookie cookie = new Cookie("name", name);
			
			// Add the cookie to the response
			response.addCookie( cookie );
			
			// Redirect the User back to the main guestbook page
			response.sendRedirect("../Labs/DownloadGuestBook");
		}
	}

}
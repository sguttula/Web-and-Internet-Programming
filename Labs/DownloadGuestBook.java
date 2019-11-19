package Labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/Labs/DownloadGuestBook")
public class DownloadGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DownloadGuestBook() {
		super();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Pre-populate the Guest Book with some entries
		ArrayList<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add( new GuestBookEntry("John Doe", "Hello, World!"));
		entries.add( new GuestBookEntry("Joe Boxer", "Howdy"));
		entries.add( new GuestBookEntry("Mary Jane", "Hi!"));
//		entries.add( new GuestBookEntry("Sid Guttula", "Hey!"));
//		entries.add( new GuestBookEntry("King James", "King Me!"));
//		entries.add( new GuestBookEntry("Basketball Forever", "Ball is Life!"));
		 
		getServletContext().setAttribute("entries", entries);
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
		out.println("        <title>Guest Book</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Guest Book</h1>");
		
		// Get a reference to our servlet context
		ServletContext context = getServletContext();
		
		// Get a reference to the list of guest book entries
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) context.getAttribute("entries");
		
		// Display all entries in a table
		out.println("<table class=\"table table-bordered table-striped table-hover\">");
				
		// For each entry, we want to display a new row in our table
		for (GuestBookEntry entry : entries) {
			out.println("<tr>");
			out.println("  <td>" + entry.getName() + "</td>");
			out.println("  <td>" + entry.getMessage() + "</td>");
			out.println("  <td>" + entry.getCreated() + "</td>");
			out.println("  <td>");
			out.println("		<a class=\"btn btn-primary\" href=\"EditEntry?id=" + entry.getId() + "\">Edit</a>");
			out.println("		<a class=\"btn btn-primary\" href=\"DeleteEntry?id=" + entry.getId() + "\">Delete</a>");
			out.println("  </td>");
			out.println("</tr>");
 
		}
		
		out.println("</table>");
		  
		out.println("<a href=\"GuestBook\" class=\"btn btn-primary\">Download Guestbook</a>");
		out.println("<a href=\"AddEntry\" class=\"btn btn-primary\">Add Entry</a>");
		out.println("<a href=\"../Labs/AddEntryWithCookies\" class=\"btn btn-primary\">Add Entry with Cookies</a>");
		out.println("<a href=\"../Labs/AddEntryWithSessions\" class=\"btn btn-primary\">Add Entry with Sessions</a>");
	
		out.println("</div>");
		out.println("</body>");
		out.println("</html>"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

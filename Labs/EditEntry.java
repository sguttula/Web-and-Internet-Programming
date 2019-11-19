package Labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

/**
 * Servlet implementation class EditEntry
 */
@WebServlet("/Labs/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected GuestBookEntry getEntry(HttpServletRequest request) {
		
		// Get the id of the entry we are editing
		int id = Integer.parseInt(request.getParameter("id"));
		
		// Get a reference to the array list of entries
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		// Find the entry
		for (GuestBookEntry entry : entries)
			if (entry.getId() == id)
				return entry;
		
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
		out.println("        <title>Edit Entry</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		GuestBookEntry entry = getEntry(request);
		
		// If we can't find the entry, go back to the guestbook
		if (entry == null) {
			response.sendRedirect("GuestBook");
			return;
		}
			
		
		out.println("<form action=\"EditEntry\" method=\"post\">");
		
		out.println("	<input type=\"text\" name=\"name\" value=\"" + entry.getName() + "\" placeholder=\"Enter your name\">");
		out.println("	<br>");
		
		out.println("	<input type=\"hidden\" name=\"id\" value=\"" + entry.getId() + "\" > <br>");
		
		out.println("	<textarea name=\"message\">" + entry.getMessage() + "</textarea>");
		out.println("	<br>");
		out.println("	<input type=\"submit\" value=\"Save Entry\">");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the name
		String name = request.getParameter("name");
				
		// Get the message
		String message = request.getParameter("message");
		
		// Get the entry in question
		GuestBookEntry entry = getEntry(request);
		
		// Updating the entry
		entry.setName(name);
		entry.setMessage(message);		
		
		response.sendRedirect("GuestBook");

	}

}
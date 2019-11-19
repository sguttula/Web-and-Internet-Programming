package Midterm;

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

//import AdminEntry;

@WebServlet("/Midterm/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		    
		// Pre-populate the Guest Book with some entries
		ArrayList<AdminEntry> entries = new ArrayList<AdminEntry>();
//		String name1 = "The Smurfs", name2 = "CoolFunnyQuotes.com", name3 = "Woody Allen", name4 = "Stephen Hawking";
//		String message1 = "Remember, safety 3rd!", message2 = "If we shouldn't eat at night, then why is there a light in the fridge?",
//			   message3 = "The lion shall lie down with the calf, but the calf won't get much sleep.",
//			   message4 = "I have noticed that even people who claim everything is pre­determined and that we can do nothing to change it look before they cross the road.";
//		
//		entries.add(new AdminEntry(message1, name1));
//		entries.add(new AdminEntry(message2, name2));
//		entries.add(new AdminEntry(message3, name3));
//		entries.add(new AdminEntry(message4, name4));
//		
		int numberOfTimesAppeared = 0;
		entries.add( new AdminEntry("Remember, safety 3rd!", "The Smurfs"));
		entries.add( new AdminEntry("If we shouldn't eat at night, then why is there a light in the fridge?", "CoolFunnyQuotes.com"));
		entries.add( new AdminEntry("The lion shall lie down with the calf, but the calf won't get much sleep.", "Woody Allen"));
		entries.add( new AdminEntry("I have noticed that even people who claim everything is pre­determined and that we can do nothing to change it look before they cross the road.", "Stephen Hawking"));
		
		getServletContext().setAttribute("appearance", numberOfTimesAppeared);
		getServletContext().setAttribute("quotes", entries);
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
		out.println("        <title>Admin</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
//		
		out.println("<p class=\"text-right\">");
		out.println("<a href=\"InspireMe\">Inspire Me</a>");
		out.println("</p>");
		//out.println("<a href=\"InspireMe\">Inspire Me</a>");
		//out.println("<br>");
		
		
		// Get a reference to our servlet context
		ServletContext context = getServletContext();
		
		// Get a reference to the list of guest book entries
		ArrayList<AdminEntry> entries = (ArrayList<AdminEntry>) context.getAttribute("quotes");
		
		// Display all entries in a table
		out.println("<table class=\"table table-bordered table-striped table-hover\">");
		out.println("<th>  </th>");
		out.println("<th> Quote </th>");
		out.println("<th> Author </th>");
		out.println("<th> Viewed </th>");
		out.println("<th> Liked </th>");
		out.println("<th> Disliked </th>");
		//out.println("<th> Parameter Value </th>");
				
		// For each entry, we want to display a new row in our table
		for (AdminEntry entry : entries) {
			//out.println("<tr>");
			
			//out.println("</tr>");
			out.println("<tr>");
			out.println("  <td>");
			out.println("		<a class=\"btn btn-primary\" href=\"DeleteQuotation?id=" + entry.getId() + "\">Delete</a>");
			out.println("  </td>");	
			out.println("  <td>" + entry.getQuote() + "</td>");
			out.println("  <td>" + entry.getAuthor() + "</td>");
			out.println("  <td>" + entry.getViewed() + "</td>");
			out.println("  <td>" + entry.getLiked() + "</td>");
			out.println("  <td>" + entry.getDisliked() + "</td>");
//			out.println("  <td>");
//			out.println("		<a class=\"btn btn-primary\" href=\"EditEntry?id=" + entry.getLiked() + "\">Edit</a>");
//			out.println("		<a class=\"btn btn-primary\" href=\"DeleteEntry?id=" + entry.getDisliked() + "\">Delete</a>");
//			out.println("  </td>");
			out.println("</tr>");

		}
		
		out.println("</table>");
		
		
		out.println("<a href=\"AddQuotation\" class=\"btn btn-primary\">Add Quotation</a>");
//		out.println("<a href=\"../cookies/AddEntryWithCookies\" class=\"btn btn-primary\">Add Entry with Cookies</a>");
//		out.println("<a href=\"../sessions/AddEntryWithSessions\" class=\"btn btn-primary\">Add Entry with Sessions</a>");
//		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
package Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class EditEntry
 */
@WebServlet("/Homework2/NoteEdit")
public class NoteEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected Note getEntry(HttpServletRequest request) {
	
			//int id = Integer.parseInt(request.getParameter("id"));
			String textBox = request.getParameter("text");
			// Get a reference to the array list of entries
			//ArrayList<Note> entries = (ArrayList<Note>) getServletContext().getAttribute("textId");

//			// Find the entry
//			Note entry = null;
//				if (entry.getText() == textBox)
//					return entry;

				// If we can't find the entry, go back to the guestbook
				
				
		
			return null;
		}
	//    
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

		//Note note = getEntry(request);
		
		Note note = new Note(3, "hi", "world");

//		if(note == null) {
//			response.sendRedirect("NoteMainPage");
//			return;
//		}
//		HttpSession session = request.getSession();
//		Note note = (Note) session.getAttribute("note");
//		

		
			out.println("<form action=\"NoteEdit\" method=\"post\">");
//
//			out.println("	<input type=\"text\" name=\"name\" value=\""  + "\" placeholder=\"Enter your name\">");
//			out.println("	<br>");

			out.println("	<input type=\"hidden\" name=\"id\" value=\""  + "\" > <br>");

			out.println("	<textarea name=\"text\">" + note.getText() + "</textarea>");
			out.println("	<br>");
			out.println("	<input type=\"submit\" value=\"Save Entry\">");
			out.println("</form>");

			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}

			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		
		//		// Get the name
		//		String name = request.getParameter("name");
		//				
		//		// Get the message
		//		String message = request.getParameter("message");
		String text = request.getParameter("text");
		Note set = getEntry(request);
		set.setText(text);
		response.sendRedirect("NoteMainPage"); 
		//		// Get the entry in question
		//		Note entry = getEntry(request);
		//		
		//		// Updating the entry
		//		entry.setTitle(name);
		//		entry.setText(message);		
		//		
		//		response.sendRedirect("NoteMainPage");
		//
			}

	}

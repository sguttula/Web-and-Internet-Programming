//package Labs;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import models.RequestParameterEntry;
//
//
//@WebServlet("/Labs/AddEntry")
//public class AddEntry extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//  
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//
//		// Get a Print Writer
//		PrintWriter out = response.getWriter();
//
//		// Generate the template HTML
//		out.println("<!DOCTYPE html>");        
//		out.println("<html lang=\"en\">");
//		out.println("<head>");
//		out.println("    <meta charset=\"UTF-8\">");
//		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
//		out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
//		out.println("        <title>Add Entry</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<div class=\"container\">");
//
//		out.println("<form action=\"AddEntry\" method=\"post\">");
//		out.println("<input type=\"text\" name=\"name\" placeholder=\"Enter your name\">");
//		out.println("<br>");
//		out.println("<textarea name=\"message\"></textarea>");
//		out.println("<br>");
//		out.println("<input type=\"submit\" value=\"Add Entry\">");
//		out.println("</form>");
//		
//		out.println("</div>");
//		out.println("</body>");
//		out.println("</html>");
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String message = request.getParameter("message");
//		
//		ArrayList<RequestParameterEntry> entries = (ArrayList<RequestParameterEntry>) getServletContext().getAttribute("entries");
//		
//		entries.add(new RequestParameterEntry(name, message));
//		
//		response.sendRedirect("RequestSummary");
//		
//		
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/Labs/AddEntry")
public class AddEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		out.println("        <title>Add Entry</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<form action=\"AddEntry\" method=\"post\">");
		
		if (request.getAttribute("nameError") != null)
			out.println("<p class=\"text-danger\">" + request.getAttribute("nameError") + "</p>");
		
		String name = "";
		if (request.getParameter("name") != null)
			name = request.getParameter("name");
		
		out.println("	<input type=\"text\" name=\"name\" value=\"" + name + "\" placeholder=\"Enter your name\">");
		out.println("	<br>");
		
		if (request.getAttribute("messageError") != null)
			out.println("<p class=\"text-danger\">" + request.getAttribute("messageError") + "</p>");
		
		String message = request.getParameter("message");
		message = message == null ? "" : message;
		
		out.println("	<textarea name=\"message\">" + message + "</textarea>");
		out.println("	<br>");
		out.println("	<input type=\"submit\" value=\"Add Entry\">");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the users's name
		String name = request.getParameter("name");
		
		// Get the user's message
		String message = request.getParameter("message");
		
		// Assume we have no errors in the user's submission
		boolean hasError = false;
		
		// Prove that there are errors
		
		if (name == null || name.trim().length() == 0) {
			request.setAttribute("nameError", "Invalid Name");
			hasError = true;
		}
		
		if (message == null || message.trim().length() == 0) {
			request.setAttribute("messageError", "Invalid Message");
			hasError = true;
		}
		
		// Validate the user's input
		if (hasError) {
			doGet(request, response);
		}
		else {		
			// Get a reference to the entries collection in the servlet context
			ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
			
			// Add a new entry to the guestbook 
			entries.add(new GuestBookEntry(name, message));
			
			// Redirect the User back to the main guestbook page
			response.sendRedirect("../Labs/DownloadGuestBook");
		}
		
	}

}


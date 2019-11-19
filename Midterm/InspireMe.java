package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import midtermreview.MathQuestion;
import midtermreview.Quiz;


@WebServlet("/Midterm/InspireMe")
public class InspireMe extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected AdminEntry getQuote(HttpServletRequest request) {
//	
//
//		return null;
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random quo = new Random();
		HttpSession session = request.getSession();
		ServletContext qwerty = getServletContext();
		ArrayList<AdminEntry> inspire = (ArrayList<AdminEntry>) qwerty.getAttribute("quotes");
		int allSizes = 0;
		int sizes = (int) getServletContext().getAttribute("appearance");
		if(inspire.size() > 1) {
			while(sizes == allSizes) {
				allSizes = (int)(Math.random() * inspire.size());
			}
		}
		getServletContext().setAttribute("appearance", allSizes);
		

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
		out.println("        <title>Inspire Me</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<p class=\"text-right\">");
		out.println("<a href=\"Admin\">Admin</a>");
		out.println("</p>");
		
		if(inspire.size() > 0) {
			AdminEntry data = inspire.get(allSizes);
			session.setAttribute("ratio", data);
			out.println("<h1>" + data.getQuote() + "<h1>");
			out.println("<p class=\"text-right\">");
			out.println("<h4>" + "-" + data.getAuthor() + "<h4>");
			data.viewGetter();
			out.println("<a href=\"LikeQuotation\" class=\"btn btn-primary\">Like</a>");
			out.println("<a href=\"DislikeQuotation\" class=\"btn btn-primary\">Dislike</a>");
			out.println("</p>");
		}
		

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}

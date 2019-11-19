package midtermreview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/midtermreview/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Automatically create a quiz for the user, or retrieve an existing quiz if it exists
		HttpSession session = request.getSession();
		
		// Try to retrieve the quiz from the session scope (if it doesn't exist, this will return null)
		Quiz quiz = (Quiz) session.getAttribute("quiz");
		
		// If we didn't find a quiz, we need to create one for the current user
		if (quiz == null) {
			quiz = new Quiz();
			
			// Add the quiz to the session
			session.setAttribute("quiz", quiz);
		}
		

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
		out.println("        <title>Addition Quiz</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		// Display the current question (or the result)
		
		if (!quiz.isComplete()) {
			
			MathQuestion question = quiz.getCurrentQuestion();
			
			out.println("<form action=\"QuizServlet\" method=\"post\" >");
			out.println("	<h1>" + question.getOp1() + " + " + question.getOp2() + " = ");
			out.println("	<input type=\"text\" name=\"answer\" placeholder=\"Enter your answer\">");
			out.println("	<input type=\"submit\" value=\"Submit Answer\">");
			out.println("</form>");
		}
		else {
			// Display the result of the quiz
			out.println("<h1>You answered " + quiz.getNumberCorrect() + " out of 5 questions correctly.</h1>");
			
			// Now that we're done with the quiz object, remove it
			session.removeAttribute("quiz");
			
			out.println("<p>Refresh your browser or <a href=\"QuizServlet\">click here</a> to begin a new quiz</p>");
		}
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		int answer = Integer.parseInt(request.getParameter("answer"));
		
		// Did the User enter the correct answer?
		Quiz quiz = (Quiz) request.getSession().getAttribute("quiz");
		MathQuestion question = quiz.getCurrentQuestion();
		
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
		out.println("        <title>Addition Quiz</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		if (answer == question.getAnswer())
			out.println("<h1 class=\"text-success\">Correct</h1>");
		else
			out.println("<h1 class=\"text-danger\">Incorrect</h1>");
		
		// Update the quiz with the user's answer
		quiz.answerQuestion(answer);
				
		if (quiz.isComplete())
			out.println("<a href=\"QuizServlet\">View Quiz Results</a>");
		else
			out.println("<a href=\"QuizServlet\" class=\"btn btn-primary\">Next Question</a>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
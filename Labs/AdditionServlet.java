package Labs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requests/add")
public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the values of both operands from the request object
		String operand1 = request.getParameter("op1");
		String operand2 = request.getParameter("op2");
		
		// Define sum here for scope
		int sum = 0;
		
//		// This approach assumes that the submitButton parameter is always submitted with the form
//		if (request.getParameter("submitButton") != null) {
//			// Convert strings to ints, and calculate the sum
//			sum = Integer.parseInt(operand1) + Integer.parseInt(operand2);
//		}
		
		String error = null;
		
		try {
			sum = Integer.parseInt(operand1) + Integer.parseInt(operand2);
		} catch(Exception e) {
			error = "Invalid operands!";
		}		
		
		// Display the results
		
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
		out.println("        <title>Addition Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Addition Servlet</h1>");
		out.println("<p class=\"lead\">");
		
		if (error != null)
			out.println(error);
		else
			out.println("The sum of " + operand1 + " and " + operand2 + " = " + sum);
		
		out.println("</p>");
		
		out.println("<a href=\"AdditionForm.html\">");
		out.println("Add more numbers");
		out.println("</a>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

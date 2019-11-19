package Labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.RequestParameterEntry;

@WebServlet("/Labs/RequestSummary")
public class RequestSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RequestSummary() {
		super();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ArrayList<RequestParameterEntry> entriesParameters = new ArrayList<RequestParameterEntry>();
		//entriesParameters.add(new RequestParameterEntry("John Doe", "Hello World!"));
		//		entries.add(new RequestParameterEntry("Joe Boxer", "Howdy"));
		//		entries.add(new RequestParameterEntry("MAry Jane", "Hi!"));
		//		entries.add(new RequestParameterEntry("MAry Jane", "Yo!"));
		//		
		getServletContext().setAttribute("entries", entriesParameters);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		// Get a Print Writer
		PrintWriter out = response.getWriter();
		Date date = new Date();

		ServletContext contextParameters = getServletContext();

		ArrayList<RequestParameterEntry> parameterInfo = (ArrayList<RequestParameterEntry>) contextParameters.getAttribute("entries");
		// Generate the template HTML
		out.println("<!DOCTYPE html>");        
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		//out.println("        <link rel=\"stylesheet\" href=\"../WebContent/request.css\">");
		out.println("        <title>Request Parameters</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<div class=\"header\">");
		out.println("<h1>Request Parameters <small>Lab 2</small></h1>");
		out.println("<p>The following <code>" + request.getMethod() + "</code> request was submitted on <code>" + date.toString());
		out.println("</div>");


		out.println("<h1><small>Request Parameters</small></h1>");
		out.println("<table class =\"table table-bordered table-striped table-hovered\">");
		out.println("<th> Parameter Name </th>");
		out.println("<th> Parameter Value </th>");

		for(RequestParameterEntry entry1 : parameterInfo) {

			out.println("<thead>");


			//out.println("</tr>");
			out.println("</thead>"); 
			out.println("<tbody>");
			//out.println("<tr>");
			out.println("<tr>");


			out.println("<td>" + request.getParameterNames() + "</td>");
			out.println("<td>" + entry1.getMessage() + "</td>");

			//
			//				//			out.println("  <td>" + entry.getCreated() + "</td>");
			//				//			out.println("  <td>");
			//				//			out.println("		<a class=\"btn btn-primary\" href=\"EditEntry?id=" + entry.getId() + "\">Edit</a>");
			//				//			out.println("		<a class=\"btn btn-primary\" href=\"DeleteEntry?id=" + entry.getId() + "\">Delete</a>");
			//				//			out.println("  </td>");
			//				out.println("</tr>");
			//				out.println("</tbody>");
		}
		Enumeration pNames = request.getParameterNames();

		while(pNames.hasMoreElements()) {
			String pName = (String)pNames.nextElement();
			out.print("<tr><td>" + pName + "</td>\n");
//			String pValue = request.getParameter(pName);
//			out.println("<td> " + pValue + "</td></tr>\n");

			out.println("<td> ");
			String[] para = request.getParameterValues(pName);
			for(int i = 0 ; i < para.length ; i++) {
				out.println(para[i] + "\n\n ");
			}
			out.println("</td></tr>\n");
		}


		out.println("</table>");
		//out.println("<a href=\"AddEntry\">Add Entry</a>");
		ArrayList<RequestParameterEntry> entriesHeaders = new ArrayList<RequestParameterEntry>();
		getServletContext().setAttribute("entries", entriesHeaders);
		ServletContext contextHeaders = getServletContext();

		ArrayList<RequestParameterEntry> headerInfo = (ArrayList<RequestParameterEntry>) contextHeaders.getAttribute("entries");
		out.println("<h1><small>Header Information</small></h1>");
		out.println("<table class =\"table table-bordered table-striped table-hovered\">");
		out.println("<th> Header Field </th>");
		out.println("<th> Header Value </th>");

		for(RequestParameterEntry entry2 : headerInfo) {
			//
			//
			out.println("<tr>");
			out.println("<td>host</td>");
			//out.println("<td>" + request.getRemoteHost().toString() + "</td>");
			out.println("</tr>");
			//out.println("<tr>");
			out.println("<td>" + entry2.getName() + "</td>");
			out.println("<td>" + entry2.getMessage() + "</td>");
			//
			//
		}
		Enumeration headerNames = request.getHeaderNames();

		while(headerNames.hasMoreElements()) {
			String paramName = (String)headerNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n");
//			String paramValue = request.getHeader(paramName);
//			out.println("<td> " + paramValue + "</td></tr>\n");
			
			out.println("<td> ");
			String paraHead = request.getHeader(paramName);
			//for(int i = 0 ; i < paraHead.length ; i++) {
				out.println(paraHead + "\n\n ");
			//}
			out.println("</td></tr>\n");
		}
		out.println("</table>");

		out.println("</div>"); 
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

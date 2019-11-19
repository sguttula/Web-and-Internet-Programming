package Labs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;


@WebServlet("/Labs/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext context = getServletContext();
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) context.getAttribute("entries");
		response.setContentType("application/vnd.ms-excel");
	      PrintWriter out = response.getWriter();
	      out.println("\t\tMessage\t\tName\t\tDate");
	      for (GuestBookEntry entry : entries) {	    	  
	    	  out.println("\t\t" + entry.getMessage() + "\t\t" + entry.getName() + "\t\t" + entry.getCreated());
			}
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	
	}
}

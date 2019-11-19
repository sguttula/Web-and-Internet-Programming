package Homework3;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Homework3.MainEntries;
@WebServlet("/Homework3/EditCustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected MainEntries getEntry(int id) {
		@SuppressWarnings("unchecked")
		ArrayList<MainEntries> entries = (ArrayList<MainEntries>) getServletContext().getAttribute("entries");
		for (MainEntries entry : entries) {
			if (entry.getId() == id) {
				return entry;
			}
		}
		return null;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Integer id = Integer.valueOf( request.getParameter( "id" ) );
		 MainEntries e = getEntry(id);
		 request.setAttribute("entries", e);
		 RequestDispatcher dis =	request.getRequestDispatcher("/WEB-INF/Homework3/EditCustomer.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf( request.getParameter( "id" ) );
        MainEntries entry = getEntry( id );
		entry.setLastName(request.getParameter("last_name"));
		entry.setFirstName(request.getParameter("first_name"));
		entry.setPhoneNumber(request.getParameter("phone_number"));
		entry.setEmailAddress(request.getParameter("email"));
		entry.setCompanyName(request.getParameter("company_name"));
		entry.setSalary(request.getParameter("salary"));
		response.sendRedirect("Main");
	}
}
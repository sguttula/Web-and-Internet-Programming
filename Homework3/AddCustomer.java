package Homework3;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Homework3.MainEntries;
@WebServlet("/Homework3/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		@SuppressWarnings("unchecked")
		ArrayList<MainEntries> entries = (ArrayList<MainEntries>) context.getAttribute("quotes");
		request.setAttribute("quotes", entries);
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Homework3/AddCustomer.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String last = request.getParameter("last_name");
		String first = request.getParameter("first_name");
		String phone = request.getParameter("phone_number");
		String email = request.getParameter("email");
		String company = request.getParameter("company_name");
		String salary = request.getParameter("salary");
		@SuppressWarnings("unchecked")
		ArrayList<MainEntries> entries = (ArrayList<MainEntries>) getServletContext().getAttribute("entries");
		entries.add(new MainEntries(last, first, phone, email, company, salary));
		response.sendRedirect("Main");
	}
}
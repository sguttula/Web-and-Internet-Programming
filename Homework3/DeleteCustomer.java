package Homework3;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Homework3/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	@SuppressWarnings("unchecked")
	ArrayList<MainEntries> entries = (ArrayList<MainEntries>) getServletContext().getAttribute("entries");
		int id = Integer.parseInt(request.getParameter("id"));
		for (MainEntries entry : entries) {
			if (entry.getId() == id) {
				entries.remove(entry);
				break;
			}
		}
		response.sendRedirect("Main");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
package Midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LikeQuotation
 */
@WebServlet("/Midterm/LikeQuotation")
public class LikeQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ServletContext a = getServletContext();
		ArrayList<AdminEntry> inspire = (ArrayList<AdminEntry>) a.getAttribute("quotes");
		AdminEntry admin = (AdminEntry) sess.getAttribute("ratio");
		for(AdminEntry c : inspire) {
			if(c.getId() == admin.getId()) {
				c.LikeGetter();
			}
		}
		response.sendRedirect("InspireMe");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

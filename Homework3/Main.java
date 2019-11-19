package Homework3;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Homework3.MainEntries;
@WebServlet("/Homework3/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ArrayList<MainEntries> entries = new ArrayList<MainEntries>();
		entries.add( new MainEntries("James", "LeBron", "123-456-7890", "lbj@nba.com", "Cavs", "$33,000,000"));
		entries.add( new MainEntries("Bryant", "Kobe", "123-456-7890", "kb24@nba.com", "Lakers", "$30,000,000"));
		entries.add( new MainEntries("Jordan", "Michael", "123-456-7890", "mj@nba.com", "Bulls", "$3,000,000"));
		entries.add( new MainEntries("Durant", "Kevin", "123-456-7890", "kd35@nba.com", "Warriors", "$25,000,000"));
		getServletContext().setAttribute("entries", entries);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Homework3/Main.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
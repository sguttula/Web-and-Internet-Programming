package Homework2;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Homework2/NoteDelete")
public class NoteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NoteUser user = (NoteUser) session.getAttribute("user");
		ArrayList<Note> notes = (ArrayList<Note>) getServletContext().getAttribute("notes");
		ArrayList<Note> deletion = new ArrayList<Note>();
		Note pager = null; 
		int noteOwner = (int) session.getAttribute("noteId");
		if (user == null) {
			response.sendRedirect("NoteLogin");
			return;
		}
		for(Note remove : notes) {
			if(remove.getOwnerId() == user.getId()) {  
				deletion.add(remove);
			}
		}	
		for(Note delete : notes) {
			if(delete.getOwnerId() == user.getId()) {  
				pager = delete;
			}
		}
		notes.remove(pager);
		response.sendRedirect("NoteMainPage");
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	}
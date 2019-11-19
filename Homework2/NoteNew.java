package Homework2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Homework2/NoteNew")
public class NoteNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NoteUser user = (NoteUser) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("NoteLogin"); 
			return;
		}
		String noteInfo = user.getFirst();
		int noteNumber = user.getId();
		Note noteNew = new Note(noteNumber, noteInfo + "'s new note", "Hello from " + noteInfo + "'s new note!");
		ArrayList<Note> notes = (ArrayList<Note>) getServletContext().getAttribute("notes");
		notes.add(noteNew);
		request.getSession().setAttribute("notes", notes);
		response.sendRedirect("NoteMainPage");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

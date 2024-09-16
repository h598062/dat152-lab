package no.hvl.dat152.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.dao.AuthorDAO;
import no.hvl.dat152.model.Author;

import java.io.IOException;

public class AddAuthorAction implements ControllerAction {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname    = request.getParameter("fname");
		String lname = request.getParameter("lname");

		Author a = new Author(fname, lname);

		// save in DB
		AuthorDAO dao = new AuthorDAO();
		dao.addAuthor(a);

		request.setAttribute("authors", dao.getAllAuthors());

		return ControllerAction.SUCCESS;

	}
}

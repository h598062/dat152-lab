package no.hvl.dat152.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.dao.AuthorDAO;
import no.hvl.dat152.dao.BookDAO;
import no.hvl.dat152.model.Author;

import java.io.IOException;

public class DeleteBookAction implements ControllerAction {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String authorid = request.getParameter("authorid");
		String isbn = request.getParameter("isbn");

		int id = Integer.parseInt(authorid);

		/* AuthorDAO adao = new AuthorDAO();
		Author    author = adao.getAuthorByID(id); */


		BookDAO bdao = new BookDAO();
		bdao.deleteBook(isbn);

		return ControllerAction.SUCCESS;

	}
}

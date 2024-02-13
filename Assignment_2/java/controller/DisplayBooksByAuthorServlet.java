package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import BookDAO.BookdbDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;

public class DisplayBooksByAuthorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookdbDAO bood = new BookdbDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String authorName = request.getParameter("authorName");

		try {
			// Retrieve books by author's name from the database
			List<Book> books = bood.getBooksByAuthor(authorName);

			// Set books list as an attribute in the request
			request.setAttribute("books", books);

			// Forward the request to the JSP page
			RequestDispatcher dispatcher = request.getRequestDispatcher("displayBooksByAuthor.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle SQLException
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// Handle ClassNotFoundException
		}
	}
}

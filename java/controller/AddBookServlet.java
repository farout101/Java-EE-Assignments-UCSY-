package controller;

import java.io.IOException;
import java.sql.SQLException;

import BookDAO.BookdbDAO;
import model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookdbDAO bood = new BookdbDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");

		Book book = new Book();
        book.setBookname(bookName);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setPrice(price);
        book.setCategory(category);

        try {
        	bood.insertBook(book);
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		response.sendRedirect("addBook.jsp"); // Redirect back to the entry page
	}
}

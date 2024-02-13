package BookDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utility.DatabaseConnection;
import model.Book;

public class BookdbDAO {
	public void insertBook(Book book) throws SQLException, ClassNotFoundException {
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO book (book_name, author, publisher, price, category_name) VALUES (?, ?, ?, ?, ?)")) {
			preparedStatement.setString(1, book.getBookname());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getPublisher());
			preparedStatement.setDouble(4, book.getPrice());
			preparedStatement.setString(5, book.getCategory());

			preparedStatement.executeUpdate();
			
			System.out.print("The data inserted successfully");
		}
	}

	public List<Book> getAllBooks() throws SQLException, ClassNotFoundException {
		List<Book> books = new ArrayList<>();
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book");
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				Book book = new Book();
				book.setBookname(resultSet.getString("bookname"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setPrice(resultSet.getInt("price"));
				book.setCategory(resultSet.getString("category"));
				books.add(book);
			}
		}
		return books;
	}
	
	public List<Book> getBooksByAuthor(String author) throws SQLException, ClassNotFoundException {
		
		List<Book> books = new ArrayList<Book>();
		
		try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE author = ?");
            ) {
            preparedStatement.setString(1, author);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookname(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setPrice(resultSet.getInt("price"));
                book.setCategory(resultSet.getString("category_name"));
                books.add(book);
            }
        }
		
		return books;
	}
}
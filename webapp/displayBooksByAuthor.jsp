<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books by Author</title>
</head>
<body>
    <h2>Books by Author</h2>
    <form action="DisplayBooksByAuthor" method="get">
        <label for="authorName">Enter Author's Name:</label><br>
        <input type="text" id="authorName" name="authorName" required><br>
        <input type="submit" value="Search">
    </form>
    
    <%-- Display the list of books here --%>
    <ul>
    <% List<Book> books = (List<Book>) request.getAttribute("books");
       if (books != null) {
           for (Book book : books) { %>
               <li>
                   <strong>Book Name:</strong> <%= book.getBookname() %><br>
                   <strong>Author:</strong> <%= book.getAuthor() %><br>
                   <strong>Publisher:</strong> <%= book.getPublisher() %><br>
                   <strong>Price:</strong> <%= book.getPrice() %><br>
                   <strong>Category:</strong> <%= book.getCategory() %><br>
               </li>
    <%     } 
       } %>
</ul>

    
 	<a href="addBook.jsp">Add Book Information</a>
</body>
</html>

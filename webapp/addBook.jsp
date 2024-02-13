<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book Information</title>
</head>
<body>
    <h2>Add Book Information</h2>
    <form action="AddBook" method="post">
        <label for="bookName">Book Name:</label><br>
        <input type="text" id="bookName" name="bookName" required><br>
        
        <label for="author">Author:</label><br>
        <input type="text" id="author" name="author" required><br>
        
        <label for="publisher">Publisher:</label><br>
        <input type="text" id="publisher" name="publisher" required><br>
        
        <label for="price">Price:</label><br>
        <input type="number" id="price" name="price" required><br>
        
        <label for="category">Category:</label><br>
        <select id="category" name="category" required>
            <option value="Java">Java</option>
            <option value="C#">C#</option>
            <option value="Python">Python</option>
        </select><br>
        
        <input type="submit" value="Submit">
    </form>
    
    <a href="displayBooksByAuthor.jsp">View Books by Author</a>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>action</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><a href="/admin/books/edit/${book.id}"><button> EDIT </button></a> </td>
            <td><a href="/admin/books/delete/${book.id}"><button> DELETE </button></a> </td>
        </tr>
    </c:forEach>
    <p><a href="/admin/books/add"><button> ADD NEW BOOK </button></a></p>
    </tbody>
</table>
</body>
</html>


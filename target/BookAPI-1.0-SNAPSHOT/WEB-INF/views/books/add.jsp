<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 19.03.2022
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add a new book</title>
</head>
<body>
<h1>Add new book:</h1>
<%--@elvariable id="book" type="pl.coderslab.entities.Book"--%>
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <p>
        <form:label path="isbn">ISBN: </form:label>
        <form:input path="isbn"/>
        <form:errors path="isbn"/>
    </p>
    <p>
        <form:label path="title">Title: </form:label>
        <form:input path="title"/>
        <form:errors path="title"/>
    </p>
    <p>
        <form:label path="author">Author: </form:label>
        <form:input path="author"/>
        <form:errors path="author"/>
    </p>
    <p>
        <form:label path="publisher">Publisher: </form:label>
        <form:input path="publisher"/>
        <form:errors path="publisher"/>
    </p>
    <p>
        <form:label path="type">Category: </form:label>
        <form:select path="type" items="${availableCategories}"/>
        <form:errors path="type"/>
    </p>
    <input type="submit">
</form:form>
</body>
</html>

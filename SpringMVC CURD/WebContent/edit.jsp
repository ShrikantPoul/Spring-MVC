<%@page import="com.springmvc.model.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<h1>Edit Here</h1>

${edit}
<br><br>

<%Student s=(Student)request.getAttribute("edit"); %>

<form action="up">

Student Id      :<input type="text" name="sid" value=<%=s.getSid() %> readonly="readonly"><br><br>
Student Name    :<input type="text" name="sname" value=<%=s.getSname() %>><br><br>
Student Address :<input type="text" name="saddress" value=<%=s.getSaddress() %>><br><br>

<input type="submit" value="update">

</form>

</body>
</html>
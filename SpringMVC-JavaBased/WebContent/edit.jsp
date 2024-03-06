<%@ page import="com.springmvc.model.Student" %>
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

<%Student s=(Student)request.getAttribute("stu"); %>

<form action="up" enctype="multipart/form-data" method="post">

	Student Id      : <input type="text" name="sid" value=<%=s.getSid() %> readonly="readonly"><br> 
	Student Name    : <input type="text" name="sname" value=<%=s.getSname() %>><br> 
	Student Address : <input type="text" name="saddress" value=<%=s.getSaddress() %>><br> 
	Student IdProof : <input type="file" name="fileUp" value=<%=s.getIdProof() %>><br>
	Student DOB     : <input type="date" name="dob" value=<%=s.getDob() %>><br>

	<input type="submit" value="edit">

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration Page</title>
</head>
<body>
	<h1>Register Here</h1>
	<form action="reg" enctype="multipart/form-data" method="post">

	Student Id      : <input type="text" name="sid"><br> 
	Student Name    : <input type="text" name="sname"><br> 
	Student Address : <input type="text" name="saddress"><br> 
	Student IdProof : <input type="file" name="fileUp"><br>
	Student DOB     : <input type="date" name="dob"><br>

	<input type="submit" value="register">

</form>
</body>
</html>
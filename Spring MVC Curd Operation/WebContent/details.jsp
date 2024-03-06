<%@page import="java.util.List"%>
<%@page import="com.springmvc.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Page</title>
</head>
<body>
	<h1>Student Details</h1>

	${list }
	<br>
	<br>

	<!-- <script type="text/javascript">
	document.mypage.
	</script> -->


	<%
		List<Student> slist = (List<Student>) request.getAttribute("list");
	%>

	<form action="del">
		<table border="5">

			<thead>
				<tr>
					<th>SELECT</th>
					<th>STUDENT ID</th>
					<th>STUDENT NAME</th>
					<th>STUDENT ADDRESS</th>
					<!-- <th>EDIT</th> -->
					<th>DELETE</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<%
						for (Student s : slist) {
					%>
					<td><input type="radio" name="sid" value=<%=s.getSid()%>></td>
					<td><%=s.getSid()%></td>
					<td><%=s.getSname()%></td>
					<td><%=s.getSaddress()%></td>
					<!-- <td><input type="submit" value="edit"></td> -->
					<td><input type="submit" value="delete"></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</form>
	<br>
	<br>

	<a href="index.jsp">Go Back To Home Page</a>

</body>
</html>
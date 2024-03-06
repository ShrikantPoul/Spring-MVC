<%@ page import="java.util.List" %>
<%@page import="com.springmvc.model.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Page</title>
</head>

<script type="text/javascript">

function editData() {
	alert("You Want To Edit???")
	document.mypage.action="edit";
	document.mypage.submit();
}

function deleteData() {
	alert("You Want To Delete???")
	document.mypage.action="delete";
	document.mypage.submit();
	
}
</script>

<body>
<h1>Student Details</h1>

${login }<br><br>
${slist }<br><br>

<%List<Student> slist=(List<Student>)request.getAttribute("slist"); %>
<form name="mypage">
<table border="5">
<thead>
<tr>
<th>SELECT</th>
<th>SID</th>
<th>SNAME</th>
<th>SADDRESS</th>
<th>DOB</th>
<th>EDIT</th>
<th>DELETE</th>
</tr>
</thead>

<tbody>
<%for(Student s:slist) {%>
<tr>
<td><input type="radio" name="sid" value=<%=s.getSid() %>></td>
<td><%=s.getSid() %></td>
<td><%=s.getSname() %></td>
<td><%=s.getSaddress() %></td>
<td><%=s.getDob() %></td>
<td><input type="submit" value="edit" onclick="editData()"></td>
<td><input type="submit" value="delete" onclick="deleteData()"></td>
</tr>
<%} %>
</tbody>

</table>

</form>

<br><br>
<a href="index.jsp">Go Back To Home Page</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Students</title>
</head>
<body>
<table border="2">
		<tr>
			<th>Id</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
			<th></th>
		</tr>
		<c:forEach var="student" items="${student_list}">
			<tr>
				<td><a href="loadstudent?studentId=${student.id}">${student.id}</a></td>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.email}</td>
				<td><a href="deletestudent?studentId=${student.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
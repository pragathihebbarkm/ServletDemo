<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addstudent" method="post">
	
	<table>
		<tr>
			<td>First Name </td>
			<td><input name="firstName" type="text"/></td>
		</tr>
		
		<tr>
			<td>Last Name </td>
			<td><input name="lastName" type="text"/></td>
		</tr>
		
		<tr>
			<td>Email </td>
			<td><input name="email" type="text"/></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Add"/></td>
		</tr>
	</table>
	</form>
	<a href="index.html">Back to List</a>
</body>
</html>
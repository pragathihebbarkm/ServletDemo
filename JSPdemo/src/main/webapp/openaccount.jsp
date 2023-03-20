<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
		Connection con;
		PreparedStatement ps;
		
		public void jspInit(){
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
	      		ps = con.prepareStatement("insert into accounts values(?,?,?,?)");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void jspDestroy(){
			try {
				
				con.close();
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	%>
	
	<%
		
		int accno = Integer.parseInt(request.getParameter("accno"));
		int bal = Integer.parseInt(request.getParameter("balance"));
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		
		ps.setInt(1, accno);
		ps.setString(2,fname);
		ps.setString(3,lname);
		ps.setInt(4, bal);
		
		ps.executeUpdate();
	%>
	
	<%@
		include file="openaccount.html"
	%>
</body>
</html>
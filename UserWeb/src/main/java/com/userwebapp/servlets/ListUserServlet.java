package com.userwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listUsers")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	
	public void init(ServletConfig config) {
    	try {
    		
    		ServletContext context = config.getServletContext();
    		String dburl = context.getInitParameter("dburl");
    		String dbuser = context.getInitParameter("dbuser");
    		String dbpassword= context.getInitParameter("dbpassword");
    		Class.forName("com.mysql.cj.jdbc.Driver");
      		connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from user");){
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Email Id</th>");
			
			
			while(rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String email = rs.getString(3);
				out.println("<tr>");
				out.println("<td>"+firstName+"</td>");
				out.println("<td>"+lastName+"</td>");
				out.println("<td>"+email+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href=\"index.html\">Home</a>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

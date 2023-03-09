package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number1 = req.getParameter("number1");
		String number2 = req.getParameter("number2");
		
		int num1int = Integer.parseInt(number1);
		int num2int = Integer.parseInt(number2);
		int result = num1int + num2int;
		
		PrintWriter out = res.getWriter();
		out.println("<p>Result = "+ (result) +" </p>");
	}

}

package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import java.sql.*; 

@WebServlet("/testDbServlet")
public class testDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="springstudent";
		String pass="springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSl=false";
		String driver="com.mysql.jdbc.Driver";
		try{
			PrintWriter out=response.getWriter();
			
			out.println("Connection ito database :: "+jdbcUrl);
			Class.forName(driver);
			Connection con=DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Success !!! ");
			con.close();
		}catch(Exception ex)
		{
			System.out.println("the error is :::: "+ex.getMessage());
		}
	}

}

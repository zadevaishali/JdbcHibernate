package org.primepro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegiPage
 */

public class RegiPage extends HttpServlet {
	     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegiPage() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("uid"));
		String name=request.getParameter("uname");
		int age=Integer.parseInt(request.getParameter("uage"));
		int salary=Integer.parseInt(request.getParameter("usalary"));
		String desig=request.getParameter("udesig");
		
		try 
		{	
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement stmt = con.prepareStatement("Insert into emp Values(?,?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3,age);
			stmt.setInt(4, salary);
			stmt.setString(5, desig);	
			stmt.execute();
			stmt.close();con.close();
			System.out.println("Data Inserted....!");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}

	

		
		
		//System.out.println(id+" "+name+" "+age);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

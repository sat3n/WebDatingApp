package com.dateme;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import oracle.jdbc.driver.*;


/**
 * Servlet implementation class RegisterAcnt
 */
@WebServlet("/RegisterAcnt")
public class RegisterAcnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	         Connection con = null;
	         Statement stmt = null;
	         ResultSet rs = null;
	         String JDBCUrl = "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
	         String username = "ee_user";
	         String password = "ee_pass";
	         
	         public void doPost(HttpServletRequest request, HttpServletResponse response)
	        	     throws ServletException, IOException {
	        	   response.setContentType("text/html");
	        	   PrintWriter out = response.getWriter();
	        	   out.println("<html><head><title>Servelet for DB</title></head>");
	        	   out.println("<body><h1>DateMe_User tabel vals</h1>");
	        	   String Userid = request.getParameter("UserID");
	        	   String Fname = request.getParameter("Fname");
	        	   String Lname = request.getParameter("Lname");
	        	   String Email = request.getParameter("Email");
	        	   String Pwd = request.getParameter("Pwd");
	        	   String Dob = request.getParameter("Dob");
	        	   String Sex = request.getParameter("sex");
	        	   
	        //inserting the values into the database 
	         try {
	             System.out.println("\nConnecting to the SSD Database......");
	             Class.forName("oracle.jdbc.driver.OracleDriver");
	             con = DriverManager.getConnection(JDBCUrl, username, password);
	         }
	         catch (Exception e) {
	             System.out.println("\nAn error has occurred during the connection phase!  This is most likely due to your CLASSPATH being set wrong and the"
	                     + " Oracle classes unable to be found.  Otherwise the database itself may be down.  Try telneting to port 1521 and see if it is up!");
	             e.printStackTrace();
	             System.exit(0);
	         }   

	 	 try {
		     System.out.println("\nConnection Successful..... creating statement....");
	      	     stmt = con.createStatement();
	      	     rs = stmt.executeQuery("INSERT INTO DateMe_User VALUES('"+Userid+"','"+Fname+"', '"+Lname+"','"+Email+"','"+Pwd+"', '"+Dob+"', '"+Sex+"')");
		      rs = stmt.executeQuery("SELECT * FROM DateMe_User");

		     while (rs.next())
	                System.out.println("<br>Name=" + rs.getString("FIRST_NAME") + rs.getString("LAST_NAME"));
		 }
	         catch (SQLException e) {
		     System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
	             while (e != null) {
		         System.out.println(e.getMessage());
	                 e = e.getNextException();
		     }
	             System.exit(0);
	         }

	         finally {
		     try {    
		         if (rs != null) rs.close();
			 if (stmt != null) stmt.close();
			 if (con != null) con.close();
		     }
		     catch (Exception ex) {
		         System.out.println("An error occurred while closing down connection/statement"); 
	             }
	         }
	    }
	  
	}

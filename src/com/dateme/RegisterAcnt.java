package com.dateme;

import java.sql.*;
import oracle.jdbc.driver.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterAcnt
 */
@WebServlet("/RegisterAcnt")
public class RegisterAcnt extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	    {
	         Connection con = null;
	         Statement stmt = null;
	         ResultSet rs = null;
	         String JDBCUrl = "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
	         String username = "ee_user";
	         String password = "ee_pass";
	         
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
		     rs = stmt.executeQuery("SELECT * FROM EE_ADMIN.CUSTOMERS");

		     while (rs.next())
	                System.out.println("\nName=" + rs.getString("FIRSTNAME") + " " + rs.getString("SURNAME"));
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

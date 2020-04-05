package com.dateme;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String JDBCUrl = "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
	String username = "ee_user";
	String password = "ee_pass";

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		try {
			System.out.println("Fecthing User info from database");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(JDBCUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			User user = validateUser(req.getParameter("usernamefield"), req.getParameter("passwordfield"));
			if (user.getUsername() != null || user != null) { // login succeeded
				HttpSession session = req.getSession();
				session.setAttribute("theUser", user); // put the OBJECT on the session
				List<User> userList = fetchAllUsers();
				req.setAttribute("UserList", userList);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
				requestDispatcher.forward(req, res);
			}
//			else { // login failed
//				res.sendRedirect("login.html");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		out.close();
	}

	/*
	 * This method will dummy the login process and return null if unsuccessful or a
	 * User object if successful
	 */
	private User validateUser(String username, String password) throws SQLException {

		String query = "SELECT * FROM DateMe_User WHERE USERNAME='" + username + "'";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		User user = null;
		if (result.next() == false) {

			System.out.println("Result set is empty! User id does not exist");
		} else {
			do {
				if (result.getString("PASSWORD").equals(password)) {
					user = new User();
					user.setFirstname(result.getString("FIRST_NAME"));
					user.setUsername(result.getString("USERNAME"));
					user.setSurname(result.getString("LAST_NAME"));
					user.setEmail(result.getString("E_MAIL"));
					user.setPassword(result.getString("PASSWORD"));
					user.setDob(result.getString("DOB"));
					user.setSex(result.getString("SEX"));
				} 
//				else {
//					System.out.println("loda lehsun");
//				}
			} while (result.next());
		}

		return user;
	}

	/*
	 * This method will dummy the login process and return null if unsuccessful or a
	 * User object if successful
	 */
	private List<User> fetchAllUsers() throws SQLException {

		String query = "SELECT * FROM DateMe_User";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<User> userList = new ArrayList<User>();
		if (result.next() == false) {

			System.out.println("Result set is empty! User id does not exist");
		} else {
			do {
				if (result.getString("password").equals(password)) {
					User user = new User();
					user.setFirstname(result.getString("FIRST_NAME"));
					user.setUsername(result.getString("USERNAME"));
					user.setSurname(result.getString("LAST_NAME"));
					user.setEmail(result.getString("E_MAIL"));
					user.setPassword(result.getString("PASSWORD"));
					user.setDob(result.getString("DOB"));
					user.setSex(result.getString("SEX"));
					userList.add(user);
				} else {
					System.out.println("loda lehsun");
				}
			} while (result.next());
		}

		return userList;
	}
}

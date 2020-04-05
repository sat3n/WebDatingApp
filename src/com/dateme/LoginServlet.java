package com.dateme;


	import java.io.*;
	import javax.servlet.*;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.*;
	import java.sql.*;
	import oracle.jdbc.driver.*;
	import javax.servlet.ServletException;

	@SuppressWarnings("unused")
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
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
	     User user=null;
		try {
			user = validateUser(req.getParameter("usernamefield"), req.getParameter("passwordfield"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     if (user!=null) {   // login succeeded
	     out.println("Welcome " + user.getFirstname() + " " + user.getSurname() + ".  You are now logged in!");
	     out.println("<br/><br/>Please click here to go to the <a href=\"AccountHome\">AccountHome page</a>");
	     HttpSession session = req.getSession();
	     session.setAttribute("theUser", user);  // put the OBJECT on the session
	     }
	     else {   // login failed
	     // no failure message for now but it will 
	     // send the user back to try again
	     res.sendRedirect("login.html");   
	     }
	     
	     out.close();
	 }
	    
	    /*
	     * This method will dummy the login process and return null if unsuccessful or a User object if successful
	     */
	    private User validateUser(String username,String password) throws SQLException{
	    	
	    	String query = "SELECT * FROM DateMe_User WHERE USERNAME='" + username + "'";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            User user=new User();
            if (result.next() == false) {
              /*user.setFirstname(result.getString("FIRST_NAME"));
                user.setUsername(result.getString("USERNAME"));
                user.setSurname(result.getString("LAST_NAME"));
                user.setEmail(result.getString("E_MAIL"));
                user.setPassword(result.getString("PASSWORD"));
                user.setDob(result.getString("DOB"));
                user.setSex(result.getString("SEX"));
                System.out.println("Result set is empty! User id does not exist");*/
            } else {
                do {
                    if (result.getString("password").equals(password)) {

                    } else {
                    	System.out.println("loda lehsun");
                    }
                } while (result.next());
            }
	    	
	    	return user; 
	    }
	}

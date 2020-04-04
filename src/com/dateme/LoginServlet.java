package com.dateme;


	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import java.util.*;

	@WebServlet("/LoginServlet")
	public class LoginServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	       
	    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     res.setContentType("text/html");
	     PrintWriter out = res.getWriter();
	     
	     User user = validateUser(req.getParameter("usernamefield"), req.getParameter("passwordfield"));
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
	    private User validateUser(String username,String password) {
	     // Let us first make a Vector of dummy users that are allowable... these would normally be taken from a database 
	     // or some other storage of all of our users
	     Vector<User> allUsers = new Vector<User>();
	     allUsers.add(new User("John", "Doe", "doej", "somepass"));
	     allUsers.add(new User("Mary", "Smith", "smithm", "mypass"));
	     
	     // Now do the comparison
	     Enumeration<User> e = allUsers.elements();
	     while (e.hasMoreElements()) {
	     User user = (User) e.nextElement();
	     if ((user.getPassword().equals(password))&&(user.getUsername().equals(username))) 
	     return user;
	     }
	     return null; 
	    }
	}

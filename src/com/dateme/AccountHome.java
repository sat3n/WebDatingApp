package com.dateme;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccountHome")
public class AccountHome extends HttpServlet {
 private static final long serialVersionUID = 1L;
    
 public void doGet(HttpServletRequest req, HttpServletResponse res) 
 throws ServletException, IOException {
 res.setContentType("text/html");
     PrintWriter out = res.getWriter();
     
     HttpSession session = req.getSession(true);
     User user = (User) session.getAttribute("theUser");
     if (user==null) {   // not logged in or timed out
     res.sendRedirect("login.html");
     } else {   // logged in and active session
     out.println("This is your secure account page!");
     out.println("If you are seeing this, you logged in!");
     }
     out.close();
 }
}

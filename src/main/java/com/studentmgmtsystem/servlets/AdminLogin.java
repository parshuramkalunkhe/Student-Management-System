package com.studentmgmtsystem.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentmgmtsystem.dao.AdminDAO;
import com.studentmgmtsystem.model.Admin;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/adminlogin")
public class AdminLogin extends HttpServlet {
	
	HttpSession session = null;
	boolean isAdmin = false;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("adminname");
		String email = req.getParameter("adminemail");
		String password = req.getParameter("adminpassword");
		
		Admin admin = new Admin();
		admin.setAdminname(name);
		admin.setAdminemail(email);
		admin.setAdminpassword(password);
		
		AdminDAO adminDAO = new AdminDAO();
		
		try {
			isAdmin = adminDAO.isAdmin(admin);
			if(isAdmin) {
				session = req.getSession();
				session.setAttribute("isAdmin", isAdmin);
				resp.sendRedirect("admin.jsp");
			} else {
				resp.sendRedirect("adminlogin.html");
			}
		} catch (SQLException e) {
			resp.sendRedirect("error.jsp");
			e.printStackTrace();
		}
		
		
	}
}

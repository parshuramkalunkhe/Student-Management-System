package com.studentmgmtsystem.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentmgmtsystem.dao.StudentDAO;
import com.studentmgmtsystem.model.Student;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{
	HttpSession session = null;
	boolean isAdmin = false;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Student student = new Student();
		student.setEmail(email);
		student.setPassword(password);
		
		StudentDAO studentDAO = new StudentDAO();
		try {
			int id = studentDAO.login(student);
			if (id > 0) {
				HttpSession session = req.getSession();
				session.setAttribute("id",  id);
				resp.sendRedirect("profile.jsp");
			} else {
				resp.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

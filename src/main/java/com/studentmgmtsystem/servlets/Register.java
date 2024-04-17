package com.studentmgmtsystem.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmgmtsystem.dao.StudentDAO;
import com.studentmgmtsystem.model.Student;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/register")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		int roll_no = Integer.parseInt(req.getParameter("roll_no"));
		int _class = Integer.parseInt(req.getParameter("class"));
		String city = req.getParameter("city");
		long contact = Long.parseLong(req.getParameter("contact"));
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		
		Student student = new Student();
		
		student.setFname(fname);
		student.setMname(mname);
		student.setLname(lname);
		student.setEmail(email);
		student.setRoll_no(roll_no);
		student.set_class(_class);
		student.setCity(city);
		student.setContact(contact);
		student.setGender(gender);
		student.setPassword(password);
		
		StudentDAO stdDao = new StudentDAO();
		
		try {
			boolean isRegister = stdDao.register(student);
			
			if (isRegister) {
				resp.sendRedirect("profile.jsp");
			} else {
				resp.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}

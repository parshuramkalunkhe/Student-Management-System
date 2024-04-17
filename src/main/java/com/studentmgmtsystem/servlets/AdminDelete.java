package com.studentmgmtsystem.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmgmtsystem.dao.AdminDAO;
import com.studentmgmtsystem.model.Admin;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/deleteAdmin")
public class AdminDelete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminname = req.getParameter("adminname");
		String adminemail = req.getParameter("adminemail");
		String adminpassword = req.getParameter("adminpassword");

		Admin admin = new Admin();
		admin.setAdminname(adminname);
		admin.setAdminemail(adminemail);
		admin.setAdminpassword(adminpassword);

		AdminDAO adminDAO = new AdminDAO();

		boolean addAdmin = adminDAO.deleteAdmin(admin);
		System.out.println(addAdmin);
		if (addAdmin) {
			resp.sendRedirect("admin.jsp");
		} else {
			resp.sendRedirect("deleteAdmin.jsp");
		}

	}
}

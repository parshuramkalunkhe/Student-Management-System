package com.studentmgmtsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.studentmgmtsystem.App;
import com.studentmgmtsystem.model.Admin;
import com.studentmgmtsystem.model.Student;

public class AdminDAO {
	public boolean isAdmin(Admin admin) throws SQLException {
		App app = App.getInstance();
		Connection con = app.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM studentmgmt.admin WHERE adminemail=? AND adminname=? AND adminpassword=?");
		
		ps.setString(1, admin.getAdminemail());
		ps.setString(2, admin.getAdminname());
		ps.setString(3, admin.getAdminpassword());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		
		return false;
	}
	
	public boolean addAdmin(Admin admin) throws SQLException {
		App app = App.getInstance();
		Connection con = app.getConnection();
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO studentmgmt.admin (adminemail, adminname, adminpassword) VALUES (?,?,?)");
		
		ps.setString(1, admin.getAdminemail());
		ps.setString(2, admin.getAdminname());
		ps.setString(3, admin.getAdminpassword());
		
		int rows = ps.executeUpdate();
		
		if(rows > 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean deleteAdmin(Admin admin) {
	    App app = null;
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        app = App.getInstance();
	        con = app.getConnection();
	        
	        String sql = "DELETE FROM studentmgmt.admin WHERE adminemail=? AND adminname=? AND adminpassword=?";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, admin.getAdminemail());
	        ps.setString(2, admin.getAdminname());
	        ps.setString(3, admin.getAdminpassword());
	        
	        int rows = ps.executeUpdate();
	        return rows > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        return false;
	    } 
	}
	
	public List<Student> getAllStudents() throws SQLException {
		List<Student> students = new ArrayList<>();
		App app = App.getInstance();
		try (Connection con = app.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM studentmgmt.student")) {
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setFname(rs.getString("fname"));
				student.setMname(rs.getString("mname"));
				student.setLname(rs.getString("lname"));
				student.setEmail(rs.getString("email"));
				student.setRoll_no(rs.getInt("roll_no"));
				student.set_class(rs.getInt("_class"));
				student.setCity(rs.getString("city"));
				student.setContact(rs.getLong("contact"));
				student.setGender(rs.getString("gender"));
				students.add(student);
			}
		}
		return students;
	}

}

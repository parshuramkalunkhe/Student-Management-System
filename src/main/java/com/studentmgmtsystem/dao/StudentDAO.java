package com.studentmgmtsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmgmtsystem.App;
import com.studentmgmtsystem.model.Student;

public class StudentDAO {

	private String register = "INSERT INTO studentmgmt.student (fname, mname, lname, email, roll_no, _class, city, contact, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String login = "SELECT * FROM studentmgmt.student WHERE email=? and password=?";

	public boolean register(Student student) throws SQLException {

		App app = App.getInstance();

		Connection con = app.getConnection();

		PreparedStatement ps = con.prepareStatement(register);

		ps.setString(1, student.getFname());
		ps.setString(2, student.getMname());
		ps.setString(3, student.getLname());
		ps.setString(4, student.getEmail());
		ps.setInt(5, student.getRoll_no());
		ps.setInt(6, student.get_class());
		ps.setString(7, student.getCity());
		ps.setLong(8, student.getContact());
		ps.setString(9, student.getGender());
		ps.setString(10, student.getPassword());

		int rowsInserted = ps.executeUpdate();

		if (rowsInserted > 0) {

			return true;
		}

		return false;
	}

	public int login(Student student) throws SQLException {

		App app = App.getInstance();

		Connection con = app.getConnection();

		PreparedStatement ps = con.prepareStatement(login);

		ps.setString(1, student.getEmail());
		ps.setString(2, student.getPassword());

		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			return rs.getInt("id");
		}
		
		return 0;
	}
}

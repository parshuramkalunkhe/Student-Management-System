package com.studentmgmtsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
	private static App instance;
	
	private String url = "jdbc:mysql://localhost:3306/mangashopdb";
	private String username = "root";
	private String password = "root";
	private Connection connection;

	private App() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static synchronized App getInstance() {
		if (instance == null) {
			instance = new App();
		}
		return instance;
	}
	
	public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
    }

	public Connection getConnection() {
		return connection;
	}
}

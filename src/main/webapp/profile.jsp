<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Profile</title>
<style>
/* Style for the profile card */
.profile-card {
	width: 300px;
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 20px;
	margin: 20px;
}
/* Style for the buttons */
.btn {
	padding: 8px 16px;
	border: none;
	border-radius: 4px;
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
	margin-right: 10px;
}

.btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>


	 <div class="profile-card">
        <h2>Student Profile</h2>
        <%
            // Retrieve database connection from session attribute
            session = request.getSession();
            Connection conn = (Connection) session.getAttribute("connection");
            
            // Retrieve student ID from request parameter
            int studentId =(int)session.getAttribute("id");
            
            // Fetch student data using prepared statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM studentmgmt.students WHERE id = ?");
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            
            // Check if student data exists
            if (rs.next()) {
                // Extract student data
                String fname = rs.getString("fname");
                String mname = rs.getString("mname");
                String lname = rs.getString("lname");
                String email = rs.getString("email");
                int rollNo = rs.getInt("roll_no");
                String _class = rs.getString("_class");
                String city = rs.getString("city");
                String contact = rs.getString("contact");
                String gender = rs.getString("gender");
        %>
        <p><strong>First Name:</strong> <%= fname %></p>
        <p><strong>Middle Name:</strong> <%= mname %></p>
        <p><strong>Last Name:</strong> <%= lname %></p>
        <p><strong>Email:</strong> <%= email %></p>
        <p><strong>Roll Number:</strong> <%= rollNo %></p>
        <p><strong>Class:</strong> <%= _class %></p>
        <p><strong>City:</strong> <%= city %></p>
        <p><strong>Contact:</strong> <%= contact %></p>
        <p><strong>Gender:</strong> <%= gender %></p>
        <% } %>
		<a href="update.jsp?id=<%=studentId%>"><button class="btn">Update</button></a> 
		<a href="delete.jsp?id=<%=studentId%>"></a>  <button class="btn">Delete</button>

	</div>
</body>
</html>

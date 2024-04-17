<%@page import="com.studentmgmtsystem.model.Student"%>
<%@page import="com.studentmgmtsystem.dao.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*"%>
<%@ page import="java.util.List"%>

<%
// Check if isAdmin attribute is set to true
Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
if (isAdmin != null && isAdmin) {
	// Admin is logged in, show admin panel
%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<nav>
		<h3 class="logo">Welcome Admin!</h3>
		<ul>
			<li><a href="registerAdmin.jsp">Add New Admin</a></li>
			<li><a href="deleteAdmin.jsp">Delete Admin</a></li>
			<li><a href="adminlogout.jsp">Logout</a></li>
		</ul>
	</nav>
	<main>
		<h2>Student Information</h2>
		<table border="1">
			<tr>
				<th>First Name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Roll No</th>
				<th>Class</th>
				<th>City</th>
				<th>Contact</th>
				<th>Gender</th>
				<th>Action</th>
				<!-- New column for action buttons -->
			</tr>
			<%
			AdminDAO studentDAO = new AdminDAO();
			List<Student> students = studentDAO.getAllStudents();
			for (Student student : students) {
			%>
			<tr>
				<td><%=student.getFname()%></td>
				<td><%=student.getMname()%></td>
				<td><%=student.getLname()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getRoll_no()%></td>
				<td><%=student.get_class()%></td>
				<td><%=student.getCity()%></td>
				<td><%=student.getContact()%></td>
				<td><%=student.getGender()%></td>
				<td><a href="update.jsp?id=<%=student.getId()%>"> <button>edit</button> </a>
					<a href="delete.jsp?id=<%=student.getId()%>"> <button>delete</button> </a></td>
			</tr>
			<%
			}
			%>
		</table>
	</main>
</body>
</html>
<%
} else {
// Admin is not logged in, redirect to login page
response.sendRedirect("adminlogin.jsp");
}
%>

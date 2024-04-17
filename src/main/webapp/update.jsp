<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<%  
    // Retrieve student ID from request parameter
    int studentId = Integer.parseInt(request.getParameter("id"));
	session.setAttribute("id", studentId);
 %>
<div class="register-container">
		<h2>Registration</h2>
		<form action="update" method="post">
			<div class="input-group">
				<label for="fname">Name: </label> <input type="text" id="fname"
					name="fname" required>
			</div>
			<div class="input-group">
				<label for="mname">Father's Name: </label> <input type="text" id="mname"
					name="mname" required>
			</div>
			<div class="input-group">
				<label for="lname">Last Name: </label> <input type="text" id="lname"
					name="lname" required>
			</div>
			<div class="input-group">
				<label for="email">Email: </label> <input type="email" id="email"
					name="email" required>
			</div>
			<div class="input-group">
				<label for="roll_no">Roll No.: </label> <input type="number" id="roll_no"
					name="roll_no" required>
			</div>
			<div class="input-group">
				<label for="class">Class: </label> <input type="number" id="class"
					name="class" required>
			</div>
			<div class="input-group">
				<label for="city">City: </label> <input type="text" id="city"
					name="city" required>
			</div>
			<div class="input-group">
				<label for="contact">Contact: </label> <input type="tel" id="contact"
					name="contact" required>
			</div>
			<div class="input-group">
				<label for="gender">Gender</label> <select id="gender" name="gender"
					required>
					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="other">Other</option>
				</select>
			</div>
			<div class="input-group">
				<label for="password">Password: </label> <input type="password" id="password"
					name="password" required>
			</div>
			<button type="submit" class="btn">Update</button>
		</form>
		
	</div>
</body>
</html>
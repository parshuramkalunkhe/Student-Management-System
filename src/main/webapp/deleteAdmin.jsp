<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Admin</title>
</head>
<body>
<div class="register-container">
		<h2>Delete Admin</h2>
		<form action="deleteAdmin" method="post">
			<div class="input-group">
				<label for="adminname">Name: </label> <input type="text" id="adminname"
					name="adminname" required>
			</div>
			<div class="input-group">
				<label for="adminemail">Email: </label> <input type="email" id="adminemail"
					name="adminemail" required>
			</div>			
			<div class="input-group">
				<label for="adminpassword">Password: </label> <input type="password" id="adminpassword"
					name="adminpassword" required>
			</div>
			<button type="submit" class="btn">delete</button>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Register</legend>
		<form action="./register" method="post">
			<table>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td>DOJ :</td>
					<td><input type="date" name="doj"></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><select name="gender" required="required">
							<option value="male">Male</option>
							<option value="female">Female</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="reset" name="reset"></td>
					<td><input type="submit" name="register"></td>
				</tr>
			</table>
		</form>
		<a href="./login">Click to Login</a>
	</fieldset>

</body>
</html>
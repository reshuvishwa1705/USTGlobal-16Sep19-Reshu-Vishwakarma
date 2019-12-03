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
		<legend>Form</legend>
		<form action="./form" method="post">
			<table align='center'>
				<tr>
					<td>Id</td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Passwword</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender"></td>
				</tr>
				<tr>
					<td>Date</td>
					<td><input type="date" name="doj"></td>
				</tr>
				<tr>
					<td><input type="reset" value=reset></td>
					<td><input type="submit" value="register"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
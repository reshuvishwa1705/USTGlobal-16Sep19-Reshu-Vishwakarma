<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="msg" class="java.lang.String" scope="request"></jsp:useBean>
<%
String id = "";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("alwaysRemember")) {
			id = cookie.getValue();
		}
	}
}
%>
<body>
<h4><%=msg %></h4>
<fieldset align='center'>
<legend>Login</legend>
<form action='./login' method='post'>
<table align='center'>
<tr>
<td>Id:</td>
<td><input type='number' name='id' value='<%=id %>'></td>
</tr>
<tr>
<td>Password:</td>
<td><input type='password' name='password'></td>
</tr>
<tr>
<td></td>
<td><input type='checkbox' name='rememberme' value='checked'>RememberMe</td>
</tr>
<tr>
<td><input type='reset' value='Reset'></td>
<td><input type='submit' name='login' value='login'></td>
</tr>
</table>
</form>
</fieldset>
</body>
<a href='./register.html'>Register</a>
</html>
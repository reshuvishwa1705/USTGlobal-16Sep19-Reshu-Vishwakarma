<%@page import="com.ustglobal.empwebapp.dto.EmployeeInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	EmployeeInfo info = (EmployeeInfo) request.getAttribute("info");
%>
<body>
	<a href='./home'>Home</a>
	<a style='float: right' href='./logout'>Logout</a>
	<%if(info!=null) {%>
	<fieldset>
		<legend align="center">Employee Info</legend>
		<table align='center'>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Gmail</td>
			</tr>
			<tr>
				<td><%=info.getId()%></td>
				<td><%=info.getName()%></td>
				<td><%=info.getEmail()%></td>
			</tr>
		</table>
	</fieldset>
	<% } else {%>
	<h4>No data is Found</h4>
	<%} %>
</body>
</html>
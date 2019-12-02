<%@page import="com.ustglobal.retailerapp.dto.RetailerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	RetailerBean bean = (RetailerBean)session.getAttribute("bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./updatepassword">Update Password</a>
	<a href="#">AmountPayable</a>
	<a href="#">Retreive  Order</a>
	<a href="./logout" style="float: right;">Logout</a>
	<h2>
		Welcome
		<%=bean.getName()%></h2>
	<fieldset>
		<legend>Search Employee</legend>
		<form action="./search">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="number" name="id"></td>
				<td><input type="submit" value="search"></td>
			</tr>
		</table>
		</form>
	</fieldset>
	<%
		RetailerBean bean2 = (RetailerBean) request.getAttribute("bean");
	%>
	<%
		if (bean2 != null) {
	%>
	<table>
		<tr>
			<td>ProductName</td>
		</tr>
		

	</table>
	<%}%>
<h3>${msg}</h3>
</body>
</html>
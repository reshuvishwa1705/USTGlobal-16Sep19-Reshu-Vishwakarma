<%@page import="com.ustglobal.spring_mvc.beans.Hotel"%>
<%@page import="com.ustglobal.spring_mvc.beans.Retailer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Retailer bean = (Retailer) session.getAttribute("bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./changepassword">Change Password</a>&nbsp;
	<a href="./update">Update Profile</a>&nbsp;&nbsp;&nbsp;<a href="./delete">Delete Profile</a>
	
	<a href="./logout" style='float: right'>Logout</a>
	
	<h2>
		Welcome
		<%=bean.getName()%></h2>
	<fieldset>
		<legend>Search For Products</legend>
		<form action="./search">
			<table>
				<tr>
					<td>Id :</td>
					<td><input type="number" name="id"></td>
					<td><input type="submit" value="search"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<br>
	<br>
	<% 
	Hotel hotelbean = (Hotel)request.getAttribute("bean");
	%>
	<%
	if(hotelbean != null){
	%>
	<table border="1px">
		<tr>
		    <td>Order Id</td>
			<td>ProductName</td>
			<td>Price Per Unit</td>
			<td>Quantity</td>
			<td>Amount Payable</td>
			<td>Retailer id</td>
		</tr>
		<tr>
		    <td><%=hotelbean.getOrderId() %></td>
			<td><%=hotelbean.getProductName() %></td>
			<td><%=hotelbean.getPricePerUnit()%></td>
			<td><%=hotelbean.getQuantity() %></td>
			<td><%=hotelbean.getAmount() %></td>
			<td><%=hotelbean.getRetailerId() %></td>
		</tr>
	</table>
<%
}
%>
<h3>${msg}</h3>

</body>
</html>
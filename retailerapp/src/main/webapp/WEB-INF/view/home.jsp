<%@page import="com.ustglobal.retailerapp.dto.ProductBean"%>
<%@page import="com.ustglobal.retailerapp.dto.OrderBean"%>
<%@page import="com.ustglobal.retailerapp.dto.RetailerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	RetailerBean bean = (RetailerBean) session.getAttribute("bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./updatepassword">Update Password</a>
	<a href="/amount">AmountPayable</a>
	<a href="#">Retreive Order</a>
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
					<td><input type="number" name="pid"></td>
					<td><input type="submit" value="search"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	OrderBean bean2 = (OrderBean) request.getAttribute("bean");
	%>
	<%
		if (bean2 != null) {
	%>
	<table>
		<tr>
			<td>ProductName</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>Buy Product</td>

		</tr>
		<tr>
			<td><%=bean2.getProductBean().getPname()%></td>
			<td><%=bean2.getPrice()%></td>
			<td><%=bean2.getQuantity()%></td>
			<td><a href="#">Buy</a></td>
		</tr>

	</table>
	<%
		}
	%>
	<h3>${msg}</h3>
</body>
</html>
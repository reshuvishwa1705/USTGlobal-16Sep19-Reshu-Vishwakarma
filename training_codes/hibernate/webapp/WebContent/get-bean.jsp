<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="obj" class="com.ustglobal.webapp.servlets.Employee" scope="request"/>
<body>
<h1><%=obj.getId() %></h1>
<h1><%=obj.getName() %></h1>
</body>
</html>
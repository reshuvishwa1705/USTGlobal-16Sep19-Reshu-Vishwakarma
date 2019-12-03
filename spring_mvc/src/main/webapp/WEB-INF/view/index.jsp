<%
String s = (String)request.getAttribute("msg");
%>
<html>
<body>
<h2 style="color:red;">${msg}</h2>
<h2 style="color:green;"><%=s%></h2>
<h3 style="color:brown;">${name}</h3>
<h3 style="color:mageenta;">${id}</h3>
</body>
</html>

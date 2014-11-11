<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String c = "teststring";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	hello
	<%-- <%=c%> --%>
	world!!
	<%
	/* this is a jsp! */
	int a = 1;
	int b = 2;
	out.println("this is number" + a + "<br>");
	out.println("this is a number" + b + "<br>");
	out.println("this is a string" + c + "<br>");
%>

</body>
</html>
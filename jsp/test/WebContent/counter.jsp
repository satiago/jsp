<%@page import="com.CounterListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Counter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>counter</title>
</head>
<body>
<jsp:useBean id="beano" scope="application" class="com.Counter"/>
<jsp:setProperty property="count" name="beano" value="10"/>
<% 
session.setAttribute("counter", "2");
out.print("the counter is:" + beano.getCount() + "<br>"); 
out.print("当前在线用户：" + CounterListener.count);
%>
</body>
</html>
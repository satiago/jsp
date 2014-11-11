<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
</head>
<body>
<table width="300" border="1">
<tr>
<td>str1=<%=(String)session.getAttribute("str1") %></td>
</tr>
<tr>
<td>str2=<%=(String)session.getAttribute("str2") %></td>
</tr>
<tr>
<td><a href="input.jsp">返回</a></td>
</tr>
</table>
</body>
</html>
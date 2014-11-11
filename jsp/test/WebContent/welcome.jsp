<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<script src="function.js"></script>
<body>
<table width="300" height="300" align="center" border="1">  
<tr>
<td colspan="2" height="100" align="center">
登录成功
</td>
</tr>
<tr>
<td height="100" align="center">
欢迎你
</td>
<td height="100" align="center">
<%=(String)session.getAttribute("username")%>
</td>
</tr>
<tr>
<td height="100" colspan="2" align="center" bgcolor="#FFFFFF">
<button name="logout" style="color: #F00">退出</button>
</td>
</tr>
</table>
</body>
</html>
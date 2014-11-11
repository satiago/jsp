<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="function.js"></script>
<body>
	<form name="form1" action="UserServlet.do?method=login" method="post" onSubmit="return check();">
		<table width="300" height="400" align="center" border="1">
			<tr>
				<td height="100" align="center">登录窗口</td>
			</tr>
			<tr>
				<td heigth="100" align="center">用户名：<input name="username"
					type="text" size=20 />
				</td>
			</tr>
			<tr>
				<td heigth="100" align="center">密码：<input name="password"
					type="password" size=20 />
				</td>
			</tr>
			<tr>
				<td heigth="100" align="center"><input name="submit"
					type="submit" value="登录" /> <a href="register.jsp">注册新用户</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
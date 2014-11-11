<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8"); 
response.setContentType("text/html; charset=utf-8"); 
%>
<%@ include file="conn.jsp"%>
<%

String username = request.getParameter("username");
String password = request.getParameter("password");

if(username == null || password == null)
{
	out.print("username="+username+" password="+password+"<br>");
	response.sendRedirect("login.jsp");
}

out.print("username="+username+" password="+password);
boolean isValid = false;
String sql = "select * from tb_user where username='"+username+"' and pwd='"+password+"'";
out.print(sql);
Class.forName(driver).newInstance();

try {
	Connection conn = DriverManager.getConnection(url, usr, pwd);

	Statement stmt = conn.createStatement();
	stmt.executeQuery("set names utf8");
	ResultSet rs = stmt.executeQuery(sql);
	ResultSetMetaData rsmd = rs.getMetaData();
	int cols = rsmd.getColumnCount();
	out.print("cols="+cols+"<br>");
	
	while(rs.next())
	{
		String field = (String) (rsmd.getColumnClassName(2));
		String value = (String) (rs.getString(2));
		out.print(field+"="+value+"<br>");
		isValid = true;
	}
	
	rs.close();
	stmt.close();
	conn.close();
} catch (Exception e) {

	e.printStackTrace();
	out.println(e);
	out.print("<script>alert('错误！');</script>");
}

if(isValid)
{
	session.setAttribute("username", username);
	out.print("<script>alert('登录成功！');</script>");
	response.sendRedirect("welcome.jsp");
}
else
{
	out.print("<script>alert('登录失败！');</script>");
	//response.sendRedirect("login.jsp");
}
%>
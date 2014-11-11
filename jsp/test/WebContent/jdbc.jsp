<%@page import="com.sun.source.tree.TryTree"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8"); 
response.setContentType("text/html; charset=utf-8"); 
%>
<%@ include file="conn.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jdbc测试</title>
</head>
<body>
<%
String sql = "select content from tb_content";
String insert = "insert into tb_category (category, icon, bz_id) values ('中文测试','1','2')";
String insert2 = new String(insert.getBytes(), "UTF-8");
Class.forName(driver).newInstance();

try {
	Connection conn = DriverManager.getConnection(url, usr, pwd);

	Statement stmt = conn.createStatement();
	stmt.executeQuery("set names utf8");
	stmt.executeUpdate(insert2);
/* 	ResultSetMetaData rsmd = rs.getMetaData();
	int cols = rsmd.getColumnCount();
	out.print("cols="+cols+"<br>");
	
	if(rs.next())
	{
			String field = (String) (rsmd.getColumnClassName(1));
			String value = (String) (rs.getString(1));
			out.print(field+"="+value+"<br>");
	}
	 */
	//rs.close();
	stmt.close();
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
	out.println(e);
}
%>
</body>
</html>
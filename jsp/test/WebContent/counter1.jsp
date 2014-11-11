<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Counter" %>
    <%@ page import="com.DBAccess" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>count1</title>
</head>
<body>
<jsp:useBean id="beano1" scope="application" class="com.Counter"></jsp:useBean>
The counter is :
<jsp:getProperty property="count" name="beano1"/>
<jsp:useBean id="db" scope="application" class="com.DBAccess"></jsp:useBean>
<%
DBAccess db1 = new DBAccess();
db1.createConn();
String sql = "select * from tb_reply_content";
db1.query(sql);
while(db1.next())
{
	String data = db1.getValue("reply_content");
	out.print(data + "<br>");
}
%>
</body>
</html>
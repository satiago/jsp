<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:set var="context_path"
	value="#parameters.action[0]"></s:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
String a = "fdsafsas";
String b = "woshib";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写表单</title>
</head>
<body>
<%=b %>
<%=a %>
<s:property value="context_path"/>
<a href="sssss/${context_path}">DDDD</a>
<form action="test.action" method="post">
<input type="text" name="str1">
<input type="text" name="str2">
<input type="submit" value="提交">
</form>
</body>
</html>
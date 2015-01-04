<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib uri="http://www.test.com/mytag" prefix="mytaglib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
div {
	float: left;
	padding: 3px;
	width: 50px;
	text-align: center;
	border: 1px solid #763284;
}
</style>
<body>
	<h1>自定义标签演示：</h1>
	<mytaglib:copyright man="mantest" cop="coptest"></mytaglib:copyright>
	<br>
	<mytaglib:tolowercasetag>HE IS A TOLOWCASETAG</mytaglib:tolowercasetag>
	<br>
	<h1>自定义标签2.x演示</h1>
	<mytaglib:mytag2 title="jsp2.xx" man="that is right" />
<mytaglib:multiattrtag>
	<jsp:attribute name="body1">标签体1</jsp:attribute>
	<jsp:attribute name="body2">标签体2</jsp:attribute>
</mytaglib:multiattrtag>
	<h1>core标准库标签演示：</h1>
	<c:out value="${param.action}"></c:out>
	<c:choose>
		<c:when test="${param.action}">
			when
		</c:when>
		<c:otherwise>
			otherwise
		</c:otherwise>
	</c:choose>
	<br>
	<c:forEach var="num" begin="2" end="100" step="2">
		<div>${num}</div>
	</c:forEach>
	<br>
	<br>
	<h1>xml标准库标签演示：</h1>
	<x:parse var="content">
		<student name="litiedan"> <age>18</age> <class>二十八</class> </student>
	</x:parse>
	name:
	<x:out select="$content/student/@name" />
	<br> age:
	<x:out select="$content/student/age" />
	class:
	<x:out select="$content/student/class" />

</body>
</html>
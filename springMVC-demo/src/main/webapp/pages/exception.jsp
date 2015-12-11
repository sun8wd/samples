<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVC-demo</title>
<base href="<%=basePath%>" />
</head>
<body>
	<h2>${msg }</h2>
	<h3>
		<a href="exception/business">业务异常</a>
	</h3>
	<h3>
		<a href="exception/error">未知异常</a>
	</h3>
</body>
</html>
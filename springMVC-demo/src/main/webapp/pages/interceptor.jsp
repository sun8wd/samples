<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>拦截器</title>
</head>
<body>
	<h2>consumeTime:<%=request.getAttribute("consumeTime") %></h2>
	<h2>randomBoolean:<%=request.getAttribute("randomBoolean") %></h2>
	<h2>randomInt:<%=request.getAttribute("randomInt") %></h2>
</body>
</html>
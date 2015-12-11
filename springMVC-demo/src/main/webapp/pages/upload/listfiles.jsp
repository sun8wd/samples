<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listfiles</title>
</head>
<body>
	<table>
		<tr>
			<th>文件名</th>
			<th>下载</th>
		</tr>
		<c:forEach items="${files }" var="file">
			<tr>
				<td>${file }</td>
				<td><a href="/springMVC-demo/files/download?filename=${file}">下载</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
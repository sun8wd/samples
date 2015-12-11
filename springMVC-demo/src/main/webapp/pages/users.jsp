<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="width:100%" border="2">
		<thead>
			<tr>
				<th>#</th>
				<th>姓名</th>
				<th>电话</th>
				<th>生日</th>
				<th>年龄</th>
				<th>身高</th>
				<th>已婚</th>
				<th>地址</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.phone }</td>
					<td>${user.birthday }</td>
					<td>${user.age }</td>
					<td>${user.height }</td>
					<td>${user.married?"是":"否" }</td>
					<td>${user.address }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
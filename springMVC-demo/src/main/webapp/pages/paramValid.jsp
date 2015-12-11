<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参数校验</title>
<base href="<%=basePath%>" />
</head>
<body>
	<form:form action="paramValid/addStudent" commandName="student"
		method="get">
		<table>
			<tr>
				<td>编号：</td>
				<td><form:input path="code" /></td>
				<td><small><form:errors path="code"
							cssStyle="color:red" /></small></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><form:input path="name" /></td>
				<td><small><form:errors path="name"
							cssStyle="color:red" /></small></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><form:input path="age" /></td>
				<td><small><form:errors path="age" cssStyle="color:red" /></small></td>
			</tr>
		</table>
		<input type="submit" value="提交" />
	</form:form>

</body>
</html>
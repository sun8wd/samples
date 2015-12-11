<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/user/addUser" method="post">
		<label>姓名</label><form:input path="user.name"/><br />
		<label>电话</label><form:input path="user.phone"/><br />
		<label>生日</label><form:input path="user.birthday"/><br />
		<label>年龄</label><form:input path="user.age"/><br />
		<label>身高</label><form:input path="user.height"/><br />
		<label>已婚</label><form:checkbox path="user.married"/><br />
		<label>地址</label><form:input path="user.address"/><br />
		<label>stu</label><form:input path="student.name"/><br />
		<input type="submit" value="提交"> <input type="reset" value="重置"/>
	</form:form>
</body>
</html>
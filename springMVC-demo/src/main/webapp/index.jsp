<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVC-demo</title>
<base href="<%=basePath%>" />
</head>
<body>
	<a href="pages/params.jsp">参数传递</a><br /><br />
	<a href="paramValid/toAdd">参数校验</a><br /><br />
	<a>数据绑定</a><br /><br />
	<a href="pages/exception.jsp">异常处理</a><br /><br />
	<a href="interceptor/index">拦截器</a><br /><br />
	<a href="pages/upload/upload.jsp">文件上传</a><br /><br />
	<a href="files/listfiles">文件下载</a><br /><br />
	<a>依赖注入：classpath:springMVC.xml</a><br /><br />
	<a>面向切面:单元测试com.celloud.dao.impl.StudentDaoTest</a><br /><br />
	<a>事务管理:单元测试com.celloud.service.StudentServiceTest</a><br /><br />
	<a>mybatis:单元测试com.celloud.dao.impl.StudentDaoTest</a><br /><br />
	<a>mongodb:单元测试com.celloud.service.StudentServiceTest</a><br /><br />
	<a href="pjax/index">pjax</a><br /><br />
</body>
</html>
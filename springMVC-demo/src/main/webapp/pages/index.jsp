<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVC-demo</title>
<!-- Latest compiled and minified CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap-theme.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">springMVC demo</div>
					<!-- List group -->
					<div class="list-group">
						<a class="list-group-item" href="<%=request.getContextPath()%>/pages/params.jsp">参数传递</a>
						<a class="list-group-item" href="<%=request.getContextPath()%>/paramValid/toAdd">参数校验</a>
						<a class="list-group-item">数据绑定</a>
						<a class="list-group-item" href="<%=request.getContextPath()%>/pages/exception.jsp">异常处理</a>
						<a class="list-group-item" href="<%=request.getContextPath()%>/interceptor/index">拦截器</a>
						<a class="list-group-item" href="<%=request.getContextPath()%>/pages/upload/upload.jsp">文件上传</a>
						<a class="list-group-item" href="<%=request.getContextPath()%>/files/listfiles">文件下载</a>
						<a class="list-group-item">依赖注入：classpath:springMVC.xml</a>
						<a class="list-group-item">面向切面:单元测试com.celloud.dao.impl.StudentDaoTest</a>
						<a class="list-group-item">事务管理:单元测试com.celloud.service.StudentServiceTest</a>
						<a class="list-group-item">mybatis:单元测试com.celloud.dao.impl.StudentDaoTest</a>
						<a class="list-group-item">mongodb:单元测试com.celloud.service.StudentServiceTest</a>
						<a class="list-group-item" href="<%=request.getContextPath()%>/pjax/index">pjax</a>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">shiro demo</div>
					<div class="panel-body">
						<p>
							<span class="glyphicon glyphicon-ok">有权限</span>
							<span class="glyphicon glyphicon-remove">无权限</span>
						</p>
					</div>
					<!-- List group -->
					<div class="list-group">
						<c:forEach items="${resources }" var="resource">
							<a class="list-group-item">
								<shiro:hasPermission name="${resource.permission }">
									<i class="glyphicon glyphicon-ok"></i>
								</shiro:hasPermission>
								<shiro:lacksPermission name="${resource.permission }">
									<i class="glyphicon glyphicon-remove"></i>
								</shiro:lacksPermission>
								${resource.name }${resource.type=='menu'?'菜单':'按钮' } ${resource.permission }
							</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/plugin/bootstrap/js/bootstrap.min.js"></script>
</html>
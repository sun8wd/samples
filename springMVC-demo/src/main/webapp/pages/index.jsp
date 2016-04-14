<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVC-demo</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">SpringMVC-demo</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<i class="glyphicon glyphicon-user"></i>
						<shiro:principal />
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="<%=request.getContextPath()%>/logout">
								<i class="glyphicon glyphicon-log-out"></i> 退出登录
							</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/chat/index">
								<i class="glyphicon glyphicon-align-left"></i> 聊天室
							</a>
						</li>
						<li>
							<a href="#"><i class="glyphicon glyphicon-align-center"></i> Something else here</a>
						</li>
						<li role="separator" class="divider"></li>
						<li>
							<a href="#"><i class="glyphicon glyphicon-align-right"></i> Separated link</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</body>
</html>
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
<body  ng-app="celloudApp">
	<jsp:include page="../navbar.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">UI-Route Demo</div>
					<!-- List group -->
					<div class="list-group">
						<a class="list-group-item" ui-sref="hello" ui-sref-active="active">hello</a>
						<a class="list-group-item" ui-sref="about" ui-sref-active="active">about</a>
						<a class="list-group-item" ui-sref="user.list()" ui-sref-active="active" ui-sref-opt="{reload:true}">users</a>
					</div>
				</div>
			</div>
			<div class="col-md-10">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">shiro demo</div>
					<div class="panel-body">
						<div ui-view></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="//cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>
	<script src="//cdn.bootcss.com/angular.js/1.5.8/angular-route.min.js"></script>
	<script src="//cdn.bootcss.com/angular.js/1.5.8/angular-resource.min.js"></script>
	<script src="//cdn.bootcss.com/angular-ui-router/1.0.0-beta.3/angular-ui-router.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/angular/main.js"></script>
</html>
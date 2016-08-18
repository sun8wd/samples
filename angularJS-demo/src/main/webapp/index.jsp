<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!doctype html>
<html lang="en">
<head>
<title>AngularJS+RequireJS</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h2>AngularJS+RequireJS!</h2>
	<div>
		<a ng-href="#/view1" class="btn btn-default">view1</a>
		<a ng-href="#/view2" class="btn btn-default">view2</a>
	</div>
	<div ng-view class="well"></div>
	<script src="<%=request.getContextPath()%>/resources/js/require.js" data-main="resources/js/main"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head lang="EN">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springMVC-demo login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<br> <br> <br> <br> <br> <br>
				<form class="form-signin" action="<%=request.getContextPath()%>/login" method="post">
					<h2 class="form-signin-heading">Please sign in</h2>
					<label for="inputEmail" class="sr-only">Email address</label>
					<input type="text" name="username" id="inputEmail" class="form-control" placeholder="Email address">
					<label for="inputPassword" class="sr-only">Password</label>
					<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password">
					<div class="checkbox">
						<c:choose>
							<c:when test="${rememberMe}">
								<label><input type="checkbox" checked="checked" name="rememberMe" value="true"> Remember me</label>
							</c:when>
							<c:otherwise>
								<label><input type="checkbox" name="rememberMe" value="true"> Remember me</label>
							</c:otherwise>
						</c:choose>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
					<span style="color: red;">${message }</span>
				</form>
			</div>
		</div>
	</div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</body>
</html>
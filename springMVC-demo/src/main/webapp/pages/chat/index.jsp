<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVC-demo</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap-theme.min.css">
</head>
<body>
	<jsp:include page="../navbar.jsp">
		<jsp:param value="chat" name="nav" />
	</jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<div class="panel panel-default">
					<div class="panel-heading">在线用户</div>
					<!-- List group -->
					<ul class="list-group" id="users">
					</ul>
				</div>
			</div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">聊天室</div>
							<div class="panel-body" style="height: 400px; overflow: auto;" id="chats"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-10">
								<textarea id="message" rows="4" style="width: 100%; height: 50px;"></textarea>
							</div>
							<div class="col-md-2" style="height: 50px;">
								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default btn-lg" onclick="messageUtils.sendMessage()">发送</button>
									<button type="button" class="btn btn-default btn-lg dropdown-toggle" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<span class="caret"></span>
										<span class="sr-only"></span>
									</button>
									<ul class="dropdown-menu">
										<li>
											<a href="javascript:;">Ctrl+Enter</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="<%=request.getContextPath()%>/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/sockjs-1.0.0.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/test.js"></script>
</body>
</html>
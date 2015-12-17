<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="jsp_layout.tld" prefix="layout"%>
<%
	String active = request.getParameter("active");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>pjax</title>
<link
	href='${pageContext.request.contextPath }/plugin/bootstrap/css/bootstrap.min.css'
	rel="stylesheet" />
<layout:block name="styles" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-3">
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation"
						class='<%="home".equals(active) ? "active" : ""%>'>
						<a class="pjax"
							href="${pageContext.request.contextPath }/pjax/home">首页</a>
					</li>
					<li role="presentation"
						class='<%="studentList".equals(active) ? "active" : ""%>'>
						<a id="student" class="pjax"
							href="${pageContext.request.contextPath }/pjax/student/list">学生</a>
					</li>
					<li role="presentation"
						class='<%="teacherList".equals(active) ? "active" : ""%>'>
						<a class="pjax"
							href="${pageContext.request.contextPath }/pjax/teacher/list">老师</a>
					</li>
					<li role="presentation"
						class='<%="userList".equals(active) ? "active" : ""%>'>
						<a class="pjax"
							href="${pageContext.request.contextPath }/pjax/user/list">用户</a>
					</li>
				</ul>
			</div>
			<div class="col-xs-9">
				<div id="main" class="center-block">
					<layout:block name="content" />
				</div>
			</div>
		</div>
	</div>
	<div id="test"></div>
	<script
		src='${pageContext.request.contextPath }/js/jquery-1.11.3.min.js'></script>
	<script src='${pageContext.request.contextPath }/js/jquery.pjax.js'></script>
	<script
		src='${pageContext.request.contextPath }/plugin/bootstrap/js/bootstrap.min.js'></script>
	<layout:block name="scripts" />
	<script type="text/javascript">
		$(document).ready(function() {
			$(document).pjax('a', '#main');
			$(document).on('pjax:complete', function(xhr, textStatus, options) {
			});
			$(document).on('pjax:start', function(xhr, options) {
			});
			$(document).on('pjax:beforeReplace', function(contents, options) {
				activeMenu(contents.state.url);
			});
			function activeMenu(url) {
				url = subUrl(url);
				$(".nav").children("li").each(function(index, item) {
					var $this = $(this);
					var menuUrl = $this.find("a").attr("href");
					menuUrl = subUrl(menuUrl);
					var index = url.indexOf(menuUrl);
					if (index >= 0 && url.substr(index) == menuUrl) {
						$this.addClass("active");
						$this.siblings().removeClass("active");
					}
				});
			}
			function subUrl(url) {
				var index = url.indexOf("?");
				return index >= 0 ? url.substr(0, index) : url;
			}
		});
	</script>
</body>
</html>
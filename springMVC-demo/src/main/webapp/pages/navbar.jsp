<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
    String nav = String.valueOf(request.getParameter("nav"));
    String[] fileNavs = { "upload", "download" };
    boolean isFile = false;
    for (String fileNav : fileNavs) {
        if (fileNav.equals(nav)) {
            isFile = true;
            break;
        }
    }
%>
<div class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/index">
				<i class="glyphicon glyphicon-book"></i> SpringMVC-demo
			</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="<%="chat".equals(nav) ? "active" : ""%>">
				<a href="<%=request.getContextPath()%>/chat">
					<i class="glyphicon glyphicon-th-list"></i> 聊天室
				</a>
			</li>
			<li class="dropdown <%=isFile ? "active" : ""%>">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					<i class="glyphicon glyphicon-file"></i> 上传下载
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li class="<%="upload".equals(nav) ? "active" : ""%>">
						<a href="<%=request.getContextPath()%>/files">
							<i class="glyphicon glyphicon-upload"></i> 文件上传
						</a>
					</li>
					<li class="disabled">
						<a href="#">
							<i class="glyphicon glyphicon-download"></i> 文件下载
						</a>
					</li>
				</ul>
			</li>
			<li class="dropdown <%=nav.startsWith("alioss_") ? "active" : ""%>">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					<i class="glyphicon glyphicon-cloud"></i> 阿里云OSS
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li class="<%="alioss_sdk".equals(nav) ? "active" : ""%>">
						<a href="<%=request.getContextPath()%>/aliyun/sdk">
							<i class="glyphicon glyphicon-cloud-upload"></i> 官方sdk方式上传
						</a>
					</li>
					<li class="<%="alioss_plupload".equals(nav) ? "active" : ""%>">
						<a href="<%=request.getContextPath()%>/aliyun/plupload">
							<i class="glyphicon glyphicon-upload"></i> 使用plupload上传
						</a>
					</li>
				</ul>
			</li>
		</ul>
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
							<i class="glyphicon glyphicon-log-out"></i> LOGOUT
						</a>
					</li>
					<li>
						<a href="#">
							<i class="glyphicon glyphicon-align-left"></i> Another action
						</a>
					</li>
					<li>
						<a href="#">
							<i class="glyphicon glyphicon-align-center"></i> Something else here
						</a>
					</li>
					<li role="separator" class="divider"></li>
					<li>
						<a href="#">
							<i class="glyphicon glyphicon-align-right"></i> Separated link
						</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</div>

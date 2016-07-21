<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.celloud.utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CelLoud-box 文件上传</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap-theme.min.css">
</head>
<body>
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
				<a class="navbar-brand" href="<%=request.getContextPath()%>/box">
					<i class="glyphicon glyphicon-inbox"></i> CelLoud-Box
				</a>
			</div>
			<ul class="nav navbar-nav">
				<li>
					<a href="<%=request.getContextPath()%>/box">
						<i class="glyphicon glyphicon-upload"></i> Upload
					</a>
				</li>
				<li class="active">
					<a href="<%=request.getContextPath()%>/box/list">
						<i class="glyphicon glyphicon-th-list"></i> List
					</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="<%=request.getContextPath()%>/box">
						<i class="glyphicon glyphicon-user"></i>
						<shiro:principal />
						celloud
					</a>
				</li>
			</ul>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<h4>Celloud-Box&nbsp;&nbsp;文件上传</h4>
					</div>
					<div style="min-height: 500px;">
						<table class="table">
							<thead>
								<tr>
									<th>文件名</th>
									<th class="text-center">上传时间</th>
									<th class="text-right">文件大小</th>
									<th class="text-right">压缩后大小</th>
									<th class="text-right">压缩率</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${files }" var="file">
									<tr>
										<td title="${file.id }">${file.filename }</td>
										<td align="center">
											<fmt:formatDate value="${file.uploadTime }" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td align="right">${file.fileSizeString }</td>
										<td align="right">${file.zipFileSizeString }</td>
										<td align="right">${file.compressionRatio }</td>
										<td align="center">
											<a href="${file.objectUrl }" title="从oss下载压缩后的文件" target="_blank">下载</a>
											|
											<a id="compressionBtn-${file.id }" href="javascript:;" onclick="compression('${file.id }')" title="重新压缩并上传此文件" target="_blank">压缩</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer">
						<button type="button" class="btn btn-default" aria-label="add file" onclick="deleteAll()">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							全部清空
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	    window.contextPath = '<%=request.getContextPath()%>';
		function deleteAll() {
			if (confirm("此操作将会同时清空盒子和远程的数据，确定进行此操作吗？")) {
				$.get(contextPath + "/box/deleteAll", function() {
					window.location.reload();
				});
			}
		}
		function compression(id) {
			$("#compressionBtn-"+id).attr("disabled","disabled");
			$.get(contextPath + "/box/sync",{'id':id}, function() {
				$("#compressionBtn-"+id).removeAttr("disabled");
            });
		}
	</script>
</body>
</html>
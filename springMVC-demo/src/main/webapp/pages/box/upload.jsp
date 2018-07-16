<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
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
				<li class="active">
					<a href="<%=request.getContextPath()%>/box">
						<i class="glyphicon glyphicon-upload"></i> Upload
					</a>
				</li>
				<li class="">
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
									<th>MD5</th>
									<th width="10%;" class="text-right">进度</th>
									<th width="10%;" class="text-right">大小</th>
									<th width="10%;" class="text-right">上传速度</th>
									<th width="10%;" class="text-center">状态</th>
								</tr>
							</thead>
							<tbody id="uploader">
							</tbody>
						</table>
					</div>
					<div class="panel-footer">
						<button type="button" class="btn btn-default" aria-label="add file" id="uploadBtn">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							添加文件
						</button>
						<button type="button" class="btn btn-default" aria-label="add file" id="startUpload">
							<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
							开始上传
						</button>
						<button type="button" class="btn btn-default" aria-label="add file" id="startUploadTest">
							<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
							呵呵哒
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	   window.contextPath = '<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/plugin/plupload-2.1.8/js/plupload.full.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/box-upload.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springMVC-demo 文件上传</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap-theme.min.css">
</head>
<body>
	<jsp:include page="../navbar.jsp">
		<jsp:param value="upload" name="nav" />
	</jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<h4>Plupload&nbsp;&nbsp;断点续传</h4>
					</div>
					<div class="panel-body">请在/user.home/Documents/testUpload下查看运行结果</div>
					<div style="min-height: 200px; border-top: solid #ddd 1px;">
						<table class="table">
							<thead>
								<tr>
									<th>文件名</th>
									<th>MD5</th>
									<th width="10%;" class="text-right">进度</th>
									<th width="10%;" class="text-right">大小</th>
									<th width="10%;" class="text-right">速度</th>
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
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">upload1</div>
					<div class="panel-body">
						<form action="/springMVC-demo/files/upload1" enctype="multipart/form-data" method="post">
							<input type="file" name="file">
							<br />
							<input type="file" name="file">
							<br />
							<input type="file" name="file">
							<br />
							<input type="file" name="file">
							<br />
							<input type="file" name="file">
							<br /> <br />
							<input type="submit" value="上传" />
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">upload2</div>
					<div class="panel-body">
						<form action="/springMVC-demo/files/upload2" enctype="multipart/form-data" method="post">
							<input type="file" name="file_1">
							<br />
							<input type="file" name="file_2">
							<br />
							<input type="file" name="file_3">
							<br />
							<input type="file" name="file_4">
							<br />
							<input type="file" name="file_5">
							<br /> <br />
							<input type="submit" value="上传" />
						</form>
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
	<script src="<%=request.getContextPath()%>/js/upload.js"></script>
</body>
</html>
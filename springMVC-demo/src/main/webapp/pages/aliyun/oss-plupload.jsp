<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springMVC-demo 阿里云OSS</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugin/bootstrap/css/bootstrap-theme.min.css">
<script src="http://gosspublic.alicdn.com/aliyun-oss-sdk-4.3.0.min.js"></script>
</head>
<body>
	<jsp:include page="../navbar.jsp">
		<jsp:param value="alioss_plupload" name="nav" />
	</jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<h4>阿里云OSS  --  plupload文件上传</h4>
					</div>
					<div style="min-height: 400px;">
						<table class="table">
							<thead>
								<tr>
									<th>文件名</th>
									<th>ETag</th>
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
						<div class="row">
							<div class="col-md-6">
								<button type="button" class="btn btn-default" aria-label="add file" id="uploadBtn">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									添加文件
								</button>
								<button type="button" class="btn btn-default" aria-label="add file" id="startUpload">
									<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
									开始上传
								</button>
							</div>
							<div class="col-md-6 ">
								<button id="listAll" class="btn btn-default pull-right">所有文件</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" tabindex="-1" role="dialog" id="allFilesModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">阿里云OSS上的所有文件</h4>
				</div>
				<div class="modal-body">
					<table class="table">
						<thead>
							<tr>
								<th>name</th>
								<th>etag</th>
								<th class="text-center">lastModified</th>
								<th class="text-right">size</th>
							</tr>
						</thead>
						<tbody id="allFileList">
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script type="text/javascript">
       window.contextPath = '<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/plugin/plupload-2.1.8/js/plupload.full.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/base64.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/crypto1/crypto/crypto.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/crypto1/hmac/hmac.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/crypto1/sha1/sha1.js"></script>
	<script src="<%=request.getContextPath()%>/js/md5.js"></script>
	<script src="<%=request.getContextPath()%>/js/oss_sdk.js"></script>
	<script src="<%=request.getContextPath()%>/js/oss_plupload.js"></script>
</body>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload</title>
</head>
<body>
	<div style="background-color: #f9f6f4; border: 2px solid red;">
		<form action="/springMVC-demo/files/upload1"
			enctype="multipart/form-data" method="post">
			<h3>upload1</h3>
			<input type="file" name="file">
			<br />
			<input type="file" name="file">
			<br />
			<input type="file" name="file">
			<br />
			<input type="file" name="file">
			<br />
			<input type="file" name="file">
			<br />
			<br />
			<input type="submit" value="上传" />
		</form>
	</div>
	<br />
	<br />
	<div style="background-color: #e3e3e3; border: 2px solid red">
		<h3>upload2</h3>
		<form action="/springMVC-demo/files/upload2"
			enctype="multipart/form-data" method="post">
			<input type="file" name="file_1">
			<br />
			<input type="file" name="file_2">
			<br />
			<input type="file" name="file_3">
			<br />
			<input type="file" name="file_4">
			<br />
			<input type="file" name="file_5">
			<br />
			<br />
			<input type="submit" value="上传" />
		</form>
	</div>
</body>
</html>
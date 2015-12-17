<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jsp_layout.tld" prefix="layout"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<layout:block name="head">
	<title>Base Title</title>
</layout:block>
</head>
<body>
	<h2><%=request.getParameter("active") %></h2>
	<layout:block name="content">
      base_body_content
   </layout:block>
   
	<script src='<%=request.getContextPath() %>/js/jquery-1.11.3.min.js'></script>
	<script src='<%=request.getContextPath() %>/js/jquery.pjax.js'></script>
	<script src='${pageContext.request.contextPath }/plugin/bootstrap/js/bootstrap.min.js'></script>
</body>
</html>
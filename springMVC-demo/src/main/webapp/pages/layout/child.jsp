<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jsp_layout.tld" prefix="layout"%>
<layout:override name="head">
	<title>Child Title</title>
</layout:override>
<layout:override name="content" pjax="true">
      child_body_content
</layout:override>
<jsp:include page="base.jsp">
	<jsp:param value="home" name="active"/>
</jsp:include>
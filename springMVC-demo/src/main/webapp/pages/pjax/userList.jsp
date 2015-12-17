<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="jsp_layout.tld" prefix="layout"%>
<%
	boolean isPjax = request.getHeader("X-PJAX") != null;
%>
<layout:override name="content" pjax="<%=isPjax %>">
	<h2>用户列表---isPjax:<%=isPjax %></h2>
	<table class="table table-bordered  table-hover">
		<thead>
			<tr>
				<th align="center">#</th>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 1; i <= 15; i++) {
			%>
			<tr>
				<td><%=i%></td>
				<td><%=100000 + i%></td>
				<td>林永超</td>
				<td><%=20 + i%></td>
				<td>北京是朝阳区朝阳路住邦2000大厦4号楼2109</td>
				<td>
					<a href="javascript:void(0)">修改</a>
					<a href="javascript:void(0)">开除</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</layout:override>
<c:if test="<%=!isPjax%>">
	<jsp:include page="index.jsp">
		<jsp:param value="userList" name="active" />
	</jsp:include>
</c:if>

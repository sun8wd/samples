<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="table">
	<thead>
		<tr>
			<th>#</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>男</td>
			<td>28</td>
			<td>
				<a ui-sref="user.detail({id:1})">查看</a>
			</td>
		</tr>
		<tr>
			<td>2</td>
			<td>李四</td>
			<td>男</td>
			<td>28</td>
			<td>
				<a ui-sref="user.detail({id:2})">查看</a>
			</td>
		</tr>
		<tr>
			<td>3</td>
			<td>王五</td>
			<td>男</td>
			<td>28</td>
			<td>
				<a ui-sref="user.detail({id:3})">查看</a>
			</td>
		</tr>
		<tr>
			<td>4</td>
			<td>赵六</td>
			<td>男</td>
			<td>28</td>
			<td>
				<a ui-sref="user.detail({id:4})">查看</a>
			</td>
		</tr>
	</tbody>
</table>
<div ui-view="detail"></div>
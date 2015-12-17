<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参数传递</title>
<base href="<%=basePath%>" />
</head>
<body>
	<span style="color: red">接收到的参数：${params }</span>
	<br />
	<br />
	<a href="params/int?num=12">基本类型参数传递：params/int?num=12</a>
	<br />
	<br />
	<a href="params/integer?num=24">包装类型参数传递：params/integer?num=24</a>
	<br />
	<br />
	<a href="params/student?code=100005&name=林永超">自定义类型参数传递：params/student?code=100005&name=林永超</a>
	<br />
	<br />
	<a
		href="params/object?student.code=100008&student.name=强欲彪&user.name=孙文栋&user.phone=18611361617">复合对象参数传递：params/object?student.code=100008&student.name=强欲彪&user.name=孙文栋&user.phone=18611361617</a>
	<br />
	<br />
	<a
		href="objectParam/object?student.code=100009&student.name=董咚咚&user.name=夏文涛&user.phone=18622900982">复合对象参数传递(基于binder)：objectParam/object?student.code=100009&student.name=董咚咚&user.name=夏文涛&user.phone=18622900982</a>
	<br />
	<br />
	<a href="params/array?array[0]=张三&array[1]=李四&array[2]=王五&array[3]=玛丽">数组类型参数传递：params/array?array[0]=张三&array[1]=李四&array[2]=王五&array[3]=玛丽</a>
	<br />
	<br />
	<a href="params/list?list[0]=郭靖&list[1]=黄蓉&list[2]=杨过&list[3]=小龙女">List类型参数传递：params/list?list[0]=郭靖&list[1]=黄蓉&list[2]=杨过&list[3]=小龙女</a>
	<br />
	<br />
	<a href="params/list?list=王重阳&list=黄药师&list=欧阳锋&list=段智兴&list=洪七公">List类型参数传递：params/list?list=王重阳&list=黄药师&list=欧阳锋&list=段智兴&list=洪七公</a>
	<br />
	<br />
	<a
		href="params/listStudent?list[0].code=1001&list[0].name=宁采臣&list[2].code=1002&list[2].name=聂小倩">List&lt;Student&gt;类型参数传递：params/listStudent?list[0].code=1001&list[0].name=宁采臣&list[2].code=1002&list[2].name=聂小倩</a>
	<br />
	<br />
	<a
		href="params/listStudent?list.code=1001&list.name=许文强&list.code=1002&list.name=冯程程">List&lt;Student&gt;类型参数传递：params/listStudent?list.code=1001&list.name=许文强&list.code=1002&list.name=冯程程</a>
	<br />
	<br />
	<a href="params/set?set=依韵&set=喜儿&set=紫衫&set=小剑&set=暮色">Set类型参数传递：params/set?set=依韵&set=喜儿&set=紫衫&set=小剑&set=暮色</a>
	<br />
	<br />
	<a
		href="params/map?map['正义传说']=依韵&map['杀戮传说']=喜儿&map['神化传说']=紫衫&map['不败传说']=小剑&map['无血传说']=暮色">Map类型参数传递：params/map?map['正义传说']=依韵&map['杀戮传说']=喜儿&map['神化传说']=紫衫&map['不败传说']=小剑&map['无血传说']=暮色</a>
	<br />
	<br />
	<a href="params/list/string?lists=100001&lists=王&lists=100002&lists=赵">List&lt;Sting&gt;类型参数传递：params/list/string?lists=100001&lists=王&lists=100002&lists=赵</a>
	<br />
	<br />
	<a href="params/list/student?lists[0].code=100001&lists[0].name=王&lists[1].code=100002&lists[1].name=赵">List&lt;Student&gt;类型参数传递：params/list/student?lists[0].code=100001&lists[0].name=王&lists[1].code=100002&lists[1].name=赵</a>
	<br />
	<br />
	<a href="params/list/student?lists=list[0].code=100001&lists.name=王&lists.code=100002&lists.name=赵">List&lt;Student&gt;类型参数传递：params/list/student?lists[0].code=100001&lists[0].name=王&lists[1].code=100002&lists[1].name=赵</a>
	<br />
	<br />
</body>
</html>
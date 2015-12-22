<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pjax--demo</title>
</head>
<body>

	<button
		onclick="changeUrl('http://localhost:8080/springMVC-demo/test1','test1')">http://localhost:8080/springMVC-demo/test1</button><br><br>
	<button
		onclick="changeUrl('http://localhost:8080/springMVC-demo/test2','test2')">http://localhost:8080/springMVC-demo/test2</button><br><br>
	<button
		onclick="changeUrl('http://localhost:8080/springMVC-demo/test3','test3')">http://localhost:8080/springMVC-demo/test3</button><br><br>
	<button
		onclick="changeUrl('http://localhost:8080/springMVC-demo/test4','test4')">http://localhost:8080/springMVC-demo/test4</button><br><br>
	<button
		onclick="changeUrl('http://localhost:8080/springMVC-demo/test5','test5')">http://localhost:8080/springMVC-demo/test5</button><br><br>
	<button
		onclick="changeUrl('http://localhost:8080/springMVC-demo/test6','test6')">http://localhost:8080/springMVC-demo/test6</button><br><br>
	<script type="text/javascript">
		function changeUrl(url, title) {
			var state = {
				'url' : url,
				'title' : title
			}
			alert(window.title=title);
			//pushState是将指定的URL添加到浏览器历史里，replaceState是将指定的URL替换当前的URL。
			window.history.pushState(state,document.title=title,url);
			//replaceState
			//window.history.replaceState(state, document.title = title, url);
			//$.ajax(url,...);
		}
		window.onpopstate=function(event){
			if (history.state) {
				var state = event.state;
				//do something(state.url, state.title); 
				//$.ajax(state.url,...);
				alert(state.title+"---"+state.url);
			}
		}
	</script>
</body>
</html>
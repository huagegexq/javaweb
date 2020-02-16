<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" 
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	
	<script type="text/javascript">
		function fun(){
			//jq的get方式发送ajax请求
			//参数1
			var url = "/day19/ajax";
			//参数2
			var data = {uname:"baby",pwd:666};
			$.get(url,data,function(msg){
				//响应成功后执行   200
				//baby:666  [baby,666]
				alert("响应成功！！"+msg);
			});
		}
	</script>
</head>
<body>

	<input type="button" value="jq的get方式"  onclick = "fun()">
</body>
</html>
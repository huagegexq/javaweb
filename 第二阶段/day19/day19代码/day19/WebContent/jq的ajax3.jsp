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
			$.ajax({
				url:"/day19/ajax",
				async:true,
				data:{uname:"baby",pwd:666},
				type:"POST",
				dataType:"text",
				success:function(){
					alert("响应成功");
				},
				error:function(){
					alert("响应失败！！");
				}
			})
		}
	</script>
</head>
<body>

	<input type="button" value="jq的ajax方式"  onclick = "fun()">
</body>
</html>
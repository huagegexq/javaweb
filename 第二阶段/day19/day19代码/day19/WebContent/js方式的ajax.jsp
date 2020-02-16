<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		//负责发送ajax请求
		function run(){
			//1、创建核心对象
			var xmlhttp;
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
			  xmlhttp=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
			  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			//2、建立连接
			//参数一：请求方式   GET/Post
			//参数二：请求的url
			//参数三：true：异步   false:同步
			xmlhttp.open("GET","ajax?uname=baby",true);
			//3、发送请求
			xmlhttp.send();
			//4、响应
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
			   	var text = xmlhttp.responseText;
			   	alert(text);
			    }
			  }
			
		}
	</script>
</head>
<body>

	<input type="button" value="js发送ajax请求" onclick="run()">
	
	<input type="text">
</body>
</html>
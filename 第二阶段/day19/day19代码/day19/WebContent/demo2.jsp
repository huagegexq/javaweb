<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	
<style type="text/css">
.content{
width:643px;
margin:200px auto;
text‐align: center;
}
input[type='text']{
width:530px;
height:40px;
font‐size: 14px;
}
input[type='button']{
width:100px;
height:46px;
background: #38f;
border: 0;
color: #fff;
font‐size: 15px
}
.show{
position: absolute;
width: 535px;
border: 1px solid #999;
border‐top: 0;
display: block;
}
</style>
<script type="text/javascript" src="js/jquery-1.11.3.min.js">
	
</script>
<script type="text/javascript">
		function searchWord(word){
			//先清空内容体
			$("#show").html("");
			if(word == ""){
				return ;
			}
			//使用ajax发送请求
			$.post("/day19/search",{word:word},function(msg){
				var content = "";
				for(var i = 0;i<msg.length;i++){
					//取出json中的username
					content += "<div>"+msg[i].username+"</div>"
				}
				$("#show").append(content);
			},"json");
		}
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="content">
<img alt="" src="logo.jpg"><br/><br/>
<input type="text" name="word" id="tid" onkeyup="searchWord(this.value)">
<input type="button" value="搜索一下">
<div class="show" id="show"></div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	//校验用户名
	function checkUsername(val){
		//发送请求   将输入框中的用户名携带过去
		//location.href = "/day19/check?username="+val;
		//ajax  三种
		$.post("/day19/check",{username:val},function(msg){
			//响应成功
			if(msg == "true"){
				//用户名可用
				//设置span的内容体
				$("#usernameInfo").html("<font color='green'>用户名可用！！<font>");
			}else if(msg == "false"){
				//用户名已经被占用
				$("#usernameInfo").html("<font color='red'>该用户名已被占用，请更换一个！！<font>");
			}
		})
	}
</script>

</head>
<body>

<div>
<font>会员注册</font>USER REGISTER
<form class="form‐horizontal" style="margin‐top: 5px;">
用户名<input type="text" name="username"
placeholder="请输入用户名"  onblur="checkUsername(this.value)">
<span id="usernameInfo" style="color:red"></span><br/>
密码<input type="password" placeholder="请输入密码"><br/>
<input type="submit" value="注册"/>
</form>
</div>

21111111111
21111111111111
211111111111gd水电费
范德萨奥奥奥奥奥奥奥奥奥




好尴尬过过过过
</body>
</html>
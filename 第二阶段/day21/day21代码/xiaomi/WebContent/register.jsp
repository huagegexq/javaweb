<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <!--外部引入  -->
    <link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>

<script type="text/javascript">
	//手机号正则表达式
	var req = /^1(3|5|6|7|8|9)\d{9}$/;//手机号
	//手机号的校验
	$(function(){
		$("#phone_number").blur(function(){
			//获取手机号的值
			var p_val = $("#phone_number").val();
			if(!req.test(p_val)){
				//手机号未校验通过，不提交并且提示请输入正确的手机号
				alert("您输入的手机号格式不正确");
				return;
			}
			//如果手机号符合规范，将手机号的值提交到服务器
			//使用ajax
			$.post("/xiaomi/user",{method:"checkPhoneNumber",phoneNumber:p_val}
			,function(msg){
				if(msg == "true"){
					//手机号可用
					$("#s_phone_number").html("<font color='green'>该手机号尚未注册，可用</font>");
				}else if(msg == "false"){
					//手机号不可用
					$("#s_phone_number").html("<font color='red'>该手机号已被注册，请更换一个！！</font>")
				}
			})
			
		})
		
		//立即注册
		$("#btn").click(function(){
			/* var data = $("#f4").serialize();
			alert(data); */
			//表单提交
			$("#f4").submit();
		})
	})
</script>
</head>
<body>
<div class="sign_background">
    <div class="sign_background_in">
        <div class="sign_background_no1">
            <a href="index.html"><img src="img/logo.jpg" alt=""></a>
        </div>
        <div class="sign_background_no2">注册小米帐号</div>
           <div class="sign_background_no3">
        	<font color='red'></font>
            <div class="sign_background_no5">
          
             	<form id="f4" action="${pageContext.request.contextPath}/user" enctype="multipart/form-data"  method="post">
             			<input type="hidden" name="method" value="register" >
             		<table style="width: 600px;" border="0" cellspacing="0">
             			<tr>
             				<td width="25%" class="_left">姓名：</td>
             				<td><input type="text" name="name"><span id="s_name"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">性别：</td>
             				<td>
             					男<input type="radio" name="sex" checked="checked" value="1">
             				 	女<input type="radio" name="sex" value="0">
							</td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">电话号码：</td>
             				<td><input type="text" id="phone_number"  name="phone_number" >
             				<span id="s_phone_number"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">所在地区：</td>
             				<td><input type="text" name="area"></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">用户名：</td>
             				<td><input type="text" id="username" name="username" ><span id="s_username"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">密码：</td>
             				<td><input type="password" id="password" name="password" ><span id="s_password"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">上传头像：</td>
             				<td><input type="file" name="photo"></td>
             			</tr>
             		</table>
             		
             		<div class="sign_background_no6" id="btn" >立即注册</div>
             	</form>
             	 
            </div>
        </div>
        <div class="sign_background_no7">注册帐号即表示您同意并愿意遵守小米 <span>用户协议</span>和<span>隐私政策</span> </div>


    </div>
    <div class="sign_background_no8"><img src="img/sign01.jpg" alt=""></div>

</div>
</body>
</html>
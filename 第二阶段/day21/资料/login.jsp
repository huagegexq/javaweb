<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery-3.3.1.js"></script>
    <style>

    </style>
<script type="text/javascript">

//读秒的方法
var iTime = 59;
var Account;
function RemainTime(){
	document.getElementById('zphone').disabled = true;
	var iSecond,sSecond="",sTime="";
	if (iTime >= 0){
		iSecond = parseInt(iTime%60);
		iMinute = parseInt(iTime/60)
		if (iSecond >= 0){
			if(iMinute>0){
				sSecond = iMinute + "分" + iSecond + "秒";
			}else{
				sSecond = iSecond + "秒";
			}
		}
		sTime=sSecond;
		if(iTime==0){
			clearTimeout(Account);
			sTime='获取手机验证码';
			iTime = 59;
			document.getElementById('zphone').disabled = false;
		}else{
			Account = setTimeout("RemainTime()",1000);
			iTime=iTime-1;
		}
	}else{
		sTime='没有倒计时';
	}
	document.getElementById('zphone').value = sTime;
}
</script>
</head>
<body>
<div class="register_head_on">

</div>
<div class="register_head">
    <a href="index.html"><img src="img/logo.jpg" alt=""></a>
    <div class="register_head_right">
        <p class="register_head_right_p1">小 米 商 城</p>
        <p class="register_head_right_p2">让每个人都享受科技乐趣</p>
    </div>

</div>

<div class="register">
    <div class="register_boby">
        <div class="register_boby_min">
            <div class="register_boby_no1">
                <div class="register_boby_no1_in">
                    <span style="color: #ff6700">手机验证码登录 </span>
                </div>
            </div>
            <form id="f3" action="" method="post">
            <div class="register_boby_no2">
            	<span id="msg" style="color: red;font-size: 12px;margin-left: 20px;"></span>
                <input id="phone_number" name="phone_number" type="text" placeholder="手机号码">
                
                <input name="code" id="code" type="text" placeholder="手机校验码" style="width: 200px; margin-left: 15px;float: left;">
                <!-- 新增加 -->
                <input id="zphone" type="button" value=" 获取手机验证码 " style="width: 138px;float: left;height: 53px;margin-left: 5px;"> 
                <div style="clear: both;">
                
                <div class="register_boby_no2_div">
                    <span id="sub">登录</span>
                </div>
            </div>
            </div>
            </form>
            
            <div class="register_boby_no3">
                <a href="javascript:void(0);" style="color: #ff6700">账号密码登录</a>
                <sapn class="register_boby_no3_span">
                    <a href="register.jsp">立即注册</a>
                    <span>|</span>
                    <a href="avascript:void(0);">忘记密码?</a>
                </sapn>

            </div>
            <div class="register_boby_no4">
                <img src="img/register02.jpg" alt="">
            </div>

        </div>
    </div>
</div>
<div class="register_foot">
    <img  src="img/register03.jpg" alt="">
</div>


</body>
</html>
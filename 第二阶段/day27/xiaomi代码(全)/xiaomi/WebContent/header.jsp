<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="box">
        <div class="inner whiteGL">
            <div class="left">
                <a class="mix" href="">仿小米商城-学习专用</a>
            </div>
            <div class="right">
            	<!--未登录  -->
            	<c:if test="${empty qianUser}">
                <a class="mix" href="/xiaomi/login.jsp">登录</a>
                <a href="sign.html">注册</a>
                </c:if>
                <!--登录成功 -->
                <c:if test="${not empty qianUser}">
                <span style="color: red;">欢迎您：${qianUser.name}</span>
                </c:if>
                <a class="max"  href="">消息通知</a>
                <a href="trolley.html"><img src="img/cart.jpg" alt=""></a>
            </div>
        </div>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/test?method=register">用户注册</a><br>
	<a href="${pageContext.request.contextPath}/test?method=login">用户登录</a><br>
	<a href="${pageContext.request.contextPath}/test?method=logout">用户退出</a><br>
	<a href="${pageContext.request.contextPath}/test?method=active">用户激活</a><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.mi.pojo.Product"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Map<String,Product> map = new LinkedHashMap();
		Product p1 = new Product();
		p1.setColor("红色");
		p1.setPname("小米手机");
		Product p2 = new Product();
		p2.setColor("金色");
		p2.setPname("苹果手机");
		Product p3 = new Product();
		p3.setColor("绿色");
		p3.setPname("华为手机");
		map.put("xiaomi", p1);
		map.put("apple", p2);
		map.put("huawei", p3);
		
		request.setAttribute("map", map);
	%>
	<c:forEach items="${map}" var="entry">
		键：${entry.key}
		商品名称：${entry.value.pname}
	</c:forEach>
</body>
</html>
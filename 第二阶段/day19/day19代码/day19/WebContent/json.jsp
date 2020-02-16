<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//自定义json格式
	//var json1 = {"uname":"baby","sex":"女",age:20};
	//取数据
	//alert(json1.age);
	//json数组格式
	var json2 = ["唐僧","悟空","八戒","沙僧"];
	//取数据
	//alert(json2[1]);
	//alert(json2.length);
	//复合形式
	var json3 = [{uname:"baby",sex:"女"},{uname:"tom",sex:"男"}
	,{uname:"lucy",sex:"女"}]
	//取出tom
	alert(json3[1].uname)
	//长度
	alert(json3.length)
</script>
</head>
<body>

</body>
</html>
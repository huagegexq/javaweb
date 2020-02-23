<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>红米5 plus</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
    
   <div class="box">
        <div class="inner whiteGL">
            <div class="left">
                <a class="mix" href="">仿小米商城-学习专用</a>
            </div>
            <div class="right">
            <c:if test="${empty user}">
                <a class="mix" href="login.jsp">登录</a>
                <a href="register.jsp">注册</a>
            </c:if>
              <c:if test="${not empty user}">
              		<a class="max"  href=""> 欢迎您：${user.name}</a>
              </c:if>
            
                <a class="max"  href="">消息通知</a>
                <a href="">进入购物车！！</a>
            </div>
        </div>
    </div>
    
    <c:if test="${not empty user}">
	    <div class="plus5_no2 ">
	        <div class="plus5_no2_in">
	            <a class="plus5_no2_in_a"> 为方便您购买，请提前登录 </a>
	            <a class="plus5_no2_in_a orange"style="color: pink;" href="login.jsp">立即登录</a>
	            <a id="plus5_no2_in" class="plus5_no2_in_a" href="javascript:;">x</a>
	        </div>
	    </div>
    </c:if>
    <div class="plus5_no3">
        <div class="plus5_no3_img">
            <img width="560px" height="560px" src="" style="display: block" alt="">
        </div>
        <div class="plus5_no3_right">
            <h3>商品名称：</h3>
            <p class="plus5_no3_right_p2">
            	<span class="plus5_no3_right_span2">「」</span>
            </p>
            <p class="plus5_no3_right_p3">价格：元</p>
            
            <h3>商品编号：</h3>
            <div class="plus5_no3_right_div4">
				<h3>购买数量：<input id="count" name="count" value="1" size="10"></h3>
            </div>
            <a href="javascript:void(0)" onclick="" ><div class="plus5_no3_right_div11" style="cursor: pointer;" >加入购物车</div></a>
            <div class="plus5_no3_right_div12">
                <div class="plus5_no3_right_div12_y">√</div>
                <div class="plus5_no3_right_div12_z">七天无理由退货</div>
                <div class="plus5_no3_right_div12_y">√</div>
                <div class="plus5_no3_right_div12_z">15天质量问题换货</div>
                <div class="plus5_no3_right_div12_y">√</div>
                <div class="plus5_no3_right_div12_z">360天保障</div>
            </div>
            <a href="javascript:void (0);"></a>

        </div>
    </div>
    
  <%--   <jsp:include page="footer.jsp"></jsp:include> --%>
    
    <script>
        var plus5_no2_in = document.getElementById("plus5_no2_in");
        var plus5_no2 = document.getElementsByClassName("plus5_no2")[0];
        plus5_no2.onclick = function () {
            plus5_no2.className="plus5_no2 plus5_no2_close";
//            plus5_no2.style.display="none";
        }
        $(".plus5_no3_right_div9 .plus5_no3_right_div7_in").click(function () {
            console.log($(this).children().eq(1).html());
            $(".plus5_no3_right_div10_span2").html($(this).children().eq(1).html());

            $(".plus5_no3_img img").css("display","none").eq($(this).index()).css("display", "block");
            $(this).siblings().removeClass("plus5_no3_right_div7_in_hover").end().addClass("plus5_no3_right_div7_in_hover");

        })
        $(".plus5_no3_right_div7 .plus5_no3_right_div7_in").click(function () {
//            var value = $(".plus5_no3_right_div7_span0 ").html();
            console.log($(this).children().eq(1).html());
            $(".plus5_no3_right_div10_span0").html($(this).children().html());
            $(".plus5_no3_right_span10").html($(this).children().eq(1).html());
            var value = "总计:"+$(this).children().eq(1).html()
            $(".plus5_no3_right_div10_p2").html(value);

            $(this).siblings().removeClass("plus5_no3_right_div7_in_hover").end().addClass("plus5_no3_right_div7_in_hover");
        })
    </script>

</body>
</html>
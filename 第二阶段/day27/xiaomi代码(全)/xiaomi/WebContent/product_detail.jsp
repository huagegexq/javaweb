<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>红米5 plus</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		//加入购物车
		function addCart(){
			//获取pid的值
			var pid = ${p.pid};
			//获取count的值
			var count = $("#count").val();
			//请求服务器
			location.href="/xiaomi/order?method=addCart&pid=${p.pid}&count="+count;
		}
	</script>
</head>
<body>
    
   
	   <!-- 引入头部 -->
	<%@ include file="header.jsp" %>
    <div class="plus5_no3">
        <div class="plus5_no3_img">
            <img width="560px" height="560px" src="/xm_upload/${p.pic}" style="display: block" alt="">
        </div>
        <div class="plus5_no3_right">
            <h3>商品名称：${p.pname}</h3>
            <p class="plus5_no3_right_p2">
            	<span class="plus5_no3_right_span2" style="font-size: 20px">「${p.description}」</span>
            </p>
            <p class="plus5_no3_right_p3">价格：${p.price}元</p>
            
            <h3>商品编号：${p.pid}</h3>
            <div class="plus5_no3_right_div4">
				<h3>购买数量：<input id="count" name="count" value="1" size="10"></h3>
            </div>
            <a href="javascript:void(0)" onclick="addCart()" ><div class="plus5_no3_right_div11" style="cursor: pointer;">加入购物车</div></a>
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
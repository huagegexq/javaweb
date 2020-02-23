<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="css/index.css">
<script type="text/javascript">
	//根据pid删除购物车
	function delCartByPid(pid){
		if(confirm("是否确认从购物车中移除呢？")){
		location.href="/xiaomi/order?method=delCartByPid&pid="+pid;
		}
	}
	
	function clearCart(){
		if(confirm("是否确认清空购物车？")){
		location.href="/xiaomi/order?method=clearCart";
		}
	}
	
	//去结算
	function toPay(){
		location.href="/xiaomi/order?method=toPay";
	}
	
</script>
</head>
<body>
	<!-- 引入头部 -->
	<%@ include file="header.jsp" %>
    <div class="order_head">
        <div class="head_background">
            <div class="head_box">
                <a href="index.html" class="head_left_a"><img src="img/logo.jpg" alt="" class="head_left_p"></a>
                <h1 class="head_h1">我的购物车</h1>
                <div class="head_right">
                    <span onclick="clearCart()" class="head_right_in">清空购物车 </span>
                </div>

            </div>
        </div>
    </div>
    <div class="trolley_background">
        <div class="trolley_background_in">
            <div class="tro_tab_h">
                <div class="col tro_tab_check">
                    <h1 class="tro_tab_check_p">√</h1>
                    <span class="tro_tab_check_sp">全选</span>

                </div>
                <div class="col tro_tab_img">
                </div>
                <p class="col tro_tab_name">商品名称</p>
                <div class="col tro_tab_price">单价</div>
                <div class="col tro_tab_num">数量</div>
                <div class="col tro_tab_total">小计</div>
                <div class="col tro_tab_action">操作</div>
            </div>
            <c:if test="${not empty cart.cartMap}">
            	<c:forEach items="${cart.cartMap}" var="entry">
	            <div class="tro_tab_h1">
	                <div class="col tro_tab_check">
	                    <h1 class="tro_tab_check_p" style="background-color: #fff">
							<input type="checkbox" name="ids">
						</h1>
	                    <span class="tro_tab_check_sp"></span>
	
	                </div>
	                <div class="col tro_tab_img">
	                </div>
	                <div class="col tro_tab_name">
	                <!--<h2 tro_tab_name_h2>小米电视4A 32英寸 黑色 32英寸</h2>-->
	               <li class="tro_tab_name_li1" style="font-size: 16px;">
	               	${entry.value.product.pname}
	               </li>
	                </div>
	                <div class="col tro_tab_price">
	                    <span  id="price"></span>${entry.value.product.price}<span>元</span>
	                </div>
	                <div class="col tro_tab_num">
	                    <input type="count" value="${entry.value.count}" id="num">
	                </div>
	                <div class="col tro_tab_total ">
	                	<c:set var="sum_money" value=""></c:set>
	                	<span class="tro_tab_total_value" id="prices">${entry.value.subTotal}</span>元
	                </div>
	                <div class="col tro_tab_action" style="cursor: pointer;width: 40px;height: 40px;" onclick="delCartByPid(${entry.key})">删除</div>
	            </div>
	           	</c:forEach>
            </c:if>
            
        </div>
        
        <div class="tro_close_bot ">
            <!--<p class="tro_bot_ppp">+</p>-->
            
            <p class="tro_close_p "> <a href="/xiaomi/index.jsp">继续购物 </a></p>
            <p class="tro_close_p_c">合计:<span id="close">${cart.total}</span>元</p>
            
            <p class="tro_close_p_r" onclick="toPay()" style="cursor: pointer;">去结算</p>
        </div>

    </div>
</body>
</html>
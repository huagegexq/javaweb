<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品信息</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/admin/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">

// old write 
$(document).ready(function(){
  	$(".click").click(function(){
 	 	$(".tip").fadeIn(200);
  	});
  
  	$(".tiptop a").click(function(){
  		$(".tip").fadeOut(200);
  	});

  	$(".sure").click(function(){
  		$(".tip").fadeOut(100);
	});

  	$(".cancel").click(function(){
  		$(".tip").fadeOut(100);
	});
});

	$(function(){
		//跳转到添加商品页面
		$("#addProduct").click(function(){
			location.href = "/xiaomi/product?method=toAddProduct"
		})
	})
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">商品管理</a></li>
    </ul>
    </div>
    
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        <!-- 
        
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
         -->
        <li style="cursor: pointer;" id="addProduct" ><span><img src="${pageContext.request.contextPath}/admin/images/t01.png"  /></span>添加商品</li>
        <li style="cursor: pointer;" ><span><img src="${pageContext.request.contextPath}/admin/images/t03.png" /></span>批量删除</li>
        </ul>
          <form id="f5" action="" method="post">
	    
	    <div style="width: 100%;height: 30px; text-align: center;">
	     	商品名称：<input name="pname" value="" style="height: 25px;border:1px solid #ccc;" type="text"/> &nbsp;&nbsp;
	     	<!-- 0 正常,1热门产品，2为你推荐，3，新品 4，小米明星单品 -->
	     	
	     	是否热推：<select name="state" style="height: 28px;border:1px solid #ccc;">
	     				<option  value="0">=== 请选择 ===</option>
	     				<option <c:if test="">selected</c:if>  value="1">热门产品</option>
	     				<option <c:if test="">selected</c:if> value="2">为你推荐</option>
	     				<option <c:if test="">selected</c:if> value="3">新品</option>
	     				<option <c:if test="">selected</c:if> value="4">小米明星单品</option>
	     	 	   </select> &nbsp;&nbsp;
	     	 时间：<input class="Wdate" name="start_time" value=""  type="text" style="height: 25px;border:1px solid #ccc;" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> ~
	     	 <input class="Wdate" name="end_time" value="" type="text" style="height: 25px;border:1px solid #ccc;" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />&nbsp;&nbsp;
	         <input type="submit" value="查询" style="width: 60px;height: 30px;"  />
	    </div><br/>
    </form>

    </div>
    
    
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th><input name="" type="checkbox" value=""/></th>
		        <th>序号<i class="sort"><img src="${pageContext.request.contextPath}/admin/images/px.gif" /></i></th>
		        <th>商品类别</th>
		        <th>商品名称</th>
		        <th>商品颜色</th>
		        <th>商品价格</th>
		        <th width="10%">简介</th>
		       	<th>商品展示图</th>
		       	<th>是否热推</th>
		       	<th>型号</th>
		       	<th>生产日期</th>
		       	<th>操作</th>
	        </tr>
        </thead>
        <tbody>
        	<c:if test="${not empty pb.result}">
        		<c:forEach items="${pb.result}" var="product" varStatus="vs">
        		<tr>
			        <td><input name="" type="checkbox" value=""/></td>
			        <td>${vs.count}</td>
			        <td>${product.category.cname}</td>
			        <td>${product.pname}</td>
			        <td>${product.color}</td>
			        <td>${product.price}</td>
			        <td width="10%">${product.description}</td>
			       	<td>
			       		<img src="/xm_upload/${product.pic}" alt="" width="80" />
			       	</td>
			       	<td>
			       		<c:if test="${product.state == 0}">普通</c:if>
			       		<c:if test="${product.state == 1}">热门商品</c:if>
			       		<c:if test="${product.state == 2}">为你推荐</c:if>
			       		<c:if test="${product.state == 3}">新品</c:if>
			       		<c:if test="${product.state == 4}">小米明星单品</c:if>
			       	</td>
			       	<td>${product.version}</td>
			       	<td>${product.product_date}</td>
			       	<td>
			       		<a href="javascript:void(0)" onclick="">删除</a>
			       		<a href="">修改</a>
			       	</td>
		        </tr>
		        </c:forEach>
        	</c:if>
        </tbody>
    </table>
    
   
   <!-- 分页条 -->
   <div class="pagin">
    	<div class="message">共<i class="blue">${pb.totalCount}</i>条记录，当前显示第&nbsp;<i class="blue">${pb.pageNumber}&nbsp;</i>页</div>
        <ul class="paginList">
	        
	         <li class="paginItem"><a href="/xiaomi/product?method=findPlistByPage&pageNumber=1">首页</a></li>
	         <c:if test="${pb.pageNumber != 1}">
	         <li class="paginItem"><a href="/xiaomi/product?method=findPlistByPage&pageNumber=${pb.pageNumber - 1}">上一页</a></li>
	          </c:if>
	          <!-- 索引页 -->
	          <c:forEach begin="1" end="${pb.totalPage}" var="i">
	          	<li class="paginItem"><a href="/xiaomi/product?method=findPlistByPage&pageNumber=${i}">${i}</a></li>
	          </c:forEach>
	          <c:if test="${pb.pageNumber != pb.totalPage}">
	         <li class="paginItem"><a href="/xiaomi/product?method=findPlistByPage&pageNumber=${pb.pageNumber + 1}">下一页</a></li>
	         </c:if>
	         <li class="paginItem"><a href="/xiaomi/product?method=findPlistByPage&pageNumber=${pb.totalPage}">尾页</a></li>
        </ul>
    </div> 
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>

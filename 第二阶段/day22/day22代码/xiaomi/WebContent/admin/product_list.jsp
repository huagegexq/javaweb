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
        		<tr>
			        <td><input name="" type="checkbox" value=""/></td>
			        <td>22</td>
			        <td>手机</td>
			        <td>小米10</td>
			        <td>红色</td>
			        <td>2999</td>
			        <td width="10%"></td>
			       	<td>
			       		<img src="" alt="" width="80" />
			       	</td>
			       	<td>
			       	
			       	</td>
			       	<td>1</td>
			       	<td>2019</td>
			       	<td>
			       		<a href="javascript:void(0)" onclick="">删除</a>
			       		<a href="">修改</a>
			       	</td>
		        </tr>
        </tbody>
    </table>
    
   
   <div class="pagin">
    	<div class="message">共<i class="blue">100</i>条记录，当前显示第&nbsp;<i class="blue">10&nbsp;</i>页</div>
        <ul class="paginList">
	        
	         <li class="paginItem"><a href="">首页</a></li>
	         <li class="paginItem"><a href="">上一页</a></li>
	         <li class="paginItem"><a href="">下一页</a></li>
	         <li class="paginItem"><a href="">尾页</a></li>
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

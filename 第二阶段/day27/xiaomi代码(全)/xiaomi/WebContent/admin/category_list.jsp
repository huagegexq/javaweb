<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品分类</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>

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
		//跳转到添加分类页面
		$("#add_category").click(function(){
			location.href= "/xiaomi/admin/category_add.jsp";
		})
		
	})
	//根据cid删除
	function del(cid){
		if(confirm("是否确认删除？")){
			location.href = "/xiaomi/category?method=delByCid&cid="+cid;
		}
	}

</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">分类管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        
        <%-- <li class="click"><span><img src="${pageContext.request.contextPath}/admin/images/t02.png" /></span>修改</li>
        <li><span><img src="${pageContext.request.contextPath}/admin/images/t04.png" /></span>统计</li> --%>
        <li style="cursor: pointer;" id="add_category"><span><img src="${pageContext.request.contextPath}/admin/images/t01.png"  /></span>添加类别</li>
        <li style="cursor: pointer;" id=""><span><img src="${pageContext.request.contextPath}/admin/images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
	        <th><input name="" type="checkbox" value="" /></th>
	        <th>序号<i class="sort"><img src="${pageContext.request.contextPath}/admin/images/px.gif" /></i></th>
	        <th>类别名称</th>
	        <th>启用状态</th>
	        <th>排序序号</th>
	        <th>创建时间</th>
	        <th>描述</th>
	        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty pb.result}">
        	<c:forEach items="${pb.result}" var="category" varStatus="vs">
	        <tr>
		        <td><input name="" type="checkbox" value="" /></td>
		        <td>${vs.count}</td>
		        <td>${category.cname}</td>
		        <td>
		        	<c:if test="${category.state == 1}">启用</c:if>
		        	<c:if test="${category.state == 0}">未启用</c:if>
		        </td>
		        <td>${category.order_number}</td>
		        <td>${category.create_time}</td>
		        <td>${category.description}</td>
		        <td>
		        	<a href="/xiaomi/category?method=toCategoryUpdate&cid=${category.cid}">修改</a>
		        	&nbsp;
		        	<a href="javascript:void(0)" onclick="del(${category.cid})" >删除</a>
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
	        
	         <li class="paginItem"><a href="/xiaomi/category?method=findClistByPage&pageNumber=1">首页</a></li>
	         <c:if test="${pb.pageNumber != 1}">
	         <li class="paginItem"><a href="/xiaomi/category?method=findClistByPage&pageNumber=${pb.pageNumber - 1}">上一页</a></li>
	          </c:if>
	          <!-- 索引页 -->
	          <c:forEach begin="1" end="${pb.totalPage}" var="i">
	          	<li class="paginItem"><a href="/xiaomi/category?method=findClistByPage&pageNumber=${i}">${i}</a></li>
	          </c:forEach>
	          <c:if test="${pb.pageNumber != pb.totalPage}">
	         <li class="paginItem"><a href="/xiaomi/category?method=findClistByPage&pageNumber=${pb.pageNumber + 1}">下一页</a></li>
	         </c:if>
	         <li class="paginItem"><a href="/xiaomi/category?method=findClistByPage&pageNumber=${pb.totalPage}">尾页</a></li>
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

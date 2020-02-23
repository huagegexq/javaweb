<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户信息</title>
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
		$("#checkbox_main").click(function(){
			//全选实现
			//1、获取全选框的选中状态   checked
			var flag = $("#checkbox_main").prop("checked");
			//2、获取所有复选框
			var ids = $("[name=ids]");
			//3、将所有复选框的checked的值设置为flag
			ids.prop("checked",flag);
		})
		
		//批量删除
		$("#batchDelete").click(function(){
			
			if(confirm("是否确认删除呢？？")){
				//删除业务
				//1、获取所有选中的复选框
				var ids = $("[name=ids]:checked");
				//2、获取选中复选框的uid的值
				//遍历数组
				var idsStr = "";
				ids.each(function(){
					idsStr += "," + this.value;
				})
				idsStr = idsStr.substring(1);
				//将参数提交到服务器
				location.href = "${pageContext.request.contextPath}/user?method=batchDelete&ids="+idsStr;
			}
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
        <li id="batchDelete" style="cursor: pointer;"><span><img src="${pageContext.request.contextPath}/admin/images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th><input id="checkbox_main" type="checkbox" /></th>
		        <th>序号<i class="sort"><img src="${pageContext.request.contextPath}/admin/images/px.gif" /></i></th>
		        <th>姓名</th>
		        <th>性别</th>
		        <th>电话号码</th>
		        <th>所在地区</th>
		        <th>权限</th>
		        <th>账号</th>
		       	<th>头像</th>
		       	<th>操作</th>
	        </tr>
	    </thead>
        <tbody>
        		<c:if test="${not empty pb.result}">
        			<c:forEach items="${pb.result}" var="user" varStatus="vs">
        		<tr>
			        <td><input name="ids"  type="checkbox" value="${user.uid}"/></td>
			        <td>${vs.count}</td>
			        <td>${user.name}</td>
			        <td>
			        	<c:if test="${user.sex == 0}">女</c:if>
			        	<c:if test="${user.sex == 1}">男</c:if>
			        </td>
			        <td>${user.phone_number}</td>
			        <td>${user.area}</td>
			        <td>
			        	<c:if test="${user.manager == 0}">
			        		<font color="blue">普通用户</font>
			        	</c:if>
			        	<c:if test="${user.manager == 1}">
			        		<font color="red">管理员</font>
			        	</c:if>
			        </td>
			        <td>${user.username}</td>
			       	<td style="text-align: center;">
			       		<img src="/xm_upload/${user.photo}" width="80" height="50" alt="" />
			       	</td>
			       	<td>
			       		<c:if test="${user.manager == 0}">
		<a href="${pageContext.request.contextPath}/user?method=updateRole&manager=1&uid=${user.uid}"><font color="red">修改为管理员</font></a>
			        	</c:if>
			        	<c:if test="${user.manager == 1}">
			        
			        		
			        		
			      <a href="${pageContext.request.contextPath}/user?method=updateRole&manager=0&uid=${user.uid}"><font color="blue">修改为普通用户  </font></a>
			      
			        	</c:if>
			       	</td>
		        </tr>
		        	</c:forEach>
        		</c:if>
        	
        </tbody>
    </table>
   
	<div class="pagin">
    	<div class="message">共<i class="blue">${pb.totalCount}</i>条记录，当前显示第&nbsp;<i class="blue">${pb.pageNumber}&nbsp;</i>页</div>
        <ul class="paginList">
	        
	         <li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=1">首页</a></li>
	         <c:if test="${pb.pageNumber != 1}">
	         <li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=${pb.pageNumber - 1}">上一页</a></li>
	          </c:if>
	          <!-- 索引页 -->
	          <c:forEach begin="1" end="${pb.totalPage}" var="i">
	          	<li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=${i}">${i}</a></li>
	          </c:forEach>
	          <c:if test="${pb.pageNumber != pb.totalPage}">
	         <li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=${pb.pageNumber + 1}">下一页</a></li>
	         </c:if>
	         <li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=${pb.totalPage}">尾页</a></li>
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

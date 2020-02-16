<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body>
	<table border="1" width="40%" class="imagetable" align="center">
		<tr>
			<th>添加员工信息</th>
		</tr>
	</table>
	<hr/>
	<form action="" method="post">
		<table border="1" width="100%" class="imagetable">
			<tr>
				<th>员工姓名</th>
				<th align="left">
					<input type="text" name="ename"/>
				</th>
			</tr>
			<tr>
				<th>入职日期</th>
				<th align="left">
					<input type="text" name="joindate "/>
				</th>
			</tr>
			<tr>
				<th>工资</th>
				<th align="left">
					<input type="text" name="salary"/>
				</th>
			</tr>
			<tr>
				<th>奖金</th>
				<th align="left">
					<input type="text" name="bonus "/>
				</th>
			</tr>
			<tr>
				<th>是否是优秀员工</th>
				<th align="left">
					<input type="radio" name="is_good " value="0" checked="checked"/>普通
					<input type="radio" name="is_good " value="1"/>优秀
				</th>
			</tr>
			<tr>
				<th>所属部门</th>
				<th align="left">
					<select name="cid">
						<option value="10">教研部</option>
						<option value="20">学工部</option>
					</select>
				</th>
			</tr>
			<tr>
				<th></th>
				<th align="left">
					<input type="submit" value="添加员工"/>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>
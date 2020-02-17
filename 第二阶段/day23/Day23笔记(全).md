# Day23笔记

回顾：

1、前端事件

常见事件：

js事件：onclick、onblur、onkeyup

jq事件：click、blur、keyup

jq对象.click(function(){})

<input type="button"  onclick="方法";

2、获取值     js.value   jq.val()

3、正则表达式

4、全选  -- 全不选

​     <input   type="text" name="text"   checked=""/>

​	prop()：

​		prop("name")   获取属性的值

​		prop("name":"text")  设置属性的值为text

5、提示信息

​	alert("111")      confirm("是否确认删除"){

​                                //

}

6、数组的遍历

​	js方式：for(var i=0;i<arr.length;i++)

​       jq方式：   arr.each(function({}))     $.each（arr,function(){}）

7、location.href 

location.href   获取地址栏的值

location.href = 值        设置地址栏的值并进行跳转

# 1、用户的分页查询

需求：

在left.jsp中点击用户管理进行分页查询(一页显示三条)

sql：

​	select   *    from   user   limit   起始索引，3

明确：页面传参(pageNumber)  pageNumber 默认值：1

left.jsp

```html
<li class="active"><cite></cite><a href="${pageContext.request.contextPath}/user?method=findUlistByPage&pageNumber=1" target="rightFrame">用户管理
```

UserServlet：

```java
//分页查询所有用户
	public String findUlistByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取pageNumber
		String pageNumber = request.getParameter("pageNumber");
		//创建pageBean对象
		PageBean<User> pb = new PageBean<User>();
		pb.setPageNumber(Integer.parseInt(pageNumber));
		//2、调用业务
		UserService us = new UserServiceImpl();
		pb = us.findUlistByPage(pb);
		request.setAttribute("pb", pb);
		//3、结果展示
		return "admin/user_list";
	}
```

UserService：

```java
public PageBean<User> findUlistByPage(PageBean<User> pb) {
		List<User> result = ud.findUlistByPage(pb);
		//设置到pb中
		pb.setResult(result);
		return pb;
	}

```

UserDao：

```java
public List<User> findUlistByPage(PageBean<User> pb) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from user limit ?,?";
		try {
			//给占位符赋值
			Object [] param = {pb.getStartIndex(),pb.getPageSize()};
			return qr.query(sql, new BeanListHandler<User>(User.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
```

user_list.jsp

```html
<c:if test="${not empty pb.result}">
        			<c:forEach items="${pb.result}" 
                               当前显示第&nbsp;<i class="blue">${pb.pageNumber}&nbsp;</i>页
```



**需求：当所处是第一页时，不让显示上一页**

判断当前页是否是第一页，如果是第一页，不显示

```html
<c:if test="${pb.pageNumber != 1}">
	         <li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=${pb.pageNumber - 1}">上一页</a></li>
	          </c:if>
```

**需求：当所处是最后一页时，不让显示下一页**

需要计算最后一页(总页数)：

总页数  = 总记录数 % 每页显示的条数  == 0 ?(总记录数 / 每页显示的条数) : (总记录数 / 每页显示的条数 + 1)

将涉及的属性封装到PageBean中

```java
//总记录数
	private int totalCount;
	//总页数
	private int totalPage;

public int getTotalPage() {
  		//第二个计算公式
		return totalPage = getTotalCount() % getPageSize() == 0
				? (getTotalCount() / getPageSize()) :
					(getTotalCount() / getPageSize() +1);
	}

public int getStartIndex() {
		//第一个计算公式
		return startIndex = (getPageNumber() - 1) * getPageSize();
	}
```

第一个计算公式：获取当前页(从页面传过来的)

第二个计算公式：求出总记录数(select count(*) from user)

user_list.jsp

```html
<c:if test="${pb.pageNumber != pb.totalPage}">
	         <li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=${pb.pageNumber + 1}">下一页</a></li>
	         </c:if>
```

```java
在UserService的分页方法里加：
//1、查询某一页的数据
		List<User> result = ud.findUlistByPage(pb);
		//设置到pb中
		pb.setResult(result);
//2、查询总记录数
		int count = ud.selectCount();
		pb.setTotalCount(count);
```

UserDao：

```java
//总记录数
	public int selectCount() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from user";
		try {
			Long count = (Long) qr.query(sql, new ScalarHandler());
			return count.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
```

需求：索引页  、 首页、尾页

```html
<li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=1">首页</a></li>

 <!-- 索引页 -->
	          <c:forEach begin="1" end="${pb.totalPage}" var="i">
	          	<li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=${i}">${i}</a></li>
	          </c:forEach>
	          
	          
 <li class="paginItem"><a href="/xiaomi/user?method=findUlistByPage&pageNumber=${pb.totalPage}">尾页</a></li>
```



# 2、分类管理结构搭建

**分类表：**

order_number字段

```sql
CREATE TABLE `category` (
  `cid` INT(10) PRIMARY KEY AUTO_INCREMENT,#主键
  `cname` VARCHAR(50) NOT NULL,#分类名称
  `state` INT(1) DEFAULT NULL,#是否启用  1：启用  0：不启用
  `order_number` INT(5) DEFAULT NULL,#排序号 (值越小越靠前)
  `description` VARCHAR(100) DEFAULT NULL,#分类描述
  `create_time` DATETIME#创建时间
);
```

**页面：**

category_list.jsp：用来展示分类信息

category_add.jsp：添加分类页面

category_update.jsp：修改分类页面

**分类的包结构搭建：**

​	dao、service、web、pojo

# 3、分类的分页查询

left.jsp

```html
  <li><cite></cite><a href="${pageContext.request.contextPath}/category?method=findClistByPage&pageNumber=1" target="rightFrame">分类管理</a><i></i></li>
```

CategoryServlet：

```java
@WebServlet("/category")
public class CategoryServlet extends BaseServlet{
	//分类的分页查询
	public String findClistByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String pageNumber = request.getParameter("pageNumber");
		PageBean<Category> pb =new PageBean<Category>();
		pb.setPageNumber(Integer.parseInt(pageNumber));
		//2、业务调用
		CategoryService cs = new CategoryServiceImpl();
		pb = cs.findUlistByPage(pb);
		//3、结果展示
		request.setAttribute("pb", pb);
		return "admin/category_list";
	}
}
```

CategroyService：

```java
public PageBean<Category> findUlistByPage(PageBean<Category> pb) {
		//1、查询某页的数据
		List<Category> result = cd.findClistByPage(pb);
		//2、查询总记录数
		int count = cd.selectCount();
		//3、将查询结果封装到PageBean中
		pb.setResult(result);
		pb.setTotalCount(count);
		return pb;
	}
```

CategoryDao：

```java
public List<Category> findClistByPage(PageBean<Category> pb) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from category limit ?,?";
		Object [] param = {pb.getStartIndex(),pb.getPageSize()};
		
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int selectCount() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from category";
		try {
			Long count = (Long) qr.query(sql, new ScalarHandler());
			return count.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

```

# 4、添加类别

问题：页面跳转的问题

直接跳转到添加分类页面还是需要携带数据过来？

需要看需求：

​	跳转到添加分类页面，不需要携带数据(不用经过服务器)

​	跳转到修改分类页面，因为要进行数据的回显，所以需要携带数据(经过服务器)

## 1、跳转到添加类别页面

category_list.jsp

```javascript
$(function(){
		//跳转到添加分类页面
		$("#add_category").click(function(){
			location.href= "/xiaomi/admin/category_add.jsp";
		})
	})
```

## 2、添加类别

- 保证页面提交过来的数据封装到Category对象中

  将表单中的status改为state

- 将数据保存到数据库

- 结果展示（页面跳转）

category_add.jsp

```html
<form action="/xiaomi/category" method="post">
    	<input type="hidden" name="method" value="addCategory">
   <input name="state" type="radio" value="1"
```

Servlet：

```java
//添加类别
	public String addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			Map<String, String[]> map = request.getParameterMap();
			Category c = new Category();
			BeanUtils.populate(c, map);
			//2、业务调用
			CategoryService cs = new CategoryServiceImpl();
			cs.addCategory(c);
			//3、结果展示
			response.sendRedirect("/xiaomi/category?method=findClistByPage&pageNumber=1");
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3、结果展示
		return "";
	}
```

Dao：

```java
public void addCategory(Category c) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into category values(?,?,?,?,?,?)";
		Object [] param = {null,c.getCname(),c.getState(),c.getOrder_number(),
				c.getDescription(),c.getCreate_time()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
```

# 5、修改类别

## 1、跳转到修改页面

需要进行数据的回显，回显该分类的数据，所以此时就要走服务器将该条分类信息查出来存储到域对象中，跳转到category_update.jsp ，EL+JSTL取数据

执行的sql：

​	select  *   from  category where  cid = ?

传参：cid

category_list.jsp

```html
<a href="/xiaomi/category?method=toCategoryUpdate&cid=${category.cid}">修改</a>
```

Servlet：

```java
//跳转到修改分类的页面
	public String toCategoryUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			String cid = request.getParameter("cid");
			//2、业务调用
			CategoryService cs = new CategoryServiceImpl();
			Category category = cs.findCategoryByCid(cid);
			//3、结果展示
			request.setAttribute("category", category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3、结果展示
		return "admin/category_update";
	}
```

Dao：

```java
public Category findCategoryByCid(String cid) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from category where cid = ?";
		
		try {
			return qr.query(sql, new BeanHandler<Category>(Category.class),cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
```

category_update.jsp   数据的回显

注意：将status 改为state

```html
  <ul class="forminfo">
		    <li><label>类别名称</label><input name="cname" type="text" value="${category.cname}" class="dfinput" /><i>类别名称不能超过30个字符</i></li>
		    <li><label>是否启用</label>
			    <cite>
				    <input name="state" type="radio" value="1" <c:if test="${category.state == 1}">checked</c:if>/>是&nbsp;&nbsp;&nbsp;&nbsp;
				    	
				    <input name="state" type="radio" value="0" <c:if test="${category.state == 0}">checked</c:if>/>否
			    </cite>
		    </li>
```

## 2、修改分类

sql：update.... 五个字段  where   cid = ？

传参：所有字段的值都需要传(注意和添加分类的区别)

将数据封装到Category对象中

category_update.jsp

```html
<form action="/xiaomi/category" method="post">
    	<input type="hidden" name="method" value="updateCategory">
    	<input type="hidden" name="cid" value="${category.cid}">
```

Servlet：

```java
//修改类别
	public String updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			Map<String, String[]> map = request.getParameterMap();
			Category c = new Category();
			BeanUtils.populate(c, map);
			//2、业务调用
			CategoryService cs = new CategoryServiceImpl();
			cs.updateCategory(c);
			//3、结果展示
			response.sendRedirect("/xiaomi/category?method=findClistByPage&pageNumber=1");
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3、结果展示
		return "";
	}
```

Dao：

```java
public void updateCategory(Category c) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update category set cname = ?,state=?,order_number=?"
				+ ",description = ?,create_time = ? where cid = ?";
		Object [] param = {c.getCname(),c.getState(),c.getOrder_number(),
				c.getDescription(),c.getCreate_time(),c.getCid()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
```



做项目的思路：

1、分析Sql的书写  

​	分页:limit  ?,?

​	添加：insert     User

​	修改：User

​	删除：ddd                 where  cid = ?      cid in (8,9,10)

sql需要什么数据才能完整执行

2、通过页面传参的形式将sql需要的数据传过来

3、层与层之间的调用

​	正序：页面、servlet、service、dao

​	倒序：dao、service、servlet、页面

4、页面的跳转/结果的展示
















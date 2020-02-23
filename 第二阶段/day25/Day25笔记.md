

# Day25笔记

## 1、分类的根据cid删除

- SQL书写 

  delete from category where cid = ?

- 页面应该传什么参数   cid

- 三层架构的调用(业务处理)

- 页面跳转和展示的问题

category_list.jsp

```html
<a href="javascript:void(0)" onclick="del(${category.cid})" >删除</a>
//根据cid删除
	function del(cid){
		if(confirm("是否确认删除？")){
			location.href = "/xiaomi/category?method=delByCid&cid="+cid;
		}
	}
```

Servlet:

```java
//修改类别
	public String delByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			String cid = request.getParameter("cid");
			//2、业务调用
			CategoryService cs = new CategoryServiceImpl();
			cs.delByCid(cid);
			//3、结果展示
			response.sendRedirect("/xiaomi/category?method=findClistByPage&pageNumber=1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3、结果展示
		return "";
	}
```

Dao:

```java
public void delByCid(String cid) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from category where cid = ?";
		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
```

## 2、登录的校验

需求：当用户访问admin下的资源时，要判断是否已经登录

​	   如果登录成功，放行，访问目标资源

​	   如果未登录：拦截，跳转到登录页面，让用户先去登录！！！

涉及技术：Filter

拦截路径：/admin/*

用户登录成功后将用户信息存到session中：

```java
request.getSession().setAttribute("user", user);
```

判断是否登录,从session中取出user信息，判断是否为空

```java
User user = (User)req.getSession().getAttribute("user");
		if(user != null) {
			//登录成功
			//放行
			chain.doFilter(request, response);
		}else {
			//未登录
			//跳转到登录页面
			resp.sendRedirect("/xiaomi/admin/login.jsp");
		}
```

过滤器无限重定向问题：

```java
resp.sendRedirect("/xiaomi/admin/login.jsp");
路径 /admin/login.jsp    过滤器再次进行拦截
```

跳转到登录页面不拦截：

```java
	//获取url
		String uri = req.getRequestURI();
		//如果url里包含login.jsp，不拦截放行
		if(uri.contains("/login.jsp")) {
			chain.doFilter(request, response);
			return;
		}
```

加上以上代码，就可以成功的跳转到登录页面，样式丢了：

```java
if(uri.contains("/login.jsp") || uri.contains("/images") ||
				uri.contains("/css") || uri.contains("/js")) {
			chain.doFilter(request, response);
			return;
		}
将CSS、图片等静态资源放行
```

```java
@WebFilter("/admin/*")
public class LoginFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//判断用户是否登录
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//获取url
		String uri = req.getRequestURI();
		//如果url里包含login.jsp，不拦截放行
		if(uri.contains("/login.jsp") || uri.contains("/images") ||
				uri.contains("/css") || uri.contains("/js")) {
			chain.doFilter(request, response);
			return;
		}
		User user = (User)req.getSession().getAttribute("user");
		if(user != null) {
			//登录成功
			//放行
			chain.doFilter(request, response);
		}else {
			//未登录
			//跳转到登录页面
			resp.sendRedirect("/xiaomi/admin/login.jsp");
		}
	}
```

## 3、商品管理

```java
CREATE TABLE `product` (
  `pid` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `pname` VARCHAR(50) NOT NULL,
  `color` VARCHAR(50),
  `price` DOUBLE NOT NULL,
  `description` VARCHAR(500),
  `pic` VARCHAR(200),
  `state` INT(5) DEFAULT '0',
  `version` VARCHAR(50),
  `product_date` DATETIME,
   cid INT(10)
) ;
```

JavaBean：

包结构搭建



### 1、跳转到添加商品页面：

​	需要回显所有分类的数据，所以需要走后台服务器

​	sql：select * from category

product_list.jsp

```javascript
$(function(){
		//跳转到添加商品页面
		$("#addProduct").click(function(){
			location.href = "/xiaomi/product?method=toAddProduct"
		})
	})
```

Servelt：

```java
public String toAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		//2、业务调用
		CategoryService ps = new CategoryServiceImpl();
		List<Category> clist = ps.findAll();
		//3、结果展示
		request.setAttribute("clist", clist);
		return "admin/product_add";
	}
```

CategoryDao:

```java
public List<Category> findAll() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from category";
		
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
```

product_add.jsp

```html
<label>商品分类</label>
	    	 	<select name="cid" class="dfinput">
	    	 		<option value="0">===请选择===</option>
	    	 		<c:forEach items="${clist}" var="c">
	    	 		<option value="${c.cid}">${c.cname}</option>
	    	 		</c:forEach>
	    	 	</select>
```

### 2、添加商品

- insert into product ...
- 传参：所有参数
- 业务处理



**分类名称取值问题：**

得到Category     ${category.cname}

在Product中加一个属性：

```java
private Category category;
```

${product.category} 可以得到Category对象   相当于调用product.getCategory()

${product.category.cname}

需要通过setCategory(c)   ，先设置进去（手动设置进去）

**如何将Category手动设置到Product对象里:**

```java
//1、查询某页的数据
		List<Product> result = pd.findPlistByPage(pb);
		for(Product p:result) {
			//获取cid的值
			int cid = p.getCid();
			//根据cid查询Category
			Category category = cd.findCategoryByCid(cid+"");
			//将category设置到Product里
			p.setCategory(category);
		}
```

取出分类的名称：<td>${product.category.cname}</td>



作业：商品的修改、删除、批量删除

​	    条件查询

## 4、手机验证码登录成功跳转到首页

登录成功后再首页头部显示：欢迎您：xxx

**UserServiceImpl：**

将user存到session中：

```
if(user != null) {
				//已被注册
				//将用户信息存到session中
				request.getSession().setAttribute("qianUser", user);
				return "2";
			}
```

**login.jsp：**

```java
else if(msg == "2"){
	//跳转到首页
	location.href = "/xiaomi/index.jsp";
}
```

**index.jsp：**

```html
<!--未登录  -->
            	<c:if test="${empty qianUser}">
                <a class="mix" href="/xiaomi/login.jsp">登录</a>
                <a href="sign.html">注册</a>
                </c:if>
                <!--登录成功 -->
                <c:if test="${not empty qianUser}">
                <span style="color: red;">欢迎您：${qianUser.name}</span>
                </c:if>
```



**直接跳转还是走服务器？**




# Day26笔记

## 1、动态将分类数据进行展示

- 页面跳转需要走服务器


- 查询sql  

  select * from category  order by  order_number  asc

- 页面不需要传参(跳转)

- 业务

- 结果展示(往首页进行跳转)

login.jsp

```javascript
else if(msg == "2"){
	//跳转到首页
	location.href = "/xiaomi/toIndex?method=toIndex";
}
```

ToIndexServlet：

```java
public String toIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		//2、调用业务
		CategoryService us = new CategoryServiceImpl();
		List<Category> clist = us.findAllByOrderNumber();
		request.setAttribute("clist", clist);
		//3、结果展示
		return "index";
	}
```

CategoryDao：

```java
public List<Category> findAllByOrderNumber() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from category order by order_number asc";
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
```

index.jsp

```html
<c:if test="${not empty clist}">
            		<c:forEach items="${clist}" var="c">
                <li class="scr_li"><a href="">${c.cname}</a><i class="scr_i"></i></li>
                </c:forEach>
```

## 2、动态查询小米明星单品

- sql：select * from product  where state = 4 limit 0,5;(查询前五条的小米明星单品)
- 页面无需传参
- 业务
- 结果的展示
- ​

ToIndexServlet：

```java
ProductService ps = new ProductServiceImpl();
		List<Product> starList = ps.findStarlist();
		request.setAttribute("clist", clist);
```

ProductDao：

```java
public List<Product> findStarlist() {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from product where state = 4 limit 0,5;";
		try {
			return qr.query(sql, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

```

index.jsp

```html
div class="H">小米明星单品</div>
        	<c:if test="${not empty starList}">
				<c:forEach items="${starList}" var="star">
```

## 3、用监听器改善以上案例

用户访问index.jsp就可以直接看到首页数据信息

目前存在的问题：看不到分类、和小米明星单品数据

解决思路：

- 所有人看到首页都是一样的  (ServletContext)
- 什么时候向ServletContext域对象中存数据（用户访问index.jsp页面之前）
- 服务器启动时，将数据查询出来，存储完成
- 监听器  ServletContextListener (监听的是ServletContext域对象的创建和销毁)

```java
@WebListener
public class IndexListener implements ServletContextListener {
    //服务器启动时执行
    public void contextInitialized(ServletContextEvent sce)  { 
    	//获取ServletContext对象
    	ServletContext context = sce.getServletContext();
		//2、调用业务
		CategoryService us = new CategoryServiceImpl();
		//查询分类的数据
		List<Category> clist = us.findAllByOrderNumber();
		//查询小米明星单品(前五条)
		ProductService ps = new ProductServiceImpl();
		List<Product> starList = ps.findStarlist();
		context.setAttribute("clist", clist);
		context.setAttribute("starList", starList);
    }
```

好处：

​	1、用户不用登陆也可以访问到首页的数据

​	2、只在服务器启动时查询一次，提升访问的效率

## 4、跳转到商品详情页面

- sql：select  *  from   product   where   pid  = ?
- 传参：pid
- 业务
- 结果展示(跳转到商品详情页面，EL取出商品数据)

index.jsp

```html
<a href="/xiaomi/product?method=findProductByPid&pid=${star.pid}" target="_blank">
            		<img class="time_min" style="width:234px;height: 234px;" src="/xm_upload/${star.pic}" alt="">
            	</a>
```

Servlet：

```java
//根据pid查询
	public String findProductByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String pid = request.getParameter("pid");
		//2、业务调用
		ProductService ps = new ProductServiceImpl();
		Product p = ps.findProductByPid(pid);
		//3、结果展示
		request.setAttribute("p", p);
		return "product_detail";
	}
```

Dao：

```java
public Product findProductByPid(String pid) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from product where pid = ?";
		Object [] param = {pid};
		
		try {
			return qr.query(sql, new BeanHandler<Product>(Product.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
```

product_detail.jsp

```html
<div class="plus5_no3_right">
            <h3>商品名称：${p.pname}</h3>
            <p class="plus5_no3_right_p2">
            	<span class="plus5_no3_right_span2" style="font-size: 20px">「${p.description}」</span>
            </p>
            <p class="plus5_no3_right_p3">价格：${p.price}元</p>
            
            <h3>商品编号：${p.pid}</h3>
```

## 5、将首页的头部抽取出来

将头部页面共用的代码抽取到header.jsp中



index.jsp  product_detail.jsp  cart.jsp。。。

引入：

```html
<!-- 引入头部 -->
	<%@ include file="header.jsp" %>
```

## 6、购物车数据的封装

购物车中的数据存在哪：session

![1](image/1.png)

CartItem：

```java
package com.mi.pojo;

import java.io.Serializable;

//购物项
public class CartItem implements Serializable{
	//商品
	private Product product;
	//购买数量
	private int count;
	//小计
	private double subTotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//计算小计
	public double getSubTotal() {
		return subTotal = (getProduct().getPrice() * getCount());
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
```

Cart：

```java
package com.mi.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//购物车
public class Cart implements Serializable{

	//集合的选用问题  LinkedHashMap
	//1、要求购物车有序  2、要求删除方便
	/*
	 *	Set：无序
	 *  List：
	 *  Map：remove(key) 
	 * */
	//key:商品的pid     value：CartItem
	private Map<Integer,CartItem> cartMap = new LinkedHashMap<Integer,CartItem>();
	
	//总价格
	private double total;

	public Map<Integer, CartItem> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<Integer, CartItem> cartMap) {
		this.cartMap = cartMap;
	}

	//计算总金额
	public double getTotal() {
		total = 0.0;
		//获取购物项的小计   进行相加
		Set<Integer> keySet = cartMap.keySet();
		for(Integer key:keySet) {
			//根据key获取CartItem
			CartItem cartItem = cartMap.get(key);
			total += cartItem.getSubTotal();
		}
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/*public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("name", "lucy");
		map.put("age", "12");
		map.put("sex", "男");
		map.put("address", "beijing");
		System.out.println(map);
		//删除
	}*/
}

```

## 7、添加购物车

传参数：

​	pid、购买数量count

product_detail.jsp

```javascript
//加入购物车
		function addCart(){
			//获取pid的值
			var pid = ${p.pid};
			//获取count的值
			var count = $("#count").val();
			//请求服务器
			location.href="/xiaomi/order?method=addCart&pid=${p.pid}&count="+count;
		}
```

OrderServelt：

```java
@WebServlet("/order")
public class OrderServlet extends BaseServlet{
	//添加购物车
	public String addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String pid = request.getParameter("pid");
		String count = request.getParameter("count");
		//根据pid查询商品
		ProductService ps = new ProductServiceImpl();
		Product product = ps.findProductByPid(pid);
		//2、业务调用
			//准备购物项对象
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setCount(Integer.parseInt(count));
			//准备购物车对象
		Cart cart = getCart(request);
			//将购物项添加到购物车
		OrderService os = new OrderServiceImpl();
		os.addCart(cart,cartItem);//添加业务实现
		//3、结果展示
		//跳转到购物车页面
		return "cart";
	}
	//获取购物车对象
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}
}
```

OrderService：

```java
//业务的实现
	public void addCart(Cart cart, CartItem cartItem) {
		/*
		 * 判断该商品是否已经在购物车中存在：
		 * 	  1、不存在(添加到购物车)
		 * 	  2、存在(修改数量)
		 * */
		//获取添加商品的pid
		Integer pid = cartItem.getProduct().getPid();
		//根据pid得到CartItem
		CartItem oldCartItem = cart.getCartMap().get(pid);
		if(oldCartItem != null) {
			//修改数量
			oldCartItem.setCount(oldCartItem.getCount() + cartItem.getCount());
		}else {
			//添加到购物车
			cart.getCartMap().put(pid, cartItem);
		}
	}

```

cart.jsp

```html
 <c:if test="${not empty cart.cartMap}">
            	<c:forEach items="${cart.cartMap}" var="entry">
	            <div class="tro_tab_h1">
	   <li class="tro_tab_name_li1" style="font-size: 16px;">
	               	${entry.value.product.pname}
	               </li>
	     <div class="col tro_tab_price">
	                    <span  id="price"></span>${entry.value.product.price}<span>元</span>
	                </div>
	                <div class="col tro_tab_num">
	                    <input type="count" value="${entry.value.count}" id="num">
	                </div>
<span class="tro_tab_total_value" id="prices">${entry.value.subTotal}</span>元

 <p class="tro_close_p_c">合计:<span id="close">${cart.total}</span>元</p>
```





继续购物：

```html
 <p class="tro_close_p "> <a href="/xiaomi/index.jsp">继续购物 </a></p>
```

## 8、删除购物车中某个购物项

传参数：pid

cart.jsp

```javascript
//根据pid删除购物车
	function delCartByPid(pid){
		if(confirm("是否确认从购物车中移除呢？")){
		location.href="/xiaomi/order?method=delCartByPid&pid="+pid;
		}
	}
```

OrderServlet：

```java
//删除购物车
	public String delCartByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Cart cart = getCart(request);
		cart.getCartMap().remove(Integer.parseInt(pid));
		return "cart";
	}
```

## 9、清空购物车

cart.jsp

```javascript
function clearCart(){
		if(confirm("是否确认清空购物车？")){
		location.href="/xiaomi/order?method=clearCart";
		}
	}
```

OrderServlet：

```java
//清空购物车
	public String clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart cart = getCart(request);
		cart.getCartMap().clear();
		return "cart";
	}
```


package com.mi.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mi.pojo.Cart;
import com.mi.pojo.CartItem;
import com.mi.pojo.OrderItem;
import com.mi.pojo.Orders;
import com.mi.pojo.Product;
import com.mi.pojo.User;
import com.mi.service.OrderService;
import com.mi.service.ProductService;
import com.mi.service.impl.OrderServiceImpl;
import com.mi.service.impl.ProductServiceImpl;
import com.mi.utils.UUIDUtils;
import com.mi.web.base.BaseServlet;
@WebServlet("/order")
public class OrderServlet extends BaseServlet{
	
	//修改订单状态
	//update orders set state = 1  where oid = ?
	public String updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService os = new OrderServiceImpl();
		
		Orders orders = (Orders)request.getSession().getAttribute("orders");
		os.updateState(orders.getOid());
		response.getWriter().write("<h2>支付成功，3秒后跳转到首页继续购物！！！</h2>");
		response.setHeader("refresh", "3;url=/xiaomi/index.jsp");
		return "";
	}
	//去结算
	public String toPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//判断用户是否登录？
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("qianUser");
		if(user == null) {
			//用户未登录
			request.setAttribute("msg", "用户尚未登录，请先去登录！！！");
			return "msg";
		}
		//用户登录成功，但是购物车中没有商品，提示请先去购物
		Cart cart = getCart(request);
		if(cart.getCartMap().size() == 0) {
			//购物车中没有数据
			request.setAttribute("msg", "购物车是空的，请先去购物！！！");
			return "msg";
		}
		
		//1、生成订单(本质就是对订单表、订单项表进行insert into)
		//创建Orders对象
		Orders orders = new Orders();
		//封装数据
		orders.setOid(UUIDUtils.getUUID());
		orders.setOrdertime(new Date().toLocaleString());
		orders.setTotal(cart.getTotal());
		orders.setState(0);
		orders.setUid(user.getUid());
		orders.setUser(user);
		List<OrderItem> olist = new ArrayList();
		   //如何拿到购物项对象
		Set<Integer> keySet = cart.getCartMap().keySet();
		for(Integer key:keySet) {
			//根据key获取CartItem对象
			CartItem ci = cart.getCartMap().get(key);
			//创建OrderItem对象
			OrderItem oi = new OrderItem();
			//进行数据的封装
			oi.setItemid(UUIDUtils.getUUID());
			oi.setCount(ci.getCount());
			oi.setSubtotal(ci.getSubTotal());
			oi.setPid(ci.getProduct().getPid());
			oi.setOid(orders.getOid());
			olist.add(oi);
		}
		orders.setOlist(olist);
		//调用业务
		OrderService os = new OrderServiceImpl();
		os.addOrdersAndOrderItem(orders);
		//2、跳转到支付页面
		//清空购物车
		cart.getCartMap().clear();
		session.setAttribute("orders", orders);
		return "pay/index";
	}
	//清空购物车
	public String clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart cart = getCart(request);
		cart.getCartMap().clear();
		return "cart";
	}
	//删除购物车
	public String delCartByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Cart cart = getCart(request);
		cart.getCartMap().remove(Integer.parseInt(pid));
		return "cart";
	}
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
		os.addCart(cart,cartItem);
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

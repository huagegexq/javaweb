package com.mi.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.mi.pojo.Category;
import com.mi.pojo.PageBean;
import com.mi.pojo.Product;
import com.mi.service.CategoryService;
import com.mi.service.ProductService;
import com.mi.service.impl.CategoryServiceImpl;
import com.mi.service.impl.ProductServiceImpl;
import com.mi.utils.UUIDUtils;
import com.mi.web.base.BaseServlet;
//商品模块
@WebServlet("/product")
@MultipartConfig
public class ProductServlet  extends BaseServlet{
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
	//商品的分页查询
	public String findPlistByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		String pageNumber = request.getParameter("pageNumber");
		PageBean<Product> pb =new PageBean<Product>();
		pb.setPageNumber(Integer.parseInt(pageNumber));
		//2、业务调用
		ProductService ps = new ProductServiceImpl();
		pb = ps.findPlistByPage(pb);
		//3、结果展示
		request.setAttribute("pb", pb);
		return "admin/product_list";
	}
	//跳转到添加商品页面
	public String toAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、准备数据
		//2、业务调用
		CategoryService ps = new CategoryServiceImpl();
		List<Category> clist = ps.findAll();
		//3、结果展示
		request.setAttribute("clist", clist);
		return "admin/product_add";
	}
	//添加商品
	public String addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、准备数据
			Map<String, String[]> map = request.getParameterMap();
			Product p = new Product();
			BeanUtils.populate(p, map);
			//2、获取photo
			Part part = request.getPart("pic");
			//本地硬盘的路径
			String path = "G:\\java\\xm_upload";
			//获取图片的名称
			String value = part.getHeader("Content-Disposition");
			String fileName = value.substring(value.indexOf("filename")+10, value.length()-1);
			//图片名称上加随机数
			fileName = UUIDUtils.getUUID() + fileName;
			//上传到指定的位置
			part.write(path+"//"+fileName);
			p.setPic(fileName);
			//2、业务调用
			ProductService ps = new ProductServiceImpl();
			ps.addProduct(p);
			//3、结果展示
			response.sendRedirect("/xiaomi/product?method=findPlistByPage&pageNumber=1");
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}

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
	}
	
	
}

package com.mi.pojo;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
	//起始索引
	private int startIndex;
	//当前页
	private int pageNumber;
	//每页显示的条数
	private int pageSize = 3;
	//查询到某页的数据
	private List<T> result;
	public int getStartIndex() {
		//第一个计算公式
		return startIndex = (getPageNumber() - 1) * getPageSize();
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	
	
}

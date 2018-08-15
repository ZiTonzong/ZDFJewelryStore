package com.ZDF.utils;

import java.util.List;

/**
 * 分页工具类（封装每页需要显示的数据）
 * @author cdk
 * @date 2018年7月27日
 */
public class PageUtil {
	//当前页页码
	private int pageNo;
	//每页显示数据条数
	private int pageSize;
	//总记录（条数）
	private int totalCount;
	//当前页数据集合
	private List data;
	//总页数
	private int totalPage;
	/**
	 * 构造方法，传递每页条数和总记录数
	 * @param pageSize
	 * @param totalCount
	 */
	public PageUtil(int pageSize,int totalCount){
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		if(this.totalCount % this.pageSize==0){
			//计算总页数
			this.totalPage = this.totalCount/this.pageSize;
		}
		else{
			this.totalPage = this.totalCount/this.pageSize+1;
		}
	}
	public PageUtil(){
		
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}

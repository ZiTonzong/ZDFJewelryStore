package com.ZDF.beans;

import java.util.List;
/**
 * 分页实体类
 * @author cdk
 * @date 2018年7月26日
 * @param <E>
 */
public class Pager<E> {
	private int currPage;
	private int pageSize;
	private int pageCount;
	private int dataCount;
	private List<E> pageDataList;
	public Pager(int currPage, int pageSize, int pageCount, int dataCount, List<E> pageDataList) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.pageDataList = pageDataList;
	}
	public Pager(){
		
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public List<E> getPageDataList() {
		return pageDataList;
	}
	public void setPageDataList(List<E> pageDataList) {
		this.pageDataList = pageDataList;
	}
	@Override
	public String toString() {
		return "Pager [currPage=" + currPage + ", pageSize=" + pageSize + ", pageCount=" + pageCount + ", dataCount="
				+ dataCount + ", pageDataList=" + pageDataList + "]";
	}
	
}

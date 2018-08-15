package com.ZDF.utils;

import java.util.List;

/**
 * ��ҳ�����ࣨ��װÿҳ��Ҫ��ʾ�����ݣ�
 * @author cdk
 * @date 2018��7��27��
 */
public class PageUtil {
	//��ǰҳҳ��
	private int pageNo;
	//ÿҳ��ʾ��������
	private int pageSize;
	//�ܼ�¼��������
	private int totalCount;
	//��ǰҳ���ݼ���
	private List data;
	//��ҳ��
	private int totalPage;
	/**
	 * ���췽��������ÿҳ�������ܼ�¼��
	 * @param pageSize
	 * @param totalCount
	 */
	public PageUtil(int pageSize,int totalCount){
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		if(this.totalCount % this.pageSize==0){
			//������ҳ��
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

package com.ZDF.beans;
/**
 * 商品分类的bean,只有一个属性即商品分类的代号
 * 0-钻石  1-玉石 2-珍珠 3-黄金  4-白银
 * @author cdk
 * @date 2018年7月30日
 */
public class Sort {
	private int sortId;
	private String sortId_name;
	public Sort(){
		
	}
	public Sort(int sortId){
		this.sortId = sortId;
		if(sortId==0)
			sortId_name = "钻石-钟大福珠宝";
		else if(sortId==1)
			sortId_name = "玉石-钟大福珠宝";
		else if(sortId==2)
			sortId_name = "珍珠-钟大福珠宝";
		else if(sortId==3)
			sortId_name = "黄金-钟大福珠宝";
		else if(sortId==4)
			sortId_name = "白银-钟大福珠宝";
		else {
			sortId_name = "error";
		}
	}
	public int getSortId() {
		return sortId;
	}


	public void setSortId(int sortId) {
		this.sortId = sortId;
	}


	public String getSortId_name() {
		return sortId_name;
	}


	public void setSortId_name(String sortId_name) {
		this.sortId_name = sortId_name;
	}


	@Override
	public String toString() {
		return "sortId";
	}
	
}

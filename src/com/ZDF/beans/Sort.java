package com.ZDF.beans;
/**
 * ��Ʒ�����bean,ֻ��һ�����Լ���Ʒ����Ĵ���
 * 0-��ʯ  1-��ʯ 2-���� 3-�ƽ�  4-����
 * @author cdk
 * @date 2018��7��30��
 */
public class Sort {
	private int sortId;
	private String sortId_name;
	public Sort(){
		
	}
	public Sort(int sortId){
		this.sortId = sortId;
		if(sortId==0)
			sortId_name = "��ʯ-�Ӵ��鱦";
		else if(sortId==1)
			sortId_name = "��ʯ-�Ӵ��鱦";
		else if(sortId==2)
			sortId_name = "����-�Ӵ��鱦";
		else if(sortId==3)
			sortId_name = "�ƽ�-�Ӵ��鱦";
		else if(sortId==4)
			sortId_name = "����-�Ӵ��鱦";
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

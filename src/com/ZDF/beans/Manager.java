package com.ZDF.beans;
/**
 * ����Ա�࣬��������Ա����������Ա�˺ź�����
 * @author cdk
 * @date 2018��7��31��
 */
public class Manager {
	private int managerId;
	private String managerName;
	private String managerPassword;
	public Manager(){
		
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerPassword="
				+ managerPassword + "]";
	}
	
}

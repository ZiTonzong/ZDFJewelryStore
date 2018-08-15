package com.ZDF.beans;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String trueName;
	private String phone;
	private String address;
	private int userStatus;
	public User(){
		
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	public User(int userId, String password, String trueName, String phone, String address,
			int userStatus) {
		super();
		this.userId = userId;
		//this.userName = userName;
		this.password = password;
		this.trueName = trueName;
		this.phone = phone;
		this.address = address;
		this.userStatus = userStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + userName + ", password=" + password + ", truename=" + trueName
				+ ", phone=" + phone + ", address=" + address + ", userStatus=" + userStatus + "]";
	}
	
}

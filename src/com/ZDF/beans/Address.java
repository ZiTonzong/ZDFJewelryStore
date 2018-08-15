package com.ZDF.beans;

public class Address {
	private int addressId;
	private String sendPlace;
	private String sendMan;
	private String sendPhone;
	private int userId;
	public Address(int addressId, String sendPlace, String sendMan,
			String sendPhone, int userId) {
		super();
		this.addressId = addressId;
		this.sendPlace = sendPlace;
		this.sendMan = sendMan;
		this.sendPhone = sendPhone;
		this.userId = userId;
	}
	public Address(String sendPlace, String sendMan, String sendPhone,
			int userId) {
		super();
		this.sendPlace = sendPlace;
		this.sendMan = sendMan;
		this.sendPhone = sendPhone;
		this.userId = userId;
	}
	public Address() {
		super();
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getSendPlace() {
		return sendPlace;
	}
	public void setSendPlace(String sendPlace) {
		this.sendPlace = sendPlace;
	}
	public String getSendMan() {
		return sendMan;
	}
	public void setSendMan(String sendMan) {
		this.sendMan = sendMan;
	}
	public String getSendPhone() {
		return sendPhone;
	}
	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", sendPlace=" + sendPlace
				+ ", sendMan=" + sendMan + ", sendPhone=" + sendPhone
				+ ", userId=" + userId + "]";
	}
	
}

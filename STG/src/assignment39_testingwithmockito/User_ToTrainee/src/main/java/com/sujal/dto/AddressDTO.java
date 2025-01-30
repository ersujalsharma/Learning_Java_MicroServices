package com.sujal.dto;

import lombok.Data;

@Data
public class AddressDTO {
	
	private Integer addressId;
	private String doorNumber;
	private String street;
	private String city;
	private String state;
	private Integer zipCode;
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", doorNumber=" + doorNumber + ", street=" + street + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}

}
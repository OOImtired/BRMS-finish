package model;

import java.sql.Date;

public class Rental {
	private String username;
	private String lpn;
	private String brand;
	private String type; 
	private double price;
	private String address;
	private Date startdate;
	private Date enddate;
	private Integer rentalnumber;
	private String telenumber;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLpn() {
		return lpn;
	}
	public void setLpn(String lpn) {
		this.lpn = lpn;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Integer getRentalnumber() {
		return rentalnumber;
	}
	public void setRentalnumber(Integer rentalnumber) {
		this.rentalnumber = rentalnumber;
	}
	public String getTelenumber() {
		return telenumber;
	}
	public void setTelenumber(String telenumber) {
		this.telenumber = telenumber;
	}


	
}

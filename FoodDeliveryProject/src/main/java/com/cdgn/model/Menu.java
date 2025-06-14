package com.cdgn.model;

public class Menu {
	private int sno;
	private String itemName;
	private int price;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [sno=" + sno + ", itemName=" + itemName + ", price=" + price + "]";
	}
	
	
	
}

package model;

public class product {
	private int productId;
	private String productname;
	private int minSellQuantity;
	private int price;
	private int quantity;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getMinSellQuantity() {
		return minSellQuantity;
	}
	public void setMinSellQuantity(int minSellQuantity) {
		this.minSellQuantity = minSellQuantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

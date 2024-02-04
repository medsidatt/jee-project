package mr.iscae;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stock {
	@JsonProperty
    private String barcode;
	@JsonProperty
	private String name;
	@JsonProperty
	private double price;
	@JsonProperty
	private int quantity;
	
	public Stock() {
		
	}
	public Stock(String barcode, String name, double price, int quantity) {
		this.barcode = barcode;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}



	public String getBarcode() {
		return barcode;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

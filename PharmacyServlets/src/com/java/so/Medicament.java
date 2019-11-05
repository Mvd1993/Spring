package com.java.so;

public class Medicament {
	private String medicamentId, name, description,producer;
	private double price;
	private long stockQuantity, stockInOrder;
	private boolean active;
	
	public String getMedicamentId() {
		return medicamentId;
	}
	public void setMedicamentId(String medicamentId) {
		this.medicamentId = medicamentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public long getStockInOrder() {
		return stockInOrder;
	}
	public void setStockInOrder(long stockInOrder) {
		this.stockInOrder = stockInOrder;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Boolean getActive() {
		
		return this.active;
	}
	

	

}

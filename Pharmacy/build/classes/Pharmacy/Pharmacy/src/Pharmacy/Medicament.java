package Pharmacy;



public class Medicament {
	
	private String medicamentId;	
	private String name, description,producer, category;
	private double price;
	private int stockQuantity, stockInOrder;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public long getStockInOrder() {
		return stockInOrder;
	}
	public void setStockInOrder(int stockInOrder) {
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
	
	public Medicament(String medicamentId) {
        super();
        this.medicamentId = medicamentId;
        
    }
    public Medicament() {
        super();
    }

}

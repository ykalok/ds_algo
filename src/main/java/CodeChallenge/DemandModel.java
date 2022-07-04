package CodeChallenge;

public class DemandModel {
	private String demandOrderId;
	private String supplyOrderId;
	private String price;
	private String quantity;
	
	public String getDemandOrderId() {
		return demandOrderId;
	}
	public void setDemandOrderId(String demandOrderId) {
		this.demandOrderId = demandOrderId;
	}
	public String getSupplyOrderId() {
		return supplyOrderId;
	}
	public void setSupplyOrderId(String supplyOrderId) {
		this.supplyOrderId = supplyOrderId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}

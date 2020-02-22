package Domain;

public class ImportDetailDomain {
	private Integer importQty ;
    private Double unitPrice;
    ImportDomain importId;
    BookDomain bookId;
    CategoryDomain categoryId;
	public Integer getImportQty() {
		return importQty;
	}
	public void setImportQty(Integer importQty) {
		this.importQty = importQty;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

}

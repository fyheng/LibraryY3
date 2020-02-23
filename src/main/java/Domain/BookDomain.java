package Domain;

import Enumeration.BooKStatus;

public class BookDomain {
	 private String bookCode;
     private String title ;
     private String language;
     private String publicAt;
     private String authors;
     private String edition;
     private Integer qty;
     private Double pricePaid;
     private BooKStatus status;
     CategoryDomain categoryId;
     
	public String getTitle() {
		return title; 
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPublicAt() {
		return publicAt;
	}
	public void setPublicAt(String publicAt) {
		this.publicAt = publicAt;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(Double pricePaid) {
		this.pricePaid = pricePaid;
	}
	public BooKStatus getStatus() {
		return status; 
	}
	public void setStatus(BooKStatus new1) {
		this.status = new1;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
}

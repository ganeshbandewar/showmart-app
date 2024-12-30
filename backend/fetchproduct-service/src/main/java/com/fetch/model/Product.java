package com.fetch.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Product {

    @Id
	private int productId;
	private String productName;
	private String productDescription;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	private String createdBy;
	
    @UpdateTimestamp
	private LocalDateTime updatedDate;
	
	private String updatedBy;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getproductDescription() {
		return productDescription;
	}

	public void setproductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", updatedDate="
				+ updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	public Product(int productId, String productName, String productDescription, LocalDateTime createdDate,
			String createdBy, LocalDateTime updatedDate, String updatedBy) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stubh
	}
}

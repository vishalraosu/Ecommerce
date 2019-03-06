package com.softvision.ecommerce.products.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ProductBo {

	private int productId;
	private String productDesc;
	private String category;
	private String price;
	private int quantity;
	private String image;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBo other = (ProductBo) obj;
		if (productId != other.productId)
			return false;
		return true;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductBo [productId=" + productId + ", productDesc=" + productDesc + ", category=" + category
				+ ", price=" + price + ", quantity=" + quantity + ", image=" + image + "]";
	}

	public ProductBo(int productId, String productDesc, String category, String price, int quantity, String image) {
		super();
		this.productId = productId;
		this.productDesc = productDesc;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

	public ProductBo() {

	}

}

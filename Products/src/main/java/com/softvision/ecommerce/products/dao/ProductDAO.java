package com.softvision.ecommerce.products.dao;

import java.util.List;

import com.softvision.ecommerce.products.model.ProductBo;

public interface ProductDAO {

	public List<ProductBo> getProduct();

	public List<ProductBo> getProductByCategory(String category);

	public ProductBo getProductInCart(String string);

	public ProductBo getProductIntoCart(String string);

}

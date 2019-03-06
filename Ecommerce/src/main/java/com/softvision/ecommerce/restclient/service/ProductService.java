package com.softvision.ecommerce.restclient.service;

import java.util.List;
import java.util.Set;

import com.softvision.ecommerce.model.ProductBo;

public interface ProductService {

	public List<ProductBo> getAllProducts();

	public List<ProductBo> getAllProductsByMen(String category);

	public List<ProductBo> getAllProductsByWomen(String category);

	public List<ProductBo> getAllProductsByKids(String category);

	public ProductBo getProductsInCart(int productId, int quantity);

	public ProductBo getProductsInBuyNow(int productId, int quantity);

	public Set<ProductBo> getProductsInBuyNowList();

	public ProductBo removeProductsFromCart(String productId);

}

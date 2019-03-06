package com.softvision.ecommerce.restclient.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softvision.ecommerce.model.ProductBo;
import com.softvision.ecommerce.util.RestClientUtil;

import static com.softvision.ecommerce.constant.Constant.VIEW_PRODUCT_URI;
import static com.softvision.ecommerce.constant.Constant.MEN_PRODUCT_URI;
import static com.softvision.ecommerce.constant.Constant.WOMEN_PRODUCT_URI;
import static com.softvision.ecommerce.constant.Constant.KID_PRODUCT_URI;
import static com.softvision.ecommerce.constant.Constant.CART_URI;
import static com.softvision.ecommerce.constant.Constant.BUY_NOW_URI;
import static com.softvision.ecommerce.constant.Constant.BUYNOW_ORDER_URI;
import static com.softvision.ecommerce.constant.Constant.REMOVE_PRODUCT_URI;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	RestClientUtil restClientUtil;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	Set<ProductBo> buyNowList = new HashSet<ProductBo>();

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBo> getAllProducts() {
		List<ProductBo> listProducts = restClientUtil.getForObject(VIEW_PRODUCT_URI, List.class);
		LOGGER.info("Calling Method getAllProducts() :: ProductBo {}" + listProducts);
		return listProducts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBo> getAllProductsByMen(String category) {
		List<ProductBo> listMen = restClientUtil.getForObject(MEN_PRODUCT_URI, List.class);
		LOGGER.info("Calling Method getAllProductsByMen() :: ProductBo {}" + listMen);
		return listMen;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBo> getAllProductsByWomen(String category) {
		List<ProductBo> listWomen = restClientUtil.getForObject(WOMEN_PRODUCT_URI, List.class);
		LOGGER.info("Calling Method getAllProductsByWomen() :: ProductBo {}" + listWomen);
		return listWomen;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBo> getAllProductsByKids(String category) {
		List<ProductBo> listKid = restClientUtil.getForObject(KID_PRODUCT_URI, List.class);
		LOGGER.info("Calling Method getAllProductsByKids() :: ProductBo {}" + listKid);
		return listKid;
	}

	@Override
	public ProductBo getProductsInCart(int productId, int quantity) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("productId", productId);
		params.put("quantity", quantity);
		ProductBo productBo = restClientUtil.getForObject(CART_URI, ProductBo.class, params);
		ProductBo productList = new ProductBo(productBo.getProductId(), productBo.getProductDesc(),
				productBo.getCategory(), productBo.getPrice(), quantity, productBo.getImage());
		LOGGER.info("Calling Method getProductsInCart() :: ProductBo {}" + productList);
		buyNowList.add(productList);
		return productList;
	}

	@Override
	public ProductBo getProductsInBuyNow(int productId, int quantity) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("productId", productId);
		params.put("quantity", quantity);

		ProductBo productBo = restClientUtil.getForObject(BUY_NOW_URI, ProductBo.class, params);
		ProductBo productList = new ProductBo(productBo.getProductId(), productBo.getProductDesc(),
				productBo.getCategory(), productBo.getPrice(), quantity, productBo.getImage());
		LOGGER.info("Calling Method getProductsInBuyNow() :: ProductBo {}" + productList);
		buyNowList.add(productList);
		return productList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<ProductBo> getProductsInBuyNowList() {
		Set<ProductBo> listBuyNow = restClientUtil.getForObject(BUYNOW_ORDER_URI, Set.class);
		LOGGER.info("Calling Method getProductsInBuyNowList() :: ProductBo {}" + listBuyNow);
		buyNowList.addAll(listBuyNow);
		return buyNowList;
	}

	@Override
	public ProductBo removeProductsFromCart(String productId) {
		ProductBo listRemove = restClientUtil.getForObject(REMOVE_PRODUCT_URI, ProductBo.class, productId);
		buyNowList.remove(listRemove);
		LOGGER.info("Calling Method removeProductsFromCart() :: ProductBo {}" + listRemove);
		return listRemove;
	}
}

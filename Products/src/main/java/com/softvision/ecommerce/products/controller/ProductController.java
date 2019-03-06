package com.softvision.ecommerce.products.controller;

import static com.softvision.ecommerce.products.constant.Constant.BUYNOW_ORDER_MAPPING_URL;
import static com.softvision.ecommerce.products.constant.Constant.CATEGORY_KID_MAPPING_URL;
import static com.softvision.ecommerce.products.constant.Constant.CATEGORY_MEN_MAPPING_URL;
import static com.softvision.ecommerce.products.constant.Constant.CATEGORY_WOMEN_MAPPING_URL;
import static com.softvision.ecommerce.products.constant.Constant.CONFIRM_ORDER_MAPPING_URL;
import static com.softvision.ecommerce.products.constant.Constant.REMOVE_PRODUCT_MAPPING_URL;
import static com.softvision.ecommerce.products.constant.Constant.VIEW_CART_MAPPING_URL;
import static com.softvision.ecommerce.products.constant.Constant.VIEW_PRODUCT_MAPPING_URL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softvision.ecommerce.products.dao.ProductDAOImpl;
import com.softvision.ecommerce.products.model.ProductBo;

@RestController
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<ProductBo> buyNowList = new HashSet();

	@Autowired
	private ProductDAOImpl productDAO;

	@RequestMapping(value = VIEW_PRODUCT_MAPPING_URL, method = RequestMethod.GET)
	@ResponseBody
	public List<ProductBo> viewProduct() {
		LOGGER.info("Calling ProductController::viewProduct()  {}");
		return productDAO.getProduct();
	}

	@RequestMapping(value = VIEW_CART_MAPPING_URL, method = RequestMethod.GET)
	@ResponseBody
	public ProductBo productsInCart(@PathVariable String productId, @PathVariable Integer quantity) {
		ProductBo productBo = productDAO.getProductInCart(productId);
		ProductBo productList = new ProductBo(productBo.getProductId(), productBo.getProductDesc(),
				productBo.getCategory(), productBo.getPrice(), quantity, productBo.getImage());
		LOGGER.info("Completed ProductController::productsInCart() :: Product list {}" + productBo);
		LOGGER.debug("Calling ProductController::productInCart() :: Updating the cart");
		buyNowList.add(productList);
		LOGGER.info("Completed ProductController::productsInCart()");
		return productList;
	}

	@RequestMapping(value = CATEGORY_MEN_MAPPING_URL, method = RequestMethod.GET)
	@ResponseBody
	public List<ProductBo> menCategory() {
		List<ProductBo> product = productDAO.getProductByCategory("men");
		LOGGER.info("Calling ProductController::menCategory() :: Product list of Men {}" + product);
		return product;
	}

	@RequestMapping(value = CATEGORY_WOMEN_MAPPING_URL, method = RequestMethod.GET)
	@ResponseBody
	public List<ProductBo> womenCategory() {
		List<ProductBo> product = productDAO.getProductByCategory("women");
		LOGGER.info("Calling ProductController::womenCategory() product list of women {}" + product);
		return product;
	}

	@RequestMapping(value = CATEGORY_KID_MAPPING_URL, method = RequestMethod.GET)
	@ResponseBody
	public List<ProductBo> kidCategory() {

		List<ProductBo> product = productDAO.getProductByCategory("Kids");
		LOGGER.info("Calling ProductController::kidCategory() ProductList of Kid :{}" + product);
		return product;
	}

	/*
	 * @RequestMapping(value = "/buyNow/{productId}/{quantity}/", method =
	 * RequestMethod.GET)
	 * 
	 * @ResponseBody public ProductBo buyNow(@PathVariable String
	 * productId, @PathVariable Integer quantity) { ProductBo productBo =
	 * productDAO.getProductInCart(productId); ProductBo productList = new
	 * ProductBo(productBo.getProductId(), productBo.getProductDesc(),
	 * productBo.getCategory(), productBo.getPrice(), quantity,
	 * productBo.getImage()); logger.info("productList of buyNow " + productList);
	 * buyNowList.add(productList);
	 * 
	 * return productList; }
	 */

	@RequestMapping(value = BUYNOW_ORDER_MAPPING_URL, method = RequestMethod.GET)
	@ResponseBody
	public Set<ProductBo> buyNowOrder() {
		LOGGER.info("ProductController::buyNowOrder() ::List of Products {}" + buyNowList);
		return buyNowList;
	}

	@RequestMapping(value = CONFIRM_ORDER_MAPPING_URL, method = RequestMethod.POST)
	public String confirmOrder(HttpSession session) {

		if (session.getAttribute("username") != null) {
			buyNowList.clear();
			LOGGER.info("Calling ProductController::confirmOrder()");
			String recipient = (String) session.getAttribute("emailId");
			LOGGER.debug("Calling ProductController::confirmOrder() :: dynamic email id received:{}" + recipient);
			// Mail mail = new Mail();
			// mail.sendMail("yes", session);
			return ("confirmOrder");
		} else {
			LOGGER.debug("Calling ProductController::confirmOrder() :: No Records found of user");
			return ("Login");
		}
	}

	@RequestMapping(value = REMOVE_PRODUCT_MAPPING_URL, method = RequestMethod.GET)
	@ResponseBody
	public ProductBo remove(@PathVariable String productId) {
		ProductBo productBo = productDAO.getProductInCart(productId);
		ProductBo productList = new ProductBo(productBo.getProductId(), productBo.getProductDesc(),
				productBo.getCategory(), productBo.getPrice(), productBo.getQuantity(), productBo.getImage());
		LOGGER.info("product list" + productList);
		buyNowList.remove(productList);
		return productList;
	}
}
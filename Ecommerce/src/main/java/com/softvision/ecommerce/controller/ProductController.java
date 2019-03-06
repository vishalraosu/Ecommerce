package com.softvision.ecommerce.controller;

import static com.softvision.ecommerce.constant.Constant.BUYNOW_ORDER_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.CATEGORY_KID_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.CATEGORY_MEN_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.CATEGORY_WOMEN_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.CONFIRM_ORDER_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.REMOVE_PRODUCT_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.VIEW_CART_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.VIEW_PRODUCT_MAPPING_URL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softvision.ecommerce.mail.Mail;
import com.softvision.ecommerce.model.ProductBo;
import com.softvision.ecommerce.restclient.service.ProductServiceImpl;

@Controller
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	private Set<ProductBo> buyNowList = new HashSet<ProductBo>();

	@Autowired
	private ProductServiceImpl productService;

	@GetMapping(value = VIEW_PRODUCT_MAPPING_URL)
	public ModelAndView viewProduct() {
		LOGGER.info("Calling ProductController::viewProduct()");
		List<ProductBo> list = productService.getAllProducts();
		LOGGER.info("Completed ProductController::viewProduct() :: Product list {}" + list);
		return new ModelAndView("viewProduct", "list", list);
	}

	@GetMapping(value = VIEW_CART_MAPPING_URL)
	public ModelAndView productsInCart(@PathVariable Integer productId, Integer quantity, HttpServletRequest request) {
		ProductBo productBo = productService.getProductsInCart(productId, quantity);
		LOGGER.info("Completed ProductController::productsInCart() :: Product list {}" + productBo);
		LOGGER.debug("Calling ProductController::productInCart() :: Updating the cart");
		buyNowList.add(productBo);
		LOGGER.info("Completed ProductController::productsInCart()");
		return new ModelAndView("redirect:/viewProduct");
	}

	@GetMapping(value = CATEGORY_MEN_MAPPING_URL)
	public ModelAndView menCategory() {
		List<ProductBo> product = productService.getAllProductsByMen("men");
		LOGGER.info("Calling ProductController::menCategory() :: Product list of Men {}" + product);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ProductMen", product);
		mv.setViewName("Men");
		LOGGER.info("Completed ProductController::menCategory()");
		return mv;
	}

	@GetMapping(value = CATEGORY_WOMEN_MAPPING_URL)
	public ModelAndView womenCategory() {
		List<ProductBo> product = productService.getAllProductsByWomen("women");
		LOGGER.info("Calling ProductController::womenCategory() product list of women {}" + product);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ProductWomen", product);
		mv.setViewName("Women");
		LOGGER.info("Completed ProductController::womenCategory()");
		return mv;
	}

	@GetMapping(value = CATEGORY_KID_MAPPING_URL)
	public ModelAndView kidCategory() {

		List<ProductBo> product = productService.getAllProductsByKids("Kids");
		LOGGER.info("Calling ProductController::kidCategory() ProductList of Kid :{}" + product);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ProductKid", product);
		mv.setViewName("Kid");
		LOGGER.info("Completed ProductController::kidCategory()");
		return mv;
	}

	/*
	 * @RequestMapping(value = "/buyNow/{productId}/{quantity}/", method =
	 * RequestMethod.GET) public ModelAndView buyNow(@PathVariable Integer
	 * productId, @PathVariable Integer quantity) { ProductBo productBo =
	 * productService.getProductsInCart(productId, quantity);
	 * 
	 * logger.info("productList of buyNow " + productBo); buyNowList.add(productBo);
	 * ModelAndView mv = new ModelAndView(); mv.addObject("buyNowList", buyNowList);
	 * mv.setViewName("buyNow"); return mv; }
	 */

	@GetMapping(value = BUYNOW_ORDER_MAPPING_URL)
	public ModelAndView buyNowOrder() {
		ModelAndView mv = new ModelAndView();
		Set<ProductBo> listBuyNow = productService.getProductsInBuyNowList();
		LOGGER.info("ProductController::buyNowOrder() ::List of Products {}" + listBuyNow);
		mv.addObject("buyNowList", buyNowList);
		mv.setViewName("buyNowOrder");
		LOGGER.info("Completed ProductController::buyNowOrder()");
		return mv;
	}

	@PostMapping(value = CONFIRM_ORDER_MAPPING_URL)
	public String confirmOrder(HttpSession session) {
		if (buyNowList.isEmpty()) {
			return ("redirect:/viewProduct");
		} else {
			if (session.getAttribute("username") != null) {
				buyNowList.clear();
				LOGGER.info("Calling ProductController::confirmOrder()");
				String recipient = (String) session.getAttribute("emailId");
				LOGGER.debug("Calling ProductController::confirmOrder() :: dynamic email id received:{}" + recipient);
				Mail mail = new Mail();
				mail.sendMail("yes", session);
				return ("confirmOrder");
			} else {
				LOGGER.debug("Calling ProductController::confirmOrder() :: No Records found of user");
				return ("Login");
			}

		}
	}

	@PostMapping(value = REMOVE_PRODUCT_MAPPING_URL)
	public ModelAndView removeProductFromCart(@PathVariable String productId) {
		ProductBo productBo = productService.removeProductsFromCart(productId);
		ProductBo productList = new ProductBo(productBo.getProductId(), productBo.getProductDesc(),
				productBo.getCategory(), productBo.getPrice(), productBo.getQuantity(), productBo.getImage());
		LOGGER.info("Calling ProductController::removeProductFromCart() ::product list  {}" + productList);
		LOGGER.debug("Calling ProductController::removeProductFromCart() :: Current Buynow list {}" + buyNowList);
		buyNowList.remove(productList);
		LOGGER.info("Completed ProductController::removeProductFromCart() :: Current Buynow list {}" + buyNowList);
		return new ModelAndView("redirect:/buyNowOrder");
	}
}
package com.softvision.ecommerce.constant;

public class Constant {

	// User Controller URL

	public static final String SIGN_UP_REQ_MAPPING_URL = "/signUp";
	public static final String USER_LOGIN_MAPPING_URL = "/login";
	public static final String USER_LOGOUT_MAPPING_URL = "/logout";
	public static final String USER_PROFILE_MAPPING_URL = "/profile";
	public static final String USER_PROFILE_EDIT_MAPPING_URL = "/editdata/{id}/";
	public static final String USER_REGISISTRATION_MAPPING_URL = "/register";
	public static final String USERLOGIN_MAPPING_URL = "/userLogin";
	public static final String USER_FEEDBACK_MAPPING_URL = "/feedback";

	// User Web URL

	public static final String EDIT_USER_URL = "http://localhost:8083/editdata/{id}/";
	public static final String SIGN_UP_URL = "http://localhost:8083/signUp";
	public static final String USER_LOGIN_URL = "http://localhost:8083/login";
	public static final String FEEDBACK_URL = "http://localhost:8083/feedback";
	public static final String USER_PROFILE_URL = "http://localhost:8083/profile";

	// Product Controller URL

	public static final String VIEW_PRODUCT_MAPPING_URL = "/viewProduct";
	public static final String VIEW_CART_MAPPING_URL = "/cart/{productId}/{quantity}/";
	public static final String CATEGORY_MEN_MAPPING_URL = "/Men";
	public static final String CATEGORY_WOMEN_MAPPING_URL = "/Women";
	public static final String CATEGORY_KID_MAPPING_URL = "/Kid";
	public static final String BUYNOW_ORDER_MAPPING_URL = "/buyNowOrder";
	public static final String REMOVE_PRODUCT_MAPPING_URL = "/remove/{productId}/";
	public static final String CONFIRM_ORDER_MAPPING_URL = "/confirmOrder";

	// Product Web URL

	public static final String VIEW_PRODUCT_URI = "http://localhost:8082/viewProduct";
	public static final String MEN_PRODUCT_URI = "http://localhost:8082/Men";
	public static final String WOMEN_PRODUCT_URI = "http://localhost:8082/Women";
	public static final String KID_PRODUCT_URI = "http://localhost:8082/Kid";
	public static final String CART_URI = "http://localhost:8082/cart/{productId}/{quantity}/";
	public static final String BUY_NOW_URI = "http://localhost:8082/buyNow/{productId}/{quantity}/";
	public static final String BUYNOW_ORDER_URI = "http://localhost:8082/buyNowOrder/";
	public static final String REMOVE_PRODUCT_URI = "http://localhost:8082/remove/{productId}/";

}

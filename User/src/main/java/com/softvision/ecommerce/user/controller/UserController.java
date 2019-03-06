package com.softvision.ecommerce.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softvision.ecommerce.user.model.FeedbackBo;
import com.softvision.ecommerce.user.model.UserRegister;
import com.softvision.ecommerce.user.service.UserService;

import static com.softvision.ecommerce.user.constant.Constant.SIGN_UP_REQ_MAPPING_URL;
import static com.softvision.ecommerce.user.constant.Constant.USER_LOGIN_MAPPING_URL;
import static com.softvision.ecommerce.user.constant.Constant.USER_PROFILE_MAPPING_URL;
import static com.softvision.ecommerce.user.constant.Constant.USER_PROFILE_EDIT_MAPPING_URL;
import static com.softvision.ecommerce.user.constant.Constant.USER_FEEDBACK_MAPPING_URL;

@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private UserRegister userData = null;

	@Autowired
	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		LOGGER.info("Calling UserController::setUserService(), UserRegister {}" + userService);
		this.userService = userService;
	}

	@RequestMapping(value = SIGN_UP_REQ_MAPPING_URL, method = RequestMethod.POST)
	public UserRegister addPerson(@RequestBody UserRegister p) {
		LOGGER.info("Calling UserController::addPerson(), UserRegister {}" + p);
		return this.userService.addPerson(p);
	}

	@RequestMapping(value = USER_LOGIN_MAPPING_URL, method = RequestMethod.POST)
	public UserRegister login(@RequestBody UserRegister userRegister) {
		LOGGER.info("Calling UserController::login(), UserRegister {}" + userRegister);
		userData = userService.getPersonByEmail(userRegister);
		if (userData != null) {
			LOGGER.info("Called UserController::login(), UserRegister {}" + userRegister);
			return userData;
		} else {
			return null;
		}
	}

	@RequestMapping(value = USER_PROFILE_EDIT_MAPPING_URL, method = RequestMethod.PUT)
	public UserRegister editPerson(@RequestBody UserRegister userRegister, @PathVariable("id") int id) {
		LOGGER.info("Calling UserController::editPerson(), UserRegister {}" + userRegister);
		return this.userService.getUserById(userRegister);
	}

	@RequestMapping(value = USER_PROFILE_MAPPING_URL)
	public UserRegister userProfile() {
		LOGGER.info("Calling UserController::userProfile()");
		UserRegister user = userData;
		LOGGER.info("Called UserController::userProfile() :: UserRegister {}" + user);
		return user;
	}

	@RequestMapping(value = USER_FEEDBACK_MAPPING_URL, method = RequestMethod.POST)
	public FeedbackBo addFeedback(@RequestBody FeedbackBo feedback) {
		LOGGER.info("Calling UserController::addFeedback():: Feedback {}" + feedback);
		return this.userService.addFeedback(feedback);
	}
}

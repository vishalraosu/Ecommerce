package com.softvision.ecommerce.controller;

import static com.softvision.ecommerce.constant.Constant.SIGN_UP_REQ_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.USERLOGIN_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.USER_FEEDBACK_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.USER_LOGIN_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.USER_LOGOUT_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.USER_PROFILE_EDIT_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.USER_PROFILE_MAPPING_URL;
import static com.softvision.ecommerce.constant.Constant.USER_REGISISTRATION_MAPPING_URL;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softvision.ecommerce.model.FeedbackBo;
import com.softvision.ecommerce.model.UserRegister;
import com.softvision.ecommerce.restclient.service.UserService;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private UserRegister userData = null;

	@Autowired
	private UserService userService;

	@PostMapping(value = SIGN_UP_REQ_MAPPING_URL)
	public ModelAndView addPerson(@ModelAttribute UserRegister userRegister) {

		LOGGER.info("Calling UserController::addPerson() request is ::{}", userRegister);

		if (userRegister.getId() == 0) {
			LOGGER.info("Calling UserService-------");
			this.userService.addNewUser(userRegister);
		}

		LOGGER.info("Completed UserController::addPerson()");
		return new ModelAndView("Login");
	}

	@PostMapping(value = USER_LOGIN_MAPPING_URL)
	public String login(UserRegister userRegister, HttpSession session, Model model) {

		LOGGER.info("Calling UserController::login() request is ::{}", userRegister);

		userData = userService.loginUser(userRegister, session);
		LOGGER.debug("Called userService: userProfile() return value is :::=={}", userData);
		if (userData != null) {
			model.addAttribute("userData", userData);
			LOGGER.info("Completed UserController::login()");
			return "redirect:/viewProduct";
		} else {
			model.addAttribute("message", "Invalid Credentials, Please try again !!");
			LOGGER.info("Completed UserController::login() With Errors");
			return "Login";
		}
	}

	@GetMapping(value = USER_LOGOUT_MAPPING_URL)
	public String logout(UserRegister userRegister, HttpSession session, Model model) {
		LOGGER.info("Calling UserController::logout() request is ::{}", userRegister);

		if (session != null) {
			session.removeAttribute("username");
			session.invalidate();
		}
		LOGGER.info("Completed UserController::logout()");
		return "redirect:/index.jsp";
	}

	@GetMapping(value = USER_PROFILE_MAPPING_URL)
	public ModelAndView userProfile() {
		LOGGER.info("Calling UserController::userProfile() request is ::{}");

		UserRegister user = userService.userProfile();
		LOGGER.debug("Called userService: userProfile() return value is :::=={}", user);
		if (user != null) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.setViewName("editProfile");
			return mv;
		} else {
			return new ModelAndView("redirect:/userLogin");
		}
	}

	@PutMapping(value = USER_PROFILE_EDIT_MAPPING_URL)
	public String editPerson(UserRegister userRegister, Model model, @PathVariable int id) {

		LOGGER.info("Calling UserController::editPerson() request is ::{}", userRegister);
		LOGGER.info("Calling UserService-------");
		UserRegister user = this.userService.editUser(userRegister);
		model.addAttribute("user", user);
		LOGGER.info("Completed UserController::editPerson()");
		return ("redirect:/profileUpdate.jsp");
	}

	@GetMapping(value = USER_REGISISTRATION_MAPPING_URL)
	public ModelAndView register() {
		LOGGER.info("Calling :: register() ");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		LOGGER.info("Completed UserController::register()");
		return mv;
	}

	@GetMapping(value = USERLOGIN_MAPPING_URL)
	public ModelAndView userLogin() {
		LOGGER.info("Calling::userLogin()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		LOGGER.info("Completed :: userLogin()");
		return mv;
	}

	@PostMapping(value = USER_FEEDBACK_MAPPING_URL)
	public String addFeedback(Model model, FeedbackBo feedback) {

		LOGGER.info("Calling::addFeedback()");
		model.addAttribute("feedback", this.userService.feedback(feedback));
		LOGGER.info("Compleated :: addFeedback()");
		return "redirect:/thanks.jsp";
	}
}

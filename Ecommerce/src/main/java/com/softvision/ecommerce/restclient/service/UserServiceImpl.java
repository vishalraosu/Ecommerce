package com.softvision.ecommerce.restclient.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softvision.ecommerce.model.FeedbackBo;
import com.softvision.ecommerce.model.UserRegister;
import com.softvision.ecommerce.util.RestClientUtil;
import static com.softvision.ecommerce.constant.Constant.EDIT_USER_URL;
import static com.softvision.ecommerce.constant.Constant.FEEDBACK_URL;
import static com.softvision.ecommerce.constant.Constant.SIGN_UP_URL;
import static com.softvision.ecommerce.constant.Constant.USER_LOGIN_URL;
import static com.softvision.ecommerce.constant.Constant.USER_PROFILE_URL;

@Service

public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	public UserServiceImpl() {
	}

	@Autowired
	RestClientUtil restClientUtil;

	@Override
	public UserRegister addNewUser(UserRegister userRegister) {
		LOGGER.info("Calling Method :: addNewUser()");
		return restClientUtil.postForObject(SIGN_UP_URL, userRegister, UserRegister.class);
	}

	@Override
	public UserRegister editUser(UserRegister userRegister) {
		LOGGER.info("Calling Method :: editUser()");
		Map<String, Integer> editparams = new HashMap<String, Integer>();
		editparams.put("id", userRegister.getId());
		restClientUtil.put(EDIT_USER_URL, userRegister, editparams);
		return userRegister;
	}

	@Override
	public UserRegister loginUser(UserRegister userRegister, HttpSession httpsession) {
		LOGGER.info("Calling Method :: loginUser()");
		Map<String, String> editparams = new HashMap<String, String>();
		editparams.put("emailId", userRegister.getEmailId());
		editparams.put("password", userRegister.getPassword());
		UserRegister user = restClientUtil.postForObject(USER_LOGIN_URL, userRegister, UserRegister.class, editparams);
		LOGGER.debug("Calling loginUser():: Login Successful :: User Details" + user);
		if (user != null) {
			httpsession.setAttribute("username", user.getFirstName());
			httpsession.setAttribute("emailId", user.getEmailId());
			LOGGER.info("Called Method :: loginUser()");
			return user;
		} else {
			LOGGER.debug("Calling loginUser():: Login Un-Successful :: User Details" + user);
			return user;
		}
	}

	@Override
	public UserRegister userProfile() {
		LOGGER.info("Calling Method :: userProfile()");
		return restClientUtil.getForObject(USER_PROFILE_URL, UserRegister.class);
	}

	@Override
	public FeedbackBo feedback(FeedbackBo feedbackBo) {
		LOGGER.info("Calling Method :: feedback()");
		return restClientUtil.postForObject(FEEDBACK_URL, feedbackBo, FeedbackBo.class);
	}
}

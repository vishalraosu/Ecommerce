package com.softvision.ecommerce.restclient.service;

import javax.servlet.http.HttpSession;

import com.softvision.ecommerce.model.FeedbackBo;
import com.softvision.ecommerce.model.UserRegister;

public interface UserService {

	public UserRegister addNewUser(UserRegister userRegister);

	public UserRegister editUser(UserRegister userRegister);

	public UserRegister loginUser(UserRegister userRegister, HttpSession session);

	public UserRegister userProfile();

	public FeedbackBo feedback(FeedbackBo feedback);

}

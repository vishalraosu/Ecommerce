package com.softvision.ecommerce.user.service;

import java.util.List;

import com.softvision.ecommerce.user.model.FeedbackBo;
import com.softvision.ecommerce.user.model.UserRegister;

public interface UserService {
	public UserRegister addPerson(UserRegister p);

	public UserRegister updatePerson(UserRegister p);

	public List<UserRegister> listUsers();

	public UserRegister getPersonByEmail(UserRegister userRegister);

	public UserRegister getUserById(UserRegister userRegister);

	public FeedbackBo addFeedback(FeedbackBo feedbackBo);
}

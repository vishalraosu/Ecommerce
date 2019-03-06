package com.softvision.ecommerce.user.dao;

import java.util.List;

import com.softvision.ecommerce.user.model.FeedbackBo;
import com.softvision.ecommerce.user.model.UserRegister;

public interface UserDAO {

	public List<UserRegister> listUsers();

	public UserRegister addPerson(UserRegister p);

	public UserRegister updatePerson(UserRegister p);

	public UserRegister getDetails(UserRegister userRegister);

	public UserRegister getUserById(UserRegister userRegister);

	public FeedbackBo saveFeedback(FeedbackBo feedbackBo);

}
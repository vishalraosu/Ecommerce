package com.softvision.ecommerce.user.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softvision.ecommerce.user.dao.UserDAOImpl;
import com.softvision.ecommerce.user.model.FeedbackBo;
import com.softvision.ecommerce.user.model.UserRegister;

@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDAOImpl userdao;

	public UserDAOImpl getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAOImpl userdao) {
		this.userdao = userdao;
	}

	@Override
	@Transactional
	public UserRegister addPerson(UserRegister p) {
		LOGGER.info("Calling UserServiceImpl :: addPerson()");
		return this.userdao.addPerson(p);
	}

	@Override
	@Transactional
	public UserRegister updatePerson(UserRegister p) {
		LOGGER.info("Calling UserServiceImpl :: updatePerson()");
		return this.userdao.updatePerson(p);
	}

	@Override
	@Transactional
	public List<UserRegister> listUsers() {
		return this.userdao.listUsers();
	}

	@Override
	@Transactional
	public UserRegister getPersonByEmail(UserRegister userRegister) {
		LOGGER.info("Calling UserServiceImpl :: getPersonByEmail()");
		return this.userdao.getDetails(userRegister);
	}

	@Override
	@Transactional
	public UserRegister getUserById(UserRegister userRegister) {
		LOGGER.info("Calling UserServiceImpl :: getUserById()");
		return this.userdao.getUserById(userRegister);
	}

	@Override
	@Transactional
	public FeedbackBo addFeedback(FeedbackBo feedbackBo) {
		LOGGER.info("Calling UserServiceImpl :: addFeedback()");
		return this.userdao.saveFeedback(feedbackBo);
	}
}

package com.softvision.ecommerce.user.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softvision.ecommerce.user.model.Address;
import com.softvision.ecommerce.user.model.FeedbackBo;
import com.softvision.ecommerce.user.model.UserData;
import com.softvision.ecommerce.user.model.UserRegister;

@Repository("userdao")
public class UserDAOImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	UserRegister userRegister = null;

	@SuppressWarnings("unchecked")
	public List<UserRegister> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		LOGGER.info("Calling UserDAOImpl::listUsers()");
		List<UserRegister> userList = session.createQuery("from user").list();
		LOGGER.info("Called UserDAOImpl::listUsers(), ListUsers {}" + userList);
		for (UserRegister p : userList) {
			LOGGER.info("User List::" + p);
		}
		return userList;
	}

	public UserRegister addPerson(UserRegister p) {
		Session session = this.sessionFactory.getCurrentSession();
		LOGGER.info("Calling UserDAOImpl::addPerson()");
		Address address = new Address(p.getStreet(), p.getCity(), p.getState(), p.getZipcode());
		UserData userData = new UserData(p.getFirstName(), p.getLastName(), p.getEmailId(), p.getGender(),
				p.getContactNumber(), p.getPassword(), address);
		LOGGER.info("Called UserDAOImpl:addPerson" + userData + address);
		session.persist(userData);
		LOGGER.info("Both successfully saved");
		session.persist(p);
		session.save(p);
		LOGGER.info("User Details saved successfully, Person Details=" + p);
		return p;
	}

	public UserRegister updatePerson(UserRegister p) {
		LOGGER.info("Calling UserDAOImpl::updatePerson()");
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		LOGGER.info("Person updated successfully, Person Details=" + p);
		return p;

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public UserRegister getDetails(UserRegister userRegister) {

		UserRegister userData = null;
		try {
			LOGGER.info("Calling UserDAOImpl::getDetails()");
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UserRegister.class);
			criteria.add(Restrictions.eq("emailId", userRegister.getEmailId()));
			criteria.add(Restrictions.eq("password", userRegister.getPassword()));
			List<UserRegister> userList = criteria.list();
			session.close();
			if (userList != null && !userList.isEmpty()) {
				LOGGER.info("User data from DB:" + userList.get(0));
				LOGGER.info("User data firstname:" + userList.get(0).getFirstName());
				return userList.get(0);
			} else {
				LOGGER.info("User details not found in db");
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("login validation not successfull");
			return userData;
		}
	}

	public UserRegister getUserById(UserRegister userRegister) {
		Session session = this.sessionFactory.getCurrentSession();

		LOGGER.info("Calling UserDAOImpl::getUserById()");

		Address address = new Address(userRegister.getStreet(), userRegister.getCity(), userRegister.getState(),
				userRegister.getZipcode());
		UserData userData = new UserData(userRegister.getFirstName(), userRegister.getLastName(),
				userRegister.getEmailId(), userRegister.getGender(), userRegister.getContactNumber(),
				userRegister.getPassword(), address);

		Integer id = userRegister.getId();
		userData.setUserId(id.intValue());
		session.merge(userData);
		session.merge(userRegister);
		LOGGER.info("Called UserDAOImpl:: getUserById()");
		return userRegister;
	}

	public FeedbackBo saveFeedback(FeedbackBo feedbackBo) {
		LOGGER.info("Calling UserDAOImpl::saveFeedback()");
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(feedbackBo);
		LOGGER.info("Calling UserDAOImpl::saveFeedback(), FeebbackBO" + feedbackBo);
		return feedbackBo;
	}
}
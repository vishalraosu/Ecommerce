package com.softvision.ecommerce.util;

import static com.softvision.ecommerce.constant.Constant.EDIT_USER_URL;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.softvision.ecommerce.model.FeedbackBo;
import com.softvision.ecommerce.model.UserRegister;

@SuppressWarnings("unused")
@Component
public class RestClientUtil {

	private RestTemplate restTemplate = new RestTemplate();

	public <T> T getForObject(String url, Class<T> responseType) {
		return restTemplate.getForObject(url, responseType);
	}

	public <T> T getForObject(String url, Class<T> responseType, Map<String, Integer> uriVariables) {
		return restTemplate.getForObject(url, responseType, uriVariables);
	}

	public <T> T getForObject(String url, Class<T> responseType, String uriVariables) {
		return restTemplate.getForObject(url, responseType, uriVariables);
	}

	public UserRegister postForObject(String userLoginUrl, UserRegister userRegister, Class<UserRegister> class1,
			Map<String, String> editparams) {
		return restTemplate.postForObject(userLoginUrl, userRegister, class1, editparams);
	}

	public UserRegister postForObject(String signUpUrl, UserRegister userRegister, Class<UserRegister> class1) {
		return restTemplate.postForObject(signUpUrl, userRegister, class1);
	}

	public FeedbackBo postForObject(String feedbackUrl, FeedbackBo feedbackBo, Class<FeedbackBo> classFeedback) {

		return restTemplate.postForObject(feedbackUrl, feedbackBo, classFeedback);
	}

	public void put(String editUserUrl, UserRegister userRegister, Map<String, Integer> editparams) {

		restTemplate.put(editUserUrl, userRegister, editparams);
	}

}

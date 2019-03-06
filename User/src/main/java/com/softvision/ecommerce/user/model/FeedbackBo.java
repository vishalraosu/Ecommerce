package com.softvision.ecommerce.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Data
@Setter
@Getter
@Entity
@Table(name = "feedback")
public class FeedbackBo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "message")
	private String message;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "FeedbackBo [ emailId=" + emailId + ", message=" + message + "]";
	}
	/*
	 * public static void main(String[] args) throws JsonProcessingException {
	 * ObjectMapper feedback=new ObjectMapper();
	 * 
	 * FeedbackBo bo = new FeedbackBo();
	 * 
	 * bo.setEmailId("fdfd"); bo.setMessage("msg");
	 * System.out.println(feedback.writeValueAsString(bo)); }
	 */
}

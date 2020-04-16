package com.mica.media.tech.foodie.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageResonseModel{


	//{"ve":{"flag":"1","message":"success",
	// "user_id":"1","user_name":"Vaibhav",
	// "user_email":"badoleakash@gmail.com",
	// "user_contact":"9595095220",
	// "user_address":"Pratap Nagar Nagpur",
	// "registration_date":"2018-04-04",
	// "user_password":"123456"}}

	@SerializedName("user_email")
	@Expose
	private String userEmail;
	@SerializedName("user_password")
	@Expose
	private String userPassword;
	@SerializedName("flag")
	@Expose
	private String flag;
	@SerializedName("registration_date")
	@Expose
	private String registrationDate;
	@SerializedName("user_id")
	@Expose
	private String userId;
	@SerializedName("user_name")
	@Expose
	private String userName;
	@SerializedName("user_address")
	@Expose
	private String userAddress;
	@SerializedName("user_contact")
	@Expose
	private String userContact;
	@SerializedName("message")
	@Expose
	private String message;

	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getUserPassword(){
		return userPassword;
	}

	public void setFlag(String flag){
		this.flag = flag;
	}

	public String getFlag(){
		return flag;
	}

	public void setRegistrationDate(String registrationDate){
		this.registrationDate = registrationDate;
	}

	public String getRegistrationDate(){
		return registrationDate;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserAddress(String userAddress){
		this.userAddress = userAddress;
	}

	public String getUserAddress(){
		return userAddress;
	}

	public void setUserContact(String userContact){
		this.userContact = userContact;
	}

	public String getUserContact(){
		return userContact;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"MessageResonseModel{" + 
			"user_email = '" + userEmail + '\'' + 
			",user_password = '" + userPassword + '\'' + 
			",flag = '" + flag + '\'' + 
			",registration_date = '" + registrationDate + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_name = '" + userName + '\'' + 
			",user_address = '" + userAddress + '\'' + 
			",user_contact = '" + userContact + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}

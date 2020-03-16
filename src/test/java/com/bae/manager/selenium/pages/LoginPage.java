package com.bae.manager.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id = "loginTitle")
	private WebElement loginTitle;
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	@FindBy(id = "registerButton")
	private WebElement registerButton;
	
	public String getLoginTitle() {
		return this.loginTitle.getText();
	}
	
	public void loginDetails(String user, String pass) {
		username.sendKeys(user); 
		password.sendKeys(pass);
	}
	
	public void submit() {
		this.loginButton.click();
	}
	
	public void registerButton() {
		this.registerButton.click();
	}
}

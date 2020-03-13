package com.bae.manager.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id = "loginTitle")
	private WebElement loginTitle;
	
	@FindBy(xpath = "/html/body/div/div[2]/form/input[1]")
	private WebElement username;
	
	@FindBy(xpath = "/html/body/div/div[2]/form/input[2]")
	private WebElement password;
	
	@FindBy(xpath = "/html/body/div/div[2]/form/button")
	private WebElement loginButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/p/button")
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

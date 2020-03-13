package com.bae.manager.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
	
	@FindBy(xpath = "/html/body/div/div[2]/form/input[1]")
	private WebElement username;
	
	@FindBy(xpath = "/html/body/div/div[2]/form/input[2]")
	private WebElement password;
	
	@FindBy(xpath = "/html/body/div/div[2]/form/input[3]")
	private WebElement password2;
	
	@FindBy(xpath = "/html/body/div/div[2]/form/button")
	private WebElement signupButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/button")
	private WebElement loginButton;
	
	public void registerDetails(String user, String pass, String pass2) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pass);
		password2.sendKeys(pass2);
	}
	
	public void submit() {
		this.signupButton.click();
	}
	
	public void loginButtonClick() {
		this.loginButton.click();
	}
}

package com.bae.manager.selenium.pages.functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bae.manager.selenium.constants.Constants;
import com.bae.manager.selenium.pages.HomePage;
import com.bae.manager.selenium.pages.LoginPage;
import com.bae.manager.selenium.pages.RegisterPage;

public class RegisterLoginFunction {

	private final int port = 3000;

	private WebDriver driver;

	private LoginPage loginPage;

	private RegisterPage registerPage;

	private String username = "JONNN";
	private String password = "jonnn";

	private String location;

	public void registerLogin() throws InterruptedException {

		this.loginPage = PageFactory.initElements(this.driver, LoginPage.class);
		this.registerPage = PageFactory.initElements(this.driver, RegisterPage.class);
		this.location = "http://" + Constants.HOST + this.port;
		// Makes user
		this.driver.get(this.location);
		Thread.sleep(1000);
		this.loginPage.registerButton();
		Thread.sleep(1000);
		this.registerPage.registerDetails(this.username, this.password, this.password);
		Thread.sleep(1000);
		this.registerPage.submit();
		Thread.sleep(1000);
		// Logs in user
		this.loginPage.loginDetails(this.username, this.password);
		Thread.sleep(1000);
		this.loginPage.submit();
	}

}

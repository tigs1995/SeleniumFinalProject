package com.bae.manager.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bae.manager.selenium.constants.Constants;
import com.bae.manager.selenium.pages.LoginPage;
import com.bae.manager.selenium.pages.HomePage;
import com.bae.manager.selenium.pages.RegisterPage;

public class HomePageTest {

	private final int port = 3000;

	private WebDriver driver;

	private LoginPage loginPage;

	private HomePage homePage;

	private RegisterPage registerPage;

	private String username = "JONNN";
	private String password = "jonnn";

	private WebDriverWait wait;

	private String location;

	@Before
	public void startup() throws Exception {

		System.setProperty(Constants.PROPERTY, Constants.PATH);
		ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		this.driver.manage().window().setSize(new Dimension(1600, 700));
		this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		this.loginPage = PageFactory.initElements(this.driver, LoginPage.class);
		this.registerPage = PageFactory.initElements(this.driver, RegisterPage.class);
		this.homePage = PageFactory.initElements(this.driver, HomePage.class);
		this.location = "http://" + Constants.HOST + this.port;
		this.wait = new WebDriverWait(this.driver, 10L);
		// Makes user
		this.driver.get(this.location);
		this.loginPage.registerButton();
		this.registerPage.registerDetails(this.username, this.password, this.password);
		Thread.sleep(1000);
		this.registerPage.submit();
		Thread.sleep(1000);
		this.registerPage.loginButtonClick();
		// Logs in user
		this.loginPage.loginDetails(this.username, this.password);
		Thread.sleep(1000);
		this.loginPage.submit();
	}

	@After
	public void teardown() throws Exception {
		this.driver.close();
	}

	@Test
	public void clickCitizen() throws InterruptedException {
		this.homePage.clickCitizen();
		Thread.sleep(1000);
		assertEquals(this.location + Constants.CITIZEN_SEARCH, driver.getCurrentUrl());
	}
	
	@Test
	public void clickVehicle() throws InterruptedException {
		this.homePage.clickVehicle();
		Thread.sleep(1000);
		assertEquals(this.location + Constants.VEHICLE_SEARCH, driver.getCurrentUrl());
	}
	
	@Test
	public void clickLocation() throws InterruptedException {
		this.homePage.clickLocation();
		Thread.sleep(1000);
		assertEquals(this.location + Constants.LOCATION_SEARCH, driver.getCurrentUrl());
	}

}
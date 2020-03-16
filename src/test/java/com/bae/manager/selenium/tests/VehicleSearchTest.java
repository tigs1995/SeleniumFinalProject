package com.bae.manager.selenium.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.bae.manager.selenium.constants.Constants;
import com.bae.manager.selenium.pages.CitizenSearchPage;
import com.bae.manager.selenium.pages.HomePage;
import com.bae.manager.selenium.pages.LoginPage;
import com.bae.manager.selenium.pages.RegisterPage;
import com.bae.manager.selenium.pages.VehicleSearchPage;

public class VehicleSearchTest {

	private final int port = 3000;
	private WebDriver driver;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private HomePage homePage;
	private CitizenSearchPage citizenSearchPage;
	private String location;
	private VehicleSearchPage vehiclePage;

	private String username = "JONNN";
	private String password = "jonnn";
	private String vehicleReg = "JU10";

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
		this.citizenSearchPage = PageFactory.initElements(this.driver, CitizenSearchPage.class);
		this.vehiclePage = PageFactory.initElements(this.driver, VehicleSearchPage.class);
		this.location = "http://" + Constants.HOST + this.port;
		// Makes user
		this.driver.get(this.location);
		this.loginPage.registerButton();
		this.registerPage.registerDetails(this.username, this.password, this.password);
		this.registerPage.submit();
		Thread.sleep(1000);
		this.driver.get(this.location);
		// Logs in user
		this.loginPage.loginDetails(this.username, this.password);
		this.loginPage.submit();
	}

	@After
	public void teardown() throws Exception {
		this.driver.close();
	}
	
	@Test
	public void searchVehicle() throws InterruptedException {
		Thread.sleep(1000);
		this.homePage.clickVehicle();
		Thread.sleep(1000);
		this.vehiclePage.searchDetails(this.vehicleReg);
		Thread.sleep(1000);
		this.vehiclePage.submitSearch();
		
	//	assertEquals("JU10 ECY", this.vehiclePage.regSearchFirstResult.getText());
	//	assertEquals("JU10 JSG", this.vehiclePage.regSearchSecondResult.getText());
		
		this.vehiclePage.goToReg();
		Thread.sleep(500);
		assertEquals(this.location + "/CitizenVehicles/9199472966", this.driver.getCurrentUrl());
		
	}
}

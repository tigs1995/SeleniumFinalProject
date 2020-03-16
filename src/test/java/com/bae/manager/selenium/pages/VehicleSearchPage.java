package com.bae.manager.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleSearchPage {
	
	@FindBy(xpath="/html/body/div/div[2]/div/form/input")
	private WebElement vehicleSearchField;
	
	@FindBy(id="vehicleSubmitButton")
	private WebElement vehicleSubmitButton;
	
	@FindBy(xpath="/html/body/div/div[2]/div[1]/div/p")
	public WebElement regSearchFirstResult;
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div/p")
	public WebElement regSearchSecondResult;
	
	@FindBy(xpath="/html/body/div/div[2]/div[1]/div/button")
	private WebElement goToSpecificRegButton;
	

	public void searchDetails(String numberPlate) throws InterruptedException {
		vehicleSearchField.sendKeys(numberPlate);
	}
	public void submitSearch() {
		this.vehicleSubmitButton.click();
	}
	
	public void goToReg() {
		this.goToSpecificRegButton.click();
	}
}

package com.bae.manager.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitizenSearchPage {
	
	@FindBy(xpath = "/html/body/div/div[2]/div/form/input[1]")
	private WebElement fornames;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/form/input[2]")
	private WebElement surname;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/form/button")
	private WebElement searchButton;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div/p")
	public WebElement personCardBobCampbell;
	
	@FindBy(xpath= "/html/body/div/div[2]/div/div/button")
	private WebElement personSubmitButton;
	
	@FindBy(id="citizenGoToVehicleButton")
	private WebElement vehicleButton;
	
	@FindBy(id="citizenGoToFinanceButton")
	private WebElement financeButton;
	
	@FindBy(id="citizenGoToWhereaboutsButton")
	private WebElement whereaboutButton;
	
	@FindBy(id="citizenGoToAssociatesButton")
	private WebElement associateButton;
	
	
	public void searchDetails(String fore, String sur) throws InterruptedException {
		fornames.sendKeys(fore);
		surname.sendKeys(sur);
	}
	public void clickSearch() {
		this.searchButton.click();
	}
	public void goToVehicle() {
		this.vehicleButton.click();
	}
	
	public void goToAssociate() {
		this.associateButton.click();
	}
	
	public void goToFinance() {
		this.financeButton.click();
	}
	
	public void goToWhereabouts() {
		this.whereaboutButton.click();
	}
	
	public void clickGoToPerson() {
		this.personSubmitButton.click();
	}

}

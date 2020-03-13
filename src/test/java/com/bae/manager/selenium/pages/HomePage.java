package com.bae.manager.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "/html/body/div/div[2]/button[1]")
	private WebElement citizenButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/button[2]")
	private WebElement vehicleButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/button[3]")
	private WebElement locationButton;

	public void clickCitizen() {
		this.citizenButton.click();
	}
	
	public void clickVehicle() {
		this.vehicleButton.click();
	}
	
	public void clickLocation() {
		this.locationButton.click();
	}

}

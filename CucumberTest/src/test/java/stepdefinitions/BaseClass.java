package stepdefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageobjects.AddCustomerPage;
import pageobjects.LoginPage1;
import pageobjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage1 lp;
	
	public AddCustomerPage addCust;
	
	public SearchCustomerPage searchCust;
	
	//Created for generating random String for Unique email
	public static String randomeString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

}

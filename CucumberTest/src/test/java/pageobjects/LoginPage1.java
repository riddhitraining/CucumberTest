package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	
	WebDriver driver;
	
	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="Email")
	WebElement username;
	
	@FindBy (id="Password")
	WebElement password;
	
	@FindBy (xpath = "//button[contains(text(),'Log in')]")
	WebElement Loginbtn;
	
	@FindBy (linkText = "Logout")
	WebElement Logout;
	
	
	public void enterusername(String user) {
		username.clear();
		username.sendKeys(user);
	}
	public void enterpassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	public void clickonLoginbtn() {
		Loginbtn.click();
	}
	public void clickonLogout() {
		Logout.click(); 
	}
	
	
	

}

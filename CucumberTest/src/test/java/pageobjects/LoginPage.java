package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By uName = By.id("email");
	By uPass = By.id("passwd");
	By loginBtn = By.id("SubmitLogin");

	public void enterusername(String user) {
		driver.findElement(uName).sendKeys(user);
	}
	public void enterpassword(String pass) {
		driver.findElement(uPass).sendKeys(pass);
	}
	public void clickloginbutton() {
		driver.findElement(loginBtn).click();
	}
	

	/*WebDriver driver;

	@FindBy(id="email")
	WebElement uName;
	
	@FindBy(id="passwd")
	WebElement uPass;
	
	@FindBy(id="SubmitLogin")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterusername(String user) {
		uName.sendKeys(user);
	}
	public void enterpassword(String pass) {
		uPass.sendKeys(pass);
	}
	public void clickloginbutton() {
		loginBtn.click();
	}*/

}
package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;

public class DataDrivenSteps{
	/*@Given("user is on login page")
	public void user_is_on_login_page() {
	   
	}

	@Given("^(.*) and (.*) are entered by user$")
	public void username_and_password_are_entered_by_user(String username, String password) {
		System.out.println("-----> "+ username);
		System.out.println("-----> " + password);
	 
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	   
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {
	}*/
	
	WebDriver driver;
	LoginPage login;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\QA_Testing\\Driver\\chromedriver.exe");
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("-remote-allow-origin=*");
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://demo.guru99.com/test/login.html#");
	}

	@Given("^(.*) and (.*) are entered by user$")
	public void riddhi_and_testing_are_entered_by_user(String username, String password) {
		login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		login.clickloginbutton();
	   
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {
	   driver.close();
	   driver.quit();
	}
}
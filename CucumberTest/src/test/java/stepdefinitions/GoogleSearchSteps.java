package stepdefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {

	WebDriver driver = null;

	@Given("Browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "C:\\QA_Testing\\Driver\\chromedriver.exe");
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("-remote-allow-origin=*");
	  
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("User is on google search page")
	public void user_is_on_google_search_page() {
		driver.navigate().to("https://www.google.ca/");
	}

	@When("User enters a test in serach box")
	public void user_enters_a_test_in_serach_box() {
		driver.findElement(By.id("APjFqb")).sendKeys("Software Automation Testing");
	}

	@When("User hits enter")
	public void user_hits_enter() {
		driver.findElement(By.name("btnK")).click();
	}

	@Then("User is navigated to serach results")
	public void user_is_navigated_to_serach_results() {
		driver.getPageSource().contains("Software Automation Testing");
		driver.close();
		driver.quit();
	}

}
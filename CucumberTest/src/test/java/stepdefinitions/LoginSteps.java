package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.AddCustomerPage;
import pageobjects.LoginPage1;
import pageobjects.SearchCustomerPage;

public class LoginSteps extends BaseClass {

	@Before
	public void setup() {
		System.out.println("setup method executed");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		lp = new LoginPage1(driver);
	}

	@When("User open URL {string}")
	public void user_open_URL(String url) {
		driver.get(url);
	}

	@When("User enter email {string} and password {string}")
	public void user_enter_email_and_password(String email, String password) {
		lp.enterusername(email);
		lp.enterpassword(password);
	}

	@When("User click on login")
	public void user_click_on_login() {
		lp.clickonLoginbtn();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			//driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws Exception {
		lp.clickonLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		//driver.close();
	}

	// Customers feature step definitions

	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on Customers Menu")
	public void user_click_on_Customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCutomerMenu();
	}

	@When("click on Customers menu Item")
	public void click_on_Customers_menu_Item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCustomerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnAddNew();
	}

	@Then("User can view Add new Customer page")
	public void user_can_view_Add_new_Customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter Cutomer info")
	public void user_enter_Cutomer_info() throws InterruptedException {
		String email = randomeString() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer roles
		// Add the customer to 'Guests' and 'Registered' Customer roles
		// addCust.setCustomerRoles("Guests");
		Thread.sleep(300);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Ravi");
		addCust.setLastName("Sanon");
		addCust.setDob("10/10/1995");
		addCust.setCompanyName("Bayer");
		addCust.setAdminComment("This is for testing ...");
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickonSave();
		Thread.sleep(2000);
	}

	/*
	 * @Then("User can view confirmation message {string}") public void
	 * user_can_view_confirmation_message(String msg) {
	 * 
	 * Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
	 * .contains("The new cutomer has been added successfully.")); }
	 */

	// steps for searching a customer using Email ID...
	@When("Enter Customer EMail")
	public void enter_Customer_EMail() {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the search table")
	public void user_should_found_Email_in_the_search_table() {
		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		// Assert.assertEquals(true, status);
		System.out.println(status);
	}

	// steps for searching customer by using first and last name
	@When("Enter Customer FirstName")
	public void enter_Customer_FirstName() {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}

	@When("Enter Customer LastName")
	public void enter_Customer_LastName() {
		searchCust.setLastName("Terces");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_Name_in_the_search_table() {
		boolean status = searchCust.searchCustomerByName("Victoria Terces");
		// Assert.assertEquals(true, status);
		System.out.println(status);
	}

	@After
	public void down(Scenario sc) {
		System.out.println("Down method executed.");

		if (sc.isFailed()) {
			TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
			File scrfile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrfile, new File("C:\\Program Files\\Eclips\\eclipse-workspace\\CucumberTest\\ScreenShot\\failedScreenshot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By lnkCutomers_menu = By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]");
	By lnkCutomer_menuitems= By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");
	
	By btnAddnew= By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]");
	
	By txtEmail= By.xpath("//input[@id='Email']");
	By txtPassword= By.xpath("//input[@id='Password']");
	
	By txtCutomerRoles= By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
	
	/*By lstitemAdministrators= By.xpath("//span[contains(text(),'Administrators')]");
	By lstitemForumModerators= By.xpath("//span[contains(text(),'Forum Moderators')]");
	By lstitemRegistered= By.xpath("//span[contains(text(),'Registered')]");
	By lstitemGuests= By.xpath("//span[contains(text(),'Guests')]");
	By lstitemVendors= By.xpath("//span[contains(text(),'Vendors')]");*/
	
	By drpmgrOfVendor = By.xpath("//select[@id='VendorId']");
	By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
	By rdFemaleGender = By.xpath("//input[@id='Gender_Female']");
	
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName = By.xpath("//input[@id='Company']");
	
	By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave = By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");
	
	//Actions method
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnCutomerMenu() {
		driver.findElement(lnkCutomers_menu).click();
	}
	public void clickOnCustomerMenuItem() {
		driver.findElement(lnkCutomer_menuitems).click();
	}
	public void clickOnAddNew() {
		driver.findElement(btnAddnew).click();
	}
	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		if(!role.equals("Vendors"))
		{
			driver.findElement(By.xpath("//body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]"));
		}
		driver.findElement(txtCutomerRoles).click();
		
		/*WebElement listitem = null;
		
		Thread.sleep(3000);
		
		if(role.equals("Administrators"))
		{
			listitem= driver.findElement(lstitemAdministrators);
		}
		if(role.equals("Guest"))
		{
			listitem= driver.findElement(lstitemGuests);
		}
		if(role.equals("Registered"))
		{
			listitem= driver.findElement(lstitemRegistered);
		}
		if(role.equals("Vendors"))
		{
			listitem= driver.findElement(lstitemVendors);
		}
		if(role.equals("Forum Moderators"))
		{
			listitem= driver.findElement(lstitemForumModerators);
		}
		listitem.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", listitem);*/
	}
		public void setManagerOfVendor(String value)
		{
			Select drp= new Select(driver.findElement(drpmgrOfVendor));
			drp.selectByVisibleText(value);
		}
		
		public void setGender(String gender) {
			
			if(gender.equals("Male"))
			{
				driver.findElement(rdMaleGender).click();
			}
			else if (gender.equals("Female"))
			{
				driver.findElement(rdFemaleGender).click();
			}else
			{
				driver.findElement(rdMaleGender);
			}
			
		}
		public void setFirstName (String fname)
		{
			driver.findElement(txtFirstName).sendKeys(fname);
		}
		public void setLastName (String lname)
		{
			driver.findElement(txtLastName).sendKeys(lname);
		}
		public void setDob(String dob)
		{
			driver.findElement(txtDob).sendKeys(dob);
		}
		public void setCompanyName(String comname)
		{
			driver.findElement(txtCompanyName).sendKeys(comname);
		}
		public void setAdminComment(String comment)
		{
			driver.findElement(txtAdminComment).sendKeys(comment);
		}
		public void clickonSave() {
			driver.findElement(btnSave).click();
		}
	}

package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver driver;
	
	WaitHelper waithelper;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);
	}
	@FindBy(id="SearchEmail")
	WebElement txtEmail;
	
	@FindBy(id="SearchFirstName")
	WebElement txtFirstName;
	
	@FindBy(id="SearchLastName")
	WebElement txtLastName;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement btnSearch;
	
	@FindBy(xpath="//div[@id='customers-grid_wrapper']")
	WebElement table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		waithelper.WaitForElement(txtEmail, Duration.ofSeconds(30));
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setFirstName(String fname) {
		waithelper.WaitForElement(txtFirstName, Duration.ofSeconds(30));
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		waithelper.WaitForElement(txtLastName, Duration.ofSeconds(30));
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	public void clickSearch() {
		btnSearch.click();
		waithelper.WaitForElement(txtFirstName, Duration.ofSeconds(30));
	}
	public int getNoOfRows() {
		return(tableRows.size());
	}
	public int getNoOfColumns() {
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		
		for(int i=1; i<=getNoOfRows(); i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
		    
			System.out.println(emailid);
			
			if(emailid.equals("email"))
			{
				flag=true;
			}
		}return flag;
		
	}
	public boolean searchCustomerByName(String Name)
	{
		boolean flag=false;
		
		for(int i=1; i<=getNoOfRows(); i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			String names[]=name.split(" "); //Separating first and last name
			
			if(names[0].equals("Victoria")&& names[1].equals("Terces"))
			{
				flag=true;
			}
		}return flag;		
	}
	
	
}

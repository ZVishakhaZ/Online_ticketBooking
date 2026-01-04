package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import base.BasePage;
import utils.DriverFactory;

public class OrangeLoginPage extends BasePage{
	//Page Factory element
	@FindBy(name="username")
	WebElement edtUsername;
	
	@FindBy(name="password")
	WebElement edtPassword;
	
	
	
//	@FindBy(xpath="//button[@type='submit']")
//	WebElement btnLogin;
	
	@FindBy(xpath="//h6[(text()='Dashboard')]")
	WebElement lblDashboard;
	
	//h6[(text()='Dashboard')]
	//constructor
	public OrangeLoginPage() {
		super();
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	//page specific methods
	
	public boolean validateLoginPageTitle() {
		if(getPageTitle().trim().contains("Orange")) {
			return true;
		}
		return false;
		
	}
	public boolean enterUsername(String username) {
		return type(edtUsername,username);
	}
	
	public boolean enterPassword(String password) {
		return type(edtPassword,password);
	}
	
	public void clickLogin() {
		WebElement btnRelLogin= DriverFactory.getDriver().findElement(RelativeLocator.with(By.tagName("button")).below(edtPassword));
		btnRelLogin.click();
		//click(btnLogin);
	}
	
	public boolean DashboardHeaderExist() {
		if(getText(lblDashboard).equalsIgnoreCase("Dashboard")) {
			return true;
		}
		return false;
	}
}

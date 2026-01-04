package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.OrangeLoginPage;
import utils.Log;

public class OrangeLoginSteps {
	
	private OrangeLoginPage oLogin;
	

	@Given("user is on login page")
	public void user_is_on_login_page() {
	    oLogin= new OrangeLoginPage();
	    Assert.assertTrue(oLogin.validateLoginPageTitle(),"OragneHrm login page is not launched");
	    Log.info("Oange HRM Login page has been launched successfully");
	}
	@When("user enters username {string}")
	public void user_enters_username(String string) {
	   oLogin.enterUsername(string);
	   Log.info("Username enteres as: "+ string);
	}
	@When("user enters password = {string}")
	public void user_enters_password(String string) {
	    oLogin.enterPassword(string);
	    Log.info("Password entered as: "+ string);
	}
	@When("user clcks on Login button")
	public void user_clcks_on_login_button() {
	    oLogin.clickLogin();
	    Log.info("Clicked on Login button");
	}
	@Then("user should be able to see the home page")
	public void user_should_be_able_to_see_the_home_page() {
	    Assert.assertTrue(oLogin.DashboardHeaderExist(),"Dashboard header does not exist");
	    Log.info("User is on Homepage");
	}
	
	@Then("user should not be able to see the home page")
	public void user_should_not_be_able_to_see_the_home_page() {
	    Assert.assertFalse(oLogin.DashboardHeaderExist(),"Dashboard header exist");
	    Log.info("User is not on Homepage");
	}



}

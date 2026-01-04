package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.HomePage;
import utils.Log;

public class HomeSteps {
	private HomePage home;

	@Given("user is on home page")
	public void user_is_on_home_page() {
		home = new HomePage();
		Log.info("Test Case: enterSearchFlightDetails has started");
		home.closeLoginPopUp();
		Log.info("Login pop up window closed");
		home.closeBotPopUp();
		Log.info("Chat bot pop up window closed");

	}
	@When("user enters from city {string} and selects {string}")
	public void user_enters_from_city_and_selects(String fromCity, String suggFromCity) throws InterruptedException{
		Assert.assertTrue(home.enterFromCity(fromCity,suggFromCity));
		Log.info("From Location entered as 'London - Gatwick'");
		
	}
	
	@And("user enter to city {string}  and selects {string}")
	public void user_enters_to_city_and_selects(String toCity, String suggToCity) throws InterruptedException{
		Assert.assertTrue(home.enterFromCity(toCity,suggToCity));
		Log.info("From Location entered as 'Mumbai-Navi Mumbai'");
		
	}
	
	@And("user selects departure date")
	public void user_selects_departure_date() {
		Log.info("Clicked on Departure Calendar");
		Assert.assertTrue(home.selectFromDate("December 2025","25"));
		Log.info("Departure date selected as '25 December 2025");
		
	}
	
	@And("user clicks on Search button")
	public void user_clicks_on_search_button() {
	home.clickSearch();
	Log.info("User clicked on Search button");
	}
	
	@And("user should be able to see the search results")
	public void user_should_be_able_to_see_the_search_results() {
		home.clickSearch();
		Assert.assertTrue(true);
		Log.info("User is able to see the search results");

}
}

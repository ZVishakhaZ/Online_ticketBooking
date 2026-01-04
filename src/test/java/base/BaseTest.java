package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
	
	public String browser;
	public String url;
	
	@Before
	public void launchApp() {
		System.out.println("Launching Application");
		//WebDriverManager.chromedriver().setup();
		ConfigReader.loadProperties();
		browser = ConfigReader.get("browser");
		DriverFactory.initDriver(browser);
		DriverFactory.getDriver().manage().window().maximize();		
		url = ConfigReader.get("appUrl");
		DriverFactory.getDriver().get(url);
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			byte [] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
					.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(screenshot, "image/png" ,scenario.getName());
		}
			
		System.out.println("Closing Application");
		DriverFactory.quitDriver();
	}
	
}
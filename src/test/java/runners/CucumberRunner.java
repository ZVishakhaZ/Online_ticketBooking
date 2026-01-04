package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features ="src/test/resources/features/OrangeLogin.feature",
	glue= {"steps", "base"},
	tags="@smoke",
	plugin = {
			"pretty",
			"html:reports/cucumber.html",
			"json:reports/cucumber.json",
			"rerun:target/rerun.txt"
			
	},
	monochrome=true //format of report
)

public class CucumberRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}

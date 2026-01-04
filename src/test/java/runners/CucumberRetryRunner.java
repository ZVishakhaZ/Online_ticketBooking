package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features ="@target/rerun.txt",
	glue= {"steps", "base"},
	plugin = {
			"pretty",
			"html:reports/cucumber-retry-report.html"
			
	},
	monochrome=true //format of report
)

public class CucumberRetryRunner extends AbstractTestNGCucumberTests{

}

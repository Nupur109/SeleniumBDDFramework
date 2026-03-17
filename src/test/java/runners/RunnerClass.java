package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	
	@CucumberOptions(
			features = {"src/test/resources/features/products.feature"},
			glue = {"stepDefinitions"},
			plugin = {"pretty",
					"html:reports/cucumber-html-report"},
			monochrome = true,
			dryRun = false
			
)

	public class RunnerClass extends AbstractTestNGCucumberTests{
		
	}

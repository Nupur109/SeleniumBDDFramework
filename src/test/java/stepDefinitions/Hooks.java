package stepDefinitions;

import java.io.IOException;


import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Utility;

public class Hooks {

	@Before

	public void setUp(Scenario scenario) throws IOException {
		if(BaseClass.extent==null) {
			BaseClass.initializeExtentReport();
		}
		BaseClass.initialiseBrowser();
		BaseClass.test=BaseClass.extent.createTest(scenario.getName());
	}
	
	@After

	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
		//	String errorMessage = scenario.getError().getMessage();
			String screenshotPath = Utility.takeScreenshot(scenario.getName());
			BaseClass.test.addScreenCaptureFromPath(screenshotPath);
			BaseClass.test.fail("Test Failed! ");
		}
		else
		{
			BaseClass.test.pass("Test Passed!");

		}

		BaseClass.quiteDriver();
		BaseClass.flushReport();

	}
	
}
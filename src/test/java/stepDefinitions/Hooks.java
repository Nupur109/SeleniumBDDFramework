package stepDefinitions;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Utility;

public class Hooks {
//
//	@BeforeSuite
//	
//	public void setUpSuite() {
//		BaseClass.initializeExtentReport();
//
//	}
//	
	@Before

	public void setUp(Scenario scenario) throws IOException {
		if(BaseClass.extent==null) {
			BaseClass.initializeExtentReport();
		}
		BaseClass.initialiseBrowser();
		//BaseClass.initializeExtentReport();
		BaseClass.test=BaseClass.extent.createTest(scenario.getName());
	}
	
	@After

	public void tearDown(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			String screenshotPath = Utility.takeScreenshot(scenario.getName());
			BaseClass.test.addScreenCaptureFromPath(screenshotPath);
			BaseClass.test.fail("Test Failed!");
		}
		else
		{
			BaseClass.test.pass("Test Passed!");

		}

		BaseClass.quiteDriver();
		BaseClass.flushReport();

	}
	
//	@AfterSuite
//	
//	public void tearDownSuite() {
//		
//		
//	}

}
package utils;
import base.BaseClass;
import stepDefinitions.Hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utility {

	public static String  takeScreenshot(String testName) throws IOException {

		TakesScreenshot  ts=(TakesScreenshot) BaseClass.driver;
		File source   = ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"/screenshots/"+testName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}
	
	public static String getPageURL() {
		return BaseClass.driver.getCurrentUrl();
	}
	
		
	//for adding error in extent report. dont push this code
	public static void execute(Runnable step)
	{
		try {step.run();
		}catch(Throwable t) {
			BaseClass.test.fail(t);
			throw t;
		}
	}
	
//	Utility.execute(() ->{
//		cart.clickContinueShopping();}); write like this for the failed step to see error in extent report
}

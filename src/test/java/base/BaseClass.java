package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public  static ExtentReports extent;
	public static  ExtentTest  test;


	public static void initialiseBrowser() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");

		prop=new Properties();
		prop.load(fis);

		String browser=prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			//driver=new ChromeDriver();
			HashMap<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);		}

		else if  (browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));

	}
	
	
	public static void quiteDriver() {
		if (driver!=null) {
			driver.quit();
		}
	}
	
	public static void initializeExtentReport() {
		String timestamp= new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss").format(new Date());
		ExtentSparkReporter report=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/TestReport_"+ timestamp + ".html");
		report.config().setReportName("Automation test report");
		report.config().setDocumentTitle("Test Results");
		extent=new  ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Nupur");
		extent.setSystemInfo("Environment", "QA");
	
	}

 public  static void flushReport() {
	 if  (extent!=null)
	 {
		 extent.flush();
	 }
	 
 }
}

package Testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fbbaseclass {
	

	
	public static WebDriver driver =null;

	@BeforeSuite
	public void drivermanage() throws Exception 
	{

	
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		Thread.sleep(5000);
		
		
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("myfbreports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest loger = extent.createTest("Web Page URL");
		
		
		if(driver.getTitle().equals("Sign in to GitHub · GitHub"))
		{
			loger.log(Status.INFO, "Github Webpage Url");
			loger.log(Status.PASS, "Title verified - LOGIN success");
		}
		else
		{
			loger.log(Status.WARNING, "Github Webpage Url");
			loger.log(Status.FAIL, "Title Not verified - lOGIN Failed");
			
		}
		
		extent.flush();
		
	}
	
	


	@AfterSuite
	public void teardown()
	{
		
		Fbbaseclass.driver.quit();
	}
}

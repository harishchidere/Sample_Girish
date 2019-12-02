package reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Smapless {
	
	
	ExtentHtmlReporter report;
	public static ExtentReports extent;
	ExtentTest test;
	ChromeDriver driver;
	
	@Test
	public void testahs() {
		
		String a = sample();
		startReport(a);
		driver.quit();
		extent.flush();
	}
	
	
	public String sample() {
		
	
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://irctc.co.in");
			
			
			File pic = driver.getScreenshotAs(OutputType.FILE);
			String pic1 = driver.getScreenshotAs(OutputType.BASE64);
			File dest = new File(System.getProperty("user.dir")+"/reports/screenshots/snap.png");
			try {
				FileUtils.copyFile(pic, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pic1;
	}

	
	public void startReport(String path) {
		
		report = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/report1.html");
		
		extent = new ExtentReports();

		extent.attachReporter(report);
		  
		test = extent.createTest("TC001", "Sample");
	
		try {
			test.log(Status.FAIL, "Test", MediaEntityBuilder.createScreenCaptureFromBase64String(path).build());
		} catch (IOException e) {
	
		}
		
		
	}
	
	
}

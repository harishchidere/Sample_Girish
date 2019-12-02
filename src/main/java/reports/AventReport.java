package reports;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class AventReport {
	
	
	
	
	
	@Test
	public void sample() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://irctc.co.in");
		// Hi Git Hub
		
		File pic = driver.getScreenshotAs(OutputType.FILE);
		String pic1 = driver.getScreenshotAs(OutputType.BASE64);
		File dest = new File(System.getProperty("user.dir")+"/reports/screenshots/snap.png");
		try {
			FileUtils.copyFile(pic, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AventReport obj = new AventReport();
		
		String a = obj.base64(dest);
		
		
		ExtentHtmlReporter report = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/report.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		ExtentTest test = extent.createTest("TC001", "Sample");
		//test.log(Status.PASS, "Test"+test.addScreenCaptureFromBase64String(a));
		//test.addScreenCaptureFromBase64String(a);
		test.fail("Test").addScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/screenshots/snap.png");
		test.log(Status.FAIL, "Test",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/screenshots/snap.png").build());
		test.log(Status.FAIL, "Test", MediaEntityBuilder.createScreenCaptureFromBase64String(a).build());
		test.log(Status.FAIL, "Test"+test.addScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/screenshots/snap.png"));
		test.log(Status.FAIL, "Test"+test.addScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/screenshots/snap.png"));
		test.log(Status.FAIL, "Test"+test.addScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/screenshots/snap.png"));
		extent.flush();
		
		
		
		
	}
	
	
	public String base64(File pic) {
		  String Base64StringofScreenshot="";
	    byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(pic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Base64StringofScreenshot = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);
	    
	    return Base64StringofScreenshot;
	    
		}	
	

}

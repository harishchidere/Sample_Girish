package reports;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class String_p {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		try {
			driver.findElementByName("firstnam").sendKeys("Sowmya");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("There is no such element to enter firstname");
		}
		driver.findElementByName("lastname").sendKeys("T");
		driver.findElementByName("reg_email_confirmation__").sendKeys("Sowmya@gmail.com");
		driver.findElementByName("reg_passwd__").sendKeys("Sowmya");
		
	}
	
	
}

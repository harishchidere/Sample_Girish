package reports;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElementByXPath("//button[text()='✕']").click();
		
		driver.findElementByClassName("LM6RPg").sendKeys("mobiles", Keys.TAB);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> list = driver.findElementsByXPath("//li[@class='_1va75j']/div");
		
		System.out.println(list.size());
		for (WebElement webElement : list) {
		
			String a = webElement.getAttribute("data-tkid");
			System.out.println(a);
			String mobileName = a.substring(a.lastIndexOf("m"), a.length());
			System.out.println(mobileName);
		}
		
		
		
		
	}

}

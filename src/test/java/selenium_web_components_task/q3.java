package selenium_web_components_task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class q3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver cd = new ChromeDriver(options);
		cd.get("https://www.guvi.in/");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//sign up
		cd.findElement(By.partialLinkText("Sign up")).click();

		//full name
		cd.findElement(By.id("name")).sendKeys("abc");
		
		//email
		cd.findElement(By.id("email")).sendKeys("abc@gmail.com");
		
		//password
		cd.findElement(By.id("password")).sendKeys("abcdef@1");
		
		//mobile number
		cd.findElement(By.id("mobileNumber")).sendKeys("9876543210");
		
		//Click Sign Up button
		cd.findElement(By.linkText("Sign Up")).click();
		
		cd.navigate().back();
		
		
		//login
		cd.findElement(By.linkText("Login")).click();
		
		//email - Dummy data
		cd.findElement(By.id("email")).sendKeys("abc@gmail.com");
		
		//password - Dummy data
		cd.findElement(By.id("password")).sendKeys("abc@2222");
		
		//login button
		cd.findElement(By.linkText("Login")).click();
		
		Thread.sleep(5000);
		cd.findElement(By.xpath("//a[@class = \"logo\"]")).click();
		
		WebElement logo = cd.findElement(By.xpath("(//img[@loading = \"eager\"])[1]"));
		if(logo.isDisplayed()) {
			System.out.println("User in the home page");
		}
		
		cd.close();
		
		}
}
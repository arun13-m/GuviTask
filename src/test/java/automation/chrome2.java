package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chrome2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver cd = new ChromeDriver();
		
		cd.get("https://www.wikipedia.org/");
		
		//TimeOut
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//maximize
		cd.manage().window().maximize();
		
		
		//Search Bar
		cd.findElement(By.id("searchInput")).sendKeys("Artificial Intelligence",Keys.ENTER);
		
		cd.findElement(By.linkText("History")).click();	
		
		System.out.println(cd.getTitle());
		
		cd.close();
		
	
		
	}

}

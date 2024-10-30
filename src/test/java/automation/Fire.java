package automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Fire {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver fd = new FirefoxDriver();
		
		fd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		//maximize
		fd.manage().window().maximize();
		
		//pen google
		fd.get("https://www.google.co.in/");
		
		//URL
		System.out.println("Current URL: "+fd.getCurrentUrl());
		
		//reload
		fd.navigate().refresh();
		
		//close
		fd.close();

	}

}

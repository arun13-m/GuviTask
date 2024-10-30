package automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();
		
		cd.get("https://www.demoblaze.com/");
		
		//TimeOut
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Maximize
		cd.manage().window().maximize();
		
		//Checking Title:
		String value = "STORE";
		if(value.equals(cd.getTitle())) {
			System.out.println("Page landed on correct website");
		}
		else {
			System.out.println("Page not landed on correct website");
		}
		
		cd.close();

	}

}

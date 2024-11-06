package windows_frames_task;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver cd = new ChromeDriver();
		cd.get("https://the-internet.herokuapp.com/windows");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		cd.findElement(By.linkText("Click Here")).click();
		
		//Child window
		Set<String> windowHandles = cd.getWindowHandles();
		ArrayList<String> windows = new ArrayList<String>(windowHandles);
		WebDriver second = cd.switchTo().window(windows.get(1));
		System.out.println("Child Window Title: "+second.getTitle());
		cd.close();
		
		//parent window
		cd.switchTo().window(windows.get(0));
		System.out.println("Parent Window Title: "+cd.getTitle());
		
		cd.quit();
		
	}

}

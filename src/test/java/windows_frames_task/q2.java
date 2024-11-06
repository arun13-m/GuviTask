package windows_frames_task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver cd = new ChromeDriver();
		cd.get("http://the-internet.herokuapp.com/nested_frames");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//topFrame
		cd.switchTo().frame("frame-top");
		
		//left
		cd.switchTo().frame("frame-left");
		WebElement leftFrame = cd.findElement(By.cssSelector("body"));
		System.out.println("Current Frame: "+leftFrame.getText());
		cd.switchTo().parentFrame();
		
		//middle
		cd.switchTo().frame("frame-middle");
		WebElement middleFrame = cd.findElement(By.xpath("//div[@id='content']"));
		System.out.println("Current Frame: "+ middleFrame.getText());
		cd.switchTo().parentFrame();
		
		//right
		cd.switchTo().frame("frame-right");
		WebElement rightFrame = cd.findElement(By.cssSelector("body"));
		System.out.println("Current Frame: "+ rightFrame.getText());
		cd.switchTo().parentFrame();
		
		//default content
		cd.switchTo().defaultContent();
		
		cd.switchTo().frame("frame-bottom");
		WebElement bottomFrame = cd.findElement(By.cssSelector("body"));
		System.out.println("Current Frame: "+ bottomFrame.getText());
		cd.switchTo().defaultContent();
		cd.switchTo().frame("frame-top");
		
		//close
		cd.close();
	
	}

}
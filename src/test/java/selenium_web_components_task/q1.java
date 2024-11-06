package selenium_web_components_task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver cd = new ChromeDriver();
		cd.get("https://jqueryui.com/datepicker/");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch to frame
		cd.switchTo().frame(0);
		
		//clicking date box
		cd.findElement(By.className("hasDatepicker")).click();
		
		//click the month
		for(int i=0;i<1;i++) {
			cd.findElement(By.xpath("(//a[@data-event=\"click\"])[2]")).click();
		}
		
		//click the date
		cd.findElement(By.linkText("22")).click();
		
		//Selected Date
		WebElement SelectedDate = cd.findElement(By.className("hasDatepicker"));
		String date = SelectedDate.getAttribute("value");
		System.out.println("Selected Date: "+date);
		
		//close
		cd.close();
	}

}

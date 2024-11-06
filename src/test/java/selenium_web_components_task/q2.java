package selenium_web_components_task;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();
		cd.get("https://jqueryui.com/droppable/");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions a = new Actions(cd);
		cd.switchTo().frame(0);
		
		//source Element
		WebElement sourceElement = cd.findElement(By.id("draggable"));
		
		//target Element
		WebElement targetElement = cd.findElement(By.id("droppable"));
	
		//drag and drop
		a.dragAndDrop(sourceElement, targetElement).perform();
		
		//verifying with color
		String changedColor = "ui-widget-header ui-droppable ui-state-highlight";
		WebElement ColorValue = cd.findElement(By.xpath("//div[@class = \"ui-widget-header ui-droppable ui-state-highlight\"]"));
		String color = ColorValue.getAttribute("class");
		if(changedColor.equals(color)) {
			System.out.println("Source dragged to target and color is changed to yellow");
		}
		
		//verifying with Text
		String value = "Dropped!";
		String changeValue = cd.findElement(By.xpath("//div[@id = 'droppable']")).getText();
		if(value.equals(changeValue)) {
			System.out.println("Source Dragged to Target");
		}
		
		cd.close();
	}
}
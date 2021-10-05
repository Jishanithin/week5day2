package week5day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ServiceDelete extends ServiceParent{
	@Test
	public void deleteIncident() throws InterruptedException{
		
	
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		
WebElement frameThree = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frameThree);
	driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	driver.switchTo().defaultContent();
	
	WebElement frame3 = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frame3);
	driver.findElement(By.id("sysverb_delete_bottom")).click();
	driver.findElement(By.id("ok_button")).click();

}
}

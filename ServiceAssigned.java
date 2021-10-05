package week5day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ServiceAssigned extends ServiceParent {
	@Test
	public void assign() throws InterruptedException {

		driver.findElement(By.xpath("//div[text()='Open']")).click();

		WebElement frameThree = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frameThree);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']//span[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winList.get(1));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Software", Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();

		driver.switchTo().window(winList.get(0));
		driver.switchTo().defaultContent();

		WebElement frame3 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.id("sysverb_update_bottom")).click();

	}
}

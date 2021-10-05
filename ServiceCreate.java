package week5day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ServiceCreate extends ServiceParent{
	@Test(dataProvider="fetchData")
public void serviceNow(String shortdesc) throws IOException, InterruptedException {

		
		driver.findElement(By.xpath("//ul[@aria-label='Modules for Application: Incident']/li[6]//div//a/div/div"))
				.click();

		WebElement frame2 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("sysverb_new")).click();
		driver.switchTo().defaultContent();

		WebElement frame3 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winList.get(1));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(winList.get(0));
		driver.switchTo().defaultContent();

		WebElement frameThree = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frameThree);

		driver.findElement(By.id("incident.short_description")).sendKeys(shortdesc);

		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The Incident number is : " + incidentNum);

		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNum, Keys.ENTER);
		System.out.println("The testcase has been created successfully");

		

	}
	@DataProvider (name="fetchData")
	public String[][] readData() throws IOException {
	return ServiceExcel.sendData("ServiceCreate");

	}
	
	
	
}

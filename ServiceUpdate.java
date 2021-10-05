package week5day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ServiceUpdate extends ServiceParent {
	@Test
	public void update() throws InterruptedException {

		WebElement frameThree = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frameThree);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The Incident number is : " + incidentNum);

		driver.findElement(By.id("incident.urgency")).click();
		driver.findElement(By.xpath("//select[@id='incident.urgency']/option[@value='1']")).click();

		driver.findElement(By.id("incident.state")).click();
		driver.findElement(By.xpath("//select[@id='incident.state']/option[text()='In Progress']")).click();

		String text = driver.findElement(By.xpath("//select[@id='incident.state']/option[text()='In Progress']"))
				.getText();
		String text2 = driver.findElement(By.xpath("//select[@id='incident.urgency']/option[text()='1 - High']"))
				.getText();

		System.out.println(text);
		System.out.println(text2);

		if (text.contains("In Progress")) {
			System.out.println("the text contains in progress and its verified");
		}

		if (text2.contains("High")) {
			System.out.println("the text contains high and its verified");
		}
		driver.findElement(By.id("sysverb_update_bottom")).click();

	}
	
	}

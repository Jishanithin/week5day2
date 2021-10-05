package week5day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AssignEditLead extends AssignParentClass {
	@Test(dataProvider="fetchData")
	public void runEditLead(String fName,String cName) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']"))
				.click();

		driver.findElement(By.linkText("Edit")).click();

		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);

		driver.findElement(By.name("submitButton")).click();

	}
	
	@DataProvider(name="fetchData")
	public String[][] readData() throws IOException {
		return AssignExcelLead.sendData("EditLead");

	}
	
	
	
}

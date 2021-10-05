package week5day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AssignCreateLead extends AssignParentClass{
	@Test(dataProvider="fetchData")
	public void createLead(String cName,String fName,String lName,String phNum) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNum);
		driver.findElement(By.name("submitButton")).click();


	}
	
	@DataProvider(name="fetchData")
	public String[][] readData() throws IOException {
		return AssignExcelLead.sendData("AssignCreateLead");

	}
	
	
	
}
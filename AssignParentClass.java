package week5day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignParentClass {
	public ChromeDriver driver;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void precondition(String url, String uName, String pWord) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverManager.chromiumdriver().browserVersion("93").setup();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();

	}

	@AfterMethod
	public void postcondition() {
		driver.close();

	}

}

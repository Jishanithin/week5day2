package week5day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceParent {
public ChromeDriver driver;
	@Parameters({"url","user_name","user_password"})
	@BeforeMethod
	public void precondition(String url,String uName,String passWord) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		String title = driver.getTitle();
		System.out.println("Title" + title);

		WebElement frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("user_name")).sendKeys(uName);
		driver.findElement(By.id("user_password")).sendKeys(passWord);
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();

		WebElement filter = driver.findElement(By.id("filter"));

		filter.sendKeys("incident", Keys.ENTER);

		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();


	}
	@AfterMethod
	public void postcondition() {
	driver.close();

	}
	
}

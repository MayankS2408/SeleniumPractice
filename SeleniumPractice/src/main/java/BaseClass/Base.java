package BaseClass;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;;;

	@BeforeTest
	public void setup() throws Exception {

		driver=WebDriverManager.chromedriver().avoidShutdownHook().create();;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
//	@AfterTest
//	public void teardown() {
//		driver.quit();
//	}
}

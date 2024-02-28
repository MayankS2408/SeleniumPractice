package Testtool;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BaseClass.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Tc_Testingtool;

public class TesttoolTest extends Base{
	
	Tc_Testingtool T ;
	@Test
	public void Testool() throws Exception {
		driver.get("https://www.google.com/search?q=testing+tools");
		T=new Tc_Testingtool(driver);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)"," ");
		driver.findElement(By.xpath("//span[text()='15 more']")).click();
		T.Actions();
				
	}
}

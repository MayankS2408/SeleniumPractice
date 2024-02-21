package Alert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.Base;

public class AlertTest extends Base {

	@Test(priority = 1)
	public void alert() {

		driver.get("https://omayo.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window,scrollBy(0,250)", "");
		driver.findElement(By.id("alert1")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

	@Test(priority = 2)
	public void prompt() {

		driver.findElement(By.id("prompt")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Mayank");
		driver.switchTo().alert().accept();
	}

	@Test(priority = 3)
	public void doubleclick() {
		WebElement element = driver.findElement(By.xpath("//button[text()=' Double click Here   ']"));
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
		driver.switchTo().alert().accept();

	}

	@Test(priority = 4)
	public void uploadfile() {
		WebElement element = driver.findElement(By.id("uploadfile"));
		element.sendKeys("C:\\Users\\hp\\Downloads\\MAYANK_SHARMA_Resume_2023 (1).pdf");

	}

	@Test(priority = 5)
	public void table() {
		List<WebElement> list = driver.findElements(By.id("table1"));
		for (WebElement a : list) {
			System.out.println(a.getText());
		}
	}

	@Test(priority = 6)
	public void select() {

		Select select = new Select(driver.findElement(By.id("drop1")));
		List<WebElement> l = select.getOptions();
		for (WebElement a : l) {
			System.out.println(a.getText());
		}

	}

	@Test(priority = 7)
	public void image() {
		System.out.println(driver.findElement(By.cssSelector("img")).getAttribute("src"));
	}
}
package pom;

import java.util.List;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tc_Testingtool {

	WebDriver driver;

	public Tc_Testingtool(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Testing tools']")
	WebElement TestautomationSoftware;

	@FindBy(xpath = " ")
	public WebElement element;

	public void Actions() throws InterruptedException {

		System.out.println(TestautomationSoftware.getText());

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='jdsrEf hhv4Fb']"));
		for (WebElement e : list) {
			System.out.println(e.getText());
			List<WebElement> list1 = driver.findElements(By.cssSelector("img"));
			for (WebElement a : list1) {
				System.out.println(a.getAttribute("src"));
					
				}
			}

		}

	}

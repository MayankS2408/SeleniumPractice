package pom;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.bouncycastle.util.Arrays.Iterator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tc_Amazon {

	WebDriver driver;
	Actions action;

	public Tc_Amazon(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"nav-cart-count-container\"]/span[2]")
	WebElement cart;

	@FindBy(xpath = "//*[@id=\"sc-empty-cart\"]/div[2]/div[1]/h2")
	WebElement gettext;

	@FindBy(id = "twotabsearchtextbox")
	WebElement amazonsearch;
	
	@FindBy(id="nav-search-submit-button")
	WebElement go;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]")
	WebElement result;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")
    WebElement clickonmobile;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addtocart;
	
	public void clickonaddtocart() {
		action=new Actions(driver);
		action.contextClick(cart).build().perform();
		cart.click();
	}

	public void search() {
		amazonsearch.sendKeys("Mobile");
	}
	
	public void clickonsearch() {
		go.click();
	}
	
	public void mobile() {
		clickonmobile.click();
	}
	
	public void Addtocart() {
		 addtocart.submit();
	}

	public void action() {
		this.clickonaddtocart();
		String actual = gettext.getText();
		String expected = "Your Amazon Cart is empty";
		if (expected.equalsIgnoreCase(actual)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	public void actioncontinue() throws InterruptedException {

		this.search();
		this.clickonsearch();
		List<WebElement>list=driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]"));
		for(WebElement li:list) {
			System.out.println(li.getText());
		}
		String parent=driver.getWindowHandle();
		this.mobile();
		Set<String>a=driver.getWindowHandles();
		java.util.Iterator<String>it= a.iterator();
		while(it.hasNext()) {
			String child=it.next();
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
			}
		}		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		this.Addtocart();
	}

}

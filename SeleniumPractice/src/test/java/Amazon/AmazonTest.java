package Amazon;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import BaseClass.Base;
import pom.Tc_Amazon;

public class AmazonTest extends Base {

	Tc_Amazon T;

	@Test(priority = 0)
	public void amazon() {
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		T = new Tc_Amazon(driver);
		T.action();

	}

	@Test(priority = 1)
	public void searchamazon() throws InterruptedException {
		T = new Tc_Amazon(driver);
		T.actioncontinue();

	}

}

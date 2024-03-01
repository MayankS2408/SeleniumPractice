package Brokenlink;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.Base;

public class BrokenLinkTest extends Base {

	@Test
	public void brokenlink() throws MalformedURLException, IOException, InterruptedException {

		driver.get("https://www.youtube.com/");
		int count=0;
		int count1=0;
		int count3=0;
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		for(WebElement link:list) {
			String url=link.getAttribute("href");
			
			if(url==null ||url.isEmpty()) {
				System.out.println("Link in empty");
				count3++;
				continue;
			}
			
			HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.connect();
			if(huc.getResponseCode()>=400) {
				System.out.println(huc +" "+"Link is broken");
				count++;
			}else {
				System.out.println(huc + "----------"+"Link is not broken");
			    count1++;
			}

		}
		
		System.out.println("Number of Links broken"+ " "+count);
		System.out.println("Number of Links are not broken"+" "+count1);
		System.out.println("Number of link is empty"+ " "+ count3);
	}

}

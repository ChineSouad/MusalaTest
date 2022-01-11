package test;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class TC3_CareersPageTest extends TestBase{



	JavascriptExecutor js = (JavascriptExecutor) driver;
	Map<String, Object>vars = new HashMap<String, Object>();
	@Test
	public void CareersPageApply() {

		driver.findElement(By.cssSelector("#menu-main-nav-1 > .menu-item-478 > .main-link")).click();
		driver.findElement(By.cssSelector(".contact-label > span")).click();

		String URLJoinUs=driver.getCurrentUrl();
		Assert.assertEquals(URLJoinUs, "https://www.musala.com/careers/join-us/" );


		driver.findElement(By.id("get_location")).click();
		{
			WebElement dropdown = driver.findElement(By.id("get_location"));
			dropdown.findElement(By.xpath("//option[. = 'Anywhere']")).click();
		}    

		// driver.findElement(By.xpath("(//img[@alt='Experienced Automation QA Engineer'])[2]")).click();
		js = (JavascriptExecutor) driver;

		WebElement myPsition = driver.findElement(By.xpath("(//img[@alt='Experienced Automation QA Engineer'])[2]"));
		js.executeScript("arguments[0].click()", myPsition);

		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".joinus-content:nth-child(1) > .pull-right h2"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".joinus-content:nth-child(1) > .pull-left h2"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".joinus-content:nth-child(2) > .pull-right h2"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".joinus-content:nth-child(2) > .pull-left h2"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.xpath("//article[@id='post-1501']/div/div[2]/div/div[2]/div[2]/div[2]/h2"));
			assert(elements.size() > 0);
		}
		// driver.findElement(By.xpath("//input[@value='Apply']")).click();
		WebElement applyBtn = driver.findElement(By.xpath("//input[@value='Apply']"));
		js.executeScript("arguments[0].click()", applyBtn);

		driver.findElement(By.id("cf-1")).sendKeys("test");
		driver.findElement(By.id("cf-2")).sendKeys("test@test");

		driver.findElement(By.id("cf-4")).sendKeys(System.getProperty("user.dir")+"\\uploadedData\\CHINE_Souad_Resume.pdf");


		WebElement sendBtn = driver.findElement(By.cssSelector(".has-spinner"));
		js.executeScript("arguments[0].click()", sendBtn);

		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".wpcf7-response-output"));
			assert(elements.size() > 0);
		}


	}

}

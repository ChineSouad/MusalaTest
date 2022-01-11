package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utils.ExcelUtil;

public class TC1_ContactsUSTest extends TestBase
{




	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeTest
	public void setUp() {

		js = (JavascriptExecutor) driver;

	}

	@Test(dataProvider = "TestData" )
	public void contactUs(String Email) throws Exception{

		js.executeScript("window.scrollTo(0,4.800000190734863)");
		js.executeScript("window.scrollTo(0,764)");
		driver.findElement(By.cssSelector(".contact-label > span")).click();
		//  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("cf-1")).click();
		driver.findElement(By.id("cf-1")).sendKeys("test");
		driver.findElement(By.id("cf-2")).sendKeys(Email);
		driver.findElement(By.id("cf-3")).sendKeys("23858272");
		driver.findElement(By.id("cf-4")).sendKeys("Application");
		driver.findElement(By.id("cf-5")).sendKeys("I want to join Musala!");
		driver.switchTo().frame(2);
	
		//recaptcha step is disabled 
		// driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector(".has-spinner")).click();
		Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/p[2]/span/span")));

	}

	@DataProvider(name="TestData")
	public Object[] dataMethod() throws Exception {
		String[] arrayObjects = ExcelUtil.getExcelDataIn2DArray("testData//contactData.xlsx", "dataSheet");
		return arrayObjects;
	}

	}

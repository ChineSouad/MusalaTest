package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class TC2_CompanyPageTest extends TestBase{


	JavascriptExecutor js = (JavascriptExecutor) driver;
	Map<String, Object>vars = new HashMap<String, Object>();



	@Test
	public void companyPage(){

		driver.manage().window().setSize(new Dimension(1341, 824));
		driver.findElement(By.xpath("//*[@id=\"menu-main-nav-1\"]/li[1]/a")).click();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.musala.com/company/" );
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".cm-content > h2"));
			assert(elements.size() > 0);
		}
		{
			WebElement element = driver.findElement(By.cssSelector("html"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.cssSelector("html"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.cssSelector("html"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".musala-icon-facebook")).click();
		vars.put("win8545", waitForWindow(2000));
		driver.switchTo().window(vars.get("win8545").toString());

		String URLFBK = driver.getCurrentUrl();
		Assert.assertEquals(URLFBK, "https://www.facebook.com/MusalaSoft?fref=ts" );

		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".b3onmgus > .oajrlxb2 image"));
			assert(elements.size() > 0);
		}

	}

	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}



}

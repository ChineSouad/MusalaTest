package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;

public class TC4_CareersPageTest extends TestBase{


	JavascriptExecutor js = (JavascriptExecutor) driver;
	Map<String, Object>vars = new HashMap<String, Object>();
	@Test
	public void CareersPageListPositions() {

		driver.findElement(By.cssSelector("#menu-main-nav-1 > .menu-item-478 > .main-link")).click();
		driver.findElement(By.cssSelector(".contact-label > span")).click();
		driver.findElement(By.id("get_location")).click();
		{
			WebElement dropdown = driver.findElement(By.id("get_location"));
			dropdown.findElement(By.xpath("//option[. = 'Sofia']")).click();
		}
		
		displayPositions();
		
		{
			WebElement dropdown = driver.findElement(By.id("get_location"));
			dropdown.findElement(By.xpath("//option[. = 'Skopje']")).click();
		}
		
		displayPositions();
		
	}
	
	public void displayPositions() {
		Select select = new Select(driver.findElement(By.id("get_location")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println(defaultItem +"\n\n");   
		WebElement t = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[2]"));


		//identify child nodes with ./child::* expression in xpath
		List<WebElement> c = t.findElements(By.xpath("./child::*"));
		// iterate child nodes
		int j=0;
		for ( WebElement i : c ) {
			//getAttribute() to get href & alt from child nodes
			j++;

			WebElement t0 = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[2]/article["+j+"]/div/a/div/div[2]/img"));

			System.out.println("Position: " + t0.getAttribute("alt"));
			WebElement t1 = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[2]/article[" + j + "]/div/a"));

			System.out.println("More details:" + t1.getAttribute("href")+"\n");
		}

	}

}

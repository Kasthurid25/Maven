package org.Amazon.Online;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class App {
	  WebDriver driver = new ChromeDriver();
	public void login()
	{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[9]/div[2]/a[1]/span[1]")).click();
		driver.findElement(By.id("ap_email")).sendKeys("+919092426929");
		driver.findElement(By.id("continue")).click(); 
		driver.findElement(By.id("ap_password")).sendKeys("shinchan25");
		driver.findElement(By.id("signInSubmit")).click(); 
		}
	public void search()
	{
		WebElement sbar= driver.findElement(By.id("twotabsearchtextbox"));
		
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(sbar)
			.click()
			.keyDown(sbar, Keys.SHIFT)
			.sendKeys(sbar, "boat headphone")
			.keyUp(sbar, Keys.SHIFT)
			.doubleClick(sbar)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;
		WebElement sbutton= driver.findElement(By.id("nav-search-submit-button"));
		sbutton.click();
		

		} 
	

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver.exe"); 
			App m=new App();
			m.login();
			m.search();
			


	}

}
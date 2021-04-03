package org.Amazon.Online;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
			.build();
			
		seriesOfActions.perform() ;
		WebElement sbutton= driver.findElement(By.id("nav-search-submit-button"));
		sbutton.click();
		

		} 
	public void select() {
		
		WebElement chk1 = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/span[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]"));							
       	chk1.click();			
        System.out.println("Option 1 Selected");	
        WebElement chk2 = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/span[1]/div[1]/div[1]/div[5]/ul[3]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]"));
        if (chk2.isSelected())
        {					
            System.out.println("Checkbox is Toggled On");					

        } else {			
            System.out.println("Checkbox is Toggled Off");					
        }	
	}
	
        
      public void screen() throws IOException {
    	  TakesScreenshot tk=(TakesScreenshot) driver; 
    	  File f = tk.getScreenshotAs(OutputType.FILE);
    	  File f1=new File("F:/facebook.png");  
    	  FileUtils.copyFile(f,f1 ); 
      }
	

	public static void main(String[] args) throws Exception {
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver.exe"); 
			App m=new App();
			m.login();
			m.search();
			m.select();
			m.screen();
						
			


	}

}
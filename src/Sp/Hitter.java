package Sp;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Hitter {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ELCOT\\eclipse-workspace\\silambu\\sd\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement source=driver.findElement(By.xpath(" //*[text()=' BANK ']"));
		WebElement target =driver.findElement(By.xpath(" (//li[@class='placeholder'])[1]"));
		WebElement source1=driver.findElement(By.xpath("//*[text()=' 5000 ']"));
		WebElement target1 =driver.findElement(By.xpath(" (//li[@class='placeholder'])[2]"));
		WebElement source2=driver.findElement(By.xpath(" //*[text()=' SALES ']"));
		WebElement target2 =driver.findElement(By.xpath(" (//li[@class='placeholder'])[3]"));
		WebElement source3=driver.findElement(By.xpath("//*[text()=' 5000']"));
		WebElement target3 =driver.findElement(By.xpath("(//li[@class='placeholder'])[4]"));
		Actions a= new Actions(driver);
		 a.dragAndDrop(source, target).perform();
    	  a.dragAndDrop(source1, target1).perform();
		 a.dragAndDrop(source2, target2).perform();
		 a.dragAndDrop(source3, target3).perform();
        
        TakesScreenshot tk=(TakesScreenshot)driver;
        File src = tk.getScreenshotAs(OutputType.FILE);
       File dest= new File("C:\\Users\\ELCOT\\eclipse-workspace\\silambu\\da\\drag and drop");
        FileUtils.copyFile(src, dest);
		WebElement username=driver.findElement(By.id("email"));
		WebElement pass=driver.findElement(By.id("pass"));
		WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
		
		JavascriptExecutor jr=(JavascriptExecutor)driver;
		jr.executeScript(("arguments[0].setAttribute('value','karthi')"), username);
		Object script=jr.executeScript("return arguments[0].getAttribute('value')",username);
		System.out.println(script);
		jr.executeScript(("arguments[0].setAttribute('value','123456')"), pass);
		Object script1=jr.executeScript("return arguments[0].getAttribute('value')",pass);
		System.out.println(script1);
		WebElement down=driver.findElement(By.linkText("Careers"));
		jr.executeScript("arguments[0].scrollIntoView(true)", down);
		Thread.sleep(2000);
		jr.executeScript("arguments[0].scrollIntoView(false)", username);
		jr.executeScript(("arguments[0].click"), login);
		
		
       
		
		
        }
 }
		
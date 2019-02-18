package pages;


import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;

import pombase.BasePage;



public class screenShots extends BasePage{
	
	//private static final TakesScreenshot driver = null;

	public void captureScreenshot() throws Exception
	{
			
	TakesScreenshot ts=((TakesScreenshot)driver);
	File source =ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source,new File("./screenshots/testing.png"));
	System.out.println("Screenshot taken");
		
		
		/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("./screenshots/testing.png"));  
	    WebElement elements = driver.findElement(By.xpath(".//*[@id=\"page-content\"]"));    
	    Thread.sleep(3000L);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int yPosition = elements.getLocation().getY();
	    js.executeScript("window.scroll (0, " + yPosition + ") ");       
		Thread.sleep(3000L);         
        File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./screenshots/testing1.png"));*/
		
		
		driver.close();
		
	}

}

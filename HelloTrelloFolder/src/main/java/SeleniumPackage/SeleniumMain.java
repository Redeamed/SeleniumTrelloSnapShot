package SeleniumPackage;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumMain {
	WebDriver driver;
	
	public SeleniumMain() 
	{
		//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "path");  
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kyle\\Documents\\geckodriver-v0.20.0-win64\\geckodriver.exe");  
		driver = new FirefoxDriver();
		
        
        //String actualTitle = driver.getTitle();
        
            //System.out.println(actualTitle);
            
            
           
            
            
            
            
            
            
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void OpenWebPage(String address)
	{
		driver.get(address);
	}
	public void ClickXpathElement(String path)
	{
		driver.findElement(By.xpath(path)).click();
	}
	public void SendStringToXpathElement(String path, String text)
	{
		driver.findElement(By.xpath(path)).sendKeys(text);
	}
	
	public void OpenTargetBoard(String boardName)
	{
		//Find Board
        List<WebElement> boards = driver.findElements(By.className("board-tile"));
        if(boards.isEmpty())
        	{
        		System.out.println("No boards found");
        	}
        else
        	{
        		System.out.println(boards.size() + " boards found");
        	}
        String[] parts;
        String currentBoard;
        String finalBoard = null;
        for(int i = 0; i < boards.size() -1; ++i)
        {
        	currentBoard = boards.get(i).getAttribute("href");
        	System.out.println(currentBoard);
        	
        	parts = currentBoard.split("/");
        	if(parts[5] != null)
        	{
        		System.out.println(parts[5]);
        		if(parts[5].compareTo(boardName) == 0)
        		{
        			finalBoard = currentBoard;
        			System.out.println("The final is: " + finalBoard);
        			break;
        		}
        	}
        }
        driver.get(finalBoard);
        
	}
	public void Close()
	{

        //close Fire fox
        driver.quit();
	}
	
}
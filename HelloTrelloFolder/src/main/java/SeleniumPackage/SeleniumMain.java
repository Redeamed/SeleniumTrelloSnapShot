package SeleniumPackage;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumMain {
	public SeleniumMain(String login, String password, String board) 
	{
		//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "path");  
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kyle\\Documents\\geckodriver-v0.20.0-win64\\geckodriver.exe");  
		WebDriver driver = new FirefoxDriver();
		
		String baseUrl = "http://Trello.com";
        
        
        driver.get(baseUrl);
        
        String actualTitle = driver.getTitle();
        
            System.out.println(actualTitle);
            
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a[1]")).click();
            
            driver.findElement(By.xpath("//*[@id=\"user\"]")).sendKeys(login);
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
            
            driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
            
           try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            
           /***************
            //Get Trello key
            driver.get("https://trello.com/app-key#");
            String trelloKey = driver.findElement(By.xpath("//*[@id=\"key\"]")).getAttribute("value");
            System.out.println("Key Aquired: " + trelloKey);
            
            //Get Trello Token
            driver.get("https://trello.com/1/authorize?expiration=never&scope=read,write,account&response_type=token&name=Server%20Token&key=4fdcc44e5f6b4f6b6e54aef4ab3e24ac");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[4]/form/input[1]")).click();
            String token = driver.findElement(By.xpath("/html/body/pre")).getText();
            System.out.println("token Aquired: " + token);
            		
            driver.get(baseUrl);	
            *****************/
            
            
            
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
            	//System.out.println(parts[0]);
            	//System.out.println(parts[1]);
            	//System.out.println(parts[2]);
            	//System.out.println(parts[3]);
            	if(parts[5] != null)
            	{
            		System.out.println(parts[5]);
            		if(parts[5].compareTo(board) == 0)
            		{
            			finalBoard = currentBoard;
            			System.out.println("The final is: " + finalBoard);
            			break;
            		}
            	}
            }
            driver.get(finalBoard);
            
            
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        //close Fire fox
        driver.quit();
	}
}
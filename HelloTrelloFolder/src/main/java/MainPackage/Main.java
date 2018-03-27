package MainPackage;

import java.io.IOException;

import org.openqa.selenium.By;

import SeleniumPackage.SeleniumMain;

public class Main 
{
	static SwingUI mainUI;
	static SeleniumMain seleniumMain;
	
	public static void main(String[] args) 
	{

		mainUI = new SwingUI("Trello SnapShot", 400,300,true);
		
	}
	
	public static void InitializeSelenium(String login, String password, String boardName)
	{
		seleniumMain = new SeleniumMain();
		seleniumMain.OpenWebPage("https://trello.com/");
		
		//click login in
		seleniumMain.ClickXpathElement("/html/body/div[1]/div[2]/a[1]"); 
		//input login information
        seleniumMain.SendStringToXpathElement("//*[@id=\"user\"]", login);
        //input password information
        seleniumMain.SendStringToXpathElement("//*[@id=\"password\"]", password);
        //click submit login information
		seleniumMain.ClickXpathElement("//*[@id=\"login\"]"); 
        
		
		 
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        seleniumMain.OpenTargetBoard(boardName);
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        seleniumMain.Close();
	}
}

package MainPackage;

import java.io.IOException;

import SeleniumPackage.SeleniumMain;

public class Main 
{

	public static void main(String[] args) 
	{
		
		
		
		SwingUI mainUI = new SwingUI("Trello SnapShot", 400,300,true);
		
		
		String baseUrl = "http://Trello.com";
		//SeleniumMain sM = new SeleniumMain();
		//sM.SetDriverFF();
		//sM.OpenURL(baseUrl);
		//sM.CloseDriver();
		
		//ExcelRW excelWR = new ExcelRW();
		//excelWR.LoadfileToPrimary("C:\\Users\\Kyle\\WorkspaceGit\\project\\HelloTrelloFolder\\SaveFolder\\SaveTest.xml");
		/*
		for(int r = 0; r < 10; r++)
		{
			for(int c = 0; c < 10; c++)
			{
				System.out.println("\n Row: "+ r + " Col: " + c);
				excelWR.WriteToCell("test(" + r +","+c +")", r, c);
				
			}
		}
		
		
		try {
			excelWR.SaveWorkbook("C:\\Users\\Kyle\\WorkspaceGit\\project\\HelloTrelloFolder\\SaveFolder\\SaveTest.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}

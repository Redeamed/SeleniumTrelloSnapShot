package MainPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRW 
{
	XSSFWorkbook primaryWorkbook;
	XSSFSheet sheet;
	
	public ExcelRW()
	{
		primaryWorkbook = new XSSFWorkbook();
		primaryWorkbook.createSheet();
		sheet = primaryWorkbook.getSheetAt(0);
		Row r = sheet.createRow(0);
		r.createCell(0);
	}

	public ExcelRW(java.io.File file) throws InvalidFormatException, IOException
	{
		primaryWorkbook = new  XSSFWorkbook(file);
	}

	public void WriteToCell(String text, int row, int col)
	{
		WriteToCell(text ,row, col, 0);
	}
	public void WriteToCell(String text, int row, int col, int sheetIndex)
	{
		Cell c = GetCell(row,col,sheetIndex);
		if (c != null)
			{
				c.setCellValue(text);
			}
	}
	public String ReadCellValue(int row, int col)
	{
		return ReadCellValue(row, col, 0);
	}
	public String ReadCellValue(int row, int col, int sheetIndex)
	{
		String string = null;
		Cell c = GetCell(row,col,sheetIndex);
		string = c.getStringCellValue();
		return string;
	}
	
	public Cell GetCell(int row, int col, int sheetIndex)
	{
		Cell cell = null;

		Row r =null;
		int tempIndex = (sheet.getLastRowNum() + 1);
		
		System.out.println("last row: " + (tempIndex) + " vs Row: " + row);
		if(row >= tempIndex)
		{
			r = sheet.createRow(row);
			System.out.println("new row created: " + row);
		}
		else
		{
			r = sheet.getRow(row);
			System.out.println("Existing row retrieved: " + row);
		}
		
		
		tempIndex = r.getLastCellNum();
		System.out.println("last Cell: " + tempIndex + " vs Col: " + col);
		if(col < tempIndex)
		{
			cell = r.getCell(col);
			System.out.println("Existing Cell retrieved: " + col);
		}
		else
		{
			cell = r.createCell(col);
			System.out.println("New Cell Created: " + col);
		}
		
		return cell;
	}
	
	public void SaveWorkbook(String filePath) throws IOException 
	{
		FileOutputStream out = new FileOutputStream(new File(filePath));
		try {
			primaryWorkbook.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not write to filePath:" + filePath);
			e.printStackTrace();
		}
		out.close();
	}
	public void LoadfileToPrimary(String filePath)
	{
		
		try {
			primaryWorkbook = new XSSFWorkbook(new File(filePath));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (primaryWorkbook != null)
		{
			
			sheet = primaryWorkbook.getSheetAt(0);
			Row row = null;
			for (int i = 0; i < (sheet.getLastRowNum()+1); i++)
			{
				row = sheet.getRow(i);
				System.out.println("ROW: " + i);
				for(int j = 0; j < row.getLastCellNum();j++)
				{
					System.out.println("Cell" + j + row.getCell(j).getStringCellValue());
				}
			}
		}
		
	}
}

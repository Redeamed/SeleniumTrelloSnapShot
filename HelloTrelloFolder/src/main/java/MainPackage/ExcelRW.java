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
		// create a new work book and the first sheet for it
		primaryWorkbook = new XSSFWorkbook();
		primaryWorkbook.createSheet();
		sheet = primaryWorkbook.getSheetAt(0);
		Row r = sheet.createRow(0);
		r.createCell(0);
	}

	public ExcelRW(java.io.File file) throws InvalidFormatException, IOException
	{
		//create a work book from an existing file
		primaryWorkbook = new  XSSFWorkbook(file);
	}

	public void WriteToCell(String text, int row, int col)
	{
		//write to sheet assuming the first sheet index is desired
		WriteToCell(text ,row, col, 0);
	}
	public void WriteToCell(String text, int row, int col, int sheetIndex)
	{
		//write to sheet given a specific cell and sheet index
		Cell c = GetCell(row,col,sheetIndex);
		if (c != null)
			{
				c.setCellValue(text);
			}
	}
	public String ReadCellValue(int row, int col)
	{
		//read cell value of row/col assuming first sheet
		return ReadCellValue(row, col, 0);
	}
	public String ReadCellValue(int row, int col, int sheetIndex)
	{
		//read cell value at row/col with a given sheet index
		String string = null;
		Cell c = GetCell(row,col,sheetIndex);
		string = c.getStringCellValue();
		return string;
	}
	
	public Cell GetCell(int row, int col, int sheetIndex)
	{
		//Returns a cell at the given row/col and on  the specified sheetIndex
		
		//Initialize local variables
		Cell cell = null;
		Row r =null;
		
		//texp index represents to total number of rows
		int tempIndex = (sheet.getLastRowNum() + 1);
		
		//Print for debugging
		//System.out.println("last row: " + (tempIndex) + " vs Row: " + row);
		
		//if the desired row is greater than or equal to the total rows create the new row to work with
		//else override the existing row
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
		
		//reusing tempIndex to get the highest index count
		tempIndex = r.getLastCellNum();
		
		//print for debugging
		//System.out.println("last Cell: " + tempIndex + " vs Col: " + col);
		
		//if the desired col is less than the column total use the existing cell
		//else create a new cell
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
		
		//return the cell value
		return cell;
	}
	
	public void SaveWorkbook(String filePath) throws IOException 
	{
		//save workbook to the provided file path (assumes a new file)
		
		//create the output stream to write to the file path
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
		
		//load workbook from an existing filePath
		
		try {
			primaryWorkbook = new XSSFWorkbook(new File(filePath));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//if not null, set sheet and print values to console for testing
		/***************************************************************
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
		***********************************************************************/
		
	}
}

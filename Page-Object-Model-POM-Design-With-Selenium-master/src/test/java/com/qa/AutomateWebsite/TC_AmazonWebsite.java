package com.qa.AutomateWebsite;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class TC_AmazonWebsite extends TestBase
{
		public static WebDriver driver;
		    String chrome_path;
		    public static XSSFWorkbook workbook;
		    public static XSSFSheet worksheet;
		    public static DataFormatter formatter= new DataFormatter();
		    static String SheetName= "Sheet1";

		
		@Test(priority=2,dataProvider="getData")
		public void MobileRecharge(String username,String password,String mNumber,String Ramount) throws InterruptedException
		{	
			amazonOb.All().click();
			Thread.sleep(2000);	
			amazonOb.Username().sendKeys(username);
			amazonOb.Continue().click();
			amazonOb.Password().sendKeys(password);
			amazonOb.Submit().click();
			Thread.sleep(16000);
			amazonOb.amazonPay().click();
			amazonOb.mRecharge().click();
			Thread.sleep(3000);
			amazonOb.mNumber().click();
			amazonOb.mNumber().sendKeys(mNumber);
			Thread.sleep(5000);
			amazonOb.rAmount().sendKeys(Ramount);
			Thread.sleep(7000);
			amazonOb.rClick().click();
			
		}
		
		

	@DataProvider
	public static Object[][] getData() throws IOException
	{
		int k=0;
	FileInputStream fileInputStream= new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\AmazonWebsite.xlsx");
	    workbook = new XSSFWorkbook (fileInputStream); 
	    worksheet=workbook.getSheet("Sheet1");
	    
	    XSSFRow Row=worksheet.getRow(0);
	 
	    int RowNum = worksheet.getPhysicalNumberOfRows();
	    int ColNum= Row.getLastCellNum();
	   System.out.println(RowNum);
	    System.out.println(ColNum);
	    Object Data[][]= new Object[RowNum-1][ColNum];
	  
	      for(int i=1; i<RowNum-1; i++)
	        {  
	            XSSFRow row= worksheet.getRow(i);
	             
	            for (int j=0; j<ColNum; j++)
	            {
	                if(row==null)
	                   break;// Data[i][j]="";
	                else
	                {
	                    XSSFCell cell= row.getCell(j);
	                    if(cell==null)
	                      Data[i][j]= "";
	                    else
	                    {
	                        String value=formatter.formatCellValue(cell);
	                        Data[i][j]=value;
	                        k++;
	                        System.out.println(value);
	                        System.out.println(k);
	                    }
	                }
	            }
	        }
	        

	    return Data;
	}


	}





	/*
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0]="pooja";
		data[0][1]="poojabh";
		data[0][0]="16553121658";
		data[0][1]="5646pooja";
		return data;
	}
	*/

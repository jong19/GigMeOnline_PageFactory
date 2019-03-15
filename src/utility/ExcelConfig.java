package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	
	public static final String excelPath = "D:\\NINZO\\RC_automation_tests2\\GigMeOnline_PageFactory\\GigmeUserCredentials.xlsx";
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	
	int lastRow = 0;
	
	
	
	public ExcelConfig(){
		  try {
			fis = new FileInputStream(excelPath);
			wb = new XSSFWorkbook(fis);
		   } 
		   catch (Exception e) {
			System.out.println(e.getMessage());
		   }
		
		
	}
	
	
	public int getSheet(int sheetIndex){
		  sh = wb.getSheetAt(sheetIndex);
		  return sheetIndex;
		 
	}
	
	public int getCurrentRow(){
		
        int currRow = sh.getLastRowNum();
        row = sh.getRow(currRow);
        System.out.println("Current Row is: " + currRow);
		return currRow;
		
		
	}
	
	
	public int getNextRow(){
		  
		  lastRow = sh.getLastRowNum();			  
          lastRow++;
		  System.out.println("Last Row Number is: " + lastRow);
		  row = sh.createRow(lastRow);
		  
		  return lastRow;
		  	
	}
	
	public int getAllRowCount(){
		
		int r = sh.getLastRowNum();
		r++;
		System.out.println("Number of rows in sheet: " + lastRow);

		return r;
	}
	
	
	
	

	public void addNewUser(String un, String em, String pw){
		
		
		  cell = row.createCell(0);
		  cell.setCellValue(un);
		  
		  cell = row.createCell(1);
		  cell.setCellValue(em);
		  
		  cell = row.createCell(2);
		  cell.setCellValue(pw);
	   
		
	}
	
	
	public void addNewPassword(String pw, int colNo){
		  cell = row.createCell(colNo);
		  cell.setCellValue(pw);
		  	
	}
	
	
	public  String readData(int rowNo, int colNo){
		String entry = sh.getRow(rowNo).getCell(colNo).getStringCellValue();
		return entry;
		
	}
	
	
	/*
	public boolean checkUsernameEmail(int rno,String uname, String email){
		
		boolean check_uname = sh.getRow(rno).getCell(0).getStringCellValue().contains(uname);
		boolean check_email = sh.getRow(rno).getCell(1).getStringCellValue().contains(email);
		
		if(check_uname || check_email){
			JOptionPane.showMessageDialog(null, uname + " and " + email + " already exist in the excel file");
			System.out.println(uname + " and " + email + " already exist in the excel file");
			
		}
	
		return false ;
		
	}
	*/
	
	
	
	public void closeFile(){
		try {
			 fos = new FileOutputStream(excelPath);
			 wb.write(fos);
			 fos.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		
	}
				
		

}

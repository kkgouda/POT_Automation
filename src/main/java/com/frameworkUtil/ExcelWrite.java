package com.frameworkUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	static File f;
	static FileInputStream excelFile ;
	
	static Workbook workbook;
	
	static Sheet sheet;

	public static void main(String[] args) throws IOException {
    	 f=new File("F:\\ScenarioDataSheet.xlsx");
    	  excelFile = new FileInputStream(f);
    	 workbook = new XSSFWorkbook(excelFile);
    	 sheet=workbook.getSheet("com.ftTest.Proposal");    
    	 
    	 
    	 for (int i = 2; i < 6; i++) {
    		 String idv=ExcelWrite.setCellData("IDV Amount", i,(int) (Math.random()*100));
    		 String pre=ExcelWrite.setCellData("Premium Amount", i,(int) (Math.random()*100));
    		 System.out.println("Idv Write "+idv);
    		 System.out.println("Premium Write "+pre);
		}
    	 
    	 
    	 
    	
//    	if(sheet.getRow(1).getCell(23).getRichStringCellValue().getString().equalsIgnoreCase("IDV Amount")) {
//    		sheet.getRow(2).createCell(23).setCellValue(900);
//    	}
		
//        FileOutputStream outputStream = new FileOutputStream(f);
//        workbook.write(outputStream);
//        workbook.close();
        
//        System.out.println(sheet.getRow(2).getCell(23).getNumericCellValue());
		
	}
	
	public  static String setCellData(String columnName, int iterationCount,double value) {
		
		boolean test=false;
		
		
    	if(sheet.getRow(1).getCell(23).getRichStringCellValue().getString().equalsIgnoreCase(columnName)) {
    		sheet.getRow(iterationCount).createCell(23).setCellValue(value);
            FileOutputStream outputStream;
            
    		try {
    			outputStream = new FileOutputStream( f);
    			workbook.write(outputStream);
    			test=true;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	if(sheet.getRow(1).getCell(24).getRichStringCellValue().getString().equalsIgnoreCase(columnName)) {
    		sheet.getRow(iterationCount).createCell(24).setCellValue(value);
            FileOutputStream outputStream;
            
    		try {
    			outputStream = new FileOutputStream( f);
    			workbook.write(outputStream);
    			test=true;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}

		return test?"Write Success":"Write Fail";
		
	}

}

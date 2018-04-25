package com.frameworkUtil;

import org.apache.poi.util.StringUtil.StringsIterator;

public class ExcelDataSheetUtil {

	private final String DAATA_SHEET_FILE_PATH = "ScenarioDataSheet.xlsx";
	org.apache.poi.ss.usermodel.Workbook workbook;
	org.apache.poi.ss.usermodel.Sheet sheet;

	public ExcelDataSheetUtil() {

		try {
			workbook = org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File(DAATA_SHEET_FILE_PATH));

		} catch (org.apache.poi.EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

	}

	public int getInvocationCountByRowCount(String scenarioName) {

		sheet = workbook.getSheet(scenarioName);
		int rowLength = sheet.getLastRowNum() - sheet.getFirstRowNum();
		rowLength -= 1;

		return rowLength;
	}

	public String getData(String columnName, int iterationCount) {
		org.apache.poi.ss.usermodel.DataFormatter dataFormatter = new org.apache.poi.ss.usermodel.DataFormatter();

		org.apache.poi.ss.usermodel.Row row = sheet.getRow(1);

		int columnNameIntFlag = -1;
		for (int cn = 0; cn <= row.getLastCellNum(); cn++) {
			org.apache.poi.ss.usermodel.Cell cell = row.getCell(cn);
			if (cell == null || cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK) {
				continue;
			}
			if (cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING) {
				String text = cell.getStringCellValue();
				if (columnName.equals(text)) {
					columnNameIntFlag = cn;
					break;
				}
			}
		}
		if (columnNameIntFlag == -1) {
			try {
				throw new Exception("None of the cells in the first row were Patch");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String charSequence = dataFormatter.formatCellValue(sheet.getRow(iterationCount).getCell(columnNameIntFlag));
		

		return charSequence;
	}
	
	public String setCellData(String columnName, int iterationCount) {
		
//		workbook.getSheet(arg0)
		
		
		
		return columnName;
		
	}

}

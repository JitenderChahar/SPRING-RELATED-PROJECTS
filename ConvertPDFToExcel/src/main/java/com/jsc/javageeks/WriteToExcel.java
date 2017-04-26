package com.jsc.javageeks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jsc.javageeks.model.StudentMark;

public class WriteToExcel {
	/**
	 * creating logger
	 */
	private static final Logger logger = Logger.getLogger(PDFReader.class);

	public void writeExcel(List<StudentMark> marksList, String excelFilePath)
			throws IOException {
		logger.info("Inside writeExcel() of WriteToExcel");

		Workbook workbook = getWorkbook(excelFilePath);
		Sheet sheet = workbook.createSheet();

		Row createRow = sheet.createRow(0);
		createRow.createCell(1).setCellValue("Htno");
		createRow.createCell(2).setCellValue("Subcode");
		createRow.createCell(3).setCellValue("Subname");
		createRow.createCell(4).setCellValue("Internals");
		createRow.createCell(5).setCellValue("Externals");
		createRow.createCell(6).setCellValue("Credits");

		int rowCount = 0;

		for (StudentMark studentMark : marksList) {
			Row row = sheet.createRow(++rowCount);
			writeBook(studentMark, row);
		}

		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
			workbook.write(outputStream);
		}

		logger.info("Exiting writeExcel() of WriteToExcel");
	}

	public void writeBook(StudentMark studentMark, Row row) {
		Cell cell = row.createCell(1);
		cell.setCellValue(studentMark.getHtno());

		cell = row.createCell(2);
		cell.setCellValue(studentMark.getSubcode());

		cell = row.createCell(3);
		cell.setCellValue(studentMark.getSubname());

		cell = row.createCell(4);
		cell.setCellValue(studentMark.getInternals());

		cell = row.createCell(5);
		cell.setCellValue(studentMark.getExternals());

		cell = row.createCell(6);
		cell.setCellValue(studentMark.getCredits());
	}

	private Workbook getWorkbook(String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new IllegalArgumentException(
					"The specified file is not Excel file");
		}

		return workbook;
	}
}

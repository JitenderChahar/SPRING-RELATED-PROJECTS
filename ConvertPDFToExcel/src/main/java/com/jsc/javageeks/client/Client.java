package com.jsc.javageeks.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jsc.javageeks.PDFReader;
import com.jsc.javageeks.WriteToExcel;
import com.jsc.javageeks.model.StudentMark;

public class Client {

	/**
	 * creating logger
	 */
	private static final Logger logger = Logger.getLogger(Client.class);

	public static void main(String[] args) {
		logger.info("Inside main() of Client");

		String pdfContent = PDFReader.readPDF();
		String strArray[] = pdfContent.split(System.lineSeparator());
		List<StudentMark> marksList = new ArrayList<StudentMark>();

		for (String line : strArray) {
			String subname = "";
			if (line.contains("10F01A0")) {
				String words[] = line.split(" ");

				int i;
				for (i = 2; i < words.length; i++) {
					if (isInteger(words[i]))
						break;
					subname = subname + words[i] + " ";
				}

				StudentMark studentMark = new StudentMark();
				studentMark.setHtno(words[0]);
				studentMark.setSubcode(words[1]);
				studentMark.setSubname(subname);
				studentMark.setInternals(Integer.parseInt(words[i++]));
				studentMark.setExternals(Integer.parseInt(words[i++]));
				studentMark.setCredits(Integer.parseInt(words[i]));

				marksList.add(studentMark);
			}
		}

		logger.info(marksList);

		WriteToExcel excelWriter = new WriteToExcel();
		String excelFilePath = "C://Users//GS-0957//Downloads//sample-pdf//studentmarks.xls";
		try {
			excelWriter.writeExcel(marksList, excelFilePath);
		} catch (IOException e) {
			logger.error("Exception : " + e.getMessage());
		}

	}

	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

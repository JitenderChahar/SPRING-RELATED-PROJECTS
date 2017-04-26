package com.jsc.javageeks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFReader {
	/**
	 * creating logger
	 */
	private static final Logger logger = Logger.getLogger(PDFReader.class);

	public static String readPDF() {
		logger.info("Inside readPDF() of PDFReader");
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		File file = new File(
				"C://Users//GS-0957//Downloads//sample-pdf//sample.pdf");
		String parsedText = null;
		try {
			PDFParser parser = new PDFParser(new FileInputStream(file));
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(5);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (IOException e) {
			logger.error("Exception : " + e.getMessage());
		}

		logger.info("Exiting readPDF() of PDFReader");
		return parsedText;
	}
}

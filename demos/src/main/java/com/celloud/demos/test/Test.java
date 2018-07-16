package com.celloud.demos.test;

import java.io.File;
import java.io.FileInputStream;

import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfReader;

public class Test {
	public static void main(String[] args) throws Exception {
		PdfReader reader = new PdfReader(new FileInputStream(new File("/Users/sun8wd/Downloads/孙文栋的简历.pdf")));
		int pages = reader.getNumberOfPages();
		for (int i = 0; i < pages; i++) {
			PdfDictionary d = reader.getPageN(i);
			System.out.println(d.isArray());
		}
	}
}

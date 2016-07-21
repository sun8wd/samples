package com.celloud.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		// try {
		// List<String> lines = FileUtils.readLines(new
		// File("/Users/sun8wd/Documents/rocky/all.snp"));
		// List<String> newLines = new ArrayList<String>();
		// for (int i = 0; i <= 20; i++) {
		// newLines.add(lines.get(i));
		// }
		// FileUtils.writeLines(new
		// File("/Users/sun8wd/Documents/rocky/test.snp"), newLines);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		test();
	}

	public static void test() throws IOException {
		List<String> lines = FileUtils.readLines(new File("/Users/sun8wd/Documents/python/des.txt"));
		FileUtils.writeLines(new File("/Users/sun8wd/Documents/python/des2.txt"), lines);
	}
}

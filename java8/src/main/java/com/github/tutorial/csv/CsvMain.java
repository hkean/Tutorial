package com.github.tutorial.csv;

import java.io.FileOutputStream;

public class CsvMain {
	public static void main(String[] args) {
		new CsvMain();
	}

	public CsvMain() {
//		CsvUtil.read();
		CsvUtil.write();

		try (FileOutputStream fos = new FileOutputStream("a.csv")) {
			byte[] b = CsvUtil.exportCSV();
			fos.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.github.tutorial.error.handling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ErrorMain {
	public static void main(String[] args) {
		File file = new File("");
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream(file);

		} catch (FileNotFoundException | ArithmeticException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
			}
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
			}
		}
	}
}

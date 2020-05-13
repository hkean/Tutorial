package com.github.tutorial.incomplete;

import java.io.FileOutputStream;

public class WriteFiles {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("D:\\HK\\abc.txt");
		fos.write("abcdef".toString().getBytes());
		fos.flush();
		fos.close();
	}
}

package com.github.tutorial.file;

import java.io.File;
import java.util.List;

public class FileMain {

//	String pattern = "[\\s+\\|]+";
//	String pattern = "\\s*,\\s*";
//	String pattern = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"; // https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
	String pattern = "\"(,\")?"; // https://www.javacodeexamples.com/java-split-string-by-comma-example/740

	Integer statusIndex = 0;
	Integer idIndex = 0;

	public static void main(String[] args) {

		System.out.println(FileMain.class.getClassLoader().getResource(".").getPath());
		new FileMain();

	}

	FileMain() {
		System.out.println(this.getClass().getClassLoader().getResource(".").getPath());
		List<List<String>> response = ReadUtil.readFileOrByteReturnList(
				new File("." + File.separator + "BatchSubmissionDetail_1.csv"), null, pattern);

		List<String> header = response.get(0);
		for (int i = 0; i < header.size(); i++) {
			System.out.println(header.get(i));
			if (header.get(i).equalsIgnoreCase("reason_code")) {
				statusIndex = i;
			} else if (header.get(i).equalsIgnoreCase("merchant_ref_number")) {
				idIndex = i;
			}
		}
		response.remove(0); // remove header
		System.out.println(statusIndex + " : " + idIndex);

		for (List<String> tmp : response) {
			if (null == tmp.get(statusIndex) || tmp.get(statusIndex).isEmpty()) {
				System.out.println(Boolean.FALSE);
			} else {
				System.out.println("process");
			}
		}
	}

}

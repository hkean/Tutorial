package com.github.tutorial.file;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadUtil {
	public static void main(String[] args) {
		new ReadUtil();
	}

	public ReadUtil() {
		existingCode();
	}

	public void existingCode() {

		// FileInputStream in = null;
		// FileReader in = null;
		// InputStreamReader in = null;
		BufferedReader in = null;

		try {
			File dirs = new File(".");
			String dirPath = dirs.getCanonicalPath() + File.separator + "src" + File.separator;
			// dirPath += "query.txt";
			dirPath += "Jedit.csv";

			// try {
			// in = new FileInputStream(dirPath);
			// in = new FileReader(dirPath);
			in = new BufferedReader(new FileReader(dirPath));

			// int c;
			String c;
			// while ((c = in.read()) != -1) {
			while ((c = in.readLine()) != null) {
				String[] a = c.split(",");
				System.out.println(a[1] + "=" + a[3]);
			}

		} catch (IOException e) {

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// e.printStackTrace();
				}
			}
		}
	}

	public static int[] readFileReturnArray(int max) {
//		int max = 1000;
		int[] arr = new int[max];

		BufferedReader in = null;

		try {
			File dirs = new File(".");
			String dirPath = dirs.getCanonicalPath() + File.separator + "src" + File.separator;
			dirPath += "data_" + max + ".txt";

			in = new BufferedReader(new FileReader(dirPath));

			String c;

			while ((c = in.readLine()) != null) {
				String[] a = c.split(",");
				// System.out.println();

				for (int i = 0; i < a.length; i++) {
					arr[i] = Integer.parseInt(a[i]);
				}
			}
		} catch (IOException e) {

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

				}
			}
		}

		return arr;
	}

	public static List<String[]> readFileReturnList(File file, String separator) {
		List<String[]> result = new ArrayList<>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			String c;
			while ((c = in.readLine()) != null) {
				String[] a = c.split(separator);
				result.add(a);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

				}
			}
		}

		return result;
	}

	public static List<List<String>> readFileOrByteReturnList(File file, byte[] content, String separator) {
		List<List<String>> result = new ArrayList<>();
		BufferedReader in = null;
		try {
			if (file != null) {
				in = new BufferedReader(new FileReader(file));
			} else if (content != null) {
				in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(content)));
			}
			String c;
			while ((c = in.readLine()) != null) {
				result.add(Arrays.asList(c.split(separator)));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

				}
			}
		}

		return result;
	}
}

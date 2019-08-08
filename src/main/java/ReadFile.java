

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {

		new ReadFile();

	}

	public ReadFile() {

		// FileInputStream in = null;
		// FileReader in = null;
		// InputStreamReader in = null;
		BufferedReader in = null;

		try {
			File dirs = new File(".");
			String dirPath = dirs.getCanonicalPath() + File.separator + "src"
					+ File.separator;
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
			String dirPath = dirs.getCanonicalPath() + File.separator + "src"
					+ File.separator;
			dirPath += "data_" + max + ".txt";

			in = new BufferedReader(new FileReader(dirPath));

			String c;

			while ((c = in.readLine()) != null) {
				String[] a = c.split(",");
				// System.out.println();

				for (int i=0; i<a.length; i++) {
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
}



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;


public class Ranking {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ParseFilesInDir();
//		ReadQueryOnly();
		rank7();
	}

	private static void ReadQueryOnly() throws IOException {

		// FileInputStream in = null;
		// FileReader in = null;
		// InputStreamReader in = null;
		BufferedReader in = null;

		File dirs = new File(".");
		String dirPath = dirs.getCanonicalPath() + File.separator + "src"
				+ File.separator;
		dirPath += "query.txt";

		try {
			// in = new FileInputStream(dirPath);
			// in = new FileReader(dirPath);
			in = new BufferedReader(new FileReader(dirPath));

			// int c;
			String c;
			int a = 1;
			// int b = 0;
			// while ((c = in.read()) != -1) {
			while ((c = in.readLine()) != null) {
				if (c.equals(Integer.toString(a))) {
					if ((c = in.readLine()) != null) {
						System.out.println(c);
						a++;
					}
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	public static void ParseFilesInDir() throws IOException {
		File dirs = new File(".");
		String dirPath = dirs.getCanonicalPath() + File.separator + "src"
				+ File.separator;

		File root = new File(dirPath);

		File[] files = root.listFiles();
		String filePath = null;

		for (File f : files) {
			filePath = f.getAbsolutePath();
			if (StringUtils.contains(filePath, "rank")) {
				if (f.isFile()) {
					parse(readFileToString(filePath));
				}
			}
		}
	}

	public static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			// System.out.println(numRead);
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}

		reader.close();

		return fileData.toString();
	}

	public static void parse(String str) {
		StringTokenizer st = new StringTokenizer(str);
		int a = 88;
		int i = 1;
		int j = 1;
		int R[] = new int[a];
		int V[] = new int[a];
		int D[] = new int[a];
		while (st.hasMoreElements()) {
			// if (i==3) {
			if (i % 3 == 0) {
				// System.out.println(st.nextElement() +" 3");
				D[j] = Integer.parseInt(st.nextElement().toString());
				// i=0;
				j++;
			}
			// else if (i==2) {
			else if (i % 3 == 2) {
				// System.out.println(st.nextElement() +" 2");
				V[j] = Integer.parseInt(st.nextElement().toString());
			} else {
				// System.out.println(st.nextElement() +" 1");
				R[j] = Integer.parseInt(st.nextElement().toString());
			}
			i++;
		}

		for (int z = 1; z < R.length; z++) {
			// System.out.println(R[z]+" "+V[z]+" "+D[z]);
			if ((R[z] < V[z]) && (V[z] < D[z])) {
				// System.out.println("R<V<D1:"+z+":"+R[z]+"<"+V[z]+"<"+D[z]);
				System.out.println(1);
			} else if ((R[z] < D[z]) && (D[z] < V[z])) {
				// System.out.println("R<D<V2:"+z+":"+R[z]+"<"+D[z]+"<"+V[z]);
				System.out.println(2);
			} else if ((V[z] < R[z]) && (R[z] < D[z])) {
				// System.out.println("V<R<D3:"+z+":"+V[z]+"<"+R[z]+"<"+D[z]);
				System.out.println(3);
			} else if ((V[z] < D[z]) && (D[z] < R[z])) {
				// System.out.println("V<D<R4:"+z+":"+V[z]+"<"+D[z]+"<"+R[z]);
				System.out.println(4);
			} else if ((D[z] < R[z]) && (R[z] < V[z])) {
				// System.out.println("D<R<V5:"+z+":"+D[z]+"<"+R[z]+"<"+V[z]);
				System.out.println(5);
			} else if ((D[z] < V[z]) && (V[z] < R[z])) {
				// System.out.println("D<V<R6:"+z+":"+D[z]+"<"+V[z]+"<"+R[z]);
				System.out.println(6);
			} else if ((R[z] == V[z]) && (V[z] < D[z])) {
				// System.out.println("R=V<D7:"+z+":"+R[z]+"="+V[z]+"<"+D[z]);
				System.out.println(7);
			} else if ((R[z] == D[z]) && (D[z] < V[z])) {
				// System.out.println("R=D<V8:"+z+":"+R[z]+"="+D[z]+"<"+V[z]);
				System.out.println(8);
			} else if ((V[z] == D[z]) && (D[z] < R[z])) {
				// System.out.println("V=D<R9:"+z+":"+V[z]+"="+D[z]+"<"+R[z]);
				System.out.println(9);
			} else if ((R[z] == V[z]) && (V[z] == D[z])) {
				// System.out.println("R=V=D0:"+z+":"+R[z]+"="+V[z]+"="+D[z]);
				System.out.println(10);
			} else if ((R[z] < V[z]) && (V[z] == D[z])) {
				// System.out.println("R<V=Da:"+z+":"+R[z]+"<"+V[z]+"="+D[z]);
				System.out.println(11);
			} else if ((V[z] < R[z]) && (R[z] == D[z])) {
				// System.out.println("V<R=Db:"+z+":"+V[z]+"<"+R[z]+"="+D[z]);
				System.out.println(12);
			} else if ((D[z] < R[z]) && (R[z] == V[z])) {
				// System.out.println("D<R=Vc:"+z+":"+D[z]+"<"+R[z]+"="+V[z]);
				System.out.println(13);
			}
		}
	}

	public static TreeMap<String, Integer> SortByValue(
			HashMap<String, Integer> map) {
		ValueComparator vc = new ValueComparator(map);
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}

	private static void rank7() {
		try {
			BufferedReader in = null;

			File dirs = new File(".");
			String dirPath = dirs.getCanonicalPath() + File.separator + "src"
					+ File.separator;
			dirPath += "sort.txt";

			try {
				in = new BufferedReader(new FileReader(dirPath));

				String c;
				while ((c = in.readLine()) != null) {

					StringTokenizer st = new StringTokenizer(c);
					HashMap<String, Integer> map = new HashMap<String, Integer>();
					int a = 0;

					while (st.hasMoreElements()) {
						int z = Integer.parseInt(st.nextElement().toString());
						switch (a) {
						case 0:
							map.put("R", z);
							a++;
							break;
						case 1:
							map.put("V", z);
							a++;
							break;
						case 2:
							map.put("D", z);
							a++;
							break;
						case 3:
							map.put("N", z);
							a++;
							break;
						case 4:
							map.put("I", z);
							a++;
							break;
						case 5:
							map.put("M", z);
							a++;
							break;
						case 6:
							map.put("K", z);
							a++;
							break;
						}
					}

					TreeMap<String, Integer> sortedMap = SortByValue(map);
					System.out.println(sortedMap);
				}
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (Exception e) {

		}
	}
}

class ValueComparator implements Comparator<String> {

	Map<String, Integer> map;

	public ValueComparator(Map<String, Integer> base) {
		this.map = base;
	}

	public int compare(String a, String b) {
		if (map.get(a) <= map.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}

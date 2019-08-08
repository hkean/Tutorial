

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class Token {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ParseFilesInDir();
	}

	public static void ParseFilesInDir() throws IOException{
		File dirs = new File(".");
		String dirPath = dirs.getCanonicalPath() + File.separator+"src"+File.separator;
 
		File root = new File(dirPath);
		
		File[] files = root.listFiles ( );
		String filePath = null;
 
		 for (File f : files ) {
			 filePath = f.getAbsolutePath();
			 if (StringUtils.contains(filePath, "test")){
			 if(f.isFile()){
				 parse(readFileToString(filePath));
			 }}
		 }
	}
	
	public static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
//			System.out.println(numRead);
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
 
		return  fileData.toString();	
	}
	
	public static void parse(String str) {
		ArrayList<String> a = new ArrayList<String>();
//		StringBuffer b = new StringBuffer();
		String b = "";
		StringTokenizer st = new StringTokenizer(str, "*{}()/@;.");
		while (st.hasMoreElements()) {
//			System.out.println("StringTokenizer Output: " + st.nextElement());
//			a.add(st.nextElement().toString());
//			b.append(st.nextElement());
			b += st.nextElement().toString().toLowerCase() +" ";
		}
		String[] c = b.split(" ");
//		c.replaceAll("\\s+","");
		Arrays.sort(c);
//		printArray(c);
//		printArray(a);
		
		Arrays.sort(c);
		 
//		System.out.println("****** Sorted String Array *******");
		for (String str1 : c) {
//		    System.out.println(str1);
		    System.out.print(str1 +" ");
//			b += str1 +" ";
		}
	}
	
	private static void printArrayList(ArrayList<String> array) {
	      for (int i = 0; i < array.size(); i++) {
	         if(i != 0){
	            System.out.print(" ");
	         }
	         System.out.print(array.get(i));                     
	      }
//	      System.out.println();
	   }
	private static void printArray(String array[]) {
	      for (int i = 0; i < array.length; i++) {
	         if(i != 0){
	            System.out.print(" ");
	         }
	         System.out.print(array[i]);                     
	      }
//	      System.out.println();
	   }

//	private static String[] getStopWords() {
//		String[] JAVA_STOP_WORDS = { "public", "private", "protected",
//				"interface", "abstract", "implements", "extends", "null",
//				"new", "switch", "case", "default", "synchronized", "do", "if",
//				"else", "break", "continue", "this", "assert", "for",
//				"instanceof", "transient", "final", "static", "void", "catch",
//				"try", "throws", "throw", "class", "finally", "return",
//				"const", "native", "super", "while", "import", "package",
//				"true", "false" };
//
//		HashSet<String> st = new HashSet<String>(Arrays.asList(StopAnalyzer.ENGLISH_STOP_WORDS));
//		st.addAll(Arrays.asList(JAVA_STOP_WORDS));
//
//		return st.toArray(new String[st.size()]);
//	} 

}


package com.github.tutorial.incomplete;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class AllCapToWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new AllCapToWord();
		
		System.out.print(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase("startDocumentXMLHandler"),' '));
		
		
	}

	public AllCapToWord() {
		// TODO Auto-generated constructor stub
//		String name = "SOME_CONSTANT";
//		String name = "startDocumentXmlHandler";
		
		// System.out.println(getName(name));
//		System.out.println(s(name));

		System.out.println(splitCamelCase("* <p>&AElig;lfred will call this method just before it"));
	}

	String getName(String text) {
		return StringUtils.remove(WordUtils.capitalizeFully(text, '_'), "_");
	}

	String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			camelCaseString = camelCaseString + toProperCase(part);
		}
		return camelCaseString;
	}

	static String toProperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	List<String> s(String s) {
		List<String> result = new ArrayList<String>();
		
		if (StringUtils.isEmpty(s)) {
			return result;
		}

		StringBuilder word = new StringBuilder();
		char[] buf = s.toCharArray();
		boolean prevIsUpper = false;

		for (int i = 0; i < buf.length; i++) {
			char ch = buf[i];
			if (Character.isUpperCase(ch)) {
				if (i == 0) {
					word.append(ch);
				} else if (!prevIsUpper) {

					result.add(word.toString());
					word = new StringBuilder();
					word.append(ch);
				} else {
					word.append(ch);
				}
				prevIsUpper = true;
			} else {
				word.append(ch);
				prevIsUpper = false;
			}
		}

		if (word != null && word.length() > 0) {
			result.add(word.toString());
		}
		
		return result;
	}
	
	String splitCamelCase(String s) {
		   return s.replaceAll(
		      String.format("%s|%s|%s",
		         "(?<=[A-Z])(?=[A-Z][a-z])",
		         "(?<=[^A-Z])(?=[A-Z])",
		         "(?<=[A-Za-z])(?=[^A-Za-z])"
		      ),
		      " "
		   );
		}
}

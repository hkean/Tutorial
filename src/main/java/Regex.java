

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		
		String r = "(interface|class|abstract)\\s+(\\w*)\\s*";
//		String r = "interface\\s+(\\w*)\\s*";
//		String r = "(interface|class)";
//		String r = "this\\s+is\\s+text";
//		String r = "this is text";
//		String r = "(John) (.+?) ";
		
		String s = "public class Script extends{}";
//		String s = "public interface Script extends{}";
//		String s = "this is  text";
//		String s = "this is text";
//		String s = "John this john is John text";
				
		Pattern p = Pattern.compile(r);
		Matcher matcher = p.matcher(s);
		while (matcher.find())
		{
		    System.out.println(matcher.group(2));
//			System.out.println(matcher.group());
//		    System.out.println(matcher.group(1) + " " + matcher.group(2));
//			System.out.println(matcher.start());
//			System.out.println(matcher.end());
//			System.out.println(matcher.);
		}
	}

}

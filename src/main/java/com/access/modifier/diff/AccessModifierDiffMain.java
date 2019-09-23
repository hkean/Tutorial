package com.access.modifier.diff;

//import com.access.modifier.Default1;
import com.access.modifier.Protected1;
import com.access.modifier.Public1;

public class AccessModifierDiffMain 
extends Protected1
//extends Default1 // constructor is not visible
{
	public static void main(String[] args) {
		Public1 pub = new Public1();
		System.out.println(pub.strPublic);
		pub.print();

		AccessModifierDiffMain protect = new AccessModifierDiffMain();
		System.out.println(protect.strProtected);
		protect.print();

		// cannot instantiate through protected class
//		Protected1 protect = new Protected1();
//		System.out.println(protect.strProtected);
//		protect.print();

//		Default1 def = new Default1(); // default constructor is not visible 

//		Private1 pri = new Private1(); // private constructor is not visible
	}
}

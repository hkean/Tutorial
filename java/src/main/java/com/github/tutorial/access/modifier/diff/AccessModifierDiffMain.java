package com.github.tutorial.access.modifier.diff;

import com.github.tutorial.access.modifier.Protected1;
import com.github.tutorial.access.modifier.Public1;

@SuppressWarnings("unused")
public class AccessModifierDiffMain 
extends Protected1
//extends Default1 // constructor is not visible
{
	public static void main(String[] args) {
		Public1 pub = new Public1();
		System.out.println(pub.strPublic);
		pub.print();

		AccessModifierDiffMain thisClass = new AccessModifierDiffMain();
		System.out.println(thisClass.strProtected);
		thisClass.print();

		Protected1 protect = new Protected1();
		// cannot use protected class
//		System.out.println(protect.strProtected);
//		protect.print();

//		Default1 def = new Default1(); // default constructor is not visible 

//		Private1 pri = new Private1(); // private constructor is not visible
	}
}

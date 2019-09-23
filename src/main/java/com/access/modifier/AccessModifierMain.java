package com.access.modifier;

public class AccessModifierMain {
	public static void main(String[] args) {
		new AccessModifierMain();
	}

	AccessModifierMain() {
		Public1 pub = new Public1();
		System.out.println(pub.strPublic);
		pub.print();

		Protected1 protect = new Protected1();
		System.out.println(protect.strProtected);
		protect.print();

		Default1 def = new Default1();
		System.out.println(def.strDefault);
		def.print();

//		Private1 pri = new Private1(); // private constructor is not visible
	}
}

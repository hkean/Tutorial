package com.github.tutorial.file;

public class FileMain {

	public static void main(String[] args) {
		
		System.out.println(FileMain.class.getClassLoader().getResource(".").getPath());
		new FileMain();
		
	}
	
	FileMain() {
		System.out.println(this.getClass().getClassLoader().getResource(".").getPath());
	}
	
}

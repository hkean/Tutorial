package com.github.tutorial.interfac3;

public class NewList implements L1st {

	private int size;
	
	public int getSize() {
		return this.size;
	}
	
	public NewList() {
		this.size = 0;
	}

	public NewList(int size) {
		this.size = size;
	}
}

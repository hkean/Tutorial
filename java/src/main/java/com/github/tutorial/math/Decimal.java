package com.github.tutorial.math;

import java.text.DecimalFormat;

public class Decimal {

	DecimalFormat df1 = new DecimalFormat("#.#"); 
	DecimalFormat df2 = new DecimalFormat("#.##"); 
	
	public static void main(String[] args) {
		new Decimal();
	}
	
	Decimal(){
		System.out.println(oneDecimalFormat(12.26)); // it will auto round
	}
	
	public Double oneDecimalFormat(Double number) {
		return Double.valueOf(df1.format(number));
	}
}

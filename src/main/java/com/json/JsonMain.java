package com.json;

import java.util.Arrays;
import java.util.List;

import com.model.Lookup;

public class JsonMain {

	public static void main(String[] args) {
		
		new JsonMain();
		
//		new JsonEncode();

//		new JsonDecode();
	}
	
	JsonMain() {
		Lookup a = new Lookup();
		a.setId(1);
		a.setHasChildren(true);
		
		Lookup b = new Lookup();
		a.setId(2);
		a.setHasChildren(false);
		
		List<Lookup> list = Arrays.asList(a,b);
		
		for (Lookup tmp: list) {
			if (tmp.getHasChildren() == true) {
				
			}
		}
	}

}

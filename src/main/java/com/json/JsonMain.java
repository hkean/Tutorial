package com.json;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;

import com.model.GenericNestedResource;
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
		
		GenericNestedResource parent = new GenericNestedResource();
		parent.setRefDataId(Byte.valueOf("1"));
		GenericNestedResource child1 = new GenericNestedResource();
		child1.setRefDataId(Byte.valueOf("11"));
		GenericNestedResource child2 = new GenericNestedResource();
		child2.setRefDataId(Byte.valueOf("12"));
		Set<GenericNestedResource> set = new HashSet<>();
		set.add(child1);
		set.add(child2);
		parent.setChildren(set);
		
		JSONObject joDemo = new JSONObject(parent);
		System.out.println(joDemo);
	}

}

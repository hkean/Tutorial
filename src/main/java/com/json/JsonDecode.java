package com.json;

import org.json.JSONArray;
import org.json.JSONObject;

import com.model.Demo;

public class JsonDecode {

	JsonDecode() {

		// Creating JSONObject from JSON String
		JSONObject joString = new JSONObject(
				  "{\"city\":\"chicago\",\"name\":\"jon doe\",\"age\":\"22\"}"
				);
		
		System.out.println(joString);
		
		// Serialize Java Object to JSON
		Demo demo = new Demo();
		demo.setId(1);
		demo.setName("lorem ipsum");
		demo.setActive(true);
		 
		JSONObject joDemo = new JSONObject(demo);

		System.out.println(joDemo);
		
		System.out.println("id: " + joDemo.get("id"));
		
		// JSONArray
		JSONArray ja = new JSONArray();
		ja.put(Boolean.TRUE);
		ja.put("lorem ipsum");
		 
		JSONObject jo = new JSONObject();
		jo.put("name", "jon doe");
		jo.put("age", "22");
		jo.put("city", "chicago");
		 
		ja.put(jo);
		
		System.out.println(ja);
		
		
	}
}

package com.json;

import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Demo;
import com.model.JsonPlaceHolder;

public class JsonDecode {

	@SuppressWarnings("unchecked")
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
		
		// JSON object to Java object 
		// using map/list
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"userId\": 1,  \"id\": 1,  \"title\": \"delectus aut autem\",  \"completed\": false}";
		try {
			Map<String,Object> map = mapper.readValue(json, Map.class);
			map.forEach((k,v)-> System.out.println(k + ":" + v));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// using JSON tree
		try {
			JsonNode rootNode = mapper.readTree(json);
			System.out.println(rootNode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// using Java class itself
		try {
			JsonPlaceHolder obj = mapper.readValue(json, JsonPlaceHolder.class);
			System.out.println(obj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

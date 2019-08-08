package com.json;

import org.json.JSONObject;

public class JsonEncode {

	JsonEncode() {
		
	      JSONObject obj = new JSONObject();

	      obj.put("name","foo");
	      obj.put("num",new Integer(100));
	      obj.put("balance",new Double(1000.21));
	      obj.put("is_vip",new Boolean(true));
	      
	      System.out.println(obj);
	      
	      JSONObject form = new JSONObject();
	      form.put("refId", 2);
//	      form.put("refLvl2", null);
	      
	      JSONObject lookup = new JSONObject();
	      lookup.put("resourceId", 2);
	      lookup.put("parent_id", 1);
	      
	      if (form.get("refId") == lookup.get("parent_id")
//	    		  && null == form.get("refIdLvl2")
	    		  ) {
	    	  System.out.println("im here");
	      }
	   }
}

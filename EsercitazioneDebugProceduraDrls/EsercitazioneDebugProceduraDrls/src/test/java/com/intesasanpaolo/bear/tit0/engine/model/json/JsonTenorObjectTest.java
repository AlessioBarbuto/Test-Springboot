package com.intesasanpaolo.bear.tit0.engine.model.json;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.gson.JsonObject;

public class JsonTenorObjectTest {

	@Test
	public void testGetRowElement() {
		
		JsonTenorObject j = new JsonTenorObject("2M");
		 JsonObject k = new JsonObject();
	  	
	         k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2022-10-30");
	        k.addProperty("SPREAD_RATE", "0");
	        k.addProperty("ORDER_NUM", "1");
	        k.addProperty("COD_TENOR", "2M");
	        k.addProperty("COD_ASSET","TEST2");
	        k.addProperty("COD_TYPE","ASK");
	    
	        j.add2Tenor(new JsonRowObject(k));
	       assertNotNull(j.getRowElement("TEST2", "ASK"));
	}

}

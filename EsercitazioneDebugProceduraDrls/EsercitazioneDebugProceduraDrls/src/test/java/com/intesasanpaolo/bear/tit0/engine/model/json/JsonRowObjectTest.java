package com.intesasanpaolo.bear.tit0.engine.model.json;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;

import org.junit.Test;

import com.google.gson.JsonObject;

public class JsonRowObjectTest {

	@Test
	public void testGetElement() {
		
		JsonObject k = new JsonObject();
	  	
        k = new JsonObject();
        k.addProperty("DT_MATURITY", "30-10-2022");
        k.addProperty("SPREAD_RATE", "0");
        k.addProperty("ORDER_NUM", "1");
        k.addProperty("COD_TENOR", "2M");
        k.addProperty("COD_ASSET","TEST2");
        k.addProperty("COD_TYPE","ASK");
    
        JsonRowObject j = new JsonRowObject(k);
     
        assertNotNull(j.getElement("ORDER_NUM"));
	}

	@Test
	public void testGetDouble() {
		JsonObject k = new JsonObject();
	  	
        k = new JsonObject();
        k.addProperty("DT_MATURITY", "30-10-2022");
        k.addProperty("SPREAD_RATE", "0");
        k.addProperty("ORDER_NUM", "1");
        k.addProperty("COD_TENOR", "2M");
        k.addProperty("COD_ASSET","TEST2");
        k.addProperty("COD_TYPE","ASK");
    
        JsonRowObject j = new JsonRowObject(k);
     
        assertNotNull(j.getDouble("ORDER_NUM"));
	}

	@Test
	public void testGetNumber() {
		JsonObject k = new JsonObject();
	  	
        k = new JsonObject();
        k.addProperty("DT_MATURITY", "30-10-2022");
        k.addProperty("SPREAD_RATE", "0");
        k.addProperty("ORDER_NUM", "1");
        k.addProperty("COD_TENOR", "2M");
        k.addProperty("COD_ASSET","TEST2");
        k.addProperty("COD_TYPE","ASK");
    
        JsonRowObject j = new JsonRowObject(k);
     
        assertNotNull(j.getNumber("ORDER_NUM"));
	}

	@Test
	public void testGetDate() throws ParseException {
		JsonObject k = new JsonObject();
	  	
        k = new JsonObject();
        k.addProperty("DT_MATURITY", "30-10-2022");
        k.addProperty("SPREAD_RATE", "0");
        k.addProperty("ORDER_NUM", "1");
        k.addProperty("COD_TENOR", "2M");
        k.addProperty("COD_ASSET","TEST2");
        k.addProperty("COD_TYPE","ASK");
    
        JsonRowObject j = new JsonRowObject(k);
     
        assertNotNull(j.getDate("DT_MATURITY"));
	}

	@Test
	public void testGetDataTime() throws ParseException {
		JsonObject k = new JsonObject();
	  	
        k = new JsonObject();
        k.addProperty("DT_MATURITY", "30-10-2022 22:10:00");
        k.addProperty("SPREAD_RATE", "0");
        k.addProperty("ORDER_NUM", "1");
        k.addProperty("COD_TENOR", "2M");
        k.addProperty("COD_ASSET","TEST2");
        k.addProperty("COD_TYPE","ASK");
    
        JsonRowObject j = new JsonRowObject(k);
     
        assertNotNull(j.getDataTime("DT_MATURITY"));
	}

	@Test
	public void testGetData() throws ParseException {
		JsonObject k = new JsonObject();
	  	
        k = new JsonObject();
        k.addProperty("DT_MATURITY", "30-10-2022");
        k.addProperty("SPREAD_RATE", "0");
        k.addProperty("ORDER_NUM", "1");
        k.addProperty("COD_TENOR", "2M");
        k.addProperty("COD_ASSET","TEST2");
        k.addProperty("COD_TYPE","ASK");
    
        JsonRowObject j = new JsonRowObject(k);
     
        assertNotNull(j.getData("DT_MATURITY"));
	}

	@Test
	public void testGetDateTime() throws ParseException {
		JsonObject k = new JsonObject();
	  	
        k = new JsonObject();
        k.addProperty("DT_MATURITY", "30-10-2022 22:10:00");
        k.addProperty("SPREAD_RATE", "0");
        k.addProperty("ORDER_NUM", "1");
        k.addProperty("COD_TENOR", "2M");
        k.addProperty("COD_ASSET","TEST2");
        k.addProperty("COD_TYPE","ASK");
    
        JsonRowObject j = new JsonRowObject(k);
     
        assertNotNull(j.getDateTime("DT_MATURITY"));
	}

	@Test
	public void testGetTruncDateTimeAsString() throws ParseException {
		JsonObject k = new JsonObject();
	  	
        k = new JsonObject();
        k.addProperty("DT_MATURITY", "30-10-2022 22:10:00");
        k.addProperty("SPREAD_RATE", "0");
        k.addProperty("ORDER_NUM", "1");
        k.addProperty("COD_TENOR", "2M");
        k.addProperty("COD_ASSET","TEST2");
        k.addProperty("COD_TYPE","ASK");
    
        JsonRowObject j = new JsonRowObject(k);
     
        assertNotNull(j.getTruncDateTimeAsString("DT_MATURITY"));
	}

}

package com.intesasanpaolo.bear.tit0.engine.model.json.structure;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonObject;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonRowObject;
import com.intesasanpaolo.bear.tit0.engine.utils.Data;

public class CurveStructureTest {

	
		
	    @Test
	    void getSoglia()   throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	        assertNotNull(z.getSoglia());
	    }

	    @Test
	    void getCod_ccy()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	  assertNotNull(z.getCod_ccy());
	    }
	    

	    @Test
	   
	    void testMerge()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
		        
		        
		  	  List<JsonRowObject> l2 = new ArrayList<JsonRowObject>();
		         k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2022");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "2M");
		        k.addProperty("COD_ASSET","TEST2");
		        l2.add(new JsonRowObject(k));
		        x_field ="DT_MATURITY";
		        y_field="SPREAD_RATE";
		        asOfD = new Date();
		         cod_asset = "TEST";
		         cod_type ="ASK";
		         fl_input ="I";
		         soglia = 0.d;
		         cod_ccy = "EUR";
		        CurveStructure z2 = new CurveStructure(l2,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
		        CurveStructure z3 =  CurveStructure.mergeWithoutJson(z, z2, "PROVA");
	    	  assertNotNull(z3);
	    }

	    @Test
	    void getCodTenor()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getCodTenor());
	    }

	    @Test
	    void getCod_asset()  throws Exception  {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getCod_asset());
	    }

	    @Test
	    void getCod_type()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getCod_type());
	    }

	    @Test
	    void getFl_input()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getFl_input());
	    }

	 

	    @Test
	    void getBucket()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getBucket("1M"));
	    }

	    @Test
	    void getValue()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getValue());
	    }

	    @Test
	    void getDtMaturity()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("COD_ASSET","TEST");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getDtMaturity("1M"));
	    }

	    @Test
	    void getOrderNum()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_ASSET","TEST");
		        k.addProperty("COD_TENOR", "1M");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getOrderNum("1M"));
	    }

	    @Test
	    void getInterpolatedRate()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_ASSET","TEST");
		        k.addProperty("COD_TENOR", "1M");
		        l.add(new JsonRowObject(k));
		         k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2022");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_ASSET","TEST");
		        k.addProperty("COD_TENOR", "2M");
		        
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getInterpolatedRate(new Date()));
	    }

	   
	    @Test
	    void getBucketDates()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_ASSET","TEST");
		        k.addProperty("COD_TENOR", "1M");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getBucketDates());
	    }

	    @Test
	    void testGetBucket()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getBucket("1M"));
	    }

	    @Test
	    void getNextBucket()  throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_ASSET","TEST");
		        k.addProperty("COD_TENOR", "1M");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getNextBucket(new Data()));
	    }

	   



	    @Test
	    void getDiscountFactor() throws Exception {
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("COD_ASSET","TEST");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
	    	assertNotNull(z.getDiscountFactor(new Data()));
	    }
	    
	    @Test
	    void testConstructor() throws Exception {
	    	
		    CurveStructure z = new  CurveStructure(new Data[] {new Data()}, new double[] {0.d} ,"TEST", new Data());
	    	assertNotNull(z);
	    }
	    
	    @Test
	    void testConstructor2() throws Exception {
	    	
		    CurveStructure z = new  CurveStructure(new Data[] {new Data()}, new double[] {0.d} ,new String[]{"1M"},"TEST", new Data());
		    assertNotNull(z);
	    }

	    @Test
	    void testConstructor3() throws Exception {
	    	
	    	 List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_ASSET","TEST");
		        k.addProperty("COD_TENOR", "1M");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		     
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD);
		        z.getBucket(0);
		        z.getDtMaturity(0);
		        z.getTenor(0);
		        z.getOrderNum(0);
		        z.getRow(0);
		        z.getRow("1M");
		        z.getRow(new Data(2021,9,30));
		        assertNotNull(z);
	    }


	    @Test
	    void testConstructor4() throws Exception {
	    	
		    CurveStructure z = new  CurveStructure(new Data[] {new Data()}, new double[] {0.d} , new double[] {0.d} ,new boolean[]{true},"TEST", new Data());
		    assertNotNull(z);
	    }
	    
	    @Test
	    void testNonDecreasing() throws Exception {
	    	
		    CurveStructure z = new  CurveStructure(new Data[] {new Data()}, new double[] {0.d} , new double[] {0.d} ,new boolean[]{true},"TEST", new Data());
		    z.applyNotDecreisingLogic();
		    
		    
		    assertNotNull(z);
	    }
	    
	    @Test
	    void testMerge2() throws Exception {
	    	
	    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
		        JsonObject k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2021");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "1M");
		        k.addProperty("COD_ASSET","TEST");
		        l.add(new JsonRowObject(k));
		        String x_field ="DT_MATURITY";
		        String y_field="SPREAD_RATE";
		        Date asOfD = new Date();
		        String cod_asset = "TEST";
		        String cod_type ="ASK";
		        String fl_input ="I";
		        Double soglia = 0.d;
		        String cod_ccy = "EUR";
		        CurveStructure z = new CurveStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
		        
		        
		  	  List<JsonRowObject> l2 = new ArrayList<JsonRowObject>();
		         k = new JsonObject();
		        k.addProperty("DT_MATURITY", "30-10-2022");
		        k.addProperty("SPREAD_RATE", "0");
		        k.addProperty("ORDER_NUM", "1");
		        k.addProperty("COD_TENOR", "2M");
		        k.addProperty("COD_ASSET","TEST2");
		        l2.add(new JsonRowObject(k));
		        x_field ="DT_MATURITY";
		        y_field="SPREAD_RATE";
		        asOfD = new Date();
		         cod_asset = "TEST";
		         cod_type ="ASK";
		         fl_input ="I";
		         soglia = 0.d;
		         cod_ccy = "EUR";
		        CurveStructure z2 = new CurveStructure(l2,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
		        CurveStructure z3 =  CurveStructure.merge(z, z2, "PROVA");
	    	  assertNotNull(z3);
	    }


}

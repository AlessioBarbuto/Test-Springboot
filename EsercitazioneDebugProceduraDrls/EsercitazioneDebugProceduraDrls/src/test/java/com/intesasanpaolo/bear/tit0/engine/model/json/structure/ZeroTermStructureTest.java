package com.intesasanpaolo.bear.tit0.engine.model.json.structure;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonObject;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonRowObject;
import com.intesasanpaolo.bear.tit0.engine.utils.Data;

class ZeroTermStructureTest {
	
    @Test
    void getSoglia()   throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
        assertNotNull(z.getSoglia());
    }

    @Test
    void getCod_ccy()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	  assertNotNull(z.getCod_ccy());
    }

    @Test
    void getCodTenor()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getCodTenor());
    }

    @Test
    void getCod_asset()  throws ParseException  {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getCod_asset());
    }

    @Test
    void getCod_type()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getCod_type());
    }

    @Test
    void getFl_input()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getFl_input());
    }

 

    @Test
    void getBucket()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getBucket("1M"));
    }

    @Test
    void getValue()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getValue());
    }

    @Test
    void getDtMaturity()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getDtMaturity("1M"));
    }

    @Test
    void getOrderNum()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getOrderNum("1M"));
    }

    @Test
    void getInterpolatedRate()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getInterpolatedRate(new Data()));
    }

   
    @Test
    void getBucketDates()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getBucketDates());
    }

    @Test
    void testGetBucket()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getBucket("1M"));
    }

    @Test
    void getNextBucket()  throws ParseException {
    	  List<JsonRowObject> l = new ArrayList<JsonRowObject>();
	        JsonObject k = new JsonObject();
	        k.addProperty("DT_MATURITY", "2021-10-30");
	        k.addProperty("SPREAD_RATE", "0");
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
	        ZeroTermStructure z = new ZeroTermStructure(l,x_field,y_field,asOfD,cod_asset,cod_type,fl_input,soglia,cod_ccy);
    	assertNotNull(z.getNextBucket(new Data()));
    }

   




   
}
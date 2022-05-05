package com.intesasanpaolo.bear.tit0.engine.model;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.model.json.JsonDealObject;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonInput;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonOutput;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonRowObject;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonTableObject;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonTenorObject;
import com.intesasanpaolo.bear.tit0.engine.model.json.structure.CurveStructure;
import com.intesasanpaolo.bear.tit0.engine.model.json.structure.DealKondorStructure;
import com.intesasanpaolo.bear.tit0.engine.model.json.structure.DealMurexStructure;
import com.intesasanpaolo.bear.tit0.engine.model.json.structure.ZeroTermStructure;
import com.intesasanpaolo.bear.tit0.engine.utils.MathOperator;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class ModelJsonTest {
	
	@Test
	public void testDealKondorStructure() {
		//PojoTestUtils.validate(DealKondorStructure.class);
		Object o = new DealKondorStructure(null, null, null, new Date(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertNotNull(o);
//		assertNotNull(o.toString());
	}
	
	@Test
	public void testCurveStructure() {
		PojoTestUtils.validate(CurveStructure.class);
		Object o = new CurveStructure();
		assertNotNull(o);
		
	}
	


	@Test
	public void testDealMurexStructure() {
		//PojoTestUtils.validate(DealMurexStructure.class);
		Object o = new DealMurexStructure(null, null, null, null, null, null, null, null, null, null, new Date(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertNotNull(o);
//		assertNotNull(o.toString());
	}

	@Test
	public void testJsonTableObject() {
		//PojoTestUtils.validate(JsonTableObject.class);
		Object o = new JsonTableObject();
		assertNotNull(o);
		assertNotNull(o.toString());
	}
	
	@Test
	public void testJsonDealObject() {
		PojoTestUtils.validate(JsonDealObject.class);
		Object o = new JsonDealObject();
		assertNotNull(o);
		assertNotNull(o.toString());
	}
	
	@Test
	public void testJsonInput() {
//		PojoTestUtils.validate(JsonInput.class);
		Object o = new JsonInput();
		assertNotNull(o);
		assertNotNull(o.toString());
	}
	
	@Test
	public void testJsonRowObject() throws Exception {
		PojoTestUtils.validate(JsonRowObject.class);
		Object o = new JsonRowObject(null);
		assertNotNull(o);
//		assertNotNull(o.toString());
	}
	
	@Test
	public void testJsonTenorObject() throws Exception {
		PojoTestUtils.validate(JsonTenorObject.class);
		Object o = new JsonTenorObject(null);
		assertNotNull(o);
		assertNotNull(o.toString());
	}
	
	@Test
	public void testJsonOutput() throws Exception {
		PojoTestUtils.validate(JsonOutput.class);
		Object o = new JsonOutput();
		assertNotNull(o);
		assertNotNull(o.toString());
	}
	
	@Test
	public void testMathOperator() throws Exception {
	
		
		assertNotNull(MathOperator.round(2.3d, 1));
		
	}
	
	
	
}

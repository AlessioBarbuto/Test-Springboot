package com.intesasanpaolo.bear.tit0.engine.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizioneConfigurazioneResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizionePayloadResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizioneResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AnagraficaInputOutputResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AnagraficaInputResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AnagraficaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloInstanceResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloResource;
import com.intesasanpaolo.bear.tit0.engine.resource.CurvaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.CurvaWithRecordsResource;
import com.intesasanpaolo.bear.tit0.engine.resource.DealConfigurazioneResource;
import com.intesasanpaolo.bear.tit0.engine.resource.HistoryResource;
import com.intesasanpaolo.bear.tit0.engine.resource.InputPayloadResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ListDealDataResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ListDetailDataResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ListInputDataResource;
import com.intesasanpaolo.bear.tit0.engine.resource.NotaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.OutputDataResource;
import com.intesasanpaolo.bear.tit0.engine.resource.RunResource;
import com.intesasanpaolo.bear.tit0.engine.resource.SogliaResource;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;


@RunWith(MockitoJUnitRunner.class)
public class ModelResourceTest {

	@Test
	public void testAcquisizioneConfigurazioneResource() {
		PojoTestUtils.validate(AcquisizioneConfigurazioneResource.class);
		Object o = new AcquisizioneConfigurazioneResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAcquisizionePayloadResource() {
		PojoTestUtils.validate(AcquisizionePayloadResource.class);
		Object o = new AcquisizionePayloadResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAcquisizioneResource() {
		PojoTestUtils.validate(AcquisizioneResource.class);
		Object o = new AcquisizioneResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAnagraficaInputOutputResource() {
		PojoTestUtils.validate(AnagraficaInputOutputResource.class);
		Object o = new AnagraficaInputOutputResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testAnagraficaInputResource() {
		PojoTestUtils.validate(AnagraficaInputResource.class);
		Object o = new AnagraficaInputResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAnagraficaResource() {
		PojoTestUtils.validate(AnagraficaResource.class);
		Object o = new AnagraficaResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testControlloInstanceResource() {
		PojoTestUtils.validate(ControlloInstanceResource.class);
		Object o = new ControlloInstanceResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testControlloResource() {
		PojoTestUtils.validate(ControlloResource.class);
		Object o = new ControlloResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testCurvaResource() {
		PojoTestUtils.validate(CurvaResource.class);
		Object o = new CurvaResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testCurvaWithRecordsResource() {
		PojoTestUtils.validate(CurvaWithRecordsResource.class);
		Object o = new CurvaWithRecordsResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDealConfigurazioneResource() {
		PojoTestUtils.validate(DealConfigurazioneResource.class);
		Object o = new DealConfigurazioneResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testHistoryResource() {
		PojoTestUtils.validate(HistoryResource.class);
		Object o = new HistoryResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testInputPayloadResource() {
		PojoTestUtils.validate(InputPayloadResource.class);
		Object o = new InputPayloadResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testListDealDataResource() {
		PojoTestUtils.validate(ListDealDataResource.class);
		Object o = new ListDealDataResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testListDetailDataResource() {
		PojoTestUtils.validate(ListDetailDataResource.class);
		Object o = new ListDetailDataResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testListInputDataResource() {
		PojoTestUtils.validate(ListInputDataResource.class);
		Object o = new ListInputDataResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testNotaResource() {
		PojoTestUtils.validate(NotaResource.class);
		Object o = new NotaResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testOutputDataResource() {
		PojoTestUtils.validate(OutputDataResource.class);
		Object o = new OutputDataResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

//	@Test
//	public void testRuleResource() {
//		PojoTestUtils.validate(RuleResource.class);
//		Object o = new RuleResource();
//		assertNotNull(o.toString());
//		assertNotEquals(o, null);
//	}

	@Test
	public void testRunResource() {
		PojoTestUtils.validate(RunResource.class);
		Object o = new RunResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testSogliaResource() {
		PojoTestUtils.validate(SogliaResource.class);
		Object o = new SogliaResource();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
}

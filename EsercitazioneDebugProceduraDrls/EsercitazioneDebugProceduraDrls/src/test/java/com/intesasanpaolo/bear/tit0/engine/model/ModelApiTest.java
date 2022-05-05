package com.intesasanpaolo.bear.tit0.engine.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.model.api.AcquisizioneConfigurazione;
import com.intesasanpaolo.bear.tit0.engine.model.api.AcquisizionePayload;
import com.intesasanpaolo.bear.tit0.engine.model.api.Anagrafica;
import com.intesasanpaolo.bear.tit0.engine.model.api.AttributoControllo;
import com.intesasanpaolo.bear.tit0.engine.model.api.AuditData;
import com.intesasanpaolo.bear.tit0.engine.model.api.CasisticaRecord;
import com.intesasanpaolo.bear.tit0.engine.model.api.ChoiceElement;
import com.intesasanpaolo.bear.tit0.engine.model.api.Controllo;
import com.intesasanpaolo.bear.tit0.engine.model.api.ControlloInstance;
import com.intesasanpaolo.bear.tit0.engine.model.api.CurvaData;
import com.intesasanpaolo.bear.tit0.engine.model.api.CurvaDataWithRecords;
import com.intesasanpaolo.bear.tit0.engine.model.api.CurvaRecord;
import com.intesasanpaolo.bear.tit0.engine.model.api.DealDataWithRecords;
import com.intesasanpaolo.bear.tit0.engine.model.api.DealInputData;
import com.intesasanpaolo.bear.tit0.engine.model.api.DealRecord;
import com.intesasanpaolo.bear.tit0.engine.model.api.ListDealData;
import com.intesasanpaolo.bear.tit0.engine.model.api.ListDetailData;
import com.intesasanpaolo.bear.tit0.engine.model.api.ListInputData;
import com.intesasanpaolo.bear.tit0.engine.model.api.Nota;
import com.intesasanpaolo.bear.tit0.engine.model.api.RunControlApi;
import com.intesasanpaolo.bear.tit0.engine.model.api.RunControllo;
import com.intesasanpaolo.bear.tit0.engine.model.api.SogliaControllo;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;



@RunWith(MockitoJUnitRunner.class)
public class ModelApiTest {

	@Test
	public void testCasisticaRecord() {
		PojoTestUtils.validate(CasisticaRecord.class);
		Object o = new CasisticaRecord(null, null);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDealDataWithRecords() {
		PojoTestUtils.validate(DealDataWithRecords.class);
		Object o = new DealDataWithRecords();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDealInputData() {
		PojoTestUtils.validate(DealInputData.class);
		Object o = new DealInputData();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDealRecord() {
		PojoTestUtils.validate(DealRecord.class);
		Object o = new DealRecord();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testListDealData() {
		PojoTestUtils.validate(ListDealData.class);
		Object o = new ListDealData();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testListDetailData() {
		PojoTestUtils.validate(ListDetailData.class);
		Object o = new ListDetailData();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	

//	@Test
//	public void testRule() {
//		PojoTestUtils.validate(Rule.class);
//		Object o = new Rule();
//		assertNotNull(o.toString());
//		assertNotEquals(o, null);
//	}

	@Test
	public void testRunControllo() {
		PojoTestUtils.validate(RunControllo.class);
		Object o = new RunControllo();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testRunControlApi() {
		PojoTestUtils.validate(RunControlApi.class);
		Object o = new RunControlApi();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testNota() {
		PojoTestUtils.validate(Nota.class);
		Object o = new Nota();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAnagrafica() {
		PojoTestUtils.validate(Anagrafica.class);
		Object o = new Anagrafica();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAcquisizionePayload() {
		PojoTestUtils.validate(AcquisizionePayload.class);
		Object o = new AcquisizionePayload();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testListInputData() {
		PojoTestUtils.validate(ListInputData.class);
		Object o = new ListInputData();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testCurvaRecord() {
		PojoTestUtils.validate(CurvaRecord.class);
		Object o = new CurvaRecord();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testCurvaDataWithRecords() {
		PojoTestUtils.validate(CurvaDataWithRecords.class);
		Object o = new CurvaDataWithRecords();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testCurvaData() {
		PojoTestUtils.validate(CurvaData.class);
		Object o = new CurvaData();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testControlloInstance() {
		PojoTestUtils.validate(ControlloInstance.class);
		Object o = new ControlloInstance();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testControllo() {
		PojoTestUtils.validate(Controllo.class);
		Object o = new Controllo();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAuditData() {
		PojoTestUtils.validate(AuditData.class);
		Object o = new AuditData();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAcquisizioneConfigurazione() {
		PojoTestUtils.validate(AcquisizioneConfigurazione.class);
		Object o = new AcquisizioneConfigurazione();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testAttributoControllo() {
		PojoTestUtils.validate(AttributoControllo.class);
		Object o = new AttributoControllo();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testChoiceElement() {
		PojoTestUtils.validate(ChoiceElement.class);
		Object o = new ChoiceElement();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testSogliaControllo() {
		PojoTestUtils.validate(SogliaControllo.class);
		Object o = new SogliaControllo();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
}

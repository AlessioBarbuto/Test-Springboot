package com.intesasanpaolo.bear.tit0.engine.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.model.entity.DtRules;
import com.intesasanpaolo.bear.tit0.engine.model.entity.DtRulesPk;
import com.intesasanpaolo.bear.tit0.engine.model.entity.DvInstance;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtCurve;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtCurveMan;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtCurveManPk;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtCurvePk;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtInputCtrl;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtInputCtrlPk;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtOutputCtrl;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtOutputCtrlPk;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtRunCtrl;
import com.intesasanpaolo.bear.tit0.engine.model.entity.WtRunDeal;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class ModelEntityTest {
	
	@Test
	public void testWtRunDeal() {
		PojoTestUtils.validate(WtRunDeal.class);
		Object o = new WtRunDeal();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDtRules() {
		PojoTestUtils.validate(DtRules.class);
		Object o = new DtRules();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDtRulesPk() {
		PojoTestUtils.validate(DtRulesPk.class);
		Object o = new DtRulesPk(null, null, null);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDvInstance() {
		PojoTestUtils.validate(DvInstance.class);
		Object o = new DvInstance();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtCurve() {
		PojoTestUtils.validate(WtCurve.class);
		Object o = new WtCurve();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtCurveMan() {
		PojoTestUtils.validate(WtCurveMan.class);
		Object o = new WtCurveMan();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtCurveManPk() {
		PojoTestUtils.validate(WtCurveManPk.class);
		Object o = new WtCurveManPk(null, null, null, null, null, null, null);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtCurvePk() {
		PojoTestUtils.validate(WtCurvePk.class);
		Object o = new WtCurvePk(null, null, null, null, null, null, null);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtInputCtrl() {
		PojoTestUtils.validate(WtInputCtrl.class);
		Object o = new WtInputCtrl();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtInputCtrlPk() {
		PojoTestUtils.validate(WtInputCtrlPk.class);
		Object o = new WtInputCtrlPk(null, null, null, null, null, null, null);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtOutputCtrl() {
		PojoTestUtils.validate(WtOutputCtrl.class);
		Object o = new WtOutputCtrl();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtOutputCtrlPk() {
		PojoTestUtils.validate(WtOutputCtrlPk.class);
		Object o = new WtOutputCtrlPk(null, null, null, null, null, null, null);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testWtRunCtrl() {
		PojoTestUtils.validate(WtRunCtrl.class);
		Object o = new WtRunCtrl();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
}

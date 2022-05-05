package com.intesasanpaolo.bear.tit0.engine.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.model.bean.DtRulesBean;
import com.intesasanpaolo.bear.tit0.engine.model.bean.HistoryBean;
import com.intesasanpaolo.bear.tit0.engine.model.bean.WtRunCtrlBean;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;


@RunWith(MockitoJUnitRunner.class)
public class ModelBeanTest {

	@Test
	public void testWtRunCtrlBean() {
		PojoTestUtils.validate(WtRunCtrlBean.class);
		Object o = new WtRunCtrlBean();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDtHistoryBean() {
		PojoTestUtils.validate(HistoryBean.class);
		Object o = new HistoryBean();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDtRulesBean() {
		PojoTestUtils.validate(DtRulesBean.class);
		Object o = new DtRulesBean();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
}

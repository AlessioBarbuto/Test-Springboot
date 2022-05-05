package com.intesasanpaolo.bear.tit0.engine.connector.jdbc;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonTableObject;
import com.intesasanpaolo.bear.tit0.engine.service.DvEngineCurveService;

public class DvEngineCurveJdbcTest extends BaseTest {

	@Autowired
	private DvEngineCurveService dvEngineCurveService;

	@Test
	public void getInputJsonTableObject() throws Exception {
		JsonTableObject test1 = dvEngineCurveService.getData("2021-10-06", "#2", "09:15", "I");
		assertNotNull(test1);
	}

	@Test
	public void getOutputJsonTableObject() throws Exception {
		JsonTableObject test1 = dvEngineCurveService.getData("2021-10-06", "#2", "09:15", "O");
		assertNotNull(test1);
	}
}

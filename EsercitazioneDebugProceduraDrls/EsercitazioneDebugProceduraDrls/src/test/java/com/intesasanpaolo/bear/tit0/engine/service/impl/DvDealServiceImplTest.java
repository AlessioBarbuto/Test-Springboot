package com.intesasanpaolo.bear.tit0.engine.service.impl;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;

public class DvDealServiceImplTest extends BaseTest{
	 @Autowired DvDealServiceImpl dvDealServiceImpl;

	@Test
	public void testGetCurveStringStringDate() throws Exception {
		dvDealServiceImpl.getCurve("EURIBOR", "EUR", new Date());
	}

	

	@Test
	public void testGetExternalDeal() throws Exception {
		dvDealServiceImpl.getExternalDeal("KONDOR", new Date(), null, null, null, null, null);
	}

}

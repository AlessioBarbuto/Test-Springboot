package com.intesasanpaolo.bear.tit0.engine.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class PkTest {

	@Test
	public void testDtRulesPkEqualsObject() {
		assertEquals(
				new DtRulesPk("", "", null), 
				new DtRulesPk("", "", null));
	}
	
	@Test
	public void testWtOutputCtrlPkEqualsObject() {
		assertEquals(
				new WtOutputCtrlPk("", "", "", "", null, "", ""), 
				new WtOutputCtrlPk("", "", "", "", null, "", ""));
	}
	
	@Test
	public void testWtInputCtrlPkEqualsObject() {
		assertEquals(
				new WtInputCtrlPk("", null, "", "", "", "", ""), 
				new WtInputCtrlPk("", null, "", "", "", "", ""));
	}
	
	@Test
	public void testWtCurveManPkEqualsObject() {
		assertEquals(
				new WtCurveManPk("", "", "", "", "", null, null), 
				new WtCurveManPk("", "", "", "", "", null, null));
	}

}

package com.intesasanpaolo.bear.tit0.engine.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class AFrequencyTest {

	@Test
	public void testAFrequency() {
		AFrequency day = AFrequency.getInstance((short)1);
		AFrequency anno = AFrequency.getInstance(1);
		AFrequency semestre = AFrequency.getInstance(2);
		AFrequency mese = AFrequency.getInstance(12);
		AFrequency biweek = AFrequency.getInstance(26);
		AFrequency week = AFrequency.getInstance(52);
		
		
		day.advance(new Data(), 1);
		anno.advance(new Data(), 1);
		semestre.advance(new Data(), 1);
		mese.advance(new Data(), 1);
		biweek.advance(new Data(), 1);
		week.advance(new Data(), 1);
		
		day.getAdvanced(new Data(), 1);
		anno.getAdvanced(new Data(), 1);
		semestre.getAdvanced(new Data(), 1);
		mese.getAdvanced(new Data(), 1);
		biweek.getAdvanced(new Data(), 1);
		week.getAdvanced(new Data(), 1);
		
		new MonthlyFrequency(1);
	
		
		assertNotNull(anno);
		
	}

	


}

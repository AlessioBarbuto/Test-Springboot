package com.intesasanpaolo.bear.tit0.engine.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import org.junit.jupiter.api.Test;

class DayCounterTest {

	@Test
	void testGetInstance() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d);
	}

	@Test
	void testGetDifferenzaGiorniActualDataData() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniActual(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorniActualDateDate() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniActual(new Date(), new Date()));
	}


	@Test
	void testGetDifferenzaMesi() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaMesi(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorni30() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni30(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorni30360() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni30360(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorniActualActual() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniActualActual(new Data(), new Data()));
	}
	
	@Test
	void testGetDifferenzaGiorniActualActual2() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniActualActual(new Data(2020,9,12), new Data()));
	}

	@Test
	void testGetDifferenzaGiorniActual360() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniActual360(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorniActual365() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniActual365(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorni2930360() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni2930360(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorni365365() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni365365(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorni30Actual() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni30Actual(new Data(), new Data()));
	}
	
	@Test
	void testGetDifferenzaGiorni30Actual2() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni30Actual(new Data(2020,9,11), new Data()));
	}

	@Test
	void testGetDifferenzaGiorni30365() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni30365(new Data(), new Data()));
	}

	@Test
	void testGetDifferenzaGiorni365Actual() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni365Actual(new Data(), new Data()));
	}
	
	@Test
	void testGetDifferenzaGiorni365Actual2() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni365Actual(new Data(2020,9,2), new Data()));
	}

	@Test
	void testGetDifferenzaGiorni365360() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorni365360(new Data(), new Data()));
	}

	

	@Test
	void testGetDifferenzaGiorniCarmDataDataInt() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.ACT365));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt2() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.ACT360));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt3() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.THIRTY29360));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt4() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.THIRTY360));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt5() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.THIRTY365));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt6() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.THIRTYACT));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt7() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.ACTACT));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt8() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.ACTIGNORING29360));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt9() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.ACTIGNORING29365));
	}
	
	@Test
	void testGetDifferenzaGiorniCarmDataDataInt10() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(new Data(), new Data(), DayCounter.ACTIGNORING29ACT));
	}
	
	
	@Test
	void testGetDifferenzaGiorniCarm() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(DayCounter.ANNUALE, new Date(), DayCounter.ACT360));
	}
	
	
	@Test
	void testGetDifferenzaGiorniCarm2() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm(DayCounter.ANNUALE, new Data(), DayCounter.ACT360));
	}
	
	
	@Test
	void testGetDifferenzaGiorniCarm3() {
		DayCounter d = DayCounter.getInstance();
		assertNotNull(d.getDifferenzaGiorniCarm((short)1, new Date(), DayCounter.ACT360));
	}
	
	
	
	

}
